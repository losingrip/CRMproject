package com.pengesoft.crmsystem.domain.dao;

import pengesoft.db.DataProvider;
import org.springframework.stereotype.Repository;
import com.pengesoft.crmsystem.domain.entity.*;
/**
 * 客户信息 数据访问接口基本实现类.
 *
 * @auther: 曾小锐.
 * @date: 2020/3/31 14:03:22.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaDaoImp),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
@Repository
public class CustomerDao extends DataProvider<Customer> implements ICustomerDao {

    /*
        default statement ids:

        InsertStatementId: .dao.CustomerDao.insertCustomer.
        UpdateStatementId: .dao.CustomerDao.updateCustomer.
        DeleteStatementId: .dao.CustomerDao.deleteCustomer.
        GetHasDetailStatementId: .dao.CustomerDao.getCustomer.
        GetNoDetailStatementId: .dao.CustomerDao.getBaseCustomer.
        QueryCountStatementId: .dao.CustomerDao.queryCustomerCount.
        QueryHasDetailListStatementId: .dao.CustomerDao.queryCustomerList.
        QueryNoDetailListStatementId: .dao.CustomerDao.queryBaseCustomerList.

        If you need to change, you can rewrite the corresponding get method.
     */

}
