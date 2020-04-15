package com.adsim.rwhs.data;

public class Precipitation {

    private double min;
    private double max;
    private double median;
    private double mean;
    private double p25;
    private double p75;
    private double st_dev;
    private double num;

    public double getMean(){
        return this.mean;
    }
    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }

    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public double getMedian() {
        return median;
    }

    public void setMedian(double median) {
        this.median = median;
    }

    public void setMean(double mean) {
        this.mean = mean;
    }

    public double getP25() {
        return p25;
    }

    public void setP25(double p25) {
        this.p25 = p25;
    }

    public double getP75() {
        return p75;
    }

    public void setP75(double p75) {
        this.p75 = p75;
    }

    public double getSt_dev() {
        return st_dev;
    }

    public void setSt_dev(double st_dev) {
        this.st_dev = st_dev;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }
}
