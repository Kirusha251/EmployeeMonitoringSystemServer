package by.specificgroup.kirill.controller;

import by.specificgroup.kirill.hashing.HashData;
import by.specificgroup.kirill.model.RegistrationCredentials;
import by.specificgroup.kirill.model.Users;
import by.specificgroup.kirill.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * Created by user1 on 7/10/2017.
 */
@RestController
@RequestMapping(value = "user")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    Authentication auth;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<Collection<Users>> getAllUsers(){
        return ResponseEntity.ok(userRepository.findAll());
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity createUser(@RequestBody RegistrationCredentials credentials){

        if(userRepository.findByEmail(credentials.getEmail())!=null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        userRepository.save(new Users(credentials.getUsername(), credentials.getEmail(), HashData.getHashByData(credentials.getPassword())));
        return new ResponseEntity(HttpStatus.OK);
    }

    @RequestMapping(value = "/signed", method = RequestMethod.GET)
    public ResponseEntity<Users> getSignedUser(){
        auth = SecurityContextHolder.getContext().getAuthentication();
        Users user = userRepository.findByEmail(auth.getName());
        if (user == null) {
            return ResponseEntity.badRequest().body(null);
        }
        return ResponseEntity.ok(user);
    }
}
