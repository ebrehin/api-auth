package com.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

/**
 * Entité représentant les informations d'authentification d'un utilisateur.
 *
 * <p>
 * Cette classe est mappée sur une table en base de données via JPA/Hibernate.
 * Elle contient les informations personnelles et de connexion de l'utilisateur.
 * </p>
 *
 * <ul>
 *     <li>Pseudo unique</li>
 *     <li>Nom et prénom</li>
 *     <li>Date de naissance</li>
 *     <li>Mot de passe (hashé)</li>
 *     <li>Statut utilisateur (ACTIF, INACTIF, BLOQUE...)</li>
 *     <li>Adresse</li>
 * </ul>
 *
 * @author
 */
@Entity
@Table(name = "authentifications")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Authentification {

    /**
     * Pseudo unique de l'utilisateur.
     * Sert de clé primaire et d'identifiant de connexion.
     */
    @Id
    @Column(nullable = false, unique = true, updatable = false)
    private String pseudo;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    private LocalDate dateNaissance;

    @Column(nullable = false)
    private String mdp;

    @Column(nullable = false)
    private String statut;

    private String adresse;
}