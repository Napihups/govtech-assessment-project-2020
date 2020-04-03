/**
 * @Created-on :  2/4/20, Thu
 * @Author : MUHAMMAD HANAFI
 * @Latest-revision on 2/4/20 - 8:31 pm
 * @Project Govtech Assessment Project 2020
 */
package com.example.demo.config;
import com.example.demo.service.CSVHelper;
import com.example.demo.service.MongoDBHelper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.example.demo.repository.UserRepository;

import java.nio.file.Path;

@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class MongoDBDatasource {

    @Bean
    CommandLineRunner commandLineRunner( MongoDBHelper mongoDbHelper, CSVHelper csvHelper) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                /**
                 * On Initializing Datasource, user provide --init-db flags to
                 * clean up database and storing csv data into the DB
                 */
                for(int i = 0; i < args.length; i++) {
                    String arg = args[i];
                    if("--init-db".equals(arg)) {
                        mongoDbHelper.cleanDB();
                        mongoDbHelper.initDataToDB();
                    }
                }
            }
        };

    }
}
