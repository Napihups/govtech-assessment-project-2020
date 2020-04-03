/**
 * @Created-on :  2/4/20, Thu
 * @Author : MUHAMMAD HANAFI
 * @Latest-revision on 2/4/20 - 8:34 pm
 * @Project Govtech Assessment Project 2020
 */

package com.example.demo.service;

import com.example.demo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.nio.file.Path;

@Service
public class MongoDBHelper implements DBHelper {

    private UserRepository userRepository;
    private CSVHelper csvHelper;
    Logger logger = LoggerFactory.getLogger(MongoDBHelper.class);

    public MongoDBHelper(UserRepository userRepository, CSVHelper csvHelper) {
        this.userRepository = userRepository;
        this.csvHelper = csvHelper;
    }

    @Override
    public void cleanDB() {
        this.userRepository.deleteAll();
        logger.info("MongoDB cleanup - success");
    }

    @Override
    public void initDataToDB() {
        this.csvHelper.initData(Path.of("").toAbsolutePath().toString() + "/data/user-data.0.3.csv");
    }
}
