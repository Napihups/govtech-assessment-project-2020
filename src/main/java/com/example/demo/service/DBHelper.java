/**
 * @Created-on :  2/4/20, Thu
 * @Author : MUHAMMAD HANAFI
 * @Latest-revision on 2/4/20 - 8:31 pm
 * @Project Govtech Assessment Project 2020
 */
package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public interface DBHelper {

    /**
     * Clean up all data from the Database
     */
    public void cleanDB();

    /**
     * Reading CSV files provided by caller, initialized and marshalling
     * data columns to POJO , Saving Pojo to MongoDB
     */
    public void initDataToDB();

}
