/**
 * @Created-on :  2/4/20, Thu
 * @Author : MUHAMMAD HANAFI
 * @Latest-revision on 2/4/20 - 8:31 pm
 * @Project Govtech Assessment Project 2020
 */
package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.bson.types.Decimal128;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Iterator;

@Document
@JsonIgnoreProperties(value = { "_id", "account_type" })
public class User implements Iterable {

    @Id
    @JsonProperty("_id")
    private String _id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("account_type")
    private String account_type;

    @JsonProperty("salary")
    private Decimal128 salary;

    public User() {} // for plain creation of model

    public User(String _id, String name, String account_type, Decimal128 salary) {
        this._id = _id;
        this.name = name;
        this.account_type = account_type;
        this.salary = salary;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAccount_type() {
        return account_type;
    }

    public void setAccount_type(String account_type) {
        this.account_type = account_type;
    }

    public Decimal128 getSalary() {
        return salary;
    }

    public void setSalary(Decimal128 salary) {
        this.salary = salary;
    }

    @Override
    public Iterator iterator() {
        return null;
    }


    public String toString() {
        return this.get_id() +  " : " + this.getName() + " : " + this.getAccount_type() + " : " + this.getSalary();
    }

}
