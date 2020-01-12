package com.mashkor.maps.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mashkor.models.GeoPoint;

@Service
public class GoogleApiBuilder implements IGoogleApiBuilder {

	@Value("${google.api.key}")
	private String key;

	@Value("${google.api.distancematrix.baseUrl}")
	private String baseUrl;

	@Override
	public String getDistanceBetweenTwoPoints(GeoPoint origin,
			GeoPoint destination) {
		StringBuilder sb = new StringBuilder();
		sb.append(baseUrl);
		sb.append("?units=metric&origins=");
		sb.append(origin.getLat()).append(",");
		sb.append(origin.getLon()).append("&destinations=");
		sb.append(destination.getLat()).append(",");
		sb.append(destination.getLon()).append("&key=").append(key);
		return sb.toString();
	}

	@Override
	public String getDistanceBetweenTwoPlaces(String originPlaceId,
			String destinationPlaceId) {
		StringBuilder sb = new StringBuilder();
		sb.append(baseUrl);
		sb.append("?units=metric&origins=").append("place_id:");
		sb.append(originPlaceId).append("&destinations=");
		sb.append("place_id:").append(destinationPlaceId);
		sb.append("&key=").append(key);
		return sb.toString();
	}

}
