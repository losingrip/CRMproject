package com.pengesoft.crmsystem.domain.entity;

import pengesoft.data.*;
import java.math.*;
import java.util.*;

/**
 * 关注项目表 的摘要说明。
 *
 * @auther: 司童.
 * @date: 2020/4/8 16:14:47.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaAdv),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
public class Attention extends DataPacket {

    //关注id.
    private int attentionId;
    //销售id.
    private String userId;
    //项目编号.
    private String projectCode;

    /**
     * 获取 关注id.
     * @return 关注id.
     */
    public int getAttentionId() {
        return attentionId;
    }

    /**
     * 设置关注id.
     * @param attentionId 关注id.
     */
    public void setAttentionId(int attentionId) {
        this.attentionId = attentionId;
    }

    /**
     * 获取 销售id.
     * @return 销售id.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置销售id.
     * @param userId 销售id.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取 项目编号.
     * @return 项目编号.
     */
    public String getProjectCode() {
        return projectCode;
    }

    /**
     * 设置项目编号.
     * @param projectCode 项目编号.
     */
    public void setProjectCode(String projectCode) {
        this.projectCode = projectCode;
    }


    /**
     * 清空对象
     */
    @Override
    public void clear() {
        super.clear();
        this.attentionId = 0;
        this.userId = null;
        this.projectCode = null;
    }

    /**
     * 复制对象（深复制）
     *
     * @param sou 被复制的对象
     */
    @Override
    public void assignFrom(DataPacket sou) {
        super.assignFrom(sou);
        Attention s = (sou instanceof Attention) ? (Attention)sou : null;
        if (s != null){
            this.attentionId = s.attentionId;
            this.userId = s.userId;
            this.projectCode = s.projectCode;
        }
    }

    @Override
    public String toString() {
        return this.getJsonText();
    }
}


