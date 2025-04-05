package com.au.iroqquois.terrible_messsanger.domain.repository;

import com.au.iroqquois.terrible_messsanger.domain.entity.Action;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ActionRepository extends JpaRepository<Action, UUID> {
    
}
