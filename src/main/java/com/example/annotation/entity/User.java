package com.example.annotation.entity;

import com.example.annotation.annnotation.ProcessFiled;

import java.util.Date;

/**
 * description
 *
 * @author yan.kang@hand-china.com
 * @date 2019/10/29 16:43
 */
public class User {

    private String name;
    private boolean isnameeq;
    @ProcessFiled(targetField = "ageMeaning")
    private Integer age;
    private String ageMeaning;
    private Date birth;

    public boolean getIsnameeq() {
        return isnameeq;
    }

    public void setIsnameeq(boolean isnameeq) {
        this.isnameeq = isnameeq;
    }

    public String getAgeMeaning() {
        return ageMeaning;
    }

    public void setAgeMeaning(String ageMeaning) {
        this.ageMeaning = ageMeaning;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", isnameeq=" + isnameeq +
                ", age=" + age +
                ", ageMeaning='" + ageMeaning + '\'' +
                ", birth=" + birth +
                '}';
    }
}
