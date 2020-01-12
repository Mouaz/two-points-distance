package com.mashkor.maps.client;

import com.mashkor.models.GeoPoint;

public interface IGoogleMapsClient {

	String getDistanceBetweenTwoPoints(GeoPoint origin, GeoPoint destination);
	String getDistanceBetweenTwoPlaces(String originPlaceId,
			String destinationPlaceId);
	String getEmbedKey();
}
