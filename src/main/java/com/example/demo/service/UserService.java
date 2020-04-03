/**
 * @Created-on :  2/4/20, Thu
 * @Author : MUHAMMAD HANAFI
 * @Latest-revision on 2/4/20 - 11:45 pm
 * @Project Govtech Assessment Project 2020
 */

package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;
import java.util.List;

@Service
public class UserService {

    private MongoTemplate mongoTemplate;

    public UserService(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public List<User> getAllUser() {
        return mongoTemplate.find(query(where("salary").gte((double) 0)
                .orOperator(where("salary").lte(4000d)))
                , User.class);
    }
}
