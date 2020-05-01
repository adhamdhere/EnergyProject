package com.rtnr.engine;

import com.rtnr.utils.Constants;
import com.rtnr.utils.MeteoStatCommunicationsManager;
import com.rtnr.utils.OpenWeatherCommunicationsManager;
import com.rtnr.vo.Analysis;
import com.rtnr.vo.Parcel;

public class Analyzer {


    public static Analysis analyze(Parcel p){
        // build url from p
        // call url to receive json
        // parse json to get avg rainfall for p
        // calculate area of p
        // do math for water saving
        // set value in analysis

        Analysis a = new Analysis();
        a.setP(p);
        //a.setWaterSavings((p.getArea()/Constants.FEET_SQUARED_TO_METERES_SQUARED) * (OpenWeatherCommunicationsManager.getAverageRain(p.getLocationCoordinate().getLat(), p.getLocationCoordinate().getLng())/Constants.MM_TO_M));
        try {
			a.setWaterSavings((p.getArea()/Constants.FEET_SQUARED_TO_METERES_SQUARED) * (MeteoStatCommunicationsManager.getAverageRain(p.getLocationCoordinate().getLat(), p.getLocationCoordinate().getLng())/Constants.MM_TO_M));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return a;

    }

        /*
         * private static double shoelaceArea(Coordinate[] c) { int n = c.length; double
         * a = 0.0; for (int i = 0; i < n - 1; i++) { a += c[i].getLatitude() * c[i +
         * 1].getLongitude() - c[i + 1].getLatitude() * c[i].getLongitude(); }
         *
         * return Math.abs(a + c[n - 1].getLatitude() * c[0].getLongitude() -
         * c[0].getLatitude() * c[n - 1].getLongitude()) / 2.0; }
         */

        /*
         * private static double shoelaceArea(List<Point> v) { int n = v.size(); double
         * a = 0.0; for (int i = 0; i < n - 1; i++) { a += v.get(i).x * v.get(i + 1).y -
         * v.get(i + 1).x * v.get(i).y; } return Math.abs(a + v.get(n - 1).x *
         * v.get(0).y - v.get(0).x * v.get(n - 1).y) / 2.0; }
         */

}
