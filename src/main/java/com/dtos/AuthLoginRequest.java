package com.dtos;

import lombok.*;

/**
 * DTO pour la requête de connexion.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthLoginRequest {
    private String pseudo;
    private String mdp;
}
