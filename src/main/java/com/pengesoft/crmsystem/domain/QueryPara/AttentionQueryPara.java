package com.pengesoft.crmsystem.domain.QueryPara;

import com.pengesoft.crmsystem.domain.entity.Attention;
import pengesoft.db.QueryParameter;
import pengesoft.utils.StringHelper;
import java.util.*;
import java.math.*;

/**
 * 关注项目表 查询参数类。
 *
 * @auther: 司童.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaQueryPara),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
public class AttentionQueryPara extends QueryParameter {

    /**
     * 缺省序列化id
     */
    private static final long serialVersionUID = 1L;
    /**
     * 常数 查询属性名(关注id).
     */
    public static final String QueryAttr_AttentionId = "attentionId";
    /**
     * 常数 查询属性名(销售id).
     */
    public static final String QueryAttr_UserId = "userId";
    /**
     * 常数 查询属性名(项目编号).
     */
    public static final String QueryAttr_ProjectCode = "projectCode";

    /**
     * 常数 排序属性名(关注id).
     */
    public static final String OrderAttr_AttentionId = "attentionId";
    /**
     * 常数 排序属性名(销售id).
     */
    public static final String OrderAttr_UserId = "userId";
    /**
     * 常数 排序属性名(项目编号).
     */
    public static final String OrderAttr_ProjectCode = "projectCode";

    /**
     * 默认构造方法
     */
    public AttentionQueryPara() {
        super();
    }

    /**
     * 构造函数,指定参数对象及排序字段
     *
     * @param data  查询参数对象
     * @param order 排序字段
     * @param isAse true升序，false降序
     */
    public AttentionQueryPara(Attention data, String order, boolean isAse) {
        super();
        SetQueryPara(data, order, isAse);
    }

    /**
     * 构造函数,指定参数对象及排序字段
     *
     * @param data 查询参数对象
     */
    public AttentionQueryPara(Attention data) {
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
    public void SetQueryPara(Attention data, String order, boolean isAse) {
        if (data != null) {
            setParamByAttentionId(data.getAttentionId());
            setParamByUserId(data.getUserId());
            setParamByProjectCode(data.getProjectCode());
        }
        if (!StringHelper.isNullOrEmpty(order))
            addOrderBy(order, isAse);
    }

    /**
     * 增加用关注id匹配条件(attentionId非0时才会加入此条件)(target = attentionId)，key:attentionId.
     * @param attentionId 关注id匹配条件参数
     */
    public void setParamByAttentionId(int attentionId){
        addParameter(QueryAttr_AttentionId, attentionId);
    }

    /**
     * 增加用关注id匹配条件(attentionId为0时也会加入此条件)(target = attentionId)，key:attentionId.
     * @param attentionId 关注id匹配条件参数
     */
    public void setParamByAttentionIdIncZero(int attentionId){
        put(QueryAttr_AttentionId, attentionId);
    }

    /**
     * 增加关注id范围条件（low <= target and target >= high），key:attentionId_L attentionId_H.
     * @param low 最小值参数
     * @param high 最大值参数
     */
    public void setParamByAttentionId_Range(int low, int high){
        addParameterByRange(QueryAttr_AttentionId, low, high);
    }

    /**
     * 增加关注id枚举条件(target in (attentionIds))，key:attentionId_Enum.
     * @param attentionIds 关注id数组条件参数
     */
    public void setParamByAttentionId_Enum(int... attentionIds){
        addParameterByEnum(QueryAttr_AttentionId, attentionIds);
    }

    /**
     * 增加用销售id匹配条件(target like userId)，key:userId.
     * @param userId 销售id匹配条件参数
     */
    public void setParamByUserId(String userId){
        addParameter(QueryAttr_UserId, userId);
    }

    /**
     * 增加用销售id匹配条件(userId为empty时也会加入此条件)，不空时(target like userId)，key:userId，为空时(target is null or target = '')，key:userId.
     * @param userId 销售id匹配条件参数
     */
    public void setParamByUserIdInEmpty(String userId){
        put(QueryAttr_UserId, userId);
    }

    /**
     * 增加销售id枚举条件(target in (userIds))，key:userId_Enum.
     * @param userIds 销售id数组条件参数
     */
    public void setParamByUserId_Enum(String... userIds){
        addParameterByEnum(QueryAttr_UserId, userIds);
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