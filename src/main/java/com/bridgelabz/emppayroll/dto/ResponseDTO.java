package com.bridgelabz.emppayroll.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ResponseDTO {

	public String message;
	public Object object;
	
	public ResponseDTO(String msg) {
		this.message = msg;
	}

}
