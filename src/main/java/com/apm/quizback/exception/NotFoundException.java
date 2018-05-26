package com.apm.quizback.exception;

public class NotFoundException extends Exception {

	private static final long serialVersionUID = 967063102860516169L;
	
	public static final String MSG = "Not found.";

	public NotFoundException() {
		super(MSG);
	}

	public NotFoundException(String msg) {
		super(msg);
	}

}
