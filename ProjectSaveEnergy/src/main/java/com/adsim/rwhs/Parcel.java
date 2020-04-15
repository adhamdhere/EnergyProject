package com.adsim.rwhs;

public class Parcel {
    private double latitude;
    private double longitude;
    private double[] coordinates;
    private String address;

    // Setter, latitude
    public void setLatitude(double lat){
        latitude = lat;
    }

    // Setter, longitude
    public void setLongitude(double lon){
        longitude = lon;
    }

    // Setter, coordinates array
    public void setCoordinates(double[] coord){
        coordinates = coord;
    }

    // Setter, address
    public void setAddress(String addr){
        address = addr;
    }

    // Getter, latitude
    public double getLatitude(){
        return latitude;
    }

    // Getter, longitude
    public double getLongitude(){
        return longitude;
    }

    // Getter, coordinate array
    public double[] getCoordinates(){
        return coordinates;
    }

    // Getter, address
    public String getAddress(){
        return address;
    }




}
