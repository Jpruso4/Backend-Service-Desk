package com.serviceDesk.runner.application.model;

import org.springframework.lang.Nullable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Response<T> {
	
	private Integer errorCode;
	
	private String errorMessage;
	
	private T body;
	
	public Response(Integer errorCode,@Nullable String errorMessage, @Nullable T body) {
		this.errorCode = errorCode;
		this.errorMessage = errorMessage;
		this.body = body;
	}
	
}
