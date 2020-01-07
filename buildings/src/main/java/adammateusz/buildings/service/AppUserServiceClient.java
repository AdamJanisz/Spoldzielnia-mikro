package adammateusz.buildings.service;

import adammateusz.buildings.domain.Owner;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "USER-SERVICE")
public interface AppUserServiceClient{
    @GetMapping(value = "/appUser/")
    List<Owner> getAppUsers();

    @GetMapping(value = "/appUser/{id}")
    Owner getAppUser(@PathVariable Long id);
}
