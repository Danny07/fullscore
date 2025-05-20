package com.co.dannykrd.fullscore.users.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.co.dannykrd.fullscore.users.entity.User;

public interface UserRepository extends JpaRepository<User, UUID> {
	
	Optional<User> findByEmailIgnoreCase(String email);
	
	Optional<User> findByDisplayNameIgnoreCase(String displayName);
	
	@Query("SELECT u FROM users u WHERE (LOWER(u.name) LIKE LOWER(CONCAT('%',:filter,'%'))) "
			+ "OR (LOWER(u.lastname) LIKE LOWER(CONCAT('%',:filter,'%'))) "
			+ "OR (LOWER(u.displayName) LIKE LOWER(CONCAT('%',:filter,'%'))) "
			+ "OR (LOWER(u.email) LIKE LOWER(CONCAT('%',:filter,'%')))")
	Page<User> findByFilter(@Param("filter")String filter, Pageable pageable);

}
