package com.alkemy.disney.auth.repository;

import com.alkemy.disney.auth.entity.UserEntity;
import com.alkemy.disney.entity.PersonajeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserEntity findByUsername(String username);
}
