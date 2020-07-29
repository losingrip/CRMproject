package com.pengesoft.crmsystem.domain.entity;

import com.pengesoft.crmsystem.domain.entitylist.InvoiceApplyList;
import com.pengesoft.crmsystem.domain.entitylist.InvoiceList;
import com.pengesoft.crmsystem.domain.entitylist.PhaseList;
import com.pengesoft.crmsystem.domain.entitylist.ReceivableList;
import pengesoft.data.*;
import java.math.*;
import java.util.*;

/**
 * 合同信息 的摘要说明。
 *
 * @auther: 余展鹏.
 * @date: 2020/4/9 18:38:06.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaAdv),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
public class ProjectContractRet extends DataPacket {

    //合同编号.
    private String contractCode;
    //项目编号.
    private String projectCode;
    //项目名称.
    private String projectName;
    //客户名称.
    private String custName;
    //销售人员名字.
    private String userName;
    //项目状态.
    private int projectStatus;
    //合同名称.
    private String contractName;
    //合同当前状态(履行中0、已结束(或作废)1).
    private int contractStatus;
    //合同类型.
    private int contractType;
    //合同甲方.
    private String partyA;
    //合同乙方.
    private String partyB;
    //合同丙方.
    private String partyC;
    //合同总金额.
    private double contractAmount;
    //该合同已收.
    private double contractAlreadyRec;
    //该合同未收.
    private double contractNotYetRec;
    //父合同编号.
    private String contractParentCode;
    //创建时间.
    private Date contractCreateTime;
    //销售人员
    private String Name;
    //合同签订时间.
    private Date contractSignTime;
    //合同结束时间.
    private Date contractEndTime;
    //合同生效时间.
    private Date contractEffectTime;
    //合同失效时间.
    private Date contractNoEffectTime;
    //备注.
    private String contractRemark;
    //发票.
    private InvoiceList invoiceList;
    //收款.
    private ReceivableList receivableList;
    //阶段信息.
    private PhaseList phaseList;
    //开票申请
    private InvoiceApplyList invoiceApplyList;
    //合同是否可以开票
    private int contractCanInv;
    //合同是否可以收款
    private int contractCanRec;
    private Phase recentPhase;

    public Phase getRecentPhase() {
        return recentPhase;
    }

    public void setRecentPhase(Phase recentPhase) {
        this.recentPhase = recentPhase;
    }

    public InvoiceApplyList getInvoiceApplyList() {
        return invoiceApplyList;
    }

    public void setInvoiceApplyList(InvoiceApplyList invoiceApplyList) {
        this.invoiceApplyList = invoiceApplyList;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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
     * 获取 项目名称.
     * @return 项目名称.
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * 设置项目名称.
     * @param projectName 项目名称.
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
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
     * 获取 销售人员名字.
     * @return 销售人员名字.
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置销售人员名字.
     * @param userName 销售人员名字.
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取 项目状态.
     * @return 项目状态.
     */
    public int getProjectStatus() {
        return projectStatus;
    }

    /**
     * 设置项目状态.
     * @param projectStatus 项目状态.
     */
    public void setProjectStatus(int projectStatus) {
        this.projectStatus = projectStatus;
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
     * 获取 合同当前状态(履行中0、已结束(或作废)1).
     * @return 合同当前状态(履行中0、已结束(或作废)1).
     */
    public int getContractStatus() {
        return contractStatus;
    }

    /**
     * 设置合同当前状态(履行中0、已结束(或作废)1).
     * @param contractStatus 合同当前状态(履行中0、已结束(或作废)1).
     */
    public void setContractStatus(int contractStatus) {
        this.contractStatus = contractStatus;
    }

    /**
     * 获取 合同类型.
     * @return 合同类型.
     */
    public int getContractType() {
        return contractType;
    }

    /**
     * 设置合同类型.
     * @param contractType 合同类型.
     */
    public void setContractType(int contractType) {
        this.contractType = contractType;
    }

    /**
     * 获取 合同甲方.
     * @return 合同甲方.
     */
    public String getPartyA() {
        return partyA;
    }

    /**
     * 设置合同甲方.
     * @param partyA 合同甲方.
     */
    public void setPartyA(String partyA) {
        this.partyA = partyA;
    }

    /**
     * 获取 合同乙方.
     * @return 合同乙方.
     */
    public String getPartyB() {
        return partyB;
    }

    /**
     * 设置合同乙方.
     * @param partyB 合同乙方.
     */
    public void setPartyB(String partyB) {
        this.partyB = partyB;
    }

    /**
     * 获取 合同丙方.
     * @return 合同丙方.
     */
    public String getPartyC() {
        return partyC;
    }

    /**
     * 设置合同丙方.
     * @param partyC 合同丙方.
     */
    public void setPartyC(String partyC) {
        this.partyC = partyC;
    }

    /**
     * 获取 合同总金额.
     * @return 合同总金额.
     */
    public double getContractAmount() {
        return contractAmount;
    }

    /**
     * 设置合同总金额.
     * @param contractAmount 合同总金额.
     */
    public void setContractAmount(double contractAmount) {
        this.contractAmount = contractAmount;
    }

    /**
     * 获取 该合同已收.
     * @return 该合同已收.
     */
    public double getContractAlreadyRec() {
        return contractAlreadyRec;
    }

    /**
     * 设置该合同已收.
     * @param contractAlreadyRec 该合同已收.
     */
    public void setContractAlreadyRec(double contractAlreadyRec) {
        this.contractAlreadyRec = contractAlreadyRec;
    }

    /**
     * 获取 该合同未收.
     * @return 该合同未收.
     */
    public double getContractNotYetRec() {
        return contractNotYetRec;
    }

    /**
     * 设置该合同未收.
     * @param contractNotYetRec 该合同未收.
     */
    public void setContractNotYetRec(double contractNotYetRec) {
        this.contractNotYetRec = contractNotYetRec;
    }

    /**
     * 获取 父合同编号.
     * @return 父合同编号.
     */
    public String getContractParentCode() {
        return contractParentCode;
    }

    /**
     * 设置父合同编号.
     * @param contractParentCode 父合同编号.
     */
    public void setContractParentCode(String contractParentCode) {
        this.contractParentCode = contractParentCode;
    }

    /**
     * 获取 创建时间.
     * @return 创建时间.
     */
    public Date getContractCreateTime() {
        return contractCreateTime;
    }

    /**
     * 设置创建时间.
     * @param contractCreateTime 创建时间.
     */
    public void setContractCreateTime(Date contractCreateTime) {
        this.contractCreateTime = contractCreateTime;
    }

    /**
     * 获取 合同签订时间.
     * @return 合同签订时间.
     */
    public Date getContractSignTime() {
        return contractSignTime;
    }

    /**
     * 设置合同签订时间.
     * @param contractSignTime 合同签订时间.
     */
    public void setContractSignTime(Date contractSignTime) {
        this.contractSignTime = contractSignTime;
    }

    /**
     * 获取 合同结束时间.
     * @return 合同结束时间.
     */
    public Date getContractEndTime() {
        return contractEndTime;
    }

    /**
     * 设置合同结束时间.
     * @param contractEndTime 合同结束时间.
     */
    public void setContractEndTime(Date contractEndTime) {
        this.contractEndTime = contractEndTime;
    }

    /**
     * 获取 合同生效时间.
     * @return 合同生效时间.
     */
    public Date getContractEffectTime() {
        return contractEffectTime;
    }

    /**
     * 设置合同生效时间.
     * @param contractEffectTime 合同生效时间.
     */
    public void setContractEffectTime(Date contractEffectTime) {
        this.contractEffectTime = contractEffectTime;
    }

    /**
     * 获取 合同失效时间.
     * @return 合同失效时间.
     */
    public Date getContractNoEffectTime() {
        return contractNoEffectTime;
    }

    /**
     * 设置合同失效时间.
     * @param contractNoEffectTime 合同失效时间.
     */
    public void setContractNoEffectTime(Date contractNoEffectTime) {
        this.contractNoEffectTime = contractNoEffectTime;
    }

    /**
     * 获取 备注.
     * @return 备注.
     */
    public String getContractRemark() {
        return contractRemark;
    }

    /**
     * 设置备注.
     * @param contractRemark 备注.
     */
    public void setContractRemark(String contractRemark) {
        this.contractRemark = contractRemark;
    }

    /**
     * 获取 发票.
     * @return 发票.
     */
    public InvoiceList getInvoiceList() {
        return invoiceList;
    }

    /**
     * 设置发票.
     * @param invoiceList 发票.
     */
    public void setInvoiceList(InvoiceList invoiceList) {
        this.invoiceList = invoiceList;
    }

    /**
     * 获取 收款.
     * @return 收款.
     */
    public ReceivableList getReceivableList() {
        return receivableList;
    }

    /**
     * 设置收款.
     * @param receivableList 收款.
     */
    public void setReceivableList(ReceivableList receivableList) {
        this.receivableList = receivableList;
    }

    /**
     * 获取 阶段信息.
     * @return 阶段信息.
     */
    public PhaseList getPhaseList() {
        return phaseList;
    }

    /**
     * 设置阶段信息.
     * @param phaseList 阶段信息.
     */
    public void setPhaseList(PhaseList phaseList) {
        this.phaseList = phaseList;
    }

    public int getContractCanInv() {
        return contractCanInv;
    }

    public void setContractCanInv(int contractCanInv) {
        this.contractCanInv = contractCanInv;
    }

    public int getContractCanRec() {
        return contractCanRec;
    }

    public void setContractCanRec(int contractCanRec) {
        this.contractCanRec = contractCanRec;
    }

    /**
     * 清空对象
     */
    @Override
    public void clear() {
        super.clear();
        this.contractCode = null;
        this.projectCode = null;
        this.projectName = null;
        this.custName = null;
        this.userName = null;
        this.projectStatus = 0;
        this.contractName = null;
        this.contractStatus = 0;
        this.contractType = 0;
        this.partyA = null;
        this.partyB = null;
        this.partyC = null;
        this.contractAmount = 0;
        this.contractAlreadyRec = 0;
        this.contractNotYetRec = 0;
        this.contractParentCode = null;
        this.contractCreateTime = new Date(0);
        this.contractSignTime = new Date(0);
        this.contractEndTime = new Date(0);
        this.contractEffectTime = new Date(0);
        this.contractNoEffectTime = new Date(0);
        this.contractRemark = null;
        this.invoiceList = null;
        this.receivableList = null;
        this.phaseList = null;
    }

    /**
     * 复制对象（深复制）
     *
     * @param sou 被复制的对象
     */
    @Override
    public void assignFrom(DataPacket sou) {
        super.assignFrom(sou);
        ProjectContractRet s = (sou instanceof ProjectContractRet) ? (ProjectContractRet)sou : null;
        if (s != null){
            this.contractCode = s.contractCode;
            this.projectCode = s.projectCode;
            this.projectName = s.projectName;
            this.custName = s.custName;
            this.userName = s.userName;
            this.projectStatus = s.projectStatus;
            this.contractName = s.contractName;
            this.contractStatus = s.contractStatus;
            this.contractType = s.contractType;
            this.partyA = s.partyA;
            this.partyB = s.partyB;
            this.partyC = s.partyC;
            this.contractAmount = s.contractAmount;
            this.contractAlreadyRec = s.contractAlreadyRec;
            this.contractNotYetRec = s.contractNotYetRec;
            this.contractParentCode = s.contractParentCode;
            if (s.contractCreateTime != null)
                this.contractCreateTime = new Date(s.contractCreateTime.getTime());
            if (s.contractSignTime != null)
                this.contractSignTime = new Date(s.contractSignTime.getTime());
            if (s.contractEndTime != null)
                this.contractEndTime = new Date(s.contractEndTime.getTime());
            if (s.contractEffectTime != null)
                this.contractEffectTime = new Date(s.contractEffectTime.getTime());
            if (s.contractNoEffectTime != null)
                this.contractNoEffectTime = new Date(s.contractNoEffectTime.getTime());
            this.contractRemark = s.contractRemark;
            if (s.invoiceList != null){
                this.invoiceList = new InvoiceList();
                this.invoiceList.assignFrom(s.invoiceList);
            }
            if (s.receivableList != null){
                this.receivableList = new ReceivableList();
                this.receivableList.assignFrom(s.receivableList);
            }
            if (s.phaseList != null){
                this.phaseList = new PhaseList();
                this.phaseList.assignFrom(s.phaseList);
            }
        }
    }

    @Override
    public String toString() {
        return this.getJsonText();
    }
}

