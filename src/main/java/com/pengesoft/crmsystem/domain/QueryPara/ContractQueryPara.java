package com.pengesoft.crmsystem.domain.QueryPara;

import com.pengesoft.crmsystem.domain.entity.Contract;
import com.pengesoft.crmsystem.domain.entitylist.InvoiceApplyList;
import com.pengesoft.crmsystem.domain.entitylist.InvoiceList;
import com.pengesoft.crmsystem.domain.entitylist.PhaseList;
import com.pengesoft.crmsystem.domain.entitylist.ReceivableList;
import pengesoft.db.QueryParameter;
import pengesoft.utils.StringHelper;
import java.util.*;
import java.math.*;

/**
 * 合同信息 查询参数类。
 *
 * @auther: 余展鹏.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaQueryPara),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
public class ContractQueryPara extends QueryParameter {

    /**
     * 缺省序列化id
     */
    private static final long serialVersionUID = 1L;
    /**
     * 常数 查询属性名(合同编号).
     */
    public static final String QueryAttr_ContractCode = "contractCode";
    /**
     * 常数 查询属性名(项目编号).
     */
    public static final String QueryAttr_ProjectCode = "projectCode";
    /**
     * 常数 查询属性名(合同名称).
     */
    public static final String QueryAttr_ContractName = "contractName";
    /**
     * 常数 查询属性名(合同当前状态(履行中0、已结束(或作废)1)).
     */
    public static final String QueryAttr_ContractStatus = "contractStatus";
    /**
     * 常数 查询属性名(合同类型).
     */
    public static final String QueryAttr_ContractType = "contractType";
    /**
     * 常数 查询属性名(合同甲方).
     */
    public static final String QueryAttr_PartyA = "partyA";
    /**
     * 常数 查询属性名(合同乙方).
     */
    public static final String QueryAttr_PartyB = "partyB";
    /**
     * 常数 查询属性名(合同丙方).
     */
    public static final String QueryAttr_PartyC = "partyC";
    /**
     * 常数 查询属性名(合同总金额).
     */
    public static final String QueryAttr_ContractAmount = "contractAmount";
    /**
     * 常数 查询属性名(该合同已收).
     */
    public static final String QueryAttr_ContractAlreadyRec = "contractAlreadyRec";
    /**
     * 常数 查询属性名(该合同未收).
     */
    public static final String QueryAttr_ContractNotYetRec = "contractNotYetRec";
    /**
     * 常数 查询属性名(父合同编号).
     */
    public static final String QueryAttr_ContractParentCode = "contractParentCode";
    /**
     * 常数 查询属性名(创建时间).
     */
    public static final String QueryAttr_ContractCreateTime = "contractCreateTime";
    /**
     * 常数 查询属性名(合同签订时间).
     */
    public static final String QueryAttr_ContractSignTime = "contractSignTime";
    /**
     * 常数 查询属性名(合同结束时间).
     */
    public static final String QueryAttr_ContractEndTime = "contractEndTime";
    /**
     * 常数 查询属性名(合同生效时间).
     */
    public static final String QueryAttr_ContractEffectTime = "contractEffectTime";
    /**
     * 常数 查询属性名(合同失效时间).
     */
    public static final String QueryAttr_ContractNoEffectTime = "contractNoEffectTime";
    /**
     * 常数 查询属性名(备注).
     */
    public static final String QueryAttr_ContractRemark = "contractRemark";
    /**
     * 常数 查询属性名(发票).
     */
    public static final String QueryAttr_InvoiceList = "invoiceList";
    /**
     * 常数 查询属性名(收款).
     */
    public static final String QueryAttr_ReceivableList = "receivableList";
    /**
     * 常数 查询属性名(阶段信息).
     */
    public static final String QueryAttr_PhaseList = "phaseList";
    /**
     * 常数 查询属性名(合同开票申请).
     */
    public static final String QueryAttr_InvoiceApplyList = "invoiceApplyList";

    /**
     * 常数 排序属性名(合同编号).
     */
    public static final String OrderAttr_ContractCode = "contractCode";
    /**
     * 常数 排序属性名(合同总金额).
     */
    public static final String OrderAttr_ContractAmount = "contractAmount";
    /**
     * 常数 排序属性名(该合同已收).
     */
    public static final String OrderAttr_ContractAlreadyRec = "contractAlreadyRec";
    /**
     * 常数 排序属性名(该合同未收).
     */
    public static final String OrderAttr_ContractNotYetRec = "contractNotYetRec";
    /**
     * 常数 排序属性名(创建时间).
     */
    public static final String OrderAttr_ContractCreateTime = "contractCreateTime";

    /**
     * 默认构造方法
     */
    public ContractQueryPara() {
        super();
    }

    /**
     * 构造函数,指定参数对象及排序字段
     *
     * @param data  查询参数对象
     * @param order 排序字段
     * @param isAse true升序，false降序
     */
    public ContractQueryPara(Contract data, String order, boolean isAse) {
        super();
        SetQueryPara(data, order, isAse);
    }

    /**
     * 构造函数,指定参数对象及排序字段
     *
     * @param data 查询参数对象
     */
    public ContractQueryPara(Contract data) {
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
    public void SetQueryPara(Contract data, String order, boolean isAse) {
        if (data != null) {
            setParamByContractCode(data.getContractCode());
            setParamByProjectCode(data.getProjectCode());
            setParamByContractName(data.getContractName());
            setParamByContractStatus(data.getContractStatus());
            setParamByContractType(data.getContractType());
            setParamByPartyA(data.getPartyA());
            setParamByPartyB(data.getPartyB());
            setParamByPartyC(data.getPartyC());
            setParamByContractAmount(data.getContractAmount());
            setParamByContractAlreadyRec(data.getContractAlreadyRec());
            setParamByContractNotYetRec(data.getContractNotYetRec());
            setParamByContractParentCode(data.getContractParentCode());
            setParamByContractCreateTime(data.getContractCreateTime());
            setParamByContractSignTime(data.getContractSignTime());
            setParamByContractEndTime(data.getContractEndTime());
            setParamByContractEffectTime(data.getContractEffectTime());
            setParamByContractNoEffectTime(data.getContractNoEffectTime());
            setParamByContractRemark(data.getContractRemark());
            setParamByInvoiceList(data.getInvoiceList());
            setParamByReceivableList(data.getReceivableList());
            setParamByPhaseList(data.getPhaseList());
            setParamByInvoiceApplyList(data.getInvoiceApplyList());
        }
        if (!StringHelper.isNullOrEmpty(order))
            addOrderBy(order, isAse);
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

    /**
     * 增加用合同名称匹配条件(target like contractName)，key:contractName.
     * @param contractName 合同名称匹配条件参数
     */
    public void setParamByContractName(String contractName){
        addParameter(QueryAttr_ContractName, contractName);
    }

    /**
     * 增加用合同名称匹配条件(contractName为empty时也会加入此条件)，不空时(target like contractName)，key:contractName，为空时(target is null or target = '')，key:contractName.
     * @param contractName 合同名称匹配条件参数
     */
    public void setParamByContractNameInEmpty(String contractName){
        put(QueryAttr_ContractName, contractName);
    }

    /**
     * 增加合同名称枚举条件(target in (contractNames))，key:contractName_Enum.
     * @param contractNames 合同名称数组条件参数
     */
    public void setParamByContractName_Enum(String... contractNames){
        addParameterByEnum(QueryAttr_ContractName, contractNames);
    }

    /**
     * 增加用合同当前状态(履行中0、已结束(或作废)1)匹配条件(contractStatus非0时才会加入此条件)(target = contractStatus)，key:contractStatus.
     * @param contractStatus 合同当前状态(履行中0、已结束(或作废)1)匹配条件参数
     */
    public void setParamByContractStatus(int contractStatus){
        addParameter(QueryAttr_ContractStatus, contractStatus);
    }

    /**
     * 增加用合同当前状态(履行中0、已结束(或作废)1)匹配条件(contractStatus为0时也会加入此条件)(target = contractStatus)，key:contractStatus.
     * @param contractStatus 合同当前状态(履行中0、已结束(或作废)1)匹配条件参数
     */
    public void setParamByContractStatusIncZero(int contractStatus){
        put(QueryAttr_ContractStatus, contractStatus);
    }

    /**
     * 增加合同当前状态(履行中0、已结束(或作废)1)范围条件（low <= target and target >= high），key:contractStatus_L contractStatus_H.
     * @param low 最小值参数
     * @param high 最大值参数
     */
    public void setParamByContractStatus_Range(int low, int high){
        addParameterByRange(QueryAttr_ContractStatus, low, high);
    }

    /**
     * 增加合同当前状态(履行中0、已结束(或作废)1)枚举条件(target in (contractStatuss))，key:contractStatus_Enum.
     * @param contractStatuss 合同当前状态(履行中0、已结束(或作废)1)数组条件参数
     */
    public void setParamByContractStatus_Enum(int... contractStatuss){
        addParameterByEnum(QueryAttr_ContractStatus, contractStatuss);
    }

    /**
     * 增加用合同类型匹配条件(contractType非0时才会加入此条件)(target = contractType)，key:contractType.
     * @param contractType 合同类型匹配条件参数
     */
    public void setParamByContractType(int contractType){
        addParameter(QueryAttr_ContractType, contractType);
    }

    /**
     * 增加用合同类型匹配条件(contractType为0时也会加入此条件)(target = contractType)，key:contractType.
     * @param contractType 合同类型匹配条件参数
     */
    public void setParamByContractTypeIncZero(int contractType){
        put(QueryAttr_ContractType, contractType);
    }

    /**
     * 增加合同类型范围条件（low <= target and target >= high），key:contractType_L contractType_H.
     * @param low 最小值参数
     * @param high 最大值参数
     */
    public void setParamByContractType_Range(int low, int high){
        addParameterByRange(QueryAttr_ContractType, low, high);
    }

    /**
     * 增加合同类型枚举条件(target in (contractTypes))，key:contractType_Enum.
     * @param contractTypes 合同类型数组条件参数
     */
    public void setParamByContractType_Enum(int... contractTypes){
        addParameterByEnum(QueryAttr_ContractType, contractTypes);
    }

    /**
     * 增加用合同甲方匹配条件(target like partyA)，key:partyA.
     * @param partyA 合同甲方匹配条件参数
     */
    public void setParamByPartyA(String partyA){
        addParameter(QueryAttr_PartyA, partyA);
    }

    /**
     * 增加用合同甲方匹配条件(partyA为empty时也会加入此条件)，不空时(target like partyA)，key:partyA，为空时(target is null or target = '')，key:partyA.
     * @param partyA 合同甲方匹配条件参数
     */
    public void setParamByPartyAInEmpty(String partyA){
        put(QueryAttr_PartyA, partyA);
    }

    /**
     * 增加合同甲方枚举条件(target in (partyAs))，key:partyA_Enum.
     * @param partyAs 合同甲方数组条件参数
     */
    public void setParamByPartyA_Enum(String... partyAs){
        addParameterByEnum(QueryAttr_PartyA, partyAs);
    }

    /**
     * 增加用合同乙方匹配条件(target like partyB)，key:partyB.
     * @param partyB 合同乙方匹配条件参数
     */
    public void setParamByPartyB(String partyB){
        addParameter(QueryAttr_PartyB, partyB);
    }

    /**
     * 增加用合同乙方匹配条件(partyB为empty时也会加入此条件)，不空时(target like partyB)，key:partyB，为空时(target is null or target = '')，key:partyB.
     * @param partyB 合同乙方匹配条件参数
     */
    public void setParamByPartyBInEmpty(String partyB){
        put(QueryAttr_PartyB, partyB);
    }

    /**
     * 增加合同乙方枚举条件(target in (partyBs))，key:partyB_Enum.
     * @param partyBs 合同乙方数组条件参数
     */
    public void setParamByPartyB_Enum(String... partyBs){
        addParameterByEnum(QueryAttr_PartyB, partyBs);
    }

    /**
     * 增加用合同丙方匹配条件(target like partyC)，key:partyC.
     * @param partyC 合同丙方匹配条件参数
     */
    public void setParamByPartyC(String partyC){
        addParameter(QueryAttr_PartyC, partyC);
    }

    /**
     * 增加用合同丙方匹配条件(partyC为empty时也会加入此条件)，不空时(target like partyC)，key:partyC，为空时(target is null or target = '')，key:partyC.
     * @param partyC 合同丙方匹配条件参数
     */
    public void setParamByPartyCInEmpty(String partyC){
        put(QueryAttr_PartyC, partyC);
    }

    /**
     * 增加合同丙方枚举条件(target in (partyCs))，key:partyC_Enum.
     * @param partyCs 合同丙方数组条件参数
     */
    public void setParamByPartyC_Enum(String... partyCs){
        addParameterByEnum(QueryAttr_PartyC, partyCs);
    }

    /**
     * 增加用合同总金额匹配条件(contractAmount非0时才会加入此条件)(target = contractAmount)，key:contractAmount.
     * @param contractAmount 合同总金额匹配条件参数
     */
    public void setParamByContractAmount(double contractAmount){
        addParameter(QueryAttr_ContractAmount, contractAmount);
    }

    /**
     * 增加用合同总金额匹配条件(contractAmount为0时也会加入此条件)(target = contractAmount)，key:contractAmount.
     * @param contractAmount 合同总金额匹配条件参数
     */
    public void setParamByContractAmountIncZero(double contractAmount){
        put(QueryAttr_ContractAmount, contractAmount);
    }

    /**
     * 增加合同总金额范围条件（low <= target and target >= high），key:contractAmount_L contractAmount_H.
     * @param low 最小值参数
     * @param high 最大值参数
     */
    public void setParamByContractAmount_Range(double low, double high){
        addParameterByRange(QueryAttr_ContractAmount, low, high);
    }

    /**
     * 增加合同总金额枚举条件(target in (contractAmounts))，key:contractAmount_Enum.
     * @param contractAmounts 合同总金额数组条件参数
     */
    public void setParamByContractAmount_Enum(double... contractAmounts){
        addParameterByEnum(QueryAttr_ContractAmount, contractAmounts);
    }

    /**
     * 增加用该合同已收匹配条件(contractAlreadyRec非0时才会加入此条件)(target = contractAlreadyRec)，key:contractAlreadyRec.
     * @param contractAlreadyRec 该合同已收匹配条件参数
     */
    public void setParamByContractAlreadyRec(double contractAlreadyRec){
        addParameter(QueryAttr_ContractAlreadyRec, contractAlreadyRec);
    }

    /**
     * 增加用该合同已收匹配条件(contractAlreadyRec为0时也会加入此条件)(target = contractAlreadyRec)，key:contractAlreadyRec.
     * @param contractAlreadyRec 该合同已收匹配条件参数
     */
    public void setParamByContractAlreadyRecIncZero(double contractAlreadyRec){
        put(QueryAttr_ContractAlreadyRec, contractAlreadyRec);
    }

    /**
     * 增加该合同已收范围条件（low <= target and target >= high），key:contractAlreadyRec_L contractAlreadyRec_H.
     * @param low 最小值参数
     * @param high 最大值参数
     */
    public void setParamByContractAlreadyRec_Range(double low, double high){
        addParameterByRange(QueryAttr_ContractAlreadyRec, low, high);
    }

    /**
     * 增加该合同已收枚举条件(target in (contractAlreadyRecs))，key:contractAlreadyRec_Enum.
     * @param contractAlreadyRecs 该合同已收数组条件参数
     */
    public void setParamByContractAlreadyRec_Enum(double... contractAlreadyRecs){
        addParameterByEnum(QueryAttr_ContractAlreadyRec, contractAlreadyRecs);
    }

    /**
     * 增加用该合同未收匹配条件(contractNotYetRec非0时才会加入此条件)(target = contractNotYetRec)，key:contractNotYetRec.
     * @param contractNotYetRec 该合同未收匹配条件参数
     */
    public void setParamByContractNotYetRec(double contractNotYetRec){
        addParameter(QueryAttr_ContractNotYetRec, contractNotYetRec);
    }

    /**
     * 增加用该合同未收匹配条件(contractNotYetRec为0时也会加入此条件)(target = contractNotYetRec)，key:contractNotYetRec.
     * @param contractNotYetRec 该合同未收匹配条件参数
     */
    public void setParamByContractNotYetRecIncZero(double contractNotYetRec){
        put(QueryAttr_ContractNotYetRec, contractNotYetRec);
    }

    /**
     * 增加该合同未收范围条件（low <= target and target >= high），key:contractNotYetRec_L contractNotYetRec_H.
     * @param low 最小值参数
     * @param high 最大值参数
     */
    public void setParamByContractNotYetRec_Range(double low, double high){
        addParameterByRange(QueryAttr_ContractNotYetRec, low, high);
    }

    /**
     * 增加该合同未收枚举条件(target in (contractNotYetRecs))，key:contractNotYetRec_Enum.
     * @param contractNotYetRecs 该合同未收数组条件参数
     */
    public void setParamByContractNotYetRec_Enum(double... contractNotYetRecs){
        addParameterByEnum(QueryAttr_ContractNotYetRec, contractNotYetRecs);
    }

    /**
     * 增加用父合同编号匹配条件(target like contractParentCode)，key:contractParentCode.
     * @param contractParentCode 父合同编号匹配条件参数
     */
    public void setParamByContractParentCode(String contractParentCode){
        addParameter(QueryAttr_ContractParentCode, contractParentCode);
    }

    /**
     * 增加用父合同编号匹配条件(contractParentCode为empty时也会加入此条件)，不空时(target like contractParentCode)，key:contractParentCode，为空时(target is null or target = '')，key:contractParentCode.
     * @param contractParentCode 父合同编号匹配条件参数
     */
    public void setParamByContractParentCodeInEmpty(String contractParentCode){
        put(QueryAttr_ContractParentCode, contractParentCode);
    }

    /**
     * 增加父合同编号枚举条件(target in (contractParentCodes))，key:contractParentCode_Enum.
     * @param contractParentCodes 父合同编号数组条件参数
     */
    public void setParamByContractParentCode_Enum(String... contractParentCodes){
        addParameterByEnum(QueryAttr_ContractParentCode, contractParentCodes);
    }

    /**
     * 增加用创建时间匹配条件(target = contractCreateTime)，key:contractCreateTime.
     * @param contractCreateTime 创建时间匹配条件参数
     */
    public void setParamByContractCreateTime(Date contractCreateTime){
        addParameter(QueryAttr_ContractCreateTime, contractCreateTime);
    }

    /**
     * 增加创建时间范围条件（startDate < target and target > endDate），key:contractCreateTime_S contractCreateTime_E.
     * @param startDate 最小值参数
     * @param endDate 最大值参数
     */
    public void setParamByContractCreateTime_Range(Date startDate, Date endDate){
        addParameterByRange(QueryAttr_ContractCreateTime, startDate, endDate);
    }

    /**
     * 增加用合同签订时间匹配条件(target = contractSignTime)，key:contractSignTime.
     * @param contractSignTime 合同签订时间匹配条件参数
     */
    public void setParamByContractSignTime(Date contractSignTime){
        addParameter(QueryAttr_ContractSignTime, contractSignTime);
    }

    /**
     * 增加合同签订时间范围条件（startDate < target and target > endDate），key:contractSignTime_S contractSignTime_E.
     * @param startDate 最小值参数
     * @param endDate 最大值参数
     */
    public void setParamByContractSignTime_Range(Date startDate, Date endDate){
        addParameterByRange(QueryAttr_ContractSignTime, startDate, endDate);
    }

    /**
     * 增加用合同结束时间匹配条件(target = contractEndTime)，key:contractEndTime.
     * @param contractEndTime 合同结束时间匹配条件参数
     */
    public void setParamByContractEndTime(Date contractEndTime){
        addParameter(QueryAttr_ContractEndTime, contractEndTime);
    }

    /**
     * 增加合同结束时间范围条件（startDate < target and target > endDate），key:contractEndTime_S contractEndTime_E.
     * @param startDate 最小值参数
     * @param endDate 最大值参数
     */
    public void setParamByContractEndTime_Range(Date startDate, Date endDate){
        addParameterByRange(QueryAttr_ContractEndTime, startDate, endDate);
    }

    /**
     * 增加用合同生效时间匹配条件(target = contractEffectTime)，key:contractEffectTime.
     * @param contractEffectTime 合同生效时间匹配条件参数
     */
    public void setParamByContractEffectTime(Date contractEffectTime){
        addParameter(QueryAttr_ContractEffectTime, contractEffectTime);
    }

    /**
     * 增加合同生效时间范围条件（startDate < target and target > endDate），key:contractEffectTime_S contractEffectTime_E.
     * @param startDate 最小值参数
     * @param endDate 最大值参数
     */
    public void setParamByContractEffectTime_Range(Date startDate, Date endDate){
        addParameterByRange(QueryAttr_ContractEffectTime, startDate, endDate);
    }

    /**
     * 增加用合同失效时间匹配条件(target = contractNoEffectTime)，key:contractNoEffectTime.
     * @param contractNoEffectTime 合同失效时间匹配条件参数
     */
    public void setParamByContractNoEffectTime(Date contractNoEffectTime){
        addParameter(QueryAttr_ContractNoEffectTime, contractNoEffectTime);
    }

    /**
     * 增加合同失效时间范围条件（startDate < target and target > endDate），key:contractNoEffectTime_S contractNoEffectTime_E.
     * @param startDate 最小值参数
     * @param endDate 最大值参数
     */
    public void setParamByContractNoEffectTime_Range(Date startDate, Date endDate){
        addParameterByRange(QueryAttr_ContractNoEffectTime, startDate, endDate);
    }

    /**
     * 增加用备注匹配条件(target like contractRemark)，key:contractRemark.
     * @param contractRemark 备注匹配条件参数
     */
    public void setParamByContractRemark(String contractRemark){
        addParameter(QueryAttr_ContractRemark, contractRemark);
    }

    /**
     * 增加用备注匹配条件(contractRemark为empty时也会加入此条件)，不空时(target like contractRemark)，key:contractRemark，为空时(target is null or target = '')，key:contractRemark.
     * @param contractRemark 备注匹配条件参数
     */
    public void setParamByContractRemarkInEmpty(String contractRemark){
        put(QueryAttr_ContractRemark, contractRemark);
    }

    /**
     * 增加备注枚举条件(target in (contractRemarks))，key:contractRemark_Enum.
     * @param contractRemarks 备注数组条件参数
     */
    public void setParamByContractRemark_Enum(String... contractRemarks){
        addParameterByEnum(QueryAttr_ContractRemark, contractRemarks);
    }

    /**
     * 增加用发票匹配条件(target like invoiceList)，key:invoiceList.
     * @param invoiceList 发票匹配条件参数
     */
    public void setParamByInvoiceList(InvoiceList invoiceList){
        addParameter(QueryAttr_InvoiceList, invoiceList);
    }

    /**
     * 增加用收款匹配条件(target like receivableList)，key:receivableList.
     * @param receivableList 收款匹配条件参数
     */
    public void setParamByReceivableList(ReceivableList receivableList){
        addParameter(QueryAttr_ReceivableList, receivableList);
    }

    /**
     * 增加用阶段信息匹配条件(target like phaseList)，key:phaseList.
     * @param phaseList 阶段信息匹配条件参数
     */
    public void setParamByPhaseList(PhaseList phaseList){
        addParameter(QueryAttr_PhaseList, phaseList);
    }

    /**
     * 增加用合同开票申请匹配条件(target like invoiceApplyList)，key:invoiceApplyList.
     * @param invoiceApplyList 合同开票申请匹配条件参数
     */
    public void setParamByInvoiceApplyList(InvoiceApplyList invoiceApplyList){
        addParameter(QueryAttr_InvoiceApplyList, invoiceApplyList);
    }

}