package wifryo.spacechraders.controller;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;
import wifryo.spacechraders.entity.Employee;
import org.springframework.web.reactive.function.client.WebClient;

import wifryo.spacechraders.utils.JsonUrlReader;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class GregController {

    @Value("$spacechraders.apiKey")
    private String apiKey;
    private String apiUrl = "https://api.spacetraders.io/v2/my/agent";


    @GetMapping("/data")
    public ResponseEntity<Object> getData() {
        Map<String, String> data = new HashMap<>();
        data.put("key1", "value1");
        data.put("key2", "value2");
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
    @GetMapping("/persons")
    public List<Employee> getEmployees() {
        return List.of(new Employee("John","Doe","Egg"), new Employee("Adam","Smith","Egg"));
    }
    @GetMapping("/greg")
    public String getGreg() throws IOException {
        /*HttpRequester jim = new HttpRequester();
        String greb = jim.sendGet();*/
        System.out.println(apiKey);

        JsonUrlReader jim = new JsonUrlReader();
        jim.go();
        String ass = "hello";
        return ass;
    }




}