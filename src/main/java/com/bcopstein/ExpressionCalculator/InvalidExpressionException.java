package com.bcopstein.ExpressionCalculator;

public class InvalidExpressionException extends RuntimeException {
	public InvalidExpressionException(String message) {
		super(message);
	}

	public InvalidExpressionException(Throwable cause) {
		super(cause);
	}
}
