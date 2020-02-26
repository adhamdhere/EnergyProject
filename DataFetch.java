// designed to get data from HTTP calls
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class DataFetch {
    //https://api.darksky.net/forecast/3d69f87ee0bee3fb9581465d2209d119/37.8267,-122.4233
    public static void getAverageRain(){
        String darkskyurl = "https://api.darksky.net/forecast/3d69f87ee0bee3fb9581465d2209d119/37.8267,-122.4233";
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet get = new HttpGet(darkskyurl);

        try{
            CloseableHttpResponse rest = client.execute(get);
            HttpEntity entity = rest.getEntity();
            System.out.println("JSON Response");
            System.out.println(EntityUtils.toString(entity));
        }

        catch(IOException ioe) {
            System.out.println("Couldn't access weather data");
            ioe.printStackTrace();
        }

        catch(Exception e){
            System.out.println("Unknown");
            e.printStackTrace();
        }
    }
}