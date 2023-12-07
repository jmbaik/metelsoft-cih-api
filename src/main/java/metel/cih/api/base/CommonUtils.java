package metel.cih.api.base;

import metel.cih.api.dto.YoutubeRequestDto;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class CommonUtils {
    public static String IsShorts(String vid){
        try {
            String url = "https://www.youtube.com/shorts/" + vid;
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setInstanceFollowRedirects(false);
            connection.setRequestMethod("GET");
            int responseCode = connection.getResponseCode();
            if (responseCode == 200) {
                return "Y";
            }
        } catch (IOException ex) {
            return "N";
        }
        return "N";
    }

    public static String getQSignal(YoutubeRequestDto dto) {
        return dto.getChannelId()+"___"+ dto.getPlaylistId() + "___"+ dto.getQ();
    }
}
