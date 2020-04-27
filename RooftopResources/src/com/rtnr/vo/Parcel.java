package com.rtnr.vo;

import com.rtnr.data.Coordinate;

public class Parcel {
    private double latitude;
    private double longitude;
    private String address;
    private Coordinate[] coordinate;
    
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public Coordinate[] getCoordinate() {
		return coordinate;
	}
	public void setCoordinate(Coordinate[] coordinate) {
		this.coordinate = coordinate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

   
}