package com.mashkor.maps.services;

import com.mashkor.models.GeoPoint;

public interface IGoogleApiBuilder {

	String getDistanceBetweenTwoPoints(GeoPoint origin, GeoPoint destination);
	String getDistanceBetweenTwoPlaces(String originPlaceId,
			String destinationPlaceId);
}
