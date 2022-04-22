 package com.tourguide.gpsutil.service;

import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import gpsUtil.GpsUtil;
import gpsUtil.location.Attraction;
import gpsUtil.location.VisitedLocation;

@Service
public class GpsUtilServiceImpl implements GpsUtilService {
	
	private Logger logger = LogManager.getLogger();

	private GpsUtil gpsUtil = new GpsUtil();
	
	private ExecutorService executorService = Executors.newFixedThreadPool(32000);

	public VisitedLocation getUserLocation(UUID userId) {
		
		logger.debug("Get User Location");
		Locale.setDefault(Locale.US); 
		return gpsUtil.getUserLocation(userId);
	}

	public List<Attraction> getAttractions() {
		
		logger.debug("Get User Location");
		
		
		try {
			return CompletableFuture.supplyAsync(()-> {	
				return gpsUtil.getAttractions();
			}, executorService ).get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
