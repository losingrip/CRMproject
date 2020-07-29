package com.pengesoft.crmsystem.domain.entitylist;

import com.pengesoft.crmsystem.domain.entity.Attention;
import pengesoft.data.*;
import pengesoft.db.*;
import java.util.Collection;

/**
 * 关注项目表 的摘要说明。
 *
 * @auther: 司童.
 * @date: 2020/4/8 16:14:47.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaListAdv),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
public class AttentionList extends QueryDataList<Attention> {

    /**
     * 默认构造方法
     */
    public AttentionList() {
        super();
    }
    
    /**
     * 通过已存在集合构造列表
     *
     * @param c 已存在的集合
     */
    public AttentionList(Collection<Attention> c) {
        super(c);
    }

}

