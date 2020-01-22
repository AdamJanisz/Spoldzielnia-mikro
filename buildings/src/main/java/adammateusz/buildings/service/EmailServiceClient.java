package adammateusz.buildings.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "EMAIL-SERVICE")
public interface EmailServiceClient {

    @GetMapping(value = "/email/{emailAddress}")
    ResponseEntity<String> sendEmail(@PathVariable String emailAddress);
}
