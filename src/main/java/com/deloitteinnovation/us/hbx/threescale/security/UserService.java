package com.deloitteinnovation.us.hbx.threescale.security;

import com.deloitteinnovation.us.hbx.threescale.data.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class UserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = User.builder().id(Long.MIN_VALUE).role(User.Role.ADMIN).email("risuarez@deloitte.com").password("123").build();
        GrantedAuthority authority = new SimpleGrantedAuthority(user.getRole().name());
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), Arrays.asList(authority));
    }
}