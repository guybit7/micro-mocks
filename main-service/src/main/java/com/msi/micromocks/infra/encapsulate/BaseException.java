package com.msi.micromocks.infra.encapsulate;

public abstract class BaseException extends RuntimeException {
	
	private String exceptionCode;

	public BaseException(String exceptionCode) {
		super(exceptionCode);
		this.exceptionCode = exceptionCode;
	}
	
	public BaseException(String exceptionCode, String msg, Throwable cause) {
		super(msg, cause);
		this.exceptionCode = exceptionCode;
	}
	
}
