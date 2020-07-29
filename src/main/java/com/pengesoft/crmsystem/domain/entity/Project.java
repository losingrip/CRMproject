package com.pengesoft.crmsystem.domain.entity;

import com.pengesoft.crmsystem.domain.entitylist.VisitList;
import pengesoft.data.DataPacket;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 项目信息 的摘要说明。
 *
 * @auther: 司童.
 * @date: 2020/3/31 16:24:48.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaAdv),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
public class Project extends DataPacket {

    //项目编码.
    private String projectCode;
    //项目名称.
    private String projectName;
    //项目描述.
    private String projectDescribe;
    //项目P级别.
    private int projectPLevel;
    //项目分类.
    private int projectType;
    //销售人员.
    private String userId;
    //项目状态.
    private int projectStatus;
    //创建时间.
    private Date projectCreateTime;
    //更新时间.
    private Date projectUpdateTime;
    //备注.
    private String projectRemark;
    //客户.
    private int custId;
    //联系人姓名.
    private String contactName;
    //联系人电话.
    private String contactTel;
    //联系人职务.
    private String contactDuty;
    //历史联系人.
    private String contactHistory;
    //拜访信息.
    private VisitList visit;
    //近期拜访时间
    private Date visitPlanTime;
    //销售人员名字
//    private String userName;
    //项目所有拜访信息
//    private List<Vist> vist;

    //合同总额
    private double contractTotal;
    //合同回款总和
    private double receiveTotal;
    //plevel级别
    private List<Object> plevelList;
    //plevel总量
    private int plevelCount;
    //回款比例
    private double percentage;
    //客户名字
//    private String custName;
    private String customerName;


    /**
     * 客户名字
     * @return
     */
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    //销售名字
//    private String userName;
    private String name;
    //是否关注

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private int attentionId;
    //项目的合同数量
    private int contractCount;


    /**
     * 项目的合同数量
     * @return
     */
    public int getContractCount() {
        return contractCount;
    }

    public void setContractCount(int contractCount) {
        this.contractCount = contractCount;
    }

    /***
     * 项目是否被关注
     * @return
     */
    public int getAttentionId() {
        return attentionId;
    }

    public void setAttentionId(int attention) {
        this.attentionId = attention;
    }


    /**
     * 销售主管收款百分比
     * @return
     */
    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    /**
     * p级别项目数量
     * @return
     */
    public int getPlevelCount() {
        return plevelCount;
    }

    public void setPlevelCount(int plevelCount) {
        this.plevelCount = plevelCount;
    }

    public List<Object> getPlevelList() {
        return plevelList;
    }

    public void setPlevelList(List<Object> plevelList) {
        this.plevelList = plevelList;
    }

    /**
     * 合同回款总额
     * @return
     */
    public double getReceiveTotal() {
        return receiveTotal;
    }

    public void setReceiveTotal(double receiveTotal) {
        this.receiveTotal = receiveTotal;
    }

    /**
     * 合同总额
     * @return
     */
    public Double getContractTotal() {
        return contractTotal;
    }

    public void setContractTotal(Double contractTotal) {
        this.contractTotal = contractTotal;
    }



    /**
     * 获取近期拜访时间
     * @return
     */
    public Date getVisitPlanTime() {
        return visitPlanTime;
    }

    /**
     * 设置近期拜访时间
     * @param visitPlanTime
     */
    public void setVisitPlanTime(Date visitPlanTime) {
        this.visitPlanTime = visitPlanTime;
    }

    /**
     * 获取拜访列表
     * @return
     */
    public VisitList getVisit() {
        return visit;
    }

    /**
     * 设置拜访列表
     * @param visit
     */
    public void setVisit(VisitList visit) {
        this.visit = visit;
    }

    /**
     * 获取 项目编码.
     * @return 项目编码.
     */
    public String getProjectCode() {
        return projectCode;
    }

    /**
     * 设置项目编码.
     * @param projectCode 项目编码.
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
     * 获取 项目描述.
     * @return 项目描述.
     */
    public String getProjectDescribe() {
        return projectDescribe;
    }

    /**
     * 设置项目描述.
     * @param projectDescribe 项目描述.
     */
    public void setProjectDescribe(String projectDescribe) {
        this.projectDescribe = projectDescribe;
    }

