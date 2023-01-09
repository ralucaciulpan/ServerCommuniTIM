package rr.ServerCommuniTIM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import rr.ServerCommuniTIM.model.User;
import rr.ServerCommuniTIM.service.UserService;

import java.util.List;

@RestController
@RequestMapping(path="/users")
public class UserController {
    private User authUser;
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers(){
        return userService.getUsers();
    }

    @PostMapping("/add")
    public void registerUser(){
        User ralu = new User("ralu","brunojohn","email");
        userService.registerUser(ralu);
    }
    @PostMapping("/login")
    public ResponseEntity loginUser(@RequestBody User user) {
        System.out.println("login request " + user);
        try{
            authUser=userService.loginUser(user.getUsername(),user.getPassword());
            System.out.println("loggin succeded" + authUser);
            return new ResponseEntity(HttpStatus.OK);
        }catch(ResponseStatusException r) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }








}
