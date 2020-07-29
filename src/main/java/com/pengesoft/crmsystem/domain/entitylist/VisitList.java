package com.pengesoft.crmsystem.domain.entitylist;

import com.pengesoft.crmsystem.domain.entity.Visit;
import pengesoft.db.QueryDataList;

import java.util.Collection;

/**
 * 拜访信息列表 的摘要说明。
 *
 * @auther: 司童.
 * @date: 2020/3/30 17:23:42.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaListAdv),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
public class VisitList extends QueryDataList<Visit> {

    /**
     * 默认构造方法
     */
    public VisitList() {
        super();
    }
    
    /**
     * 通过已存在集合构造列表
     *
     * @param c 已存在的集合
     */
    public VisitList(Collection<Visit> c) {
        super(c);
    }

}

