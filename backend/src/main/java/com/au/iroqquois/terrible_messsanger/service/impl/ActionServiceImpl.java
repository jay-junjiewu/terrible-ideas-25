package com.au.iroqquois.terrible_messsanger.service.impl;

import com.au.iroqquois.terrible_messsanger.domain.entity.Action;
import com.au.iroqquois.terrible_messsanger.service.ActionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
class ActionServiceImpl implements ActionService {

    @Override
    public Action create(Action action) {
        return null;
    }

    @Override
    public void verify(UUID id) {

    }
}
