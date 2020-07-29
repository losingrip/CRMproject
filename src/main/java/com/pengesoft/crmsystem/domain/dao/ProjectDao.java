package com.pengesoft.crmsystem.domain.dao;

import com.pengesoft.crmsystem.domain.entity.Project;
import org.springframework.stereotype.Repository;
import pengesoft.db.DataProvider;

/**
 * 项目信息 数据访问接口基本实现类.
 *
 * @auther: 司童.
 * @date: 2020/3/30 17:06:23.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaDaoImp),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
@Repository
public class ProjectDao extends DataProvider<Project> implements IProjectDao {

    /*
        default statement ids:

        InsertStatementId: com.entity.dao.ProjectDao.insertProject.
        UpdateStatementId: com.entity.dao.ProjectDao.updateProject.
        DeleteStatementId: com.entity.dao.ProjectDao.deleteProject.
        GetHasDetailStatementId: com.entity.dao.ProjectDao.getProject.
        GetNoDetailStatementId: com.entity.dao.ProjectDao.getBaseProject.
        QueryCountStatementId: com.entity.dao.ProjectDao.queryProjectCount.
        QueryHasDetailListStatementId: com.entity.dao.ProjectDao.queryProjectList.
        QueryNoDetailListStatementId: com.entity.dao.ProjectDao.queryBaseProjectList.

        If you need to change, you can rewrite the corresponding get method.
     */

}
