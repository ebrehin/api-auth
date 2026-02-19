package com.repositories;

import com.entities.Authentification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository JPA permettant l'accès aux données
 * d'authentification en base.
 *
 * <p>
 * Hérite des fonctionnalités CRUD de {@link JpaRepository}.
 * </p>
 */
@Repository
public interface AuthentificationRepository extends JpaRepository<Authentification, String> {
}