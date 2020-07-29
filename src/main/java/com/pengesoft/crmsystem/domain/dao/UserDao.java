package com.pengesoft.crmsystem.domain.dao;


import pengesoft.db.DataProvider;
import org.springframework.stereotype.Repository;
import com.pengesoft.crmsystem.domain.entity.User;

/**
 * 用户 数据访问接口基本实现类.
 *
 * @auther: 余展鹏.
 * @date: 2020/3/31 16:25:49.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaDaoImp),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
@Repository
public class UserDao extends DataProvider<User> implements IUserDao {

    /*
        default statement ids:

        InsertStatementId: com.pengesoft.crmsystem.domain.entity.dao.UserDao.insertUser.
        UpdateStatementId: com.pengesoft.crmsystem.domain.entity.dao.UserDao.updateUser.
        DeleteStatementId: com.pengesoft.crmsystem.domain.entity.dao.UserDao.deleteUser.
        GetHasDetailStatementId: com.pengesoft.crmsystem.domain.entity.dao.UserDao.getUser.
        GetNoDetailStatementId: com.pengesoft.crmsystem.domain.entity.dao.UserDao.getBaseUser.
        QueryCountStatementId: com.pengesoft.crmsystem.domain.entity.dao.UserDao.queryUserCount.
        QueryHasDetailListStatementId: com.pengesoft.crmsystem.domain.entity.dao.UserDao.queryUserList.
        QueryNoDetailListStatementId: com.pengesoft.crmsystem.domain.entity.dao.UserDao.queryBaseUserList.

        If you need to change, you can rewrite the corresponding get method.
     */

}