package com.zola.invoice.exception;

public class ZolaException extends RuntimeException {
	private static final long serialVersionUID = 3210861420662761156L;

	public ZolaException(Throwable throwable) {
		super(throwable);
	}
}
