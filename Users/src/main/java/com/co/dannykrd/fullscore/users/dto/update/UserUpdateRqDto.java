package com.co.dannykrd.fullscore.users.dto.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserUpdateRqDto {

	private String name;
	
	private String lastName;
	
	private String displayName;
	
	private String email;
	
	private String password;
	
	private String areaId;
	
	private String photo;

}
