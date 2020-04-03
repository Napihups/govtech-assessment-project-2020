/**
 * @Created-on :  3/4/20, Fri
 * @Author : MUHAMMAD HANAFI
 * @Latest-revision on 3/4/20 - 12:26 pm
 * @Project Govtech Assessment Project 2020
 */

package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

public class UsersGetResponse {

    @JsonProperty("results")
    public List<User> results;


    public UsersGetResponse(List<User> results) {
        this.results = results;
    }
}
