package com.au.iroqquois.terrible_messsanger.service;

import com.au.iroqquois.terrible_messsanger.domain.entity.Action;

import java.util.UUID;

public interface ActionService {
    Action create(User user, String actionName);
    void verify(UUID id);
}
