package com.au.iroqquois.terrible_messsanger.service.impl;

import com.au.iroqquois.terrible_messsanger.domain.entity.User;
import com.au.iroqquois.terrible_messsanger.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Override
    public User getEntity(String username) {
        return null;
    }

    @Override
    public User getSelf() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            Object principal = authentication.getPrincipal();

            if (principal instanceof UserDetails userDetails) {
                String username = userDetails.getUsername();

                return getEntity(username);
            }
        }

        throw new RuntimeException("User not found");
    }
}
