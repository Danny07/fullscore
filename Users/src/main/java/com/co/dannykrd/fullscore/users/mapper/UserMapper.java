package com.co.dannykrd.fullscore.users.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.co.dannykrd.fullscore.users.dto.ProfileDto;
import com.co.dannykrd.fullscore.users.dto.create.UserCreateRqDto;
import com.co.dannykrd.fullscore.users.dto.create.UserCreateRsDto;
import com.co.dannykrd.fullscore.users.entity.User;

@Mapper
public interface UserMapper {

	UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
	
	@Mapping(target="profile", source = "profileDto")
	@Mapping(target="name", source="userCreateRqDto.name")
	User userCreateRqDtoToUser(UserCreateRqDto userCreateRqDto, ProfileDto profileDto);
	
	UserCreateRsDto userToUserCreateRsDto(User user);
}
