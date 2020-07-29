package com.pengesoft.crmsystem.domain.entity;

import pengesoft.data.*;
import java.math.*;
import java.util.*;

/**
 * 发票信息 的摘要说明。
 *
 * @auther: 余展鹏.
 * @date: 2020/4/2 16:17:11.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaAdv),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
public class Invoice extends DataPacket {

    //发票编号.
    private String invoiceCode;
    //发票金额.
    private double invoiceAmount;
    //开票时间.
    private Date invoiceTime;
    //开票人.
    private String invoicePerson;
    //开票类型.
    private int invoiceType;
    //是否可以开票


    /**
     * 获取 发票编号.
     * @return 发票编号.
     */
    public String getInvoiceCode() {
        return invoiceCode;
    }

    /**
     * 设置发票编号.
     * @param invoiceCode 发票编号.
     */
    public void setInvoiceCode(String invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    /**
     * 获取 发票金额.
     * @return 发票金额.
     */
    public double getInvoiceAmount() {
        return invoiceAmount;
    }

    /**
     * 设置发票金额.
     * @param invoiceAmount 发票金额.
     */
    public void setInvoiceAmount(double invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    /**
     * 获取 开票时间.
     * @return 开票时间.
     */
    public Date getInvoiceTime() {
        return invoiceTime;
    }

    /**
     * 设置开票时间.
     * @param invoiceTime 开票时间.
     */
    public void setInvoiceTime(Date invoiceTime) {
        this.invoiceTime = invoiceTime;
    }

    /**
     * 获取 开票人.
     * @return 开票人.
     */
    public String getInvoicePerson() {
        return invoicePerson;
    }

    /**
     * 设置开票人.
     * @param invoicePerson 开票人.
     */
    public void setInvoicePerson(String invoicePerson) {
        this.invoicePerson = invoicePerson;
    }

    /**
     * 获取 开票类型.
     * @return 开票类型.
     */
    public int getInvoiceType() {
        return invoiceType;
    }

    /**
     * 设置开票类型.
     * @param invoiceType 开票类型.
     */
    public void setInvoiceType(int invoiceType) {
        this.invoiceType = invoiceType;
    }


    /**
     * 清空对象
     */
    @Override
    public void clear() {
        super.clear();
        this.invoiceCode = null;
        this.invoiceAmount = 0;
        this.invoiceTime = new Date(0);
        this.invoicePerson = null;
        this.invoiceType = 0;
    }

    /**
     * 复制对象（深复制）
     *
     * @param sou 被复制的对象
     */
    @Override
    public void assignFrom(DataPacket sou) {
        super.assignFrom(sou);
        Invoice s = (sou instanceof Invoice) ? (Invoice)sou : null;
        if (s != null){
            this.invoiceCode = s.invoiceCode;
            this.invoiceAmount = s.invoiceAmount;
            if (s.invoiceTime != null)
                this.invoiceTime = new Date(s.invoiceTime.getTime());
            this.invoicePerson = s.invoicePerson;
            this.invoiceType = s.invoiceType;
        }
    }

    @Override
    public String toString() {
        return this.getJsonText();
    }
}

