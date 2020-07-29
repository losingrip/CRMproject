package com.pengesoft.crmsystem.domain.QueryPara;

import com.pengesoft.crmsystem.domain.entity.InvoiceApply;
import pengesoft.db.QueryParameter;
import pengesoft.utils.StringHelper;
import java.util.*;
import java.math.*;

/**
 * 开票申请 查询参数类。
 *
 * @auther: 余展鹏.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaQueryPara),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
public class InvoiceApplyQueryPara extends QueryParameter {

    /**
     * 缺省序列化id
     */
    private static final long serialVersionUID = 1L;
    /**
     * 常数 查询属性名(申请id).
     */
    public static final String QueryAttr_InvoiceApplyId = "invoiceApplyId";
    /**
     * 常数 查询属性名(申请人Id).
     */
    public static final String QueryAttr_UserId = "userId";
    /**
     * 常数 查询属性名(申请人名字).
     */
    public static final String QueryAttr_Name = "name";
    /**
     * 常数 查询属性名(合同编号).
     */
    public static final String QueryAttr_ContractCode = "contractCode";
    /**
     * 常数 查询属性名(阶段序号).
     */
    public static final String QueryAttr_PhaseId = "phaseId";
    /**
     * 常数 查询属性名(是否处理).
     */
    public static final String QueryAttr_InvoiceApplyIsDeal = "invoiceApplyIsDeal";
    /**
     * 常数 查询属性名(申请开票金额).
     */
    public static final String QueryAttr_InvoiceApplyAmount = "invoiceApplyAmount";

    /**
     * 常数 排序属性名(申请id).
     */
    public static final String OrderAttr_InvoiceApplyId = "invoiceApplyId";

    /**
     * 默认构造方法
     */
    public InvoiceApplyQueryPara() {
        super();
    }

    /**
     * 构造函数,指定参数对象及排序字段
     *
     * @param data  查询参数对象
     * @param order 排序字段
     * @param isAse true升序，false降序
     */
    public InvoiceApplyQueryPara(InvoiceApply data, String order, boolean isAse) {
        super();
        SetQueryPara(data, order, isAse);
    }

    /**
     * 构造函数,指定参数对象及排序字段
     *
     * @param data 查询参数对象
     */
    public InvoiceApplyQueryPara(InvoiceApply data) {
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
    public void SetQueryPara(InvoiceApply data, String order, boolean isAse) {
        if (data != null) {
            setParamByInvoiceApplyId(data.getInvoiceApplyId());
            setParamByUserId(data.getUserId());
            setParamByName(data.getName());
            setParamByContractCode(data.getContractCode());
            setParamByPhaseId(data.getPhaseId());
            setParamByInvoiceApplyIsDeal(data.getInvoiceApplyIsDeal());
            setParamByInvoiceApplyAmount(data.getInvoiceApplyAmount());
        }
        if (!StringHelper.isNullOrEmpty(order))
            addOrderBy(order, isAse);
    }

    /**
     * 增加用申请id匹配条件(target like invoiceApplyId)，key:invoiceApplyId.
     * @param invoiceApplyId 申请id匹配条件参数
     */
    public void setParamByInvoiceApplyId(String invoiceApplyId){
        addParameter(QueryAttr_InvoiceApplyId, invoiceApplyId);
    }

    /**
     * 增加用申请id匹配条件(invoiceApplyId为empty时也会加入此条件)，不空时(target like invoiceApplyId)，key:invoiceApplyId，为空时(target is null or target = '')，key:invoiceApplyId.
     * @param invoiceApplyId 申请id匹配条件参数
     */
    public void setParamByInvoiceApplyIdInEmpty(String invoiceApplyId){
        put(QueryAttr_InvoiceApplyId, invoiceApplyId);
    }

    /**
     * 增加申请id枚举条件(target in (invoiceApplyIds))，key:invoiceApplyId_Enum.
     * @param invoiceApplyIds 申请id数组条件参数
     */
    public void setParamByInvoiceApplyId_Enum(String... invoiceApplyIds){
        addParameterByEnum(QueryAttr_InvoiceApplyId, invoiceApplyIds);
    }

    /**
     * 增加用申请人Id匹配条件(target like userId)，key:userId.
     * @param userId 申请人Id匹配条件参数
     */
    public void setParamByUserId(String userId){
        addParameter(QueryAttr_UserId, userId);
    }

    /**
     * 增加用申请人Id匹配条件(userId为empty时也会加入此条件)，不空时(target like userId)，key:userId，为空时(target is null or target = '')，key:userId.
     * @param userId 申请人Id匹配条件参数
     */
    public void setParamByUserIdInEmpty(String userId){
        put(QueryAttr_UserId, userId);
    }

    /**
     * 增加申请人Id枚举条件(target in (userIds))，key:userId_Enum.
     * @param userIds 申请人Id数组条件参数
     */
    public void setParamByUserId_Enum(String... userIds){
        addParameterByEnum(QueryAttr_UserId, userIds);
    }

    /**
     * 增加用申请人名字匹配条件(target like name)，key:name.
     * @param name 申请人名字匹配条件参数
     */
    public void setParamByName(String name){
        addParameter(QueryAttr_Name, name);
    }

    /**
     * 增加用申请人名字匹配条件(name为empty时也会加入此条件)，不空时(target like name)，key:name，为空时(target is null or target = '')，key:name.
     * @param name 申请人名字匹配条件参数
     */
    public void setParamByNameInEmpty(String name){
        put(QueryAttr_Name, name);
    }

    /**
     * 增加申请人名字枚举条件(target in (names))，key:name_Enum.
     * @param names 申请人名字数组条件参数
     */
    public void setParamByName_Enum(String... names){
        addParameterByEnum(QueryAttr_Name, names);
    }

    /**
     * 增加用合同编号匹配条件(target like contractCode)，key:contractCode.
     * @param contractCode 合同编号匹配条件参数
     */
    public void setParamByContractCode(String contractCode){
        addParameter(QueryAttr_ContractCode, contractCode);
    }

    /**
     * 增加用合同编号匹配条件(contractCode为empty时也会加入此条件)，不空时(target like contractCode)，key:contractCode，为空时(target is null or target = '')，key:contractCode.
     * @param contractCode 合同编号匹配条件参数
     */
    public void setParamByContractCodeInEmpty(String contractCode){
        put(QueryAttr_ContractCode, contractCode);
    }

    /**
     * 增加合同编号枚举条件(target in (contractCodes))，key:contractCode_Enum.
     * @param contractCodes 合同编号数组条件参数
     */
    public void setParamByContractCode_Enum(String... contractCodes){
        addParameterByEnum(QueryAttr_ContractCode, contractCodes);
    }

    /**
     * 增加用阶段序号匹配条件(target like phaseId)，key:phaseId.
     * @param phaseId 阶段序号匹配条件参数
     */
    public void setParamByPhaseId(String phaseId){
        addParameter(QueryAttr_PhaseId, phaseId);
    }

    /**
     * 增加用阶段序号匹配条件(phaseId为empty时也会加入此条件)，不空时(target like phaseId)，key:phaseId，为空时(target is null or target = '')，key:phaseId.
     * @param phaseId 阶段序号匹配条件参数
     */
    public void setParamByPhaseIdInEmpty(String phaseId){
        put(QueryAttr_PhaseId, phaseId);
    }

    /**
     * 增加阶段序号枚举条件(target in (phaseIds))，key:phaseId_Enum.
     * @param phaseIds 阶段序号数组条件参数
     */
    public void setParamByPhaseId_Enum(String... phaseIds){
        addParameterByEnum(QueryAttr_PhaseId, phaseIds);
    }

    /**
     * 增加用是否处理匹配条件(invoiceApplyIsDeal非0时才会加入此条件)(target = invoiceApplyIsDeal)，key:invoiceApplyIsDeal.
     * @param invoiceApplyIsDeal 是否处理匹配条件参数
     */
    public void setParamByInvoiceApplyIsDeal(int invoiceApplyIsDeal){
        addParameter(QueryAttr_InvoiceApplyIsDeal, invoiceApplyIsDeal);
    }

    /**
     * 增加用是否处理匹配条件(invoiceApplyIsDeal为0时也会加入此条件)(target = invoiceApplyIsDeal)，key:invoiceApplyIsDeal.
     * @param invoiceApplyIsDeal 是否处理匹配条件参数
     */
    public void setParamByInvoiceApplyIsDealIncZero(int invoiceApplyIsDeal){
        put(QueryAttr_InvoiceApplyIsDeal, invoiceApplyIsDeal);
    }

    /**
     * 增加是否处理范围条件（low <= target and target >= high），key:invoiceApplyIsDeal_L invoiceApplyIsDeal_H.
     * @param low 最小值参数
     * @param high 最大值参数
     */
    public void setParamByInvoiceApplyIsDeal_Range(int low, int high){
        addParameterByRange(QueryAttr_InvoiceApplyIsDeal, low, high);
    }

    /**
     * 增加是否处理枚举条件(target in (invoiceApplyIsDeals))，key:invoiceApplyIsDeal_Enum.
     * @param invoiceApplyIsDeals 是否处理数组条件参数
     */
    public void setParamByInvoiceApplyIsDeal_Enum(int... invoiceApplyIsDeals){
        addParameterByEnum(QueryAttr_InvoiceApplyIsDeal, invoiceApplyIsDeals);
    }

    /**
     * 增加用申请开票金额匹配条件(invoiceApplyAmount非0时才会加入此条件)(target = invoiceApplyAmount)，key:invoiceApplyAmount.
     * @param invoiceApplyAmount 申请开票金额匹配条件参数
     */
    public void setParamByInvoiceApplyAmount(double invoiceApplyAmount){
        addParameter(QueryAttr_InvoiceApplyAmount, invoiceApplyAmount);
    }

    /**
     * 增加用申请开票金额匹配条件(invoiceApplyAmount为0时也会加入此条件)(target = invoiceApplyAmount)，key:invoiceApplyAmount.
     * @param invoiceApplyAmount 申请开票金额匹配条件参数
     */
    public void setParamByInvoiceApplyAmountIncZero(double invoiceApplyAmount){
        put(QueryAttr_InvoiceApplyAmount, invoiceApplyAmount);
    }

    /**
     * 增加申请开票金额范围条件（low <= target and target >= high），key:invoiceApplyAmount_L invoiceApplyAmount_H.
     * @param low 最小值参数
     * @param high 最大值参数
     */
    public void setParamByInvoiceApplyAmount_Range(double low, double high){
        addParameterByRange(QueryAttr_InvoiceApplyAmount, low, high);
    }

    /**
     * 增加申请开票金额枚举条件(target in (invoiceApplyAmounts))，key:invoiceApplyAmount_Enum.
     * @param invoiceApplyAmounts 申请开票金额数组条件参数
     */
    public void setParamByInvoiceApplyAmount_Enum(double... invoiceApplyAmounts){
        addParameterByEnum(QueryAttr_InvoiceApplyAmount, invoiceApplyAmounts);
    }

}