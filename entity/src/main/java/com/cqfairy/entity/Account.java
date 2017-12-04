/*
 * Copyright (c) 天畅伟业科技有限公司 2017
 * 本著作物的著作权归天畅伟业有限公司所有。
 * -----------------------------------------------
 * 修改记录 :
 * 日 期          版本          修改人         修改内容
 *
 */
package com.cqfairy.entity;

import com.cqfairy.util.EnumSupper;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * [概 要] 描述类 <br/>
 * [环 境] J2SE 1.7
 *
 * @author 研发部-张光富
 * @version 1.0
 */
public class Account {

    private int id ;

    private String name ;

    private String password;

    private Status status ;

    private UserInfo userInfo;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
//                ", userInfo=" + userInfo.getName() +
                '}';
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }


    public enum Status implements EnumSupper<Status> {
        normal(1,"正常"),
        cancelled(2,"作废的"),
        nonactivated(3,"未激活");



        private int value ;

        private String text ;

        @JsonCreator
        public static Status getItem(int value){
            for(Status item : values()){
                if(item.value == value){
                    return item;
                }
            }
            return null;
        }

        Status(int value, String text) {
            this.value = value;
            this.text = text;
        }

        @JsonValue
        public int getValue(){
            return value;
        }

        public String getText(){
            return text;
        }
    }
}
