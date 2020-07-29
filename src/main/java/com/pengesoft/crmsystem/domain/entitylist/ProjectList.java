package com.pengesoft.crmsystem.domain.entitylist;

import com.pengesoft.crmsystem.domain.entity.Project;
import pengesoft.db.QueryDataList;

import java.util.Collection;

/**
 * 项目列表 的摘要说明。
 *
 * @auther: 司童.
 * @date: 2020/3/30 17:21:03.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaListAdv),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
public class ProjectList extends QueryDataList<Project> {

    /**
     * 默认构造方法
     */
    public ProjectList() {
        super();
    }
    
    /**
     * 通过已存在集合构造列表
     *
     * @param c 已存在的集合
     */
    public ProjectList(Collection<Project> c) {
        super(c);
    }

}

