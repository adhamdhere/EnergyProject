package com.rtnr.vo;

import com.rtnr.data.Coordinate;

public class Parcel {
    private Coordinate locationCoordinate;
    private String address;
    private Coordinate[] polygonCoordinate;
    private double area;

        public Coordinate getLocationCoordinate() {
                return locationCoordinate;
        }
        public void setLocationCoordinate(Coordinate locationCoordinate) {
                this.locationCoordinate = locationCoordinate;
        }
        public String getAddress() {
                return address;
        }
        public void setAddress(String address) {
                this.address = address;
        }
        public Coordinate[] getPolygonCoordinate() {
                return polygonCoordinate;
        }
        public void setPolygonCoordinate(Coordinate[] polygonCoordinate) {
                this.polygonCoordinate = polygonCoordinate;
        }
        public double getArea() {
                return area;
        }
        public void setArea(double area) {
                this.area = area;
        }

}
