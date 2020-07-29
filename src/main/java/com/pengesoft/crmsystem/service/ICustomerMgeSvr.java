package com.pengesoft.crmsystem.service;

import com.pengesoft.crmsystem.domain.entity.Customer;
import pengesoft.account.Person;
import pengesoft.service.IApplication;
import pengesoft.service.PublishMethod;
import pengesoft.service.PublishName;

import java.util.List;
import java.util.Map;

/**
 * ICustomerMgeSvr 接口定义。客户服务.
 *
 * @auther: 曾小锐.
 * @date: 2020/3/30 15:55:40.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaAppService),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
@PublishName("CustomerMgeSvr")
public interface ICustomerMgeSvr extends IApplication {

    /**
     * 添加客户  .
     *
     * @param token token.
     * @param CustName 客户名称.
     * @param CustEmail 邮箱.
     * @param CustTel 手机.
     * @param CustPhone 座机.
     * @param CustRemark 备注.
     * @param CustRegionCode 地区代码.
     * @param CustAddress 详细地址.
     * @param ContactName 联系人姓名.
     * @param ContactTel 联系人电话.
     * @param ContactDuty 联系人职务.
     */

    @PublishMethod
    Customer addCustomer(String token, String CustName, String CustEmail, String CustTel, String CustPhone, String CustRemark, int CustRegionCode, String CustAddress, String ContactName, String ContactTel, String ContactDuty);

    /**
     * 修改客户信息  .
     *
     * @param token token.
     * @param CustId 客户Id.
     * @param CustName 客户名称.
     * @param CustEmail 邮箱.
     * @param CustTel 手机.
     * @param CustPhone 座机.
     * @param CustRemark 备注.
     */
    @PublishMethod
    int updateCustomer(String token, int CustId, String CustName, String CustEmail, String CustTel, String CustPhone, String CustRemark,String CustAddress);

    /**
     * 修改客户联系人  .
     *
     * @param token token.
     * @param CustId 客户Id.
     * @param ContactName 联系人姓名.
     * @param ContactTel 联系人电话.
     * @param ContactDuty 联系人职务.
     */
    @PublishMethod
    int updateCustomerContact(String token, int CustId, String ContactName, String ContactTel, String ContactDuty);

    /**
     * 删除客户  .
     *
     * @param token token.
     * @param CustomerId 客户Id.
     */
    @PublishMethod
    int deleteCustomer(String token, String CustomerId);

    /**
     * 分配客户  .
     *
     * @param token token.
     * @param UserId 销售人Id.
     * @param CustomerId 客户Id.
     */
    @PublishMethod
    int distributeCustomer(String token, String UserId, String CustomerId);

    /**
     * 获取客户详情  .
     *
     * @param token token.
     * @param CustId 客户Id.
     * @param Option 选项.
     */
    @PublishMethod
    Customer getCustomerDetail(String token, int CustId, int Option);

    /**
     * 销售员获取自身客户列表(token取自己ID)（销售主管获取销售员工或全部客户列表）  .
     *
     * @param token token.
     * @param skipNum skipNum.
     * @param sizeNum sizeNum.
     * @param Option 选项.
     */
    @PublishMethod
    List<Object> getCustomerList( String token, int skipNum, int sizeNum, int Option);


    /**
     * 根据销售id查新自己的客户列表
     * @param token
     * @param Option
     * @return
     */
    @PublishMethod
    List<Object> getCustumerListByUserId(String token,int skipNum, int sizeNum, int Option);


    /**
     * 模糊查询
     * @param token
     * @param Str
     * @param Option
     * @return
     */
    @PublishMethod
    List<Customer> getCustomerLike(String token,String Str,int Option,int skipNum,int sizeNum);


    /**
     * 数量统计
     * @param Option
     * @return map
     */
    @PublishMethod
    Map<String, Integer> getCustomerListCount(String token, int Option);


    /**
     * 公海列表
     * @param token
     * @param skipNum
     * @param sizeNum
     * @param Option
     * @return
     */
    @PublishMethod
    List<Customer> getCustomerSeaList(String token, int skipNum, int sizeNum, int Option);

    /**
     * 查看部门里的客户
     * @param token
     * @param skipNum
     * @param sizeNum
     * @param Option
     * @return
     */
    @PublishMethod
    List<Customer> getCustomerListByAdmin(String token ,int skipNum, int sizeNum, int Option);

    /**
     * 按id获取客户的角色
     * @param token
     * @return 角色id
     */
    @PublishMethod
    int[] getUserRole(String token);


    /**
     * 获取部门成员
     * @param token
     * @return
     */
    @PublishMethod
     List<Person> getUser(String token ,int skipNum, int sizeNum);


    /**
     * 查询待分配的客户
     * @param token
     * @param skipNum
     * @param sizeNum
     * @param Option
     * @return
     */
    @PublishMethod
    List<Customer> getCustomerSeaListCat(String token, int skipNum, int sizeNum, int Option);


    /**
     * 查询潜在的客户
     * @param token
     * @param skipNum
     * @param sizeNum
     * @param Option
     * @return
     */
    @PublishMethod
    List<Customer> getCutimerListpot(String token, int skipNum, int sizeNum, int Option);


    /**
     * 统计每一个销售的各个数量
     * @param token
     * @param Option
     * @return
     */
    @PublishMethod
    List<Object> getCountByuser(String token ,int Option);


}


