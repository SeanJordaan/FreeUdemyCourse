package com.appsdeveloperblog.app.ws.ui.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetailsRequestModel {
	@NotNull(message = "First Name Can Not be Null")
	@Size(min = 2, message ="Your Real Name" )
	private String firstName;
	
	@NotNull(message = "Last Name Can Not be Null")
	@Size(min = 2, message ="Your Real surname" )
	private String lastName;
	
	@NotNull(message = "Emaile Can Not be Null")
	@Email
	private String email;
	
	@NotNull(message = "Password Can Not be Null")
	@Size(min = 8, max = 16, message ="Password is only between 8 and 16 charachters" )
	private String password;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
