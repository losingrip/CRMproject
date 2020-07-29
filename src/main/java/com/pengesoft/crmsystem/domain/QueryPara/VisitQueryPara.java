package com.pengesoft.crmsystem.domain.QueryPara;

import com.pengesoft.crmsystem.domain.entity.Visit;
import pengesoft.db.QueryParameter;
import pengesoft.utils.StringHelper;

import java.util.Date;

/**
 * 拜访记录 查询参数类。
 *
 * @auther: 司童.
 * @date: 2020/3/30 17:23:42.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaQueryPara),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
public class VisitQueryPara extends QueryParameter {

    /**
     * 缺省序列化id
     */
    private static final long serialVersionUID = 1L;
    /**
     * 常数 查询属性名(拜访记录ID).
     */
    public static final String QueryAttr_VisitId = "visitId";
    /**
     * 常数 查询属性名(计划拜访时间).
     */
    public static final String QueryAttr_VisitPlanTime = "visitPlanTime";
    /**
     * 常数 查询属性名(实际拜访内容).
     */
    public static final String QueryAttr_VisitFactContent = "visitFactContent";
    /**
     * 常数 查询属性名(项目编号).
     */
    public static final String QueryAttr_ProjectCode = "projectCode";

    /**
     * 常数 排序属性名(拜访记录ID).
     */
    public static final String OrderAttr_VisitId = "visitId";
    /**
     * 常数 排序属性名(计划拜访时间).
     */
    public static final String OrderAttr_VisitPlanTime = "visitPlanTime";
    /**
     * 常数 排序属性名(实际拜访内容).
     */
    public static final String OrderAttr_VisitFactContent = "visitFactContent";
    /**
     * 常数 排序属性名(项目编号).
     */
    public static final String OrderAttr_ProjectCode = "projectCode";

    /**
     * 默认构造方法
     */
    public VisitQueryPara() {
        super();
    }

    /**
     * 构造函数,指定参数对象及排序字段
     *
     * @param data  查询参数对象
     * @param order 排序字段
     * @param isAse true升序，false降序
     */
    public VisitQueryPara(Visit data, String order, boolean isAse) {
        super();
        SetQueryPara(data, order, isAse);
    }

    /**
     * 构造函数,指定参数对象及排序字段
     *
     * @param data 查询参数对象
     */
    public VisitQueryPara(Visit data) {
        super();
        SetQueryPara(data, null, false);
    }

    /**
     * 指定查询参数对象及排序字段
     *
     * @param data  查询参数对象
     * @param order 排序字段
     * @param isAse true升序，false降序
     */
    public void SetQueryPara(Visit data, String order, boolean isAse) {
        if (data != null) {
            setParamByVisitId(data.getVisitId());
            setParamByVisitPlanTime(data.getVisitPlanTime());
            setParamByVisitFactContent(data.getVisitFactContent());
            setParamByProjectCode(data.getProjectCode());
        }
        if (!StringHelper.isNullOrEmpty(order))
            addOrderBy(order, isAse);
    }

    /**
     * 增加用拜访记录ID匹配条件(visitId非0时才会加入此条件)(target = visitId)，key:visitId.
     * @param visitId 拜访记录ID匹配条件参数
     */
    public void setParamByVisitId(int visitId){
        addParameter(QueryAttr_VisitId, visitId);
    }

    /**
     * 增加用拜访记录ID匹配条件(visitId为0时也会加入此条件)(target = visitId)，key:visitId.
     * @param visitId 拜访记录ID匹配条件参数
     */
    public void setParamByVisitIdIncZero(int visitId){
        put(QueryAttr_VisitId, visitId);
    }

    /**
     * 增加拜访记录ID范围条件（low <= target and target >= high），key:visitId_L visitId_H.
     * @param low 最小值参数
     * @param high 最大值参数
     */
    public void setParamByVisitId_Range(int low, int high){
        addParameterByRange(QueryAttr_VisitId, low, high);
    }

    /**
     * 增加拜访记录ID枚举条件(target in (visitIds))，key:visitId_Enum.
     * @param visitIds 拜访记录ID数组条件参数
     */
    public void setParamByVisitId_Enum(int... visitIds){
        addParameterByEnum(QueryAttr_VisitId, visitIds);
    }

    /**
     * 增加用计划拜访时间匹配条件(target = visitPlanTime)，key:visitPlanTime.
     * @param visitPlanTime 计划拜访时间匹配条件参数
     */
    public void setParamByVisitPlanTime(Date visitPlanTime){
        addParameter(QueryAttr_VisitPlanTime, visitPlanTime);
    }

    /**
     * 增加计划拜访时间范围条件（startDate < target and target > endDate），key:visitPlanTime_S visitPlanTime_E.
     * @param startDate 最小值参数
     * @param endDate 最大值参数
     */
    public void setParamByVisitPlanTime_Range(Date startDate, Date endDate){
        addParameterByRange(QueryAttr_VisitPlanTime, startDate, endDate);
    }

    /**
     * 增加用实际拜访内容匹配条件(target like visitFactContent)，key:visitFactContent.
     * @param visitFactContent 实际拜访内容匹配条件参数
     */
    public void setParamByVisitFactContent(String visitFactContent){
        addParameter(QueryAttr_VisitFactContent, visitFactContent);
    }

    /**
     * 增加用实际拜访内容匹配条件(visitFactContent为empty时也会加入此条件)，不空时(target like visitFactContent)，key:visitFactContent，为空时(target is null or target = '')，key:visitFactContent.
     * @param visitFactContent 实际拜访内容匹配条件参数
     */
    public void setParamByVisitFactContentInEmpty(String visitFactContent){
        put(QueryAttr_VisitFactContent, visitFactContent);
    }

    /**
     * 增加实际拜访内容枚举条件(target in (visitFactContents))，key:visitFactContent_Enum.
     * @param visitFactContents 实际拜访内容数组条件参数
     */
    public void setParamByVisitFactContent_Enum(String... visitFactContents){
        addParameterByEnum(QueryAttr_VisitFactContent, visitFactContents);
    }

    /**
     * 增加用项目编号匹配条件(target like projectCode)，key:projectCode.
     * @param projectCode 项目编号匹配条件参数
     */
    public void setParamByProjectCode(String projectCode){
        addParameter(QueryAttr_ProjectCode, projectCode);
    }

    /**
     * 增加用项目编号匹配条件(projectCode为empty时也会加入此条件)，不空时(target like projectCode)，key:projectCode，为空时(target is null or target = '')，key:projectCode.
     * @param projectCode 项目编号匹配条件参数
     */
    public void setParamByProjectCodeInEmpty(String projectCode){
        put(QueryAttr_ProjectCode, projectCode);
    }

    /**
     * 增加项目编号枚举条件(target in (projectCodes))，key:projectCode_Enum.
     * @param projectCodes 项目编号数组条件参数
     */
    public void setParamByProjectCode_Enum(String... projectCodes){
        addParameterByEnum(QueryAttr_ProjectCode, projectCodes);
    }

}
