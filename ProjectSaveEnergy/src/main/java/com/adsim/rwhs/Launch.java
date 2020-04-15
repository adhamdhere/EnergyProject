package com.adsim.rwhs;

import com.adsim.rwhs.Analysis;
import com.adsim.rwhs.Analyzer;
import com.adsim.rwhs.Parcel;

public class Launch {
    public static void main(String[] args){
        String lat = args[0];
        String lng = args[1];
        String address = args[2];

        double lt = Double.parseDouble(lat);
        double ln = Double.parseDouble(lng);


        System.out.println(address);
        Parcel p = new Parcel();
        p.setAddress("15 Blackthorn Dr");
        p.setLatitude(lt);
        p.setLongitude(ln);

        Analysis a = new Analyzer().analyze(p);
        System.out.println(a.getWaterSavings());
    }
}