    /**
     * 获取 项目P级别.
     * @return 项目P级别.
     */
    public int getProjectPLevel() {
        return projectPLevel;
    }

    /**
     * 设置项目P级别.
     * @param projectPLevel 项目P级别.
     */
    public void setProjectPLevel(int projectPLevel) {
        this.projectPLevel = projectPLevel;
    }

    /**
     * 获取 项目分类.
     * @return 项目分类.
     */
    public int getProjectType() {
        return projectType;
    }

    /**
     * 设置项目分类.
     * @param projectType 项目分类.
     */
    public void setProjectType(int projectType) {
        this.projectType = projectType;
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
     * 获取 创建时间.
     * @return 创建时间.
     */
    public Date getProjectCreateTime() {
        return projectCreateTime;
    }

    /**
     * 设置创建时间.
     * @param projectCreateTime 创建时间.
     */
    public void setProjectCreateTime(Date projectCreateTime) {
        this.projectCreateTime = projectCreateTime;
    }

    /**
     * 获取 更新时间.
     * @return 更新时间.
     */
    public Date getProjectUpdateTime() {
        return projectUpdateTime;
    }

    /**
     * 设置更新时间.
     * @param projectUpdateTime 更新时间.
     */
    public void setProjectUpdateTime(Date projectUpdateTime) {
        this.projectUpdateTime = projectUpdateTime;
    }

    /**
     * 获取 备注.
     * @return 备注.
     */
    public String getProjectRemark() {
        return projectRemark;
    }

    /**
     * 设置备注.
     * @param projectRemark 备注.
     */
    public void setProjectRemark(String projectRemark) {
        this.projectRemark = projectRemark;
    }

    /**
     * 获取 客户.
     * @return 客户.
     */
    public int getCustId() {
        return custId;
    }

    /**
     * 设置客户.
     * @param custId 客户.
     */
    public void setCustId(int custId) {
        this.custId = custId;
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
     * 获取 历史联系人.
     * @return 历史联系人.
     */
    public String getContactHistory() {
        return contactHistory;
    }

    /**
     * 设置历史联系人.
     * @param contactHistory 历史联系人.
     */
    public void setContactHistory(String contactHistory) {
        this.contactHistory = contactHistory;
    }



    /**
     * 清空对象
     */
    @Override
    public void clear() {
        super.clear();
        this.projectCode = null;
        this.projectName = null;
        this.projectDescribe = null;
        this.projectPLevel = 0;
        this.projectType = 0;
        this.userId = null;
        this.projectStatus = 0;
        this.projectCreateTime = new Date(0);
        this.projectUpdateTime = new Date(0);
        this.projectRemark = null;
        this.custId = 0;
        this.contactName = null;
        this.contactTel = null;
        this.contactDuty = null;
        this.contactHistory = null;
//        this.visit = null;
    }

    /**
     * 复制对象（深复制）
     *
     * @param sou 被复制的对象
     */
    @Override
    public void assignFrom(DataPacket sou) {
        super.assignFrom(sou);
        Project s = (sou instanceof Project) ? (Project)sou : null;
        if (s != null){
            this.projectCode = s.projectCode;
            this.projectName = s.projectName;
            this.projectDescribe = s.projectDescribe;
            this.projectPLevel = s.projectPLevel;
            this.projectType = s.projectType;
            this.userId = s.userId;
            this.projectStatus = s.projectStatus;
            if (s.projectCreateTime != null)
                this.projectCreateTime = new Date(s.projectCreateTime.getTime());
            if (s.projectUpdateTime != null)
                this.projectUpdateTime = new Date(s.projectUpdateTime.getTime());
            this.projectRemark = s.projectRemark;
            this.custId = s.custId;
            this.contactName = s.contactName;
            this.contactTel = s.contactTel;
            this.contactDuty = s.contactDuty;
            this.contactHistory = s.contactHistory;
//            if (s.visit != null){
//                this.visit = new VisitList();
//                this.visit.assignFrom(s.visit);
//            }
        }
    }

    @Override
    public String toString() {
        return this.getJsonText();
    }
}

