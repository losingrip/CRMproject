package com.pengesoft.crmsystem.domain.QueryPara;

import com.pengesoft.crmsystem.domain.entity.Customer;
import pengesoft.db.QueryParameter;
import pengesoft.utils.StringHelper;
import java.util.*;
import java.math.*;

/**
 * 客户信息 查询参数类。
 *
 * @auther: 曾小锐.
 * @date: 2020/3/31 14:36:28.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaQueryPara),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
public class CustomerQueryPara extends QueryParameter {

    /**
     * 缺省序列化id
     */
    private static final long serialVersionUID = 1L;
    /**
     * 常数 查询属性名(客户Id).
     */
    public static final String QueryAttr_CustId = "custId";
    /**
     * 常数 查询属性名(客户名称).
     */
    public static final String QueryAttr_CustName = "custName";
    /**
     * 常数 查询属性名(邮箱).
     */
    public static final String QueryAttr_CustEmail = "custEmail";
    /**
     * 常数 查询属性名(手机).
     */
    public static final String QueryAttr_CustTel = "custTel";
    /**
     * 常数 查询属性名(座机).
     */
    public static final String QueryAttr_CustPhone = "custPhone";
    /**
     * 常数 查询属性名(备注).
     */
    public static final String QueryAttr_CustRemark = "custRemark";
    /**
     * 常数 查询属性名(销售人员).
     */
    public static final String QueryAttr_UserId = "userId";
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
     * 常数 查询属性名(地区代码).
     */
    public static final String QueryAttr_CustRegionCode = "custRegionCode";
    /**
     * 常数 查询属性名(详细地址).
     */
    public static final String QueryAttr_CustAddress = "custAddress";
    /**
     * 常数 查询属性名(创建时间).
     */
    public static final String QueryAttr_CustCreateTime = "custCreateTime";
    /**
     * 常数 查询属性名(更新时间).
     */
    public static final String QueryAttr_CustUpdateTime = "custUpdateTime";

    /**
     * 常数 排序属性名(客户Id).
     */
    public static final String OrderAttr_CustId = "custId";
    /**
     * 常数 排序属性名(地区代码).
     */
    public static final String OrderAttr_CustRegionCode = "custRegionCode";
    /**
     * 常数 排序属性名(创建时间).
     */
    public static final String OrderAttr_CustCreateTime = "custCreateTime";
    /**
     * 常数 排序属性名(更新时间).
     */
    public static final String OrderAttr_CustUpdateTime = "custUpdateTime";

    /**
     * 默认构造方法
     */
    public CustomerQueryPara() {
        super();
    }

    /**
     * 构造函数,指定参数对象及排序字段
     *
     * @param data  查询参数对象
     * @param order 排序字段
     * @param isAse true升序，false降序
     */
    public CustomerQueryPara(Customer data, String order, boolean isAse) {
        super();
        SetQueryPara(data, order, isAse);
    }

    /**
     * 构造函数,指定参数对象及排序字段
     *
     * @param data 查询参数对象
     */
    public CustomerQueryPara(Customer data) {
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
    public void SetQueryPara(Customer data, String order, boolean isAse) {
        if (data != null) {
            setParamByCustId(data.getCustId());
            setParamByCustName(data.getCustName());
            setParamByCustEmail(data.getCustEmail());
            setParamByCustTel(data.getCustTel());
            setParamByCustPhone(data.getCustPhone());
            setParamByCustRemark(data.getCustRemark());
            setParamByUserId(data.getUserId());
            setParamByContactName(data.getContactName());
            setParamByContactTel(data.getContactTel());
            setParamByContactDuty(data.getContactDuty());
            setParamByCustRegionCode(data.getCustRegionCode());
            setParamByCustAddress(data.getCustAddress());
            setParamByCustCreateTime(data.getCustCreateTime());
            setParamByCustUpdateTime(data.getCustUpdateTime());
        }
        if (!StringHelper.isNullOrEmpty(order))
            addOrderBy(order, isAse);
    }

    /**
     * 增加用客户Id匹配条件(custId非0时才会加入此条件)(target = custId)，key:custId.
     * @param custId 客户Id匹配条件参数
     */
    public void setParamByCustId(int custId){
        addParameter(QueryAttr_CustId, custId);
    }

    /**
     * 增加用客户Id匹配条件(custId为0时也会加入此条件)(target = custId)，key:custId.
     * @param custId 客户Id匹配条件参数
     */
    public void setParamByCustIdIncZero(int custId){
        put(QueryAttr_CustId, custId);
    }

    /**
     * 增加客户Id范围条件（low <= target and target >= high），key:custId_L custId_H.
     * @param low 最小值参数
     * @param high 最大值参数
     */
    public void setParamByCustId_Range(int low, int high){
        addParameterByRange(QueryAttr_CustId, low, high);
    }

    /**
     * 增加客户Id枚举条件(target in (custIds))，key:custId_Enum.
     * @param custIds 客户Id数组条件参数
     */
    public void setParamByCustId_Enum(int... custIds){
        addParameterByEnum(QueryAttr_CustId, custIds);
    }

    /**
     * 增加用客户名称匹配条件(target like custName)，key:custName.
     * @param custName 客户名称匹配条件参数
     */
    public void setParamByCustName(String custName){
        addParameter(QueryAttr_CustName, custName);
    }

    /**
     * 增加用客户名称匹配条件(custName为empty时也会加入此条件)，不空时(target like custName)，key:custName，为空时(target is null or target = '')，key:custName.
     * @param custName 客户名称匹配条件参数
     */
    public void setParamByCustNameInEmpty(String custName){
        put(QueryAttr_CustName, custName);
    }

    /**
     * 增加客户名称枚举条件(target in (custNames))，key:custName_Enum.
     * @param custNames 客户名称数组条件参数
     */
    public void setParamByCustName_Enum(String... custNames){
        addParameterByEnum(QueryAttr_CustName, custNames);
    }

    /**
     * 增加用邮箱匹配条件(target like custEmail)，key:custEmail.
     * @param custEmail 邮箱匹配条件参数
     */
    public void setParamByCustEmail(String custEmail){
        addParameter(QueryAttr_CustEmail, custEmail);
    }

    /**
     * 增加用邮箱匹配条件(custEmail为empty时也会加入此条件)，不空时(target like custEmail)，key:custEmail，为空时(target is null or target = '')，key:custEmail.
     * @param custEmail 邮箱匹配条件参数
     */
    public void setParamByCustEmailInEmpty(String custEmail){
        put(QueryAttr_CustEmail, custEmail);
    }

    /**
     * 增加邮箱枚举条件(target in (custEmails))，key:custEmail_Enum.
     * @param custEmails 邮箱数组条件参数
     */
    public void setParamByCustEmail_Enum(String... custEmails){
        addParameterByEnum(QueryAttr_CustEmail, custEmails);
    }

    /**
     * 增加用手机匹配条件(target like custTel)，key:custTel.
     * @param custTel 手机匹配条件参数
     */
    public void setParamByCustTel(String custTel){
        addParameter(QueryAttr_CustTel, custTel);
    }

    /**
     * 增加用手机匹配条件(custTel为empty时也会加入此条件)，不空时(target like custTel)，key:custTel，为空时(target is null or target = '')，key:custTel.
     * @param custTel 手机匹配条件参数
     */
    public void setParamByCustTelInEmpty(String custTel){
        put(QueryAttr_CustTel, custTel);
    }

    /**
     * 增加手机枚举条件(target in (custTels))，key:custTel_Enum.
     * @param custTels 手机数组条件参数
     */
    public void setParamByCustTel_Enum(String... custTels){
        addParameterByEnum(QueryAttr_CustTel, custTels);
    }

    /**
     * 增加用座机匹配条件(target like custPhone)，key:custPhone.
     * @param custPhone 座机匹配条件参数
     */
    public void setParamByCustPhone(String custPhone){
        addParameter(QueryAttr_CustPhone, custPhone);
    }

    /**
     * 增加用座机匹配条件(custPhone为empty时也会加入此条件)，不空时(target like custPhone)，key:custPhone，为空时(target is null or target = '')，key:custPhone.
     * @param custPhone 座机匹配条件参数
     */
    public void setParamByCustPhoneInEmpty(String custPhone){
        put(QueryAttr_CustPhone, custPhone);
    }

    /**
     * 增加座机枚举条件(target in (custPhones))，key:custPhone_Enum.
     * @param custPhones 座机数组条件参数
     */
    public void setParamByCustPhone_Enum(String... custPhones){
        addParameterByEnum(QueryAttr_CustPhone, custPhones);
    }

    /**
     * 增加用备注匹配条件(target like custRemark)，key:custRemark.
     * @param custRemark 备注匹配条件参数
     */
    public void setParamByCustRemark(String custRemark){
        addParameter(QueryAttr_CustRemark, custRemark);
    }

    /**
     * 增加用备注匹配条件(custRemark为empty时也会加入此条件)，不空时(target like custRemark)，key:custRemark，为空时(target is null or target = '')，key:custRemark.
     * @param custRemark 备注匹配条件参数
     */
    public void setParamByCustRemarkInEmpty(String custRemark){
        put(QueryAttr_CustRemark, custRemark);
    }

    /**
     * 增加备注枚举条件(target in (custRemarks))，key:custRemark_Enum.
     * @param custRemarks 备注数组条件参数
     */
    public void setParamByCustRemark_Enum(String... custRemarks){
        addParameterByEnum(QueryAttr_CustRemark, custRemarks);
    }

    /**
     * 增加用销售人员匹配条件(userId非0时才会加入此条件)(target = userId)，key:userId.
     * @param userId 销售人员匹配条件参数
     */
    public void setParamByUserId(String userId){
        addParameter(QueryAttr_UserId, userId);
    }

    /**
     * 增加用销售人员匹配条件(userId为0时也会加入此条件)(target = userId)，key:userId.
     * @param userId 销售人员匹配条件参数
     */
    public void setParamByUserIdIncZero(String userId){
        put(QueryAttr_UserId, userId);
    }

    /**
     * 增加销售人员范围条件（low <= target and target >= high），key:userId_L userId_H.
     * @param low 最小值参数
     * @param high 最大值参数
     */
    public void setParamByUserId_Range(int low, int high){
        addParameterByRange(QueryAttr_UserId, low, high);
    }

    /**
     * 增加销售人员枚举条件(target in (userIds))，key:userId_Enum.
     * @param userIds 销售人员数组条件参数
     */
    public void setParamByUserId_Enum(String... userIds){
        addParameterByEnum(QueryAttr_UserId, userIds);
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
     * 增加用地区代码匹配条件(custRegionCode非0时才会加入此条件)(target = custRegionCode)，key:custRegionCode.
     * @param custRegionCode 地区代码匹配条件参数
     */
    public void setParamByCustRegionCode(int custRegionCode){
        addParameter(QueryAttr_CustRegionCode, custRegionCode);
    }

    /**
     * 增加用地区代码匹配条件(custRegionCode为0时也会加入此条件)(target = custRegionCode)，key:custRegionCode.
     * @param custRegionCode 地区代码匹配条件参数
     */
    public void setParamByCustRegionCodeIncZero(int custRegionCode){
        put(QueryAttr_CustRegionCode, custRegionCode);
    }

    /**
     * 增加地区代码范围条件（low <= target and target >= high），key:custRegionCode_L custRegionCode_H.
     * @param low 最小值参数
     * @param high 最大值参数
     */
    public void setParamByCustRegionCode_Range(int low, int high){
        addParameterByRange(QueryAttr_CustRegionCode, low, high);
    }

    /**
     * 增加地区代码枚举条件(target in (custRegionCodes))，key:custRegionCode_Enum.
     * @param custRegionCodes 地区代码数组条件参数
     */
    public void setParamByCustRegionCode_Enum(int... custRegionCodes){
        addParameterByEnum(QueryAttr_CustRegionCode, custRegionCodes);
    }

    /**
     * 增加用详细地址匹配条件(target like custAddress)，key:custAddress.
     * @param custAddress 详细地址匹配条件参数
     */
    public void setParamByCustAddress(String custAddress){
        addParameter(QueryAttr_CustAddress, custAddress);
    }

    /**
     * 增加用详细地址匹配条件(custAddress为empty时也会加入此条件)，不空时(target like custAddress)，key:custAddress，为空时(target is null or target = '')，key:custAddress.
     * @param custAddress 详细地址匹配条件参数
     */
    public void setParamByCustAddressInEmpty(String custAddress){
        put(QueryAttr_CustAddress, custAddress);
    }

    /**
     * 增加详细地址枚举条件(target in (custAddresss))，key:custAddress_Enum.
     * @param custAddresss 详细地址数组条件参数
     */
    public void setParamByCustAddress_Enum(String... custAddresss){
        addParameterByEnum(QueryAttr_CustAddress, custAddresss);
    }

    /**
     * 增加用创建时间匹配条件(target = custCreateTime)，key:custCreateTime.
     * @param custCreateTime 创建时间匹配条件参数
     */
    public void setParamByCustCreateTime(Date custCreateTime){
        addParameter(QueryAttr_CustCreateTime, custCreateTime);
    }

    /**
     * 增加创建时间范围条件（startDate < target and target > endDate），key:custCreateTime_S custCreateTime_E.
     * @param startDate 最小值参数
     * @param endDate 最大值参数
     */
    public void setParamByCustCreateTime_Range(Date startDate, Date endDate){
        addParameterByRange(QueryAttr_CustCreateTime, startDate, endDate);
    }

    /**
     * 增加用更新时间匹配条件(target = custUpdateTime)，key:custUpdateTime.
     * @param custUpdateTime 更新时间匹配条件参数
     */
    public void setParamByCustUpdateTime(Date custUpdateTime){
        addParameter(QueryAttr_CustUpdateTime, custUpdateTime);
    }

    /**
     * 增加更新时间范围条件（startDate < target and target > endDate），key:custUpdateTime_S custUpdateTime_E.
     * @param startDate 最小值参数
     * @param endDate 最大值参数
     */
    public void setParamByCustUpdateTime_Range(Date startDate, Date endDate){
        addParameterByRange(QueryAttr_CustUpdateTime, startDate, endDate);
    }

}
