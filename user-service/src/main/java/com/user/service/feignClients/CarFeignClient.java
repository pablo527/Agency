package com.user.service.feignClients;

import com.user.service.models.Car;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "car-service", url = "http://localhost:8002")
@RequestMapping("/car")
public interface CarFeignClient {

    @PostMapping
     Car save(@RequestBody Car car);
}
