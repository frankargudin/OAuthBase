package com.oauth.oauthbase.controller;

import com.oauth.oauthbase.model.User;
import com.oauth.oauthbase.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;



import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value="/user", method = RequestMethod.GET)
    public List<User> listUser(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public User create(@RequestBody User user){
        return userRepository.save(user);
    }

//    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
//    public String delete(@PathVariable(value = "id") long id){
//        userRepository.delete(id);
//        return "success";
//    }

    @RequestMapping(value="/existUser", method = RequestMethod.GET)
    public User existUser(@Param("username")String username, @Param("password")String password){
        boolean exist = true;
        User user = userRepository.findByUsernameAndPassword(username,password);
        return user;

    }

    @GetMapping("usuario")
    public String helloUser() {
        return "Hello User";
    }

    @GetMapping("admin")
    public String helloAdmin() {
        return "Hello Admin";
    }
}