package com.apm.quizback.exception;

public class InvalidDataException extends Exception{

	private static final long serialVersionUID = -3682963642308262757L;
	
	public static final String MSG = "Invalid Data.";
	
	public InvalidDataException() {
		super(MSG);
	}
	
	public InvalidDataException(String msg) {
		super(msg);
	}
	
}
