package com.mappers;

import com.dtos.AuthentificationDTO;
import com.entities.Authentification;
import org.springframework.stereotype.Component;

/**
 * Mapper responsable de la conversion entre
 * l'entité {@link Authentification} et son {@link AuthentificationDTO}.
 */
@Component
public class AuthentificationMapper {

    /**
     * Convertit une entité en DTO.
     */
    public AuthentificationDTO toDto(Authentification entity) {
        return AuthentificationDTO.builder()
                .pseudo(entity.getPseudo())
                .nom(entity.getNom())
                .prenom(entity.getPrenom())
                .dateNaissance(entity.getDateNaissance())
                .statut(entity.getStatut())
                .adresse(entity.getAdresse())
                .build();
    }

    /**
     * Convertit un DTO en entité.
     */
    public Authentification toEntity(AuthentificationDTO dto) {
        return Authentification.builder()
                .pseudo(dto.getPseudo())
                .nom(dto.getNom())
                .prenom(dto.getPrenom())
                .dateNaissance(dto.getDateNaissance())
                .mdp(dto.getMdp())
                .statut(dto.getStatut())
                .adresse(dto.getAdresse())
                .build();
    }
}
