package com.clients.impl;

import com.clients.UserDirectoryClient;
import com.clients.UserDirectoryUser;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDirectoryClientPlaceholder implements UserDirectoryClient {

    @Value("${user.api.base-url:}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    @Override
    public Optional<UserDirectoryUser> fetchByPseudo(String pseudo) {
        if (baseUrl == null || baseUrl.isBlank()) {
            return Optional.empty();
        }

        try {
            ResponseEntity<List<Map<String, Object>>> response = restTemplate.exchange(
                    baseUrl + "/users",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<>() {}
            );

            List<Map<String, Object>> users = response.getBody();
            if (users == null) return Optional.empty();

            return users.stream()
                    .filter(u -> pseudo.equals(u.get("pseudo")))
                    .findFirst()
                    .map(u -> new UserDirectoryUser(
                            (String) u.get("pseudo"),
                            (String) u.get("motDePasse"),
                            String.valueOf(u.get("statut"))
                    ));
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
