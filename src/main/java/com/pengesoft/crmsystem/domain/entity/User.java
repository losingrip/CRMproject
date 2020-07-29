package com.pengesoft.crmsystem.domain.entity;

import pengesoft.data.*;
import java.math.*;
import java.util.*;

/**
 * 用户 的摘要说明。
 *
 * @auther: 余展鹏.
 * @date: 2020/4/1 17:36:25.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaAdv),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
public class User extends DataPacket {

    //UserId.
    private String userId;
    //用户名.
    private String userName;
    //密码.
    private String password;

    /**
     * 获取 UserId.
     * @return UserId.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置UserId.
     * @param userId UserId.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取 用户名.
     * @return 用户名.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名.
     * @param userName 用户名.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取 密码.
     * @return 密码.
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码.
     * @param password 密码.
     */
    public void setPassword(String password) {
        this.password = password;
    }


    /**
     * 清空对象
     */
    @Override
    public void clear() {
        super.clear();
        this.userId = null;
        this.userName = null;
        this.password = null;
    }

    /**
     * 复制对象（深复制）
     *
     * @param sou 被复制的对象
     */
    @Override
    public void assignFrom(DataPacket sou) {
        super.assignFrom(sou);
        User s = (sou instanceof User) ? (User)sou : null;
        if (s != null){
            this.userId = s.userId;
            this.userName = s.userName;
            this.password = s.password;
        }
    }

    @Override
    public String toString() {
        return this.getJsonText();
    }
}

