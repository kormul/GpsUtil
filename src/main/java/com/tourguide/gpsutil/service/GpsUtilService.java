package com.tourguide.gpsutil.service;

import java.util.List;
import java.util.UUID;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import gpsUtil.GpsUtil;
import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;

@Service
public class GpsUtilService {
	
	private Logger logger = LogManager.getLogger();

	private GpsUtil gpsUtil = new GpsUtil();

	
	public VisitedLocation getUserLocation(UUID userId) {
		
		logger.debug("Get User Location");
		return gpsUtil.getUserLocation(userId);
	}

	public List<Attraction> getAttractions() {
		
		logger.debug("Get User Location");
		
		return gpsUtil.getAttractions();
	}
	
}
