package com.co.dannykrd.fullscore.users.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.co.dannykrd.fullscore.users.dto.ProfileDto;
import com.co.dannykrd.fullscore.users.entity.Profile;

@Mapper
public interface ProfileMapper {
	
	ProfileMapper MAPPER = Mappers.getMapper(ProfileMapper.class);
	
	ProfileDto profileToProfileDto(Profile profile);

}
