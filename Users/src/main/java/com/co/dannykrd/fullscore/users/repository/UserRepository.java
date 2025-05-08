package com.co.dannykrd.fullscore.users.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.dannykrd.fullscore.users.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {
	
	Optional<User> findByEmailIgnoreCase(String email);
	
	Optional<User> findByDisplayNameIgnoreCase(String displayName);

}
