package com.co.dannykrd.fullscore.users.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import org.mapstruct.factory.Mappers;
import org.springframework.context.MessageSource;
import org.springframework.http.RequestEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.co.dannykrd.fullscore.users.dto.ProfileDto;
import com.co.dannykrd.fullscore.users.dto.create.UserCreateRqDto;
import com.co.dannykrd.fullscore.users.dto.create.UserCreateRsDto;
import com.co.dannykrd.fullscore.users.entity.User;
import com.co.dannykrd.fullscore.users.mapper.UserMapper;
import com.co.dannykrd.fullscore.users.repository.UserRepository;
import com.co.dannykrd.fullscore.utils.exception.FullScoreException;
import com.co.dannykrd.fullscore.utils.utils.Utils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {
	
	private final UserRepository repository;
	
	private final ProfileService profileService;
	
	private final MessageSource messageSource;
	
	private final PasswordEncoder passwordEncoder;
	
	private UserMapper mapper = Mappers.getMapper(UserMapper.class);

	public String createUser(RequestEntity<UserCreateRqDto> entityRequest) throws FullScoreException{
		try {
			UserCreateRqDto userCreateRqDto = entityRequest.getBody();
			Locale locale = Utils.getLocale(entityRequest);
			User userFind = repository.findByEmailIgnoreCase(userCreateRqDto.getEmail()).orElse(null);
			List<String> validations = new ArrayList<>();
			if(Objects.nonNull(userFind)) {
				validations.add(messageSource.getMessage("user.validation.emailduplicate", null, locale));
			}
			userFind = repository.findByDisplayNameIgnoreCase(userCreateRqDto.getDisplayName()).orElse(null);
			if(Objects.nonNull(userFind)) {
				validations.add(messageSource.getMessage("user.validation.usernameduplicate", null, locale));
			}
			if(!validations.isEmpty()) {
				throw new FullScoreException(validations);
			}
			userCreateRqDto.setPassword(passwordEncoder.encode(userCreateRqDto.getPassword()));
			ProfileDto profileDto = profileService.findProfileById(userCreateRqDto.getProfile()); 
			User userCreate = mapper.userCreateRqDtoToUser(userCreateRqDto, profileDto);
			repository.save(userCreate);
			UserCreateRsDto userCreateRsDto = mapper.userToUserCreateRsDto(userCreate);
			return String.format(messageSource.getMessage("user.create.ok", null, locale), userCreateRsDto.getDisplayName(), Utils.maskEmail(userCreateRsDto.getEmail()));
		}catch(RuntimeException re) {
			log.error("Se presento un error en createUser ", re);
			throw new FullScoreException(re.getMessage());
		}
	}
	
	//public String updateUser
}
