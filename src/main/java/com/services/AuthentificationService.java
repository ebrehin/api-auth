package com.services;

import com.dtos.AuthentificationDTO;

import java.util.List;

/**
 * Service métier gérant la logique applicative
 * liée à l'authentification des utilisateurs.
 */
public interface AuthentificationService {

    AuthentificationDTO register(AuthentificationDTO dto);

    AuthentificationDTO getByPseudo(String pseudo);

    List<AuthentificationDTO> getAll();

    void delete(String pseudo);
}
