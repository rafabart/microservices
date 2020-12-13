package com.hrworker.resources;

import com.hrworker.entities.Worker;
import com.hrworker.repositories.WorkerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/workers")
public class WorkerResource {

    private final WorkerRepository workerRepository;


    @GetMapping
    public ResponseEntity<List<Worker>> findAll() {
        return ResponseEntity.ok(workerRepository.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Worker> findById(@PathVariable final Long id) {
        return ResponseEntity.ok(workerRepository.findById(id).get());
    }
}
