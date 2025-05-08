package com.co.dannykrd.fullscore.users.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.dannykrd.fullscore.users.entity.Profile;

public interface ProfileRepository extends JpaRepository<Profile, UUID> {

}
