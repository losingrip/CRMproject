package com.pengesoft.crmsystem.service;

import com.pengesoft.crmsystem.domain.entity.*;
import com.pengesoft.crmsystem.domain.entitylist.InvoiceApplyList;
import com.pengesoft.crmsystem.domain.entitylist.PhaseList;
import com.pengesoft.crmsystem.domain.entitylist.ProjectContractRetList;
import pengesoft.service.IApplication;
import pengesoft.service.PublishMethod;
import pengesoft.service.PublishName;

import java.util.Date;
import java.util.HashMap;

/**
 * IContractMgeSvr 接口定义。项目服务.
 *
 * @auther: 余展鹏.
 * @date: 2020/3/31 14:01:33.
 * <p>
 * 文件由鹏业软件模型工具生成(模板名称：JavaAppService),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
@PublishName("ContractMgeSvr")
public interface IContractMgeSvr extends IApplication {

    /**
     * 添加合同  .
     *
     * @param token                token.
     * @param ContractCode         合同编号.
     * @param ProjectCode         项目编号.
     * @param ContractName         合同名称.
     * @param ContractType         合同类型.
     * @param ContractStatus 合同状态.
     * @param PartyA               合同甲方.
     * @param PartyB               合同乙方.
     * @param PartyC               合同丙方.
     * @param ContractAmount       合同总金额.
     * @param ContractParentCode   父合同编号.
     * @param ContractSignTime     合同签订时间.
     * @param ContractEndTime      合同结束时间.
     * @param ContractEffectTime   合同生效时间.
     * @param ContractNoEffectTime 合同失效时间.
     * @param ContractRemark       备注.
     */
    @PublishMethod
    Contract addContract(String token, String ContractCode,String ProjectCode, String ContractName, int ContractType,int ContractStatus, String PartyA, String PartyB, String PartyC, double ContractAmount, String ContractParentCode, Date ContractSignTime, Date ContractEndTime, Date ContractEffectTime, Date ContractNoEffectTime, String ContractRemark);

    /**
     * 修改合同信息  .
     *
     * @param token                token.
     * @param ContractCode         合同编号.
     * @param ProjectCode         项目编号.
     * @param ContractEffectTime   合同生效时间.
     * @param ContractNoEffectTime 合同失效时间.
     * @param ContractName         合同名称.
     * @param ContractType         合同类型.
     * @param ContractStatus         合同状态.
     * @param PartyA               合同甲方.
     * @param PartyB               合同乙方.
     * @param PartyC               合同丙方.
     * @param ContractAmount       合同总金额.
     * @param ContractParentCode   父合同编号.
     * @param ContractSignTime     合同签订时间.
     * @param ContractEndTime      合同结束时间.
     * @param ContractEffectTime   合同结束时间.
     * @param ContractNoEffectTime 合同结束时间.
     * @param ContractRemark       备注.
     */
    @PublishMethod
    int updateContract(String token, String ContractCode,String ProjectCode, Date ContractEffectTime, Date ContractNoEffectTime, String ContractName, int ContractType,int ContractStatus, String PartyA, String PartyB, String PartyC, double ContractAmount, String ContractParentCode, Date ContractSignTime, Date ContractEndTime, String ContractRemark);

    /**
     * 删除合同信息  .
     *
     * @param token        token.
     * @param ContractCode 合同编号.
     */
    @PublishMethod
    int deleteContract(String token, String ContractCode);

    @PublishMethod
    ProjectContractRetList getOwnContractList(String token, String ProjectCode, int Option, int SortNum);

    /**
     * (从项目进)获取合同列表（如果有项目编号就从项目进，如果没有就是从合同进）  .
     *
     * @param token       token.
     * @param sizeNum     sizeNum.
     * @param skipNum     skipNum.
     * @param ProjectCode 项目编号.
     * @param Option      选项.
     * @param SortNum      排序数字.
     */
    @PublishMethod
    ProjectContractRetList getContractList(String token, int sizeNum, int skipNum, String ProjectCode, int Option,int SortNum);

    /**
     * 合同模糊搜索  .
     *  @param token             token.
     * @param sizeNum           sizeNum.
     * @param skipNum           skipNum.
     * @param SearchCondition   条件.
     * @param ContractStartTime 查询起始时间.
     * @param ContractEndTime   查询截止时间.
     * @param Option            选项.
     */
    @PublishMethod
    ProjectContractRetList fuzzySearchContract(String token, int sizeNum, int skipNum, String SearchCondition, Date ContractStartTime, Date ContractEndTime, int Option);


    /**
     * 获取合同详情（包含阶段信息、收款、发票）  .
     *
     * @param token        token.
     * @param ContractCode 合同编号.
     * @param Option       选项.
     */
    @PublishMethod
    ProjectContractRet getContractDetail(String token, String ContractCode, int Option);

    /**
     * 添加阶段信息  .
     *
     * @param token         token.
     * @param ContractCode  合同编号.
     * @param PhaseDescribe 阶段描述.
     * @param PhaseFactTime 实际完成时间.
     * @param PhasePlanTime 预期完成时间.
     * @param PhaseType     阶段类型.
     * @param PhaseAmount   应收金额.
     */
    @PublishMethod
    Phase addPhase(String token, String ContractCode, String PhaseId, String PhaseDescribe, Date PhasePlanTime, int PhaseType, double PhaseAmount, Date PhaseFactTime);


    /**
     * 删除阶段信息  .
     *
     * @param token        token.
     * @param ContractCode 合同编号.
     * @param PhaseId      阶段序号.
     */
    @PublishMethod
    int deletePhase(String token, String ContractCode, String PhaseId);

    /**
     * 添加发票信息  .
     *
     * @param token         token.
     * @param ContractCode  合同编号.
     * @param InvoiceCode   发票编号.
     * @param InvoiceAmount 发票金额.
     * @param InvoicePerson 开票人(财务人员id).
     * @param InvoiceType   开票类型.
     * @param InvoiceTime   开票时间.
     * @param InvoiceApplyId   开票申请Id.
     */
    @PublishMethod
    Invoice addInvoice(String token, Date InvoiceTime,String InvoiceApplyId, String ContractCode, String InvoiceCode, double InvoiceAmount, String InvoicePerson, int InvoiceType);

    /**
     * 删除发票信息  .
     *
     * @param token        token.
     * @param ContractCode 合同编号.
     * @param InvoiceCode  发票编号.
     */
    @PublishMethod
    int deleteInvoice(String token, String ContractCode, String InvoiceCode);

    /**
     * 添加收款信息  .
     *
     * @param token        token.
     * @param ContractCode 合同编号.
     * @param RecId    收款Id.
     * @param RecAmount    收款金额.
     * @param RecTime      收款时间.
     * @param RecType      收款类型.
     */
    @PublishMethod
    Receivable addReceivable(String token,String RecId, String ContractCode, double RecAmount, Date RecTime, int RecType);

    /**
     * 删除收款信息  .
     *
     * @param token        token.
     * @param ContractCode 合同编号.
     * @param RecId        收款序号.
     */
    @PublishMethod
    int deleteReceivable(String token, String ContractCode, String RecId);

    /*
     * 解析字符串
     * */
    String[] AnalyseStr(String str);

    /**
     * app首页项目合同信息列表  .
     *
     * @param token  token.
     * @param Option Option.
     */
    @PublishMethod
    ProjectContractRetList getProjectContractList(String token, int Option);


    /**
     * 合同统计接口  .
     *
     * @param token      token.
     * @param QueryYear  查询年份.
     * @param QueryYear2 查询年份.
     */
    @PublishMethod
    HashMap<String, Object> getProjectStatistic(String token, int QueryYear, int QueryYear2);


    /**
     * 获取待办数据  .
     *
     * @param token token.
     */
    @PublishMethod
    HashMap<String, Object> getBacklogDataForSeller(String token);

    @PublishMethod
    HashMap<String, Object> getBacklogDataForFinance(String token);

    @PublishMethod
    HashMap<String, Object> getBacklogData(String token);
    /**
     * 判断合同是否可以开票或收款  .
     *
     * @param token token.
     * @param ContractCode 合同编号.
     */
    @PublishMethod
    HashMap<String,Boolean> judgeContractCanInvOrRec(String token, String ContractCode);


       /**
     * 判断合同是否过期(过期则改状态为1)  .
     *
     * @param token token.
     */
    @PublishMethod
    int judgeContractIsDue(String token);

    /**
     * 批量添加阶段信息  .
     *  @param token token.
     * @param ContractCode 合同编号.
     * @param PhaseStr 阶段对象.
     */
    @PublishMethod
    PhaseList addPhaseBatch(String token, String ContractCode,String PhaseStr);

    /**
     * 申请开票  .
     *
     * @param token token.
     * @param ContractCode 合同编号.
     * @param PhaseId 阶段序号.
     * @param InvoiceApplyAmount 申请开票金额.
     */
    @PublishMethod
    InvoiceApply addInvoiceApply(String token,  String ContractCode, String PhaseId, double InvoiceApplyAmount);


    /**
     * 撤销开票申请  .
     *
     * @param token token.
     * @param ContractCode 合同编号.
     * @param InvoiceApplyId 申请Id.
     */
    @PublishMethod
    int deleteInvoiceApply(String token, String ContractCode, String InvoiceApplyId);

    /**
     * 销售查看自己开票申请列表  .
     *
     * @param token token.
     * @param Option 选项.
     */
    @PublishMethod
    InvoiceApplyList getOwnInvoiceApplyList(String token, int Option);
    /**
     * 财务统计接口  .
     *
     * @param token      token.
     * @param QueryDate  查询时间.
     */
    @PublishMethod
    HashMap<String, Object> getContractStatistic(String token, Date QueryDate);

}


