import org.json.JSONArray;
import org.json.JSONObject;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

// Makes HTTP calls, parses their JSON response to return desired values

public class DataGrab {

    public static void makeAverageRainRequest(double lat, double lon){

        // this will be OpenWeather API not DarkSky
        String url = "https://api.darksky.net/forecast/3d69f87ee0bee3fb9581465d2209d119/" + lat + "," + lon;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();

        //thenApply, once response received, apply next method to previous result
        // :: means lambda expression, want to use body method from HttpResponse class on the previous response
        //thenAccept, use that body to print out on println method

        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenAccept(System.out::println)
                .join();
    }
        // returns average rain fall
        // input a JSON, in form of a String after making HTTP call to OpenWeather API
    public static double parseAverageRain(String responseBody){
        JSONObject input = new JSONObject(responseBody);
        JSONArray results = new JSONArray(input.getJSONArray("result"));
        JSONObject precipitation = new JSONObject(results.getJSONObject(7));
        double getAverageRain = precipitation.getDouble("mean");
        return getAverageRain;
    }
}
