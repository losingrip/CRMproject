package com.pengesoft.crmsystem.domain.entitylist;

import com.pengesoft.crmsystem.domain.entity.InvoiceApply;
import pengesoft.data.*;
import pengesoft.db.*;
import java.util.Collection;

/**
 * 开票申请列表 的摘要说明。
 *
 * @auther: 余展鹏.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaListAdv),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
public class InvoiceApplyList extends QueryDataList<InvoiceApply> {

    /**
     * 默认构造方法
     */
    public InvoiceApplyList() {
        super();
    }

    /**
     * 通过已存在集合构造列表
     *
     * @param c 已存在的集合
     */
    public InvoiceApplyList(Collection<InvoiceApply> c) {
        super(c);
    }

}
