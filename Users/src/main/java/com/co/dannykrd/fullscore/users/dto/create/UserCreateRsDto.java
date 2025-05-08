package com.co.dannykrd.fullscore.users.dto.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCreateRsDto {

	private String name;
	
	private String lastName;
	
	private String displayName;
	
	private String email;

}
