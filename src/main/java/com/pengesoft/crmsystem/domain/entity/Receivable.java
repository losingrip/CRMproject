package com.pengesoft.crmsystem.domain.entity;

import pengesoft.data.*;
import java.math.*;
import java.util.*;

/**
 * 收款信息 的摘要说明。
 *
 * @auther: 余展鹏.
 * @date: 2020/4/14 13:27:23.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaAdv),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
public class Receivable extends DataPacket {

    //收款序号.
    private String recId;
    //收款金额.
    private double recAmount;
    //收款时间.
    private Date recTime;
    //收款类型.
    private int recType;


    /**
     * 获取 收款序号.
     * @return 收款序号.
     */
    public String getRecId() {
        return recId;
    }

    /**
     * 设置收款序号.
     * @param recId 收款序号.
     */
    public void setRecId(String recId) {
        this.recId = recId;
    }



    /**
     * 获取 收款金额.
     * @return 收款金额.
     */
    public double getRecAmount() {
        return recAmount;
    }

    /**
     * 设置收款金额.
     * @param recAmount 收款金额.
     */
    public void setRecAmount(double recAmount) {
        this.recAmount = recAmount;
    }

    /**
     * 获取 收款时间.
     * @return 收款时间.
     */
    public Date getRecTime() {
        return recTime;
    }

    /**
     * 设置收款时间.
     * @param recTime 收款时间.
     */
    public void setRecTime(Date recTime) {
        this.recTime = recTime;
    }

    /**
     * 获取 收款类型.
     * @return 收款类型.
     */
    public int getRecType() {
        return recType;
    }

    /**
     * 设置收款类型.
     * @param recType 收款类型.
     */
    public void setRecType(int recType) {
        this.recType = recType;
    }


    /**
     * 清空对象
     */
    @Override
    public void clear() {
        super.clear();
        this.recId = null;
        this.recAmount = 0;
        this.recTime = new Date(0);
        this.recType = 0;
    }

    /**
     * 复制对象（深复制）
     *
     * @param sou 被复制的对象
     */
    @Override
    public void assignFrom(DataPacket sou) {
        super.assignFrom(sou);
        Receivable s = (sou instanceof Receivable) ? (Receivable)sou : null;
        if (s != null){
            this.recId = s.recId;
            this.recAmount = s.recAmount;
            if (s.recTime != null)
                this.recTime = new Date(s.recTime.getTime());
            this.recType = s.recType;
        }
    }

    @Override
    public String toString() {
        return this.getJsonText();
    }
}

