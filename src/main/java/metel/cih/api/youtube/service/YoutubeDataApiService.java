package metel.cih.api.youtube.service;

import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestInitializer;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.util.DateTime;
import com.google.api.services.youtube.YouTube;
import com.google.api.services.youtube.model.ChannelListResponse;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;

import com.google.api.services.youtube.model.PlaylistItem;
import com.google.api.services.youtube.model.PlaylistItemListResponse;
import com.google.api.services.youtube.model.SearchListResponse;
import lombok.extern.slf4j.Slf4j;
import metel.cih.api.dto.YoutubeVideoDto;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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
//    private static final String YOUTUBE_API_KEY = "AIzaSyCU6n82YBGi7Q3cFPScwqUtPI4q3-oxDXc";
    private static final String YOUTUBE_API_KEY = "AIzaSyBiLtIN06CXDJ_fsp6mEe0njdZ_tfUbBsU";

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
            ChannelListResponse response = request.setId(channelId).setKey(YOUTUBE_API_KEY)
                    .setMaxResults(NUMBER_OF_VIDEOS_RETURNED).execute();
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

    public PlaylistItemListResponse getPlayListItems(String playListId, String nextPageToken, String prevPageToken){
        try{
            YouTube youtubeService = getService();
            YouTube.PlaylistItems.List request = youtubeService.playlistItems().list("snippet,contentDetails,status")
                .setPlaylistId(playListId).setKey(YOUTUBE_API_KEY).setMaxResults(NUMBER_OF_VIDEOS_RETURNED);
            if(nextPageToken != null && !nextPageToken.isEmpty()){
                request.setPageToken(nextPageToken);
            }
            if(prevPageToken != null && !prevPageToken.isEmpty()){
                request.setPageToken(prevPageToken);
            }
            return request.execute();
        }catch (GoogleJsonResponseException e) {
            System.err.println("There was a service error: " + e.getDetails().getCode() + " : "
                    + e.getDetails().getMessage());
        } catch (IOException e) {
            System.err.println("There was an IO error: " + e.getCause() + " : " + e.getMessage());
        } catch (Throwable t) {
            log.debug(t.getMessage());
        }
        return null;
    }

    public SearchListResponse getVideosBySearch(String channelId, String q, String order, String duration, String nextPageToken, String prevPageToken){
        try{
            YouTube youtubeService = getService();
            YouTube.Search.List request = youtubeService.search().list("snippet")
                    .setKey(YOUTUBE_API_KEY)
                    .setChannelId(channelId)
                    .setMaxResults(NUMBER_OF_VIDEOS_RETURNED)
                    .setSafeSearch("strict")
                    .setType("video")
                    .setVideoLicense("youtube");
                    // .setPublishedAfter(DateTime.parseRfc3339("2023-01-01T00:00:00Z"))
            if(q != null && !q.isEmpty()) {
                request.setQ(q);
            }
            if(order != null && !order.isEmpty()){
                request.setOrder(order);
            }
            if(duration.equals("short")){
                request.setVideoDuration("short");
            }
            if(nextPageToken != null && !nextPageToken.isEmpty()){
                request.setPageToken(nextPageToken);
            }
            if(prevPageToken != null && !prevPageToken.isEmpty()){
                request.setPageToken(prevPageToken);
            }
            System.out.println(channelId + "-" + q + "-"+ order+"-" + duration);
            return request.execute();
        }catch (GoogleJsonResponseException e) {
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
