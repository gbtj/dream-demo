package com.api.controller;

import com.api.service.UserService;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user/{id}",produces = "application/json;charset=UTF-8")
    public Object getUserById(@PathVariable(value = "id") String id) {
        return userService.get(id);
    }

    @PostMapping(value = "/user",produces = "application/json;charset=UTF-8")
    public String insert(@RequestBody User user) {
        return userService.insert(user);
    }

}
