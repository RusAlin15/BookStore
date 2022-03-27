package com.application.exception;

public class ResourceNotFoundException extends RuntimeException {

	// must be generated
	private static final long serialVersionUID = -4372590862909853742L;

	public ResourceNotFoundException(String message) {
		super(message);
	}
}
