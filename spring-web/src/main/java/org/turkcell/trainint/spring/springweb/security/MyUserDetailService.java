package org.turkcell.trainint.spring.springweb.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.turkcell.trainint.spring.springweb.security.models.IInternalUserRepository;
import org.turkcell.trainint.spring.springweb.security.models.InternalUser;

import java.util.Optional;

@RequiredArgsConstructor
public class MyUserDetailService implements UserDetailsService {
    private final IInternalUserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        System.out.println("(((((((((LOAD USER )))))))))))))  " + username);
        if (username.equals("loc_admin")) {
            return User.builder()
                       .username(username)
                       .password(passwordEncoder.encode("123456"))
                       .authorities("SUPER_ADMIN")
                       .build();
        }
        InternalUser myUser = userRepository.findById(username)
                                            .orElse(null);
        if (myUser == null) {
            throw new UsernameNotFoundException("böyle bir user yok");
        }
        return User.builder()
                   .username(username)
                   .password(myUser.getPassword())
                   .authorities(myUser.getRole())
                   .build();
    }

}
