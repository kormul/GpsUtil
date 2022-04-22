package com.tourguide.gpsutil.service;

import java.util.List;
import java.util.UUID;

import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;

public interface GpsUtilService {
	

	public VisitedLocation getUserLocation(UUID userId);
	public List<Attraction> getAttractions();
	
}
