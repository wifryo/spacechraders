package wifryo.spacechraders.controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wifryo.spacechraders.entity.Employee;
import wifryo.spacechraders.service.EmployeeService;
import wifryo.spacechraders.utils.HttpRequester;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class GregController {




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
        HttpRequester jim = new HttpRequester();
        jim.sendGet();
        return "chode";
    }
}