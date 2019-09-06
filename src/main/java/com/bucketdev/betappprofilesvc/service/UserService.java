package com.bucketdev.betappprofilesvc.service;

import com.bucketdev.betappprofilesvc.dto.UserDTO;

import java.util.Set;

/**
 * @author rodrigo.loyola
 */
public interface UserService {

    UserDTO save(UserDTO dto);
    UserDTO findByUid(String uid);
    Set<UserDTO> findByDisplayName(String uid);

}
