package com.co.dannykrd.fullscore.users.service;

import java.util.UUID;

import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.co.dannykrd.fullscore.users.dto.ProfileDto;
import com.co.dannykrd.fullscore.users.entity.Profile;
import com.co.dannykrd.fullscore.users.mapper.ProfileMapper;
import com.co.dannykrd.fullscore.users.repository.ProfileRepository;
import com.co.dannykrd.fullscore.utils.exception.FullScoreException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProfileService {

	@Autowired
	private ProfileRepository repository;
	
	private ProfileMapper mapper = Mappers.getMapper(ProfileMapper.class);
	
	public ProfileDto findProfileById(String id) throws FullScoreException {
		log.info("Begin findProfileById");
		log.debug("Begin findProfileById whith id: "+id);
		try {
			Profile profile = repository.findById(UUID.fromString(id)).orElse(null);
			log.info("End findProfileById");
			return mapper.profileToProfileDto(profile);
		}catch(RuntimeException re) {
			log.error("error in findProfileById", re);
			throw new FullScoreException(re.getMessage());
		}
		
	}
	
}
