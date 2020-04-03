/**
 * @Created-on :  2/4/20, Thu
 * @Author : MUHAMMAD HANAFI
 * @Latest-revision on 2/4/20 - 11:45 pm
 * @Project Govtech Assessment Project 2020
 */

package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;
    private MongoTemplate mongoTemplate;

    public UserService(UserRepository userRepository, MongoTemplate mongoTemplate) {
        this.userRepository = userRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public List<User> getAllUser() {
        List<User> user =  mongoTemplate.find(query(where("salary").gte(Double.valueOf(0))
                .orOperator(where("salary").lte(Double.valueOf(4000))))
                , User.class);
        return user;
    }
}
