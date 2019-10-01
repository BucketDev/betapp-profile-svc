package com.bucketdev.betapp.profilesvc.domain;

import com.bucketdev.betapp.profilesvc.dto.UserDTO;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * @author rodrigo.loyola
 */
@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotNull
    private String uid;

    @Column
    @NotNull
    private String email;

    @Column
    private String displayName;

    @Column
    private String photoUrl;

    @Column
    @NotNull
    private String provider;

    public UserDTO toDTO() {
        UserDTO dto = new UserDTO();

        dto.setId(id);
        dto.setUid(uid);
        dto.setEmail(email);
        dto.setDisplayName(displayName);
        dto.setPhotoUrl(photoUrl);
        dto.setProvider(provider);

        return dto;
    }

    public void setValuesFromDTO(UserDTO dto) {
        uid = dto.getUid();
        email = dto.getEmail();
        displayName = dto.getDisplayName();
        photoUrl = dto.getPhotoUrl();
        provider = dto.getProvider();
    }

}
