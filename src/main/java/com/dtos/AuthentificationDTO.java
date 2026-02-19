package com.dtos;

import lombok.*;

import java.time.LocalDate;

/**
 * DTO (Data Transfer Object) utilisé pour exposer les données
 * d'authentification via l'API REST.
 *
 * <p>
 * Le mot de passe peut être exclu dans certaines réponses pour
 * des raisons de sécurité.
 * </p>
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthentificationDTO {

    private String pseudo;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private String mdp;
    private String statut;
    private String adresse;
}
