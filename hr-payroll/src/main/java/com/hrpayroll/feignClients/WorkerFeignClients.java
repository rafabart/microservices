package com.hrpayroll.feignClients;

import com.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeignClients {

    @GetMapping("/{id}")
    ResponseEntity<Worker> findById(@PathVariable final Long id);
}
