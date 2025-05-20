package com.co.dannykrd.fullscore.users.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import com.co.dannykrd.fullscore.users.dto.ProfileDto;
import com.co.dannykrd.fullscore.users.dto.UserDto;
import com.co.dannykrd.fullscore.users.dto.create.UserCreateRqDto;
import com.co.dannykrd.fullscore.users.dto.create.UserCreateRsDto;
import com.co.dannykrd.fullscore.users.dto.read.UserReadRsDto;
import com.co.dannykrd.fullscore.users.dto.update.UserUpdateRqDto;
import com.co.dannykrd.fullscore.users.entity.User;

@Mapper(
	    componentModel = "spring",
	    nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
	)
public interface UserMapper {

	UserMapper MAPPER = Mappers.getMapper(UserMapper.class);
	
	@Mapping(target="profile", source = "profileDto")
	@Mapping(target="name", source="userCreateRqDto.name")
	User userCreateRqDtoToUser(UserCreateRqDto userCreateRqDto, ProfileDto profileDto);
	
	UserCreateRsDto userToUserCreateRsDto(User user);
	
	UserReadRsDto userToUserReadRsDto(User user);
	
	List<UserReadRsDto> lstUserToLstUserReadRsDto(List<User> users);
	
	User updateUser(UserUpdateRqDto userUpdateDto, @MappingTarget  User user);
	
	UserDto userToUserDto(User user);
}
