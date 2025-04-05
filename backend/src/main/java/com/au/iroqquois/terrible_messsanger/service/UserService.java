package com.au.iroqquois.terrible_messsanger.service;

import com.au.iroqquois.terrible_messsanger.domain.entity.User;

public interface UserService {

    User getEntity(String username);

    User getSelf();
}
