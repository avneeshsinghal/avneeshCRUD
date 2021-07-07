package com.avneeshCRUD.avneeshCRUD.custom.exception;

import org.springframework.stereotype.Component;

@Component
public class ControllerException extends RuntimeException {

	
	
	private static final long serialVersionUID = 1L;
	private String code;
	private String errorMessage;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public ControllerException(String code, String errorMessage) {
		super();
		this.code = code;
		this.errorMessage = errorMessage;
	}
	
	
	public ControllerException() {
		
	}
}
