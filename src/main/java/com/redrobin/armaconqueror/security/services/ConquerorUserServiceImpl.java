package com.redrobin.armaconqueror.security.services;

import java.util.ArrayList;

import com.redrobin.armaconqueror.security.exceptions.EmailExistsException;
import com.redrobin.armaconqueror.security.models.AuthenticatedUser;
import com.redrobin.armaconqueror.security.models.ConquerorUser;
import com.redrobin.armaconqueror.security.repository.UserRepository;
import com.redrobin.armaconqueror.web.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ConquerorUserServiceImpl implements ConquerorUserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public ConquerorUserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AuthenticatedUser registerNewUserAccount(ConquerorUser serviceUser) throws EmailExistsException {

        // todo: return false
        if (emailExist(serviceUser.getEmail())) {
            throw new EmailExistsException("There is an account with that email adress:" + serviceUser.getEmail());
        }

        User user = new User();
        user.setFirstName(serviceUser.getFirstName());
        user.setLastName(serviceUser.getLastName());

        user.setPassword(passwordEncoder.encode(serviceUser.getPassword()));

        user.setEmail(serviceUser.getEmail());

        userRepository.save(user);

        AuthenticatedUser authenticatedUser = new AuthenticatedUser(user);
        Authentication auth = new UsernamePasswordAuthenticationToken(authenticatedUser, null,
                new ArrayList<GrantedAuthority>());

        // todo: wrap this is a bean?
        SecurityContextHolder.getContext().setAuthentication(auth);

        return authenticatedUser;

    }

    private boolean emailExist(String email) {
        return userRepository.findByEmail(email) != null;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.springframework.security.core.userdetails.UserDetailsService#
     * loadUserByUsername(java.lang.String)
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Could not find user " + username);
        }
        return new AuthenticatedUser(user);
    }
}