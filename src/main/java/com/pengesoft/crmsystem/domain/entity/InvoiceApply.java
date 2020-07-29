package com.pengesoft.crmsystem.domain.entity;

import pengesoft.data.*;
import java.math.*;
import java.util.*;

/**
 * 开票申请 的摘要说明。
 *
 * @auther: 余展鹏.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaAdv),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
public class InvoiceApply extends DataPacket {

    //申请id.
    private String invoiceApplyId;
    //申请人Id.
    private String userId;
    //申请人名字.
    private String name;
    //合同编号.
    private String contractCode;
    //阶段序号.
    private String phaseId;
    //是否处理.
    private int invoiceApplyIsDeal;
    //申请开票金额.
    private double invoiceApplyAmount;
    //阶段名称.
    private String phaseDescribeMapString;
    //合同名称.
    private String contractName;
    //申请时间.
    private Date invoiceApplyTime;

    /**
     * 获取 申请id.
     * @return 申请id.
     */
    public String getInvoiceApplyId() {
        return invoiceApplyId;
    }

    /**
     * 设置申请id.
     * @param invoiceApplyId 申请id.
     */
    public void setInvoiceApplyId(String invoiceApplyId) {
        this.invoiceApplyId = invoiceApplyId;
    }

    /**
     * 获取 申请人Id.
     * @return 申请人Id.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置申请人Id.
     * @param userId 申请人Id.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取 申请人名字.
     * @return 申请人名字.
     */
    public String getName() {
        return name;
    }

    /**
     * 设置申请人名字.
     * @param name 申请人名字.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取 合同编号.
     * @return 合同编号.
     */
    public String getContractCode() {
        return contractCode;
    }

    /**
     * 设置合同编号.
     * @param contractCode 合同编号.
     */
    public void setContractCode(String contractCode) {
        this.contractCode = contractCode;
    }

    /**
     * 获取 阶段序号.
     * @return 阶段序号.
     */
    public String getPhaseId() {
        return phaseId;
    }

    /**
     * 设置阶段序号.
     * @param phaseId 阶段序号.
     */
    public void setPhaseId(String phaseId) {
        this.phaseId = phaseId;
    }

    /**
     * 获取 是否处理.
     * @return 是否处理.
     */
    public int getInvoiceApplyIsDeal() {
        return invoiceApplyIsDeal;
    }

    /**
     * 设置是否处理.
     * @param invoiceApplyIsDeal 是否处理.
     */
    public void setInvoiceApplyIsDeal(int invoiceApplyIsDeal) {
        this.invoiceApplyIsDeal = invoiceApplyIsDeal;
    }

    /**
     * 获取 申请开票金额.
     * @return 申请开票金额.
     */
    public double getInvoiceApplyAmount() {
        return invoiceApplyAmount;
    }

    /**
     * 设置申请开票金额.
     * @param invoiceApplyAmount 申请开票金额.
     */
    public void setInvoiceApplyAmount(double invoiceApplyAmount) {
        this.invoiceApplyAmount = invoiceApplyAmount;
    }

    /**
     * 获取 阶段名称.
     * @return 阶段名称.
     */
    public String getPhaseDescribeMapString() {
        return phaseDescribeMapString;
    }

    /**
     * 设置阶段名称.
     * @param phaseDescribeMapString 阶段名称.
     */
    public void setPhaseDescribeMapString(String phaseDescribeMapString) {
        this.phaseDescribeMapString = phaseDescribeMapString;
    }

    /**
     * 获取 合同名称.
     * @return 合同名称.
     */
    public String getContractName() {
        return contractName;
    }

    /**
     * 设置合同名称.
     * @param contractName 合同名称.
     */
    public void setContractName(String contractName) {
        this.contractName = contractName;
    }

    /**
     * 获取 申请时间.
     * @return 申请时间.
     */
    public Date getInvoiceApplyTime() {
        return invoiceApplyTime;
    }

    /**
     * 设置申请时间.
     * @param invoiceApplyTime 申请时间.
     */
    public void setInvoiceApplyTime(Date invoiceApplyTime) {
        this.invoiceApplyTime = invoiceApplyTime;
    }


    /**
     * 清空对象
     */
    @Override
    public void clear() {
        super.clear();
        this.invoiceApplyId = null;
        this.userId = null;
        this.name = null;
        this.contractCode = null;
        this.phaseId = null;
        this.invoiceApplyIsDeal = 0;
        this.invoiceApplyAmount = 0;
        this.phaseDescribeMapString = null;
        this.contractName = null;
        this.invoiceApplyTime = new Date(0);
    }

    /**
     * 复制对象（深复制）
     *
     * @param sou 被复制的对象
     */
    @Override
    public void assignFrom(DataPacket sou) {
        super.assignFrom(sou);
        InvoiceApply s = (sou instanceof InvoiceApply) ? (InvoiceApply)sou : null;
        if (s != null){
            this.invoiceApplyId = s.invoiceApplyId;
            this.userId = s.userId;
            this.name = s.name;
            this.contractCode = s.contractCode;
            this.phaseId = s.phaseId;
            this.invoiceApplyIsDeal = s.invoiceApplyIsDeal;
            this.invoiceApplyAmount = s.invoiceApplyAmount;
            this.phaseDescribeMapString = s.phaseDescribeMapString;
            this.contractName = s.contractName;
            if (s.invoiceApplyTime != null)
                this.invoiceApplyTime = new Date(s.invoiceApplyTime.getTime());
        }
    }

    @Override
    public String toString() {
        return this.getJsonText();
    }
}

