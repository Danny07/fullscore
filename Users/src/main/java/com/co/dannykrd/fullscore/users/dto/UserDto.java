package com.co.dannykrd.fullscore.users.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {

	private String id;
	
	private String name;
	
	private String lastName;
	
	private String displayName;
	
	private String email;
	
	private String password;
	
	private Date dateBirth;
	
	private Date dateCreate;
	
	private ProfileDto profile;
	
	private String areaId;

}
