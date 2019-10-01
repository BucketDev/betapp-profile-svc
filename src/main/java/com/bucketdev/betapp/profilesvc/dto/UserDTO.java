package com.bucketdev.betapp.profilesvc.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author rodrigo.loyola
 */
@Data
public class UserDTO implements Serializable {

    private long id;
    private String uid;
    private String email;
    private String displayName;
    private String photoUrl;
    private String provider;

}
