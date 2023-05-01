package com.msi.micromocks.infra.encapsulate;

public class BusinessException extends BaseException {

	public BusinessException(String msg) {
		super(msg);
	}
	
	public BusinessException(String exceptionCode, String msg, Throwable cause) {
		super(exceptionCode, msg, cause);
	}

}
