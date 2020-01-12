package com.mashkor.maps.request;

public class PlacesDistanceRequest {

	private String originPlaceId;
	private String destinationPlaceId;
	public String getDestinationPlaceId() {
		return destinationPlaceId;
	}
	public void setDestinationPlaceId(String destinationPlaceId) {
		this.destinationPlaceId = destinationPlaceId;
	}
	public String getOriginPlaceId() {
		return originPlaceId;
	}
	public void setOriginPlaceId(String originPlaceId) {
		this.originPlaceId = originPlaceId;
	}
}
