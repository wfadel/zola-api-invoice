package com.zola.invoice.api.dto;

import java.io.Serializable;

public class ErrorDto implements Serializable {
	private static final long serialVersionUID = 7289803765133892918L;

	private int statusCode;
	private String message;

	private ErrorDto() {

	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static class ErrorDtoBuilder {
		private int statusCode;
		private String message;

		public ErrorDtoBuilder statusCode(int statusCode) {
			this.statusCode = statusCode;
			return this;
		}

		public ErrorDtoBuilder message(String message) {
			this.message = message;
			return this;
		}

		public ErrorDto build() {
			ErrorDto result = new ErrorDto();
			result.setStatusCode(statusCode);
			result.setMessage(message);
			return result;
		}
	}
}
