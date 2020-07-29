package com.pengesoft.crmsystem.domain.entity;

import pengesoft.data.*;
import java.math.*;
import java.util.*;

/**
 * 阶段信息 的摘要说明。
 *
 * @auther: 余展鹏.
 * @date: 2020/4/2 16:07:37.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaAdv),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
public class Phase extends DataPacket {

    //阶段序号.
    private String phaseId;
    //阶段描述.
    private String phaseDescribe;
    //预期完成时间.
    private Date planTime;
    //实际完成时间.
    private Date factTime;
    //阶段类型.
    private int phaseType;
    //应收金额.
    private double phaseAmount;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phase phase = (Phase) o;
        return phaseType == phase.phaseType &&
                Double.compare(phase.phaseAmount, phaseAmount) == 0 &&
                Objects.equals(phaseId, phase.phaseId) &&
                Objects.equals(phaseDescribe, phase.phaseDescribe) &&
                Objects.equals(planTime, phase.planTime) &&
                Objects.equals(factTime, phase.factTime);
    }

    @Override
    public int hashCode() {

        return Objects.hash(phaseId, phaseDescribe, planTime, factTime, phaseType, phaseAmount);
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
     * 获取 阶段描述.
     * @return 阶段描述.
     */
    public String getPhaseDescribe() {
        return phaseDescribe;
    }

    /**
     * 设置阶段描述.
     * @param phaseDescribe 阶段描述.
     */
    public void setPhaseDescribe(String phaseDescribe) {
        this.phaseDescribe = phaseDescribe;
    }

    /**
     * 获取 预期完成时间.
     * @return 预期完成时间.
     */
    public Date getPlanTime() {
        return planTime;
    }

    /**
     * 设置预期完成时间.
     * @param planTime 预期完成时间.
     */
    public void setPlanTime(Date planTime) {
        this.planTime = planTime;
    }

    /**
     * 获取 实际完成时间.
     * @return 实际完成时间.
     */
    public Date getFactTime() {
        return factTime;
    }

    /**
     * 设置实际完成时间.
     * @param factTime 实际完成时间.
     */
    public void setFactTime(Date factTime) {
        this.factTime = factTime;
    }

    /**
     * 获取 阶段类型.
     * @return 阶段类型.
     */
    public int getPhaseType() {
        return phaseType;
    }

    /**
     * 设置阶段类型.
     * @param phaseType 阶段类型.
     */
    public void setPhaseType(int phaseType) {
        this.phaseType = phaseType;
    }

    /**
     * 获取 应收金额.
     * @return 应收金额.
     */
    public double getPhaseAmount() {
        return phaseAmount;
    }

    /**
     * 设置应收金额.
     * @param phaseAmount 应收金额.
     */
    public void setPhaseAmount(double phaseAmount) {
        this.phaseAmount = phaseAmount;
    }


    /**
     * 清空对象
     */
    @Override
    public void clear() {
        super.clear();
        this.phaseId = null;
        this.phaseDescribe = null;
        this.planTime = new Date(0);
        this.factTime = new Date(0);
        this.phaseType = 0;
        this.phaseAmount = 0;
    }

    /**
     * 复制对象（深复制）
     *
     * @param sou 被复制的对象
     */
    @Override
    public void assignFrom(DataPacket sou) {
        super.assignFrom(sou);
        Phase s = (sou instanceof Phase) ? (Phase)sou : null;
        if (s != null){
            this.phaseId = s.phaseId;
            this.phaseDescribe = s.phaseDescribe;
            if (s.planTime != null)
                this.planTime = new Date(s.planTime.getTime());
            if (s.factTime != null)
                this.factTime = new Date(s.factTime.getTime());
            this.phaseType = s.phaseType;
            this.phaseAmount = s.phaseAmount;
        }
    }

    @Override
    public String toString() {
        return this.getJsonText();
    }
}

