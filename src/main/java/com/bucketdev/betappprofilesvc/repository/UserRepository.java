package com.bucketdev.betappprofilesvc.repository;

import com.bucketdev.betappprofilesvc.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @author rodrigo.loyola
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUid(String uid);
    Set<User> findByDisplayNameContaining(String name);
}
