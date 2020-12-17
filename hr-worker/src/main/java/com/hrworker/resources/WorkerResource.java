package com.hrworker.resources;


import com.hrworker.entities.Worker;
import com.hrworker.repositories.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RefreshScope
@RestController
@RequiredArgsConstructor
@RequestMapping("/workers")
public class WorkerResource {

    private final WorkerRepository workerRepository;

    private final Environment environment;

    @Value("${test.config}")
    private String CONFIG;


    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        return ResponseEntity.ok(workerRepository.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable final Long id) {


        System.out.println("PORT: " + environment.getProperty("local.server.port"));
        System.out.println("CONFIG: " + CONFIG);
        return ResponseEntity.ok(workerRepository.findById(id).get());
    }
}
