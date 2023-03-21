package com.exam.payload;

import lombok.Data;

@Data
public class JwtAuthRequest {

	private String userName;
	
	private String password;
	
}
