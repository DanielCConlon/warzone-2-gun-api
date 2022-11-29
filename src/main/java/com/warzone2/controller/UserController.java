package com.warzone2.controller;

import com.warzone2.model.User;
import com.warzone2.model.WeaponClass;
import com.warzone2.repository.UserRepository;
import com.warzone2.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserRepository repository;

    @Autowired
    VoteRepository voteRepository;

    @GetMapping("/api/users")
    public List<User> getAllUsers() {
        List<User> userList = repository.findAll();

        for(User u : userList) {
            List<WeaponClass> weaponClassList = u.getWeaponClasses();
            for (WeaponClass w : weaponClassList) {
                w.setVoteCount(voteRepository.countVotesByPostId(w.getId()));
            }
        }
        return userList;
    }

    @GetMapping("/api/users/{id}")
    public User getUserById(@PathVariable Integer id) {
        User returnUser = repository.getById(id);
        List<WeaponClass> weaponClassList = returnUser.getWeaponClasses();

        for (WeaponClass w : weaponClassList) {
            w.setVoteCount(voteRepository.countVotesByPostId(w.getId()));
        }

        return returnUser;
    }

}
