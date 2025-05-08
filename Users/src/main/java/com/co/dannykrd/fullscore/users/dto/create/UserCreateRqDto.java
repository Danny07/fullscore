package com.co.dannykrd.fullscore.users.dto.create;

import java.util.Date;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserCreateRqDto {

	@NotBlank(message = "{user.name.notblank}")
	@NotNull(message = "{user.name.notblank}")
	private String name;
	
	@NotBlank(message = "{user.lastname.notblank}")
	@NotNull(message = "{user.lastname.notblank}")
	private String lastName;
	
	@NotBlank(message = "{user.displayname.notblank}")
	@NotNull(message = "{user.displayname.notblank}")
	private String displayName;
	
	@NotBlank(message = "{user.email.notblank}")
	@NotNull(message = "{user.email.notblank}")
	@Email(message = "{user.email.format}")
	private String email;
	
	@NotBlank(message = "{user.password.notblank}")
	@NotNull(message = "{user.password.notblank}")
	private String password;
	
	@NotBlank(message = "{user.dateBirth.notblank}")
	@NotNull(message = "{user.dateBirth.notblank}")
	private Date dateBirth;
	
	@NotBlank(message = "{user.profile.notblank}")
	@NotNull(message = "{user.profile.notblank}")
	private String profile;
	
	@NotBlank(message = "{user.areaID.notblank}")
	@NotNull(message = "{user.areaID.notblank}")
	private String areaId;

}
