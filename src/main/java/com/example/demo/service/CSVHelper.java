/**
 * @Created-on :  2/4/20, Thu
 * @Author : MUHAMMAD HANAFI
 * @Latest-revision on 2/4/20 - 8:42 pm
 * @Project Govtech Assessment Project 2020
 */

package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import org.bson.types.Decimal128;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.ArrayList;

@Service
public class CSVHelper {

    private ArrayList<String> headers;
    private String filePath;
    private ArrayList<User> dataList;
    private UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(CSVHelper.class);

    public CSVHelper(UserRepository userRepository) {
        this.headers = new ArrayList<String>();
        this.dataList = new ArrayList<User>();
        this.userRepository = userRepository;
    }

    /**
     *
     */
    public void initData(String filePath) {
        this.filePath = filePath;
        initFileAndScan();
        saveUserToDb();
    }

    protected void initFileAndScan() {
        try{
            BufferedReader bufferedReader = new BufferedReader(new FileReader(this.filePath));
            this.initAndPopulateData(bufferedReader);
        }
        catch( IOException ioe) {
            ioe.printStackTrace();
        }
    }

    protected void  initAndPopulateData (BufferedReader bufferedReader) throws IOException {
        Integer count = 0;
        String line;
        while((line = bufferedReader.readLine()) != null){
            if(count == 0) {

                /** get firsts row for its col headers */
                String[] data =  line.split(",");
                for (int i = 0; i < data.length; i++) {

                    /** Remove the non-ASCII chars for safety evaluation*/
                    String head = data[i].replaceAll("[^\\x00-\\x7F]", "").trim();
                    this.headers.add(head);
                }
            }
            else if(count > 0){
                String[] data =  line.split(",");
                User user = new User();
                for (int i = 0; i < this.headers.size(); i++) {
                    String head = this.headers.get(i);
                    if(head.equals("EmpID")){
                        user.set_id(data[i]);
                    }
                    else if(head.equals("Name")) {
                        user.setName(data[i]);
                    }
                    else if(head.equals("Account_Type")) {
                        user.setAccount_type(data[i]);
                    }
                    else if(head.equals("Salary")) {
                        String n = data[i].toString();
                        user.setSalary(Decimal128.parse(n));
                    }
                }
                this.dataList.add(user);
            }

            count = count + 1;
        }
    }

    /**
     *
     */
    protected void saveUserToDb() {
        for (User user : this.dataList) {
            User savedUser = userRepository.save(user);
            logger.info(savedUser.toString() + " -- suucessfully insert ");
        }
        logger.info("Datase Initialized and populated - success ");
    }

}
