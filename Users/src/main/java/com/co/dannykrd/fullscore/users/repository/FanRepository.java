package com.co.dannykrd.fullscore.users.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.co.dannykrd.fullscore.users.entity.Fan;

public interface FanRepository extends JpaRepository<Fan, UUID> {

}
