package adammateusz.buildings.service;

import adammateusz.buildings.domain.AppUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "USER-SERVICE")
public interface AppUserServiceClient{
    @GetMapping(value = "/appUser/")
    List<AppUser> getAppUsers();
}
