package com.rtnr.utils;

import java.io.IOException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtnr.data.OpenWeatherValues;
import com.rtnr.data.Result;

import java.net.URL;

public class OpenWeatherCommunicationsManager {

    // Requires lat and lon
    public static double getAverageRain(double lat, double lon){
        String url = Constants.OPEN_WEATHER_FILE_URL; //when external URL, add + lat, + lon
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try{
            URL fileURL = new URL(url);
            OpenWeatherValues weatherData = objectMapper.readValue(fileURL, OpenWeatherValues.class);
            double sum = 0.0;
            for(Result r : weatherData.getResult()){
                sum += r.getPrecipitation().getMean();
            }

            return sum;

        }

        // if server cannot be reached, prints stack
        catch(IOException ioe) {
            System.out.println("Couldn't access weather data");
            ioe.printStackTrace();
        }

        catch(Exception e){
            System.out.println("Unknown");
            e.printStackTrace();
        }
        return -1;
    }
    
}