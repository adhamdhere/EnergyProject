import java.awt.*;

public class Unit {
    // instance variables

    double latitude;
    double longitude;
    double[] coordinates;

    public static void main(String args[]){
        // want it to return proper output values;
        DataFetch.getAverageRain();
    }

    // Constructor, with all required inputs for model
    public Unit(double lt, double lg, double[] cr){
        latitude = lt;
        longitude = lg;
        coordinates = cr;
    }

    private double area(int[] c){
        double area = 0.0;
        // method should return the area of the inputted polygon
        return area;
    }

    private double averagerainfall(double latitude, double longitude){
        // method needs to use getrainavg in DataFetch class, pass lat and long to get data returned
        DataFetch.getAverageRain();
        return 0.0;
    }
}