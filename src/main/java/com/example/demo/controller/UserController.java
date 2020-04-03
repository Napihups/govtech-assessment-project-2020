/**
 * @Created-on :  2/4/20, Thu
 * @Author : MUHAMMAD HANAFI
 * @Latest-revision on 2/4/20 - 8:31 pm
 * @Project Govtech Assessment Project 2020
 */
package com.example.demo.controller;


import com.example.demo.model.UsersGetResponse;
import com.example.demo.service.UserService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value= "/users", produces = MediaType.APPLICATION_JSON_VALUE)
    public UsersGetResponse getUsers() {
        UsersGetResponse response = new UsersGetResponse(this.userService.getAllUser());
        return response;
    }


}