package com.mrv.security.service;

import com.mrv.entity.abstracts.User;
import com.mrv.repository.AdminRepository;
import com.mrv.repository.ClientRepository;
import com.mrv.utilis.Messages;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AdminRepository adminRepository;
    private final ClientRepository clientRepository;



    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = null;
        User    admin=   adminRepository.findByUsernameEquals(username);
        if (admin != null) {
            user = admin;
        }
        User client= clientRepository.findByUsernameEquals(username);
        if (client != null) {
            user = client;
        }
        if (user != null) {
            return new UserDetailsImpl(
                    user.getId(),
                    user.getUsername(),
                    user.getName(),
                    user.getPassword(),
                    user.getUserRole().getRoleType().name());
        }
        throw new UsernameNotFoundException(String.format(Messages.USERNAME_NOT_FOUND,username));
    }
}
