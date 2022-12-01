package com.warzone2.controller;

import com.warzone2.model.WeaponClass;
import com.warzone2.repository.UserRepository;
import com.warzone2.repository.VoteRepository;
import com.warzone2.repository.WeaponClassRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeaponClassController {
    @Autowired
    WeaponClassRepository repository;

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/api/weapons")
    public List<WeaponClass> getAllWeapons() {
        List<WeaponClass> weaponList = repository.findAll();
        for (WeaponClass w : weaponList) {
            w.setVoteCount(voteRepository.countVotesByPostId(w.getId()));
        }

        return weaponList;
    }
}
