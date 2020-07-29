package com.pengesoft.crmsystem.domain.entity;

import pengesoft.data.*;

import java.util.*;

/**
 * 客户信息 的摘要说明。
 *
 * @auther: 曾小锐.
 * @date: 2020/3/31 15:15:10.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaAdv),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
public class Customer extends DataPacket {

    //客户Id.
    private int custId;
    //客户名称.
    private String custName;
    //邮箱.
    private String custEmail;
    //手机.
    private String custTel;
    //座机.
    private String custPhone;
    //备注.
    private String custRemark;
    //销售人员.
    private String userId;
    //联系人姓名.
    private String contactName;
    //联系人电话.
    private String contactTel;
    //联系人职务.
    private String contactDuty;
    //地区代码.
    private int custRegionCode;
    //详细地址.
    private String custAddress;
    //创建时间.
    private Date custCreateTime;
    //更新时间.
    private Date custUpdateTime;

    /**
     * 获取 客户Id.
     * @return 客户Id.
     */
    public int getCustId() {
        return custId;
    }

    /**
     * 设置客户Id.
     * @param custId 客户Id.
     */
    public void setCustId(int custId) {
        this.custId = custId;
    }

    /**
     * 获取 客户名称.
     * @return 客户名称.
     */
    public String getCustName() {
        return custName;
    }

    /**
     * 设置客户名称.
     * @param custName 客户名称.
     */
    public void setCustName(String custName) {
        this.custName = custName;
    }

    /**
     * 获取 邮箱.
     * @return 邮箱.
     */
    public String getCustEmail() {
        return custEmail;
    }

    /**
     * 设置邮箱.
     * @param custEmail 邮箱.
     */
    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    /**
     * 获取 手机.
     * @return 手机.
     */
    public String getCustTel() {
        return custTel;
    }

    /**
     * 设置手机.
     * @param custTel 手机.
     */
    public void setCustTel(String custTel) {
        this.custTel = custTel;
    }

    /**
     * 获取 座机.
     * @return 座机.
     */
    public String getCustPhone() {
        return custPhone;
    }

    /**
     * 设置座机.
     * @param custPhone 座机.
     */
    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    /**
     * 获取 备注.
     * @return 备注.
     */
    public String getCustRemark() {
        return custRemark;
    }

    /**
     * 设置备注.
     * @param custRemark 备注.
     */
    public void setCustRemark(String custRemark) {
        this.custRemark = custRemark;
    }

    /**
     * 获取 销售人员.
     * @return 销售人员.
     */
    public String getUserId() {
        return userId;
    }

    /**
     * 设置销售人员.
     * @param userId 销售人员.
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * 获取 联系人姓名.
     * @return 联系人姓名.
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * 设置联系人姓名.
     * @param contactName 联系人姓名.
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * 获取 联系人电话.
     * @return 联系人电话.
     */
    public String getContactTel() {
        return contactTel;
    }

    /**
     * 设置联系人电话.
     * @param contactTel 联系人电话.
     */
    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    /**
     * 获取 联系人职务.
     * @return 联系人职务.
     */
    public String getContactDuty() {
        return contactDuty;
    }

    /**
     * 设置联系人职务.
     * @param contactDuty 联系人职务.
     */
    public void setContactDuty(String contactDuty) {
        this.contactDuty = contactDuty;
    }

    /**
     * 获取 地区代码.
     * @return 地区代码.
     */
    public int getCustRegionCode() {
        return custRegionCode;
    }

    /**
     * 设置地区代码.
     * @param custRegionCode 地区代码.
     */
    public void setCustRegionCode(int custRegionCode) {
        this.custRegionCode = custRegionCode;
    }

    /**
     * 获取 详细地址.
     * @return 详细地址.
     */
    public String getCustAddress() {
        return custAddress;
    }

    /**
     * 设置详细地址.
     * @param custAddress 详细地址.
     */
    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    /**
     * 获取 创建时间.
     * @return 创建时间.
     */
    public Date getCustCreateTime() {
        return custCreateTime;
    }

    /**
     * 设置创建时间.
     * @param custCreateTime 创建时间.
     */
    public void setCustCreateTime(Date custCreateTime) {
        this.custCreateTime = custCreateTime;
    }

    /**
     * 获取 更新时间.
     * @return 更新时间.
     */
    public Date getCustUpdateTime() {
        return custUpdateTime;
    }

    /**
     * 设置更新时间.
     * @param custUpdateTime 更新时间.
     */
    public void setCustUpdateTime(Date custUpdateTime) {
        this.custUpdateTime = custUpdateTime;
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * 清空对象
     */
    @Override
    public void clear() {
        super.clear();
        this.custId = 0;
        this.custName = null;
        this.custEmail = null;
        this.custTel = null;
        this.custPhone = null;
        this.custRemark = null;
        this.userId = null;
        this.contactName = null;
        this.contactTel = null;
        this.contactDuty = null;
        this.custRegionCode = 0;
        this.custAddress = null;
        this.custCreateTime = new Date(0);
        this.custUpdateTime = new Date(0);
    }

    /**
     * 复制对象（深复制）
     *
     * @param sou 被复制的对象
     */
    @Override
    public void assignFrom(DataPacket sou) {
        super.assignFrom(sou);
        Customer s = (sou instanceof Customer) ? (Customer)sou : null;
        if (s != null){
            this.custId = s.custId;
            this.custName = s.custName;
            this.custEmail = s.custEmail;
            this.custTel = s.custTel;
            this.custPhone = s.custPhone;
            this.custRemark = s.custRemark;
            this.userId = s.userId;
            this.contactName = s.contactName;
            this.contactTel = s.contactTel;
            this.contactDuty = s.contactDuty;
            this.custRegionCode = s.custRegionCode;
            this.custAddress = s.custAddress;
            if (s.custCreateTime != null)
                this.custCreateTime = new Date(s.custCreateTime.getTime());
            if (s.custUpdateTime != null)
                this.custUpdateTime = new Date(s.custUpdateTime.getTime());
        }
    }

    @Override
    public String toString() {
        return this.getJsonText();
    }
}

