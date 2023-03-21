package com.exam.payload;

import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Data
public class UserDto {
	private Long id;
	private String userName;
	private String firstName;

	private String lastName;
	private String password;
	private String email;
	private String phone;

	private String profilePic;
	
	private Set<RoleDto> roles=new HashSet<>();
}
