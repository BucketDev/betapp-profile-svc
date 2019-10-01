package com.bucketdev.betapp.profilesvc.service;

import com.bucketdev.betapp.profilesvc.dto.UserDTO;

import java.util.Set;

/**
 * @author rodrigo.loyola
 */
public interface UserService {

    UserDTO save(UserDTO dto);
    UserDTO findByUid(String uid);
    Set<UserDTO> findByDisplayName(String uid);

}
