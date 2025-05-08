package com.co.dannykrd.fullscore.utils.objects;

import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntityRequest<T> {

	private T body;

	private HttpServletRequest servletRequest;
	
	public String toString() {
		return body.toString().concat(" ").concat(servletRequest.getLocale().toString());
	}
}
