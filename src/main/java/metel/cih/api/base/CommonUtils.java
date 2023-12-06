package metel.cih.api.base;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CommonUtils {
    public static String IsShorts(String vid){
        String result ="N";
        try {
            String url = "https://www.youtube.com/shorts/";
            url += vid;
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                result = "Y";
            }
        } catch (IOException ex) {
            return "N";
        }
        return result;
    }
}
