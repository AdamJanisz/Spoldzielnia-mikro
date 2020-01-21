package adammateusz.buildings.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "EMAIL-SERVICE")
public interface EmailServiceClient {

    @PostMapping(value = "/email/{emailAddress}")
    void sendEmail(@PathVariable String emailAddress);
}
