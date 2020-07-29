package com.pengesoft.crmsystem.domain.QueryPara;

import com.pengesoft.crmsystem.domain.entity.User;
import pengesoft.db.QueryParameter;
import pengesoft.utils.StringHelper;
import java.util.*;
import java.math.*;

/**
 * 用户 查询参数类。
 *
 * @auther: 余展鹏.
 * @date: 2020/4/1 17:37:10.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaQueryPara),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
public class UserQueryPara extends QueryParameter {

    /**
     * 缺省序列化id
     */
    private static final long serialVersionUID = 1L;
    /**
     * 常数 查询属性名(UserId).
     */
    public static final String QueryAttr_UserId = "userId";
    /**
     * 常数 查询属性名(用户名).
     */
    public static final String QueryAttr_UserName = "userName";
    /**
     * 常数 查询属性名(密码).
     */
    public static final String QueryAttr_Password = "password";

    /**
     * 常数 排序属性名(UserId).
     */
    public static final String OrderAttr_UserId = "userId";

    /**
     * 默认构造方法
     */
    public UserQueryPara() {
        super();
    }

    /**
     * 构造函数,指定参数对象及排序字段
     *
     * @param data  查询参数对象
     * @param order 排序字段
     * @param isAse true升序，false降序
     */
    public UserQueryPara(User data, String order, boolean isAse) {
        super();
        SetQueryPara(data, order, isAse);
    }

    /**
     * 构造函数,指定参数对象及排序字段
     *
     * @param data 查询参数对象
     */
    public UserQueryPara(User data) {
        super();
        SetQueryPara(data, null, false);
    }

    /**
     * 指定查询参数对象及排序字段
     *
     * @param data  查询参数对象
     * @param order 排序字段
     * @param isAse true升序，false降序
     */
    public void SetQueryPara(User data, String order, boolean isAse) {
        if (data != null) {
            setParamByUserId(data.getUserId());
            setParamByUserName(data.getUserName());
            setParamByPassword(data.getPassword());
        }
        if (!StringHelper.isNullOrEmpty(order))
            addOrderBy(order, isAse);
    }

    /**
     * 增加用UserId匹配条件(target like userId)，key:userId.
     * @param userId UserId匹配条件参数
     */
    public void setParamByUserId(String userId){
        addParameter(QueryAttr_UserId, userId);
    }

    /**
     * 增加用UserId匹配条件(userId为empty时也会加入此条件)，不空时(target like userId)，key:userId，为空时(target is null or target = '')，key:userId.
     * @param userId UserId匹配条件参数
     */
    public void setParamByUserIdInEmpty(String userId){
        put(QueryAttr_UserId, userId);
    }

    /**
     * 增加UserId枚举条件(target in (userIds))，key:userId_Enum.
     * @param userIds UserId数组条件参数
     */
    public void setParamByUserId_Enum(String... userIds){
        addParameterByEnum(QueryAttr_UserId, userIds);
    }

    /**
     * 增加用用户名匹配条件(target like userName)，key:userName.
     * @param userName 用户名匹配条件参数
     */
    public void setParamByUserName(String userName){
        addParameter(QueryAttr_UserName, userName);
    }

    /**
     * 增加用用户名匹配条件(userName为empty时也会加入此条件)，不空时(target like userName)，key:userName，为空时(target is null or target = '')，key:userName.
     * @param userName 用户名匹配条件参数
     */
    public void setParamByUserNameInEmpty(String userName){
        put(QueryAttr_UserName, userName);
    }

    /**
     * 增加用户名枚举条件(target in (userNames))，key:userName_Enum.
     * @param userNames 用户名数组条件参数
     */
    public void setParamByUserName_Enum(String... userNames){
        addParameterByEnum(QueryAttr_UserName, userNames);
    }

    /**
     * 增加用密码匹配条件(target like password)，key:password.
     * @param password 密码匹配条件参数
     */
    public void setParamByPassword(String password){
        addParameter(QueryAttr_Password, password);
    }

    /**
     * 增加用密码匹配条件(password为empty时也会加入此条件)，不空时(target like password)，key:password，为空时(target is null or target = '')，key:password.
     * @param password 密码匹配条件参数
     */
    public void setParamByPasswordInEmpty(String password){
        put(QueryAttr_Password, password);
    }

    /**
     * 增加密码枚举条件(target in (passwords))，key:password_Enum.
     * @param passwords 密码数组条件参数
     */
    public void setParamByPassword_Enum(String... passwords){
        addParameterByEnum(QueryAttr_Password, passwords);
    }

}