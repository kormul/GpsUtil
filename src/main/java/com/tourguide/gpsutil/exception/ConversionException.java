package com.tourguide.gpsutil.exception;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class ConversionException extends Exception{

	
	private Logger logger = LogManager.getLogger();
	public ConversionException(String id) {
		super("UserID invald : " + id);
		logger.error("UserID is invalid : " + id );
	}

}
