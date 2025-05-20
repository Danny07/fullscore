package com.co.dannykrd.fullscore.users.dto.read;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserReadRsDto {

	private String name;
	
	private String lastName;
	
	private String displayName;
	
	private String url;
	
	private String photo;

}
