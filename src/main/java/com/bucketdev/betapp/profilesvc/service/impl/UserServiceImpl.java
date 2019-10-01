package com.bucketdev.betapp.profilesvc.service.impl;

import com.bucketdev.betapp.profilesvc.domain.User;
import com.bucketdev.betapp.profilesvc.dto.UserDTO;
import com.bucketdev.betapp.profilesvc.exception.user.UserNotFoundException;
import com.bucketdev.betapp.profilesvc.repository.UserRepository;
import com.bucketdev.betapp.profilesvc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author rodrigo.loyola
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public UserDTO save(UserDTO dto) {
        User user = new User();
        if(dto.getId() > 0) {
            Optional<User> userOptional = repository.findById(dto.getId());
            if(userOptional.isEmpty())
                throw new UserNotFoundException("id: " + dto.getId());
            user = userOptional.get();
        }
        user.setValuesFromDTO(dto);
        return repository.save(user).toDTO();
    }

    @Override
    public UserDTO findByUid(String uid) {
        return repository.findByUid(uid).toDTO();
    }

    @Override
    public Set<UserDTO> findByDisplayName(String name) {
        return repository.findByDisplayNameContaining(name).stream().map(User::toDTO).collect(Collectors.toSet());
    }

}
