package com.cqfairy.entity;

import com.cqfairy.util.EnumCodeSupper;
import com.fasterxml.jackson.annotation.JsonCreator;

import java.util.Date;
import java.util.List;

public class UserInfo {
    private Integer id;

    private String name;

    private Sex sex;

    private Date birthday;

    private String email ;

    private List<Account> accounts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public enum Sex implements EnumCodeSupper {
        man("N","男"),woman("V","女");
        private String code ;

        private String text ;

        @JsonCreator
        public static Sex getItem(String code){
            for(Sex item : values()){
                if(item.code == code){
                    return item;
                }
            }
            return null;
        }

        Sex(String code, String text) {
            this.code = code;
            this.text = text;
        }

        public String getCode(){
            return this.code;
        }
        public String getText(){
            return text;
        }
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", birthday=" + birthday +
                ", email='" + email + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}