package com.adsim.rwhs;

import com.adsim.rwhs.utils.Constants;
import com.adsim.rwhs.utils.OpenWeatherCommunicationsManager;

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
