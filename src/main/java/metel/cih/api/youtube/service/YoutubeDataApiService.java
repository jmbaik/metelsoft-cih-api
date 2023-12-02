package metel.cih.api.youtube.service;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ChannelListResponse;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.io.IOException;


@Slf4j
@Service
public class YoutubeDataApiService {

    /** Global instance properties filename. */
    private static final String PROPERTIES_FILENAME = "youtube.properties";
    /** Global instance of the HTTP transport. */
    private static final HttpTransport HTTP_TRANSPORT = new NetHttpTransport();
    /** Global instance of the JSON factory. */
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    /** Global instance of the max number of videos we want returned (50 = upper limit per page). */
    private static final long NUMBER_OF_VIDEOS_RETURNED = 50;
    /** Global instance of Youtube object to make all API requests. */
    private static final String YOUTUBE_API_KEY = "AIzaSyCU6n82YBGi7Q3cFPScwqUtPI4q3-oxDXc";

    public static YouTube getService() throws IOException{
        return new YouTube.Builder(HTTP_TRANSPORT, JSON_FACTORY, new HttpRequestInitializer() {
            public void initialize(HttpRequest request) throws IOException {}
        }).setApplicationName("metelsoft-cih-api").build();
    }

    public ChannelListResponse getPlayListByChannelId(String channelId) {
        try{
            /*
             * The YouTube object is used to make all API requests. The last argument is required, but
             * because we don't need anything initialized when the HttpRequest is initialized, we override
             * the interface and provide a no-op function.
             */
           YouTube youtubeService = getService();
            YouTube.Channels.List request = youtubeService.channels()
                    .list("snippet,contentDetails,statistics");
            // ChannelListResponse response = request.setId("UC_x5XG1OV2P6uZZ5FSM9Ttw").execute();
            ChannelListResponse response = request.setId(channelId).execute();
            System.out.println(response);
            return response;
        } catch (GoogleJsonResponseException e) {
            System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
        } catch (IOException e) {
            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        } catch (Throwable t) {
            log.debug(t.getMessage());
        }
        return null;
    }
}
