package com.security;

import com.entities.Authentification;
import com.repositories.AuthentificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Charge un utilisateur à partir du pseudo stocké en base.
 */
@Service
@RequiredArgsConstructor
public class AuthentificationUserDetailsService implements UserDetailsService {

    private final AuthentificationRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Authentification auth = repository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException("Utilisateur non trouvé"));

        return User.withUsername(auth.getPseudo())
                .password(auth.getMdp())
                .roles("USER")
                .build();
    }
}
