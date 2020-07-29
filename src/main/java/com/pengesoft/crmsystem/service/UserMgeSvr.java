package com.pengesoft.crmsystem.service;

import pengesoft.data.*;
import pengesoft.service.ApplicationBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.*;
import java.util.*;

/**
 * IUserMgeSvr 接口实现。用户服务.
 *
 * @auther: 余展鹏.
 * @date: 2020/3/31 16:24:49.
 *
 * Copyright (C) 2008 - 鹏业软件公司
 */
@Service
@Transactional
public class UserMgeSvr extends ApplicationBase implements IUserMgeSvr {

    /**
     * 构造方法
     */
    @Autowired
    public UserMgeSvr() {
        //TODO: 通过构造方法参数设置依赖注入.
    }

    /**
     * 登录  .
     *
     * @param UserName 用户名.
     * @param Password 密码.
     */
    @Override
    public int userLogin(String UserName, String Password) {
        //TODO: 未实现.
        return 0;
    }

//    public  addMssage(){
//
//    }

}

