package com.oauth.services;

import com.oauth.entities.User;
import com.oauth.feignClients.UserFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserFeignClient userFeignClient;


    public User findByEmail(final String email) {

        final User user = userFeignClient.findByEmail(email).getBody();

        if (Objects.isNull(user)) {
            log.error("Email not found: " + email);
            throw new IllegalArgumentException("Email não encontrado");
        }

        log.info("Email found: " + email);
        return user;
    }
}
