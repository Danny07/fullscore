package com.co.dannykrd.fullscore.utils.objects;

import org.springframework.http.HttpStatusCode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntityResponse<T> {
	
	private T body;
	
	private String message;
	
	private HttpStatusCode status;

	

}
