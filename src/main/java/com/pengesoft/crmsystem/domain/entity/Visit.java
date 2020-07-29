package com.pengesoft.crmsystem.domain.entity;

import pengesoft.data.DataPacket;

import java.util.Date;

/**
 * 拜访记录 的摘要说明。
 *
 * @auther: 司童.
 * @date: 2020/3/30 17:23:42.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaAdv),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
public class Visit extends DataPacket {

    //拜访记录ID.
    private int visitId;
    //计划拜访时间.
    private Date visitPlanTime;
    //计划拜访内容.
    private String visitPlanContent;
    //实际拜访时间.
    private Date visitFactTime;
    //实际拜访内容.
    private String visitFactContent;
    //备注.
    private String visitRemark;
    //项目编号.
    private String projectCode;


    public Visit(int visitId) {
        this.visitId = visitId;
    }

    public Visit() {
    }

    /**
     * 获取 拜访记录ID.
     * @return 拜访记录ID.
     */
    public int getVisitId() {
        return visitId;
    }

    /**
     * 设置拜访记录ID.
     * @param visitId 拜访记录ID.
     */
    public void setVisitId(int visitId) {
        this.visitId = visitId;
    }

    /**
     * 获取 计划拜访时间.
     * @return 计划拜访时间.
     */
    public Date getVisitPlanTime() {
        return visitPlanTime;
    }

    /**
     * 设置计划拜访时间.
     * @param visitPlanTime 计划拜访时间.
     */
    public void setVisitPlanTime(Date visitPlanTime) {
        this.visitPlanTime = visitPlanTime;
    }

    /**
     * 获取 计划拜访内容.
     * @return 计划拜访内容.
     */
    public String getVisitPlanContent() {
        return visitPlanContent;
    }

    /**
     * 设置计划拜访内容.
     * @param visitPlanContent 计划拜访内容.
     */
    public void setVisitPlanContent(String visitPlanContent) {
        this.visitPlanContent = visitPlanContent;
    }

    /**
     * 获取 实际拜访时间.
     * @return 实际拜访时间.
     */
    public Date getVisitFactTime() {
        return visitFactTime;
    }

    /**
     * 设置实际拜访时间.
     * @param visitFactTime 实际拜访时间.
     */
    public void setVisitFactTime(Date visitFactTime) {
        this.visitFactTime = visitFactTime;
    }

    /**
     * 获取 实际拜访内容.
     * @return 实际拜访内容.
     */
    public String getVisitFactContent() {
        return visitFactContent;
    }

    /**
     * 设置实际拜访内容.
     * @param visitFactContent 实际拜访内容.
     */
    public void setVisitFactContent(String visitFactContent) {
        this.visitFactContent = visitFactContent;
    }

    /**
     * 获取 备注.
     * @return 备注.
     */
    public String getVisitRemark() {
        return visitRemark;
    }

    /**
     * 设置备注.
     * @param visitRemark 备注.
     */
    public void setVisitRemark(String visitRemark) {
        this.visitRemark = visitRemark;
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
        this.visitId = 0;
        this.visitPlanTime = new Date(0);
        this.visitPlanContent = null;
        this.visitFactTime = new Date(0);
        this.visitFactContent = null;
        this.visitRemark = null;
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
        Visit s = (sou instanceof Visit) ? (Visit)sou : null;
        if (s != null){
            this.visitId = s.visitId;
            if (s.visitPlanTime != null)
                this.visitPlanTime = new Date(s.visitPlanTime.getTime());
            this.visitPlanContent = s.visitPlanContent;
            if (s.visitFactTime != null)
                this.visitFactTime = new Date(s.visitFactTime.getTime());
            this.visitFactContent = s.visitFactContent;
            this.visitRemark = s.visitRemark;
            this.projectCode = s.projectCode;
        }
    }

    @Override
    public String toString() {
        return this.getJsonText();
    }
}


