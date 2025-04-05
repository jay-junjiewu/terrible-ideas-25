package com.au.iroqquois.terrible_messsanger.domain.entity.security;

import com.au.iroqquois.terrible_messsanger.domain.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@AllArgsConstructor
public class CustomUserDetails implements UserDetails {

    private String password;
    private String username;
    private Boolean isEnabled;

    public CustomUserDetails(User user) {
        this.password = user.getPassword();
        this.username = user.getUsername();
        this.isEnabled = true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
