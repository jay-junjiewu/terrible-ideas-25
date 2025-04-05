package com.au.iroqquois.terrible_messsanger.service.impl;
import com.au.iroqquois.terrible_messsanger.domain.entity.Action;
import com.au.iroqquois.terrible_messsanger.domain.entity.User;
import com.au.iroqquois.terrible_messsanger.domain.repository.ActionRepository;
import com.au.iroqquois.terrible_messsanger.service.ActionService;

import com.au.iroqquois.terrible_messsanger.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
class ActionServiceImpl implements ActionService {

    private final ActionRepository actionRepository;
    private final UserService userService;

    @Override
    public Action create(User user, String actionName) {
        Action newAction = new Action();
        newAction.setUser(user);
        newAction.setActionName(actionName);
        newAction.setVerified(false);
        actionRepository.save(newAction);

        return newAction;
    }

    @Override
    public void verify(UUID id) {
        Action action = actionRepository.findById(id).orElseThrow(() -> new RuntimeException("Action not found"));

        // Check JWT token
        User user = userService.getSelf();
        if (!user.getId().equals(action.getUser().getId())) {
            throw new RuntimeException("User not found");
        }

        action.setVerified(true);
        actionRepository.save(action);
    }
}
