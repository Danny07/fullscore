package com.co.dannykrd.fullscore.utils.exception;

import java.util.List;

import lombok.Getter;

public class FullScoreException extends RuntimeException {

	private static final long serialVersionUID = -485538808650509569L;
	
	@Getter
	private final List<String> validations;

	public FullScoreException(String message) {
		super(message);
		this.validations = null;
	}
	
	public FullScoreException(List<String> validations) {
		super("Se ha producion un error de validación");
		this.validations = validations;
	}
}
