package com.co.dannykrd.fullscore.users.dto.update;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserProfileUpdateRqDto {

	private String idUser;
	
	private String idProfile;
}
