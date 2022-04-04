package com.tourguide.gpsutil.controller;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tourguide.gpsutil.exception.ConversionException;
import com.tourguide.gpsutil.service.GpsUtilService;

import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;

@RestController
public class GpsUtilController {

	private Logger logger = LogManager.getLogger();
	
	@Autowired
	GpsUtilService gpsUtilService;
	
	@GetMapping("/getUserLocation")
	public VisitedLocation getUserLocation(@RequestParam String userId) throws ConversionException {
		
		UUID userUUID = null;
		try {
			logger.debug("Get Request UserLocation");
			userUUID = UUID.fromString(userId);
		} catch (IllegalArgumentException e) {
			throw new ConversionException(userId);
		}
		return gpsUtilService.getUserLocation(userUUID);
	}
	
	@GetMapping("/getListAttractions")
    public List<Attraction> getListAttractions() {
		
		logger.debug("Get Request ListAttraction");

		return gpsUtilService.getAttractions();
	}
}
