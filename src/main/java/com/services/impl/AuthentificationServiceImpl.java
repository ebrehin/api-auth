package com.services.impl;

import com.dtos.AuthentificationDTO;
import com.entities.Authentification;
import com.mappers.AuthentificationMapper;
import com.repositories.AuthentificationRepository;
import com.services.AuthentificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implémentation du service {@link AuthentificationService}.
 *
 * <p>
 * Contient la logique métier et les interactions avec le repository.
 * </p>
 */
@Service
@RequiredArgsConstructor
public class AuthentificationServiceImpl implements AuthentificationService {

    private final AuthentificationRepository repository;
    private final AuthentificationMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthentificationDTO register(AuthentificationDTO dto) {
        if (repository.existsById(dto.getPseudo())) {
            throw new RuntimeException("Pseudo déjà utilisé");
        }
        Authentification entity = mapper.toEntity(dto);
        entity.setMdp(passwordEncoder.encode(dto.getMdp()));
        Authentification saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public AuthentificationDTO getByPseudo(String pseudo) {
        return repository.findById(pseudo)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé"));
    }

    @Override
    public List<AuthentificationDTO> getAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String pseudo) {
        repository.deleteById(pseudo);
    }
}
