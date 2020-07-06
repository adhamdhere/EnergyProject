package com.rtnr.utils;

import java.io.IOException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.rtnr.data.*;

import java.net.URL;

public class MeteoStatCommunicationsManager {

    // Requires lat and lon
    public static double getAverageRain(double lat, double lon) throws IOException, Exception{
    	String key = "API KEY GOES HERE";
    	String lat_and_lon = "lat=" + lat + "&lon=" + lon +"&limit=5&";

        String station_id_url = Constants.METEO_STAT_STATION_ID_URL + lat_and_lon + key; //when external URL, add + lat, + lon
        String climate_data_url = Constants.METEO_STAT_CLIMATE_DATA_URL;
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(
                DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        
            URL station_id = new URL(station_id_url);
            StationValue station = objectMapper.readValue(station_id, StationValue.class);
            Climate climate = null;
            
            for(StationData sv : station.getData()) {
            	URL climate_data = new URL(climate_data_url + station.getData()[0].getId() + key);
            	climate = objectMapper.readValue(climate_data, Climate.class);
            	if(climate.getData() != null)
            		break;
            }
            
            if(climate.getData() == null) throw new Exception("No Reported Data for this location");
 
            double averageRain =
            		Double.valueOf(climate.getData().getPrecipitation().JAN) + 
            		Double.valueOf(climate.getData().getPrecipitation().FEB) +
            		Double.valueOf(climate.getData().getPrecipitation().MAR) +
            		Double.valueOf(climate.getData().getPrecipitation().APR) +
            		Double.valueOf(climate.getData().getPrecipitation().MAY) +
            		Double.valueOf(climate.getData().getPrecipitation().JUN) +
            		Double.valueOf(climate.getData().getPrecipitation().JUL) +
            		Double.valueOf(climate.getData().getPrecipitation().AUG) +
            		Double.valueOf(climate.getData().getPrecipitation().SEP) +
            		Double.valueOf(climate.getData().getPrecipitation().OCT) +
            		Double.valueOf(climate.getData().getPrecipitation().NOV) +
            		Double.valueOf(climate.getData().getPrecipitation().DEC);
            
            return averageRain;

         }
    
}
