package com.pensionauth.exception;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExceptionDetails {
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
	private LocalDateTime timeStamp;
	
	private String message;
	
	
	
	
	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}




	public void setTimeStamp(LocalDateTime timeStamp) {
		this.timeStamp = timeStamp;
	}




	public String getMessage() {
		return message;
	}




	public void setMessage(String message) {
		this.message = message;
	}




	public ExceptionDetails(LocalDateTime timeStamp, String message) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
	}
}
