package com.appsdeveloperblog.app.ws.ui.model.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
	@NotNull(message = "First Name Can Not be Null")
	@Size(min = 2, message ="Your Real Name" )
	private String firstName;
	
	@NotNull(message = "Last Name Can Not be Null")
	@Size(min = 2, message ="Your Real surname" )
	private String lastName;

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
}
