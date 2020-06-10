package br.com.tt.petshop.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class InfraRestController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping(path = "/port")
    public ResponseEntity greetings() {
         return ResponseEntity.ok("Application running on port "+port);
    }

}
