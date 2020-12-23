package com.user.resources;

import com.user.entities.User;
import com.user.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserResource {

    private final UserRepository userRepository;


    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable final Long id) {

        return ResponseEntity.ok(userRepository.findById(id).get());
    }

    @GetMapping("/search")
    public ResponseEntity<User> findByEmail(@RequestParam final String email) {

        return ResponseEntity.ok(userRepository.findByEmail(email));
    }
}
