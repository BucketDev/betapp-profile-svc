package com.bucketdev.betappprofilesvc.service.impl;

import com.bucketdev.betappprofilesvc.domain.User;
import com.bucketdev.betappprofilesvc.dto.UserDTO;
import com.bucketdev.betappprofilesvc.exception.user.UserNotFoundException;
import com.bucketdev.betappprofilesvc.repository.UserRepository;
import com.bucketdev.betappprofilesvc.service.UserService;
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
