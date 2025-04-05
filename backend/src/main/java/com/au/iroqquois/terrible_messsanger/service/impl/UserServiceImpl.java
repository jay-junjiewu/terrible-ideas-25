package com.au.iroqquois.terrible_messsanger.service.impl;

import com.au.iroqquois.terrible_messsanger.domain.entity.User;
import com.au.iroqquois.terrible_messsanger.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @Override
    public User getEntity(String username) {
        return null;
    }
}
