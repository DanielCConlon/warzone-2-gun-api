package com.warzone2.controller;

import com.warzone2.model.User;
import com.warzone2.model.WeaponClass;
import com.warzone2.repository.UserRepository;
import com.warzone2.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/api/users")
    public User addUser(@RequestBody User user) {
//        encrypt password
        user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
        repository.save(user);
        return user;
    }


    @PutMapping("/api/users/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user) {
        User tempUser = repository.getById(id);
        if (!tempUser.equals(null)) {
            user.setId(tempUser.getId());
            repository.save(user);
        }
        return user;
    }
    @DeleteMapping("/api/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable int id) {
        repository.deleteById(id);
    }

}
