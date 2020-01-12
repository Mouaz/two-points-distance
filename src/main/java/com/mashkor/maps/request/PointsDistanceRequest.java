package com.mashkor.maps.request;

import com.mashkor.models.GeoPoint;

public class PointsDistanceRequest {

	private GeoPoint origin;
	private GeoPoint destination;
	public GeoPoint getOrigin() {
		return origin;
	}
	public void setOrigin(GeoPoint origin) {
		this.origin = origin;
	}
	public GeoPoint getDestination() {
		return destination;
	}
	public void setDestination(GeoPoint destination) {
		this.destination = destination;
	}

}
