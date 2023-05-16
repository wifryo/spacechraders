package wifryo.spacechraders.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

public class JsonUrlReader {

    @Value("$spacechraders.apiKey")
    private String apiKey;
    private String apiUrl = "https://api.spacetraders.io/v2/my/agent";

   public void go() throws StreamReadException, DatabindException, MalformedURLException, IOException {
       WebClient client = WebClient.builder()
               .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
               .defaultHeader("Authorization", apiKey)
               .build();

        JsonNode node = JsonUrlReader.get(client, apiUrl);
        System.out.println(node.toPrettyString());
    }

    //this one works
/*    public static JsonNode get(String url) throws StreamReadException, DatabindException, MalformedURLException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode json = mapper.readTree(new URL(url));
        return json;
    }*/

    public static JsonNode get(WebClient client, String url) {
        return client.get()
                .uri(url)
                .retrieve()
                .bodyToMono(JsonNode.class)
                .block();
    }

/*    public static <T> T get(String url, Class<T> type) throws StreamReadException, DatabindException, MalformedURLException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        T entity = mapper.readValue(new URL(url), type);
        return entity;
    }*/

}