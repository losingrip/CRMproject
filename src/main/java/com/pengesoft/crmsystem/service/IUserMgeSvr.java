package com.pengesoft.crmsystem.service;

import pengesoft.data.*;
import pengesoft.service.IApplication;
import pengesoft.service.PublishMethod;
import pengesoft.service.PublishName;

import java.math.*;
import java.util.*;

/**
 * IUserMgeSvr 接口定义。用户服务.
 *
 * @auther: 余展鹏.
 * @date: 2020/3/31 16:24:10.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaAppService),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
@PublishName("UserMgeSvr")
public interface IUserMgeSvr extends IApplication {

    /**
     * 登录  .
     *
     * @param UserName 用户名.
     * @param Password 密码.
     */
    @PublishMethod
    int userLogin(String UserName, String Password);

}
