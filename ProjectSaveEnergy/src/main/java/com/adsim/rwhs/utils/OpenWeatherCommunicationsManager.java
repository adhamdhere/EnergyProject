package com.adsim.rwhs.utils;

import com.adsim.rwhs.data.OpenWeatherVO;
import com.adsim.rwhs.data.Precipitation;
import com.adsim.rwhs.data.Result;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URL;


public class OpenWeatherCommunicationsManager {

    // Requires lat and lon
    public static double getAverageRain(double lat, double lon){
        String url = " " + lat + "," + lon;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        try{
            URL fileURL = new URL(Constants.OPEN_WATHER_FILE_URL);
            OpenWeatherVO weatherData = objectMapper.readValue(fileURL, OpenWeatherVO.class);
            double sum = 0.0;
            for(Result r : weatherData.getResult()){
                sum += r.getPrecipitation().getMean();
            }

            return sum/weatherData.getResult().length;

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
