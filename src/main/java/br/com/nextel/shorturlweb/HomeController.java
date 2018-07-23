package br.com.nextel.shorturlweb;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @PostMapping("/encurta")
    @ResponseBody
    public ResponseEntity<String> encurta(@RequestBody String url) {
        RestTemplate restTemplate = new RestTemplateBuilder().build();
        ResponseEntity<String> responseEntity = restTemplate.postForEntity("http://localhost:8091", url, String.class);
        return responseEntity;
    }
}
