package com.rtnr.engine;

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
        a.setWaterSavings(OpenWeatherCommunicationsManager.getAverageRain(p.getLatitude(), p.getLongitude()));
        return a;

    }
}
