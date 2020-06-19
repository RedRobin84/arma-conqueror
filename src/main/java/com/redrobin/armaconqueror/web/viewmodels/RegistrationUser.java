package com.redrobin.armaconqueror.web.viewmodels;


import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class RegistrationUser {

	@NotEmpty
	@Email
	private String email;

	@NotEmpty
	private String firstName;

	@NotEmpty
	private String username;

	@NotEmpty
	private String lastName;

	@NotEmpty
	private String password;

	@NotEmpty
	private String repeatPassword;

}
