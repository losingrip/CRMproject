package com.pengesoft.crmsystem.domain.entitylist;

import com.pengesoft.crmsystem.domain.entity.Receivable;
import pengesoft.db.QueryDataList;

import java.util.Collection;

/**
 * 收款信息列表 的摘要说明。
 *
 * @auther: 余展鹏.
 * @date: 2020/3/30 16:09:08.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaListAdv),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
public class ReceivableList extends QueryDataList<Receivable> {

    /**
     * 默认构造方法
     */
    public ReceivableList() {
        super();
    }

    /**
     * 通过已存在集合构造列表
     *
     * @param c 已存在的集合
     */
    public ReceivableList(Collection<Receivable> c) {
        super(c);
    }

}
