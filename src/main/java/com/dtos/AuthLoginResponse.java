package com.dtos;

import lombok.*;

/**
 * DTO pour la réponse de connexion.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthLoginResponse {
    private String token;
    private String pseudo;
}
