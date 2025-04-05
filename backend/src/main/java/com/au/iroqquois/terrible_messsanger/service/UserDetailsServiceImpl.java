package com.au.iroqquois.terrible_messsanger.service;

import com.au.iroqquois.terrible_messsanger.domain.entity.User;
import com.au.iroqquois.terrible_messsanger.domain.entity.security.CustomUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getEntity(username);

        return new CustomUserDetails(user);
    }

}
