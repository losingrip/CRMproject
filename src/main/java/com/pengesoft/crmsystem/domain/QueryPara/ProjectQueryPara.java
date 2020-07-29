package com.pengesoft.crmsystem.domain.QueryPara;

import com.pengesoft.crmsystem.domain.entity.Project;
import pengesoft.db.QueryParameter;
import pengesoft.utils.StringHelper;
import java.util.*;
import java.math.*;

/**
 * 项目信息 查询参数类。
 *
 * @auther: 司童.
 * @date: 2020/3/31 16:25:33.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaQueryPara),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
public class ProjectQueryPara extends QueryParameter {

    /**
     * 缺省序列化id
     */
    private static final long serialVersionUID = 1L;
    /**
     * 常数 查询属性名(项目编码).
     */
    public static final String QueryAttr_ProjectCode = "projectCode";
    /**
     * 常数 查询属性名(项目名称).
     */
    public static final String QueryAttr_ProjectName = "projectName";
    /**
     * 常数 查询属性名(项目描述).
     */
    public static final String QueryAttr_ProjectDescribe = "projectDescribe";
    /**
     * 常数 查询属性名(项目P级别).
     */
    public static final String QueryAttr_ProjectPLevel = "projectPLevel";
    /**
     * 常数 查询属性名(项目分类).
     */
    public static final String QueryAttr_ProjectType = "projectType";
    /**
     * 常数 查询属性名(销售人员).
     */
    public static final String QueryAttr_UserId = "userId";
    /**
     * 常数 查询属性名(项目状态).
     */
    public static final String QueryAttr_ProjectStatus = "projectStatus";
    /**
     * 常数 查询属性名(创建时间).
     */
    public static final String QueryAttr_ProjectCreateTime = "projectCreateTime";
    /**
     * 常数 查询属性名(更新时间).
     */
    public static final String QueryAttr_ProjectUpdateTime = "projectUpdateTime";
    /**
     * 常数 查询属性名(客户).
     */
    public static final String QueryAttr_CustId = "custId";
    /**
     * 常数 查询属性名(联系人姓名).
     */
    public static final String QueryAttr_ContactName = "contactName";
    /**
     * 常数 查询属性名(联系人电话).
     */
    public static final String QueryAttr_ContactTel = "contactTel";
    /**
     * 常数 查询属性名(联系人职务).
     */
    public static final String QueryAttr_ContactDuty = "contactDuty";
    /**
     * 常数 查询属性名(历史联系人).
     */
    public static final String QueryAttr_ContactHistory = "contactHistory";

    /**
     * 常数 排序属性名(项目编码).
     */
    public static final String OrderAttr_ProjectCode = "projectCode";
    /**
     * 常数 排序属性名(项目名称).
     */
    public static final String OrderAttr_ProjectName = "projectName";
    /**
     * 常数 排序属性名(项目描述).
     */
    public static final String OrderAttr_ProjectDescribe = "projectDescribe";
    /**
     * 常数 排序属性名(项目P级别).
     */
    public static final String OrderAttr_ProjectPLevel = "projectPLevel";
    /**
     * 常数 排序属性名(项目分类).
     */
    public static final String OrderAttr_ProjectType = "projectType";
    /**
     * 常数 排序属性名(销售人员).
     */
    public static final String OrderAttr_UserId = "userId";
    /**
     * 常数 排序属性名(项目状态).
     */
    public static final String OrderAttr_ProjectStatus = "projectStatus";
    /**
     * 常数 排序属性名(创建时间).
     */
    public static final String OrderAttr_ProjectCreateTime = "projectCreateTime";
    /**
     * 常数 排序属性名(更新时间).
     */
    public static final String OrderAttr_ProjectUpdateTime = "projectUpdateTime";
    /**
     * 常数 排序属性名(客户).
     */
    public static final String OrderAttr_CustId = "custId";
    /**
     * 常数 排序属性名(联系人姓名).
     */
    public static final String OrderAttr_ContactName = "contactName";
    /**
     * 常数 排序属性名(联系人电话).
     */
    public static final String OrderAttr_ContactTel = "contactTel";

    /**
     * 默认构造方法
     */
    public ProjectQueryPara() {
        super();
    }

    /**
     * 构造函数,指定参数对象及排序字段
     *
     * @param data  查询参数对象
     * @param order 排序字段
     * @param isAse true升序，false降序
     */
    public ProjectQueryPara(Project data, String order, boolean isAse) {
        super();
        SetQueryPara(data, order, isAse);
    }

    /**
     * 构造函数,指定参数对象及排序字段
     *
     * @param data 查询参数对象
     */
    public ProjectQueryPara(Project data) {
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
    public void SetQueryPara(Project data, String order, boolean isAse) {
        if (data != null) {
            setParamByProjectCode(data.getProjectCode());
            setParamByProjectName(data.getProjectName());
            setParamByProjectDescribe(data.getProjectDescribe());
            setParamByProjectPLevel(data.getProjectPLevel());
            setParamByProjectType(data.getProjectType());
            setParamByUserId(data.getUserId());
            setParamByProjectStatus(data.getProjectStatus());
            setParamByProjectCreateTime(data.getProjectCreateTime());
            setParamByProjectUpdateTime(data.getProjectUpdateTime());
            setParamByCustId(data.getCustId());
            setParamByContactName(data.getContactName());
            setParamByContactTel(data.getContactTel());
            setParamByContactDuty(data.getContactDuty());
            setParamByContactHistory(data.getContactHistory());
        }
        if (!StringHelper.isNullOrEmpty(order))
            addOrderBy(order, isAse);
    }

    /**
     * 增加用项目编码匹配条件(target like projectCode)，key:projectCode.
     * @param projectCode 项目编码匹配条件参数
     */
    public void setParamByProjectCode(String projectCode){
        addParameter(QueryAttr_ProjectCode, projectCode);
    }

    /**
     * 增加用项目编码匹配条件(projectCode为empty时也会加入此条件)，不空时(target like projectCode)，key:projectCode，为空时(target is null or target = '')，key:projectCode.
     * @param projectCode 项目编码匹配条件参数
     */
    public void setParamByProjectCodeInEmpty(String projectCode){
        put(QueryAttr_ProjectCode, projectCode);
    }

    /**
     * 增加项目编码枚举条件(target in (projectCodes))，key:projectCode_Enum.
     * @param projectCodes 项目编码数组条件参数
     */
    public void setParamByProjectCode_Enum(String... projectCodes){
        addParameterByEnum(QueryAttr_ProjectCode, projectCodes);
    }

    /**
     * 增加用项目名称匹配条件(target like projectName)，key:projectName.
     * @param projectName 项目名称匹配条件参数
     */
    public void setParamByProjectName(String projectName){
        addParameter(QueryAttr_ProjectName, projectName);
    }

    /**
     * 增加用项目名称匹配条件(projectName为empty时也会加入此条件)，不空时(target like projectName)，key:projectName，为空时(target is null or target = '')，key:projectName.
     * @param projectName 项目名称匹配条件参数
     */
    public void setParamByProjectNameInEmpty(String projectName){
        put(QueryAttr_ProjectName, projectName);
    }

    /**
     * 增加项目名称枚举条件(target in (projectNames))，key:projectName_Enum.
     * @param projectNames 项目名称数组条件参数
     */
    public void setParamByProjectName_Enum(String... projectNames){
        addParameterByEnum(QueryAttr_ProjectName, projectNames);
    }

    /**
     * 增加用项目描述匹配条件(target like projectDescribe)，key:projectDescribe.
     * @param projectDescribe 项目描述匹配条件参数
     */
    public void setParamByProjectDescribe(String projectDescribe){
        addParameter(QueryAttr_ProjectDescribe, projectDescribe);
    }

    /**
     * 增加用项目描述匹配条件(projectDescribe为empty时也会加入此条件)，不空时(target like projectDescribe)，key:projectDescribe，为空时(target is null or target = '')，key:projectDescribe.
     * @param projectDescribe 项目描述匹配条件参数
     */
    public void setParamByProjectDescribeInEmpty(String projectDescribe){
        put(QueryAttr_ProjectDescribe, projectDescribe);
    }

    /**
     * 增加项目描述枚举条件(target in (projectDescribes))，key:projectDescribe_Enum.
     * @param projectDescribes 项目描述数组条件参数
     */
    public void setParamByProjectDescribe_Enum(String... projectDescribes){
        addParameterByEnum(QueryAttr_ProjectDescribe, projectDescribes);
    }

    /**
     * 增加用项目P级别匹配条件(projectPLevel非0时才会加入此条件)(target = projectPLevel)，key:projectPLevel.
     * @param projectPLevel 项目P级别匹配条件参数
     */
    public void setParamByProjectPLevel(int projectPLevel){
        addParameter(QueryAttr_ProjectPLevel, projectPLevel);
    }

    /**
     * 增加用项目P级别匹配条件(projectPLevel为0时也会加入此条件)(target = projectPLevel)，key:projectPLevel.
     * @param projectPLevel 项目P级别匹配条件参数
     */
    public void setParamByProjectPLevelIncZero(int projectPLevel){
        put(QueryAttr_ProjectPLevel, projectPLevel);
    }

    /**
     * 增加项目P级别范围条件（low <= target and target >= high），key:projectPLevel_L projectPLevel_H.
     * @param low 最小值参数
     * @param high 最大值参数
     */
    public void setParamByProjectPLevel_Range(int low, int high){
        addParameterByRange(QueryAttr_ProjectPLevel, low, high);
    }

    /**
     * 增加项目P级别枚举条件(target in (projectPLevels))，key:projectPLevel_Enum.
     * @param projectPLevels 项目P级别数组条件参数
     */
    public void setParamByProjectPLevel_Enum(int... projectPLevels){
        addParameterByEnum(QueryAttr_ProjectPLevel, projectPLevels);
    }

    /**
     * 增加用项目分类匹配条件(projectType非0时才会加入此条件)(target = projectType)，key:projectType.
     * @param projectType 项目分类匹配条件参数
     */
    public void setParamByProjectType(int projectType){
        addParameter(QueryAttr_ProjectType, projectType);
    }

    /**
     * 增加用项目分类匹配条件(projectType为0时也会加入此条件)(target = projectType)，key:projectType.
     * @param projectType 项目分类匹配条件参数
     */
    public void setParamByProjectTypeIncZero(int projectType){
        put(QueryAttr_ProjectType, projectType);
    }

    /**
     * 增加项目分类范围条件（low <= target and target >= high），key:projectType_L projectType_H.
     * @param low 最小值参数
     * @param high 最大值参数
     */
    public void setParamByProjectType_Range(int low, int high){
        addParameterByRange(QueryAttr_ProjectType, low, high);
    }

    /**
     * 增加项目分类枚举条件(target in (projectTypes))，key:projectType_Enum.
     * @param projectTypes 项目分类数组条件参数
     */
    public void setParamByProjectType_Enum(int... projectTypes){
        addParameterByEnum(QueryAttr_ProjectType, projectTypes);
    }

    /**
     * 增加用销售人员匹配条件(target like userId)，key:userId.
     * @param userId 销售人员匹配条件参数
     */
    public void setParamByUserId(String userId){
        addParameter(QueryAttr_UserId, userId);
    }

    /**
     * 增加用销售人员匹配条件(userId为empty时也会加入此条件)，不空时(target like userId)，key:userId，为空时(target is null or target = '')，key:userId.
     * @param userId 销售人员匹配条件参数
     */
    public void setParamByUserIdInEmpty(String userId){
        put(QueryAttr_UserId, userId);
    }

    /**
     * 增加销售人员枚举条件(target in (userIds))，key:userId_Enum.
     * @param userIds 销售人员数组条件参数
     */
    public void setParamByUserId_Enum(String... userIds){
        addParameterByEnum(QueryAttr_UserId, userIds);
    }

    /**
     * 增加用项目状态匹配条件(projectStatus非0时才会加入此条件)(target = projectStatus)，key:projectStatus.
     * @param projectStatus 项目状态匹配条件参数
     */
    public void setParamByProjectStatus(int projectStatus){
        addParameter(QueryAttr_ProjectStatus, projectStatus);
    }

    /**
     * 增加用项目状态匹配条件(projectStatus为0时也会加入此条件)(target = projectStatus)，key:projectStatus.
     * @param projectStatus 项目状态匹配条件参数
     */
    public void setParamByProjectStatusIncZero(int projectStatus){
        put(QueryAttr_ProjectStatus, projectStatus);
    }

    /**
     * 增加项目状态范围条件（low <= target and target >= high），key:projectStatus_L projectStatus_H.
     * @param low 最小值参数
     * @param high 最大值参数
     */
    public void setParamByProjectStatus_Range(int low, int high){
        addParameterByRange(QueryAttr_ProjectStatus, low, high);
    }

    /**
     * 增加项目状态枚举条件(target in (projectStatuss))，key:projectStatus_Enum.
     * @param projectStatuss 项目状态数组条件参数
     */
    public void setParamByProjectStatus_Enum(int... projectStatuss){
        addParameterByEnum(QueryAttr_ProjectStatus, projectStatuss);
    }

    /**
     * 增加用创建时间匹配条件(target = projectCreateTime)，key:projectCreateTime.
     * @param projectCreateTime 创建时间匹配条件参数
     */
    public void setParamByProjectCreateTime(Date projectCreateTime){
        addParameter(QueryAttr_ProjectCreateTime, projectCreateTime);
    }

    /**
     * 增加创建时间范围条件（startDate < target and target > endDate），key:projectCreateTime_S projectCreateTime_E.
     * @param startDate 最小值参数
     * @param endDate 最大值参数
     */
    public void setParamByProjectCreateTime_Range(Date startDate, Date endDate){
        addParameterByRange(QueryAttr_ProjectCreateTime, startDate, endDate);
    }

    /**
     * 增加用更新时间匹配条件(target = projectUpdateTime)，key:projectUpdateTime.
     * @param projectUpdateTime 更新时间匹配条件参数
     */
    public void setParamByProjectUpdateTime(Date projectUpdateTime){
        addParameter(QueryAttr_ProjectUpdateTime, projectUpdateTime);
    }

    /**
     * 增加更新时间范围条件（startDate < target and target > endDate），key:projectUpdateTime_S projectUpdateTime_E.
     * @param startDate 最小值参数
     * @param endDate 最大值参数
     */
    public void setParamByProjectUpdateTime_Range(Date startDate, Date endDate){
        addParameterByRange(QueryAttr_ProjectUpdateTime, startDate, endDate);
    }

    /**
     * 增加用客户匹配条件(custId非0时才会加入此条件)(target = custId)，key:custId.
     * @param custId 客户匹配条件参数
     */
    public void setParamByCustId(int custId){
        addParameter(QueryAttr_CustId, custId);
    }

    /**
     * 增加用客户匹配条件(custId为0时也会加入此条件)(target = custId)，key:custId.
     * @param custId 客户匹配条件参数
     */
    public void setParamByCustIdIncZero(int custId){
        put(QueryAttr_CustId, custId);
    }

    /**
     * 增加客户范围条件（low <= target and target >= high），key:custId_L custId_H.
     * @param low 最小值参数
     * @param high 最大值参数
     */
    public void setParamByCustId_Range(int low, int high){
        addParameterByRange(QueryAttr_CustId, low, high);
    }

    /**
     * 增加客户枚举条件(target in (custIds))，key:custId_Enum.
     * @param custIds 客户数组条件参数
     */
    public void setParamByCustId_Enum(int... custIds){
        addParameterByEnum(QueryAttr_CustId, custIds);
    }

    /**
     * 增加用联系人姓名匹配条件(target like contactName)，key:contactName.
     * @param contactName 联系人姓名匹配条件参数
     */
    public void setParamByContactName(String contactName){
        addParameter(QueryAttr_ContactName, contactName);
    }

    /**
     * 增加用联系人姓名匹配条件(contactName为empty时也会加入此条件)，不空时(target like contactName)，key:contactName，为空时(target is null or target = '')，key:contactName.
     * @param contactName 联系人姓名匹配条件参数
     */
    public void setParamByContactNameInEmpty(String contactName){
        put(QueryAttr_ContactName, contactName);
    }

    /**
     * 增加联系人姓名枚举条件(target in (contactNames))，key:contactName_Enum.
     * @param contactNames 联系人姓名数组条件参数
     */
    public void setParamByContactName_Enum(String... contactNames){
        addParameterByEnum(QueryAttr_ContactName, contactNames);
    }

    /**
     * 增加用联系人电话匹配条件(target like contactTel)，key:contactTel.
     * @param contactTel 联系人电话匹配条件参数
     */
    public void setParamByContactTel(String contactTel){
        addParameter(QueryAttr_ContactTel, contactTel);
    }

    /**
     * 增加用联系人电话匹配条件(contactTel为empty时也会加入此条件)，不空时(target like contactTel)，key:contactTel，为空时(target is null or target = '')，key:contactTel.
     * @param contactTel 联系人电话匹配条件参数
     */
    public void setParamByContactTelInEmpty(String contactTel){
        put(QueryAttr_ContactTel, contactTel);
    }

    /**
     * 增加联系人电话枚举条件(target in (contactTels))，key:contactTel_Enum.
     * @param contactTels 联系人电话数组条件参数
     */
    public void setParamByContactTel_Enum(String... contactTels){
        addParameterByEnum(QueryAttr_ContactTel, contactTels);
    }

    /**
     * 增加用联系人职务匹配条件(target like contactDuty)，key:contactDuty.
     * @param contactDuty 联系人职务匹配条件参数
     */
    public void setParamByContactDuty(String contactDuty){
        addParameter(QueryAttr_ContactDuty, contactDuty);
    }

    /**
     * 增加用联系人职务匹配条件(contactDuty为empty时也会加入此条件)，不空时(target like contactDuty)，key:contactDuty，为空时(target is null or target = '')，key:contactDuty.
     * @param contactDuty 联系人职务匹配条件参数
     */
    public void setParamByContactDutyInEmpty(String contactDuty){
        put(QueryAttr_ContactDuty, contactDuty);
    }

    /**
     * 增加联系人职务枚举条件(target in (contactDutys))，key:contactDuty_Enum.
     * @param contactDutys 联系人职务数组条件参数
     */
    public void setParamByContactDuty_Enum(String... contactDutys){
        addParameterByEnum(QueryAttr_ContactDuty, contactDutys);
    }

    /**
     * 增加用历史联系人匹配条件(target like contactHistory)，key:contactHistory.
     * @param contactHistory 历史联系人匹配条件参数
     */
    public void setParamByContactHistory(String contactHistory){
        addParameter(QueryAttr_ContactHistory, contactHistory);
    }

    /**
     * 增加用历史联系人匹配条件(contactHistory为empty时也会加入此条件)，不空时(target like contactHistory)，key:contactHistory，为空时(target is null or target = '')，key:contactHistory.
     * @param contactHistory 历史联系人匹配条件参数
     */
    public void setParamByContactHistoryInEmpty(String contactHistory){
        put(QueryAttr_ContactHistory, contactHistory);
    }

    /**
     * 增加历史联系人枚举条件(target in (contactHistorys))，key:contactHistory_Enum.
     * @param contactHistorys 历史联系人数组条件参数
     */
    public void setParamByContactHistory_Enum(String... contactHistorys){
        addParameterByEnum(QueryAttr_ContactHistory, contactHistorys);
    }

}