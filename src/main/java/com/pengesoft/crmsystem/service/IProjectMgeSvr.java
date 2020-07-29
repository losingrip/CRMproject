package com.pengesoft.crmsystem.service;

import com.pengesoft.crmsystem.domain.entity.Attention;
import com.pengesoft.crmsystem.domain.entity.Project;
import com.pengesoft.crmsystem.domain.entity.Visit;
import com.pengesoft.crmsystem.domain.entitylist.ProjectList;
import pengesoft.service.IApplication;
import pengesoft.service.PublishMethod;
import pengesoft.service.PublishName;
import pengesoft.web.PublishService;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * IProjectMgeSvr 接口定义。合同服务.
 *
 * @auther: 司童.
 * @date: 2020/3/30 17:21:03.
 *
 * 文件由鹏业软件模型工具生成(模板名称：JavaAppService),一般不应直接修改此文件.
 * Copyright (C) 2008 - 鹏业软件公司
 */
@PublishName("ProjectMgeSvr")
public interface IProjectMgeSvr extends IApplication {

    /**
     * 添加项目  .
     *
     * @param Token token.
     * @param ProjectName 项目名称.
     * @param ProjectDescribe 项目描述.
     * @param ProjectType 项目分类.
     * @param ProjectRemark 备注.
     * @param CustId 客户id.
     * @param ContactName 联系人名字
     * @param ContactTel 联系人电话
     * @param ContactDuty 联系人职务
     */
    @PublishMethod
    Project addProject(String Token, String ProjectName,int ProjectPLevel,int ProjectStatus, String ProjectDescribe, int ProjectType, String ProjectRemark, int CustId, String UserId, String ContactName, String ContactTel, String ContactDuty);

    @PublishMethod
    Project adddProject(String UserName, String ProjectName, int ProjectPLevel,int ProjectStatus,String ProjectDescribe, int ProjectType, String ProjectRemark, int CustId, String UserId, String ContactName, String ContactTel, String ContactDuty);

    /**
     * 修改项目信息  .
     *
     * @param Token token.
     * @param ProjectCode 项目编号.
     * @param ProjectName 项目名称.
     * @param ProjectDescribe 项目描述.
     * @param ProjectType 项目分类.
     * @param ProjectRemark 备注.
     * @param ProjectPLevel 项目p级
     * @param ProjectStatus 项目状态
     * @param CustId 客户id.
     * @param UserId 销售id.
     * @param ContactName 联系人名字
     * @param ContactTel 联系人电话
     * @param ContactDuty 联系人职务
     */
    @PublishMethod
    int updateProject(String Token,String ProjectCode, String ProjectName, int ProjectPLevel,int ProjectStatus,String ProjectDescribe, int ProjectType, String ProjectRemark, int CustId, String UserId, String ContactName , String ContactTel, String ContactDuty);

    /**
     * 获取项目详情  .
     *
     * @param Token token.
     * @param ProjectCode 项目编号.
     * @param Option 选项.
     */
    @PublishMethod
    Object getProjectDetail(String Token, String ProjectCode, int Option);

    /**
     * 删除项目  .
     *
     * @param Token token.
     * @param ProjectCode 项目编号.
     */
    @PublishMethod
    int deleteProject(String Token, String ProjectCode);

    /**
     * (销售)获取自己项目列表  .
     *
     * @param Token token.
     * @param Option 选项.
     * @param SortField 排序字段.
     */
    @PublishMethod
    List<Object>  getOwnProjectList(String Token, int Option,int SortField);

    /**
     * (销售主管)获取销售员工或全部项目列表  .
     *
     * @param Token token.
     * @param Option 选项.
     * @param SizeNum SizeNum.
     * @param SkipNum SkipNum.
     */
    @PublishMethod
    List<Object> getProjectList(String Token, int Option, int SizeNum, int SkipNum);

    /**
     * 修改项目销售负责人  .
     *
     * @param Token token.
     * @param ProjectCode 项目编号.
     */
    @PublishMethod
    int updateProjectCharger(String Token,String ProjectCode);

    /**
     * 添加拜访  .
     *
     * @param Token token.
     * @param VisitPlanTime 计划拜访时间.
     * @param VisitPlanContent 计划拜访内容.
     * @param VisitFactTime 实际拜访时间.
     * @param VisitFactContent 实际拜访内容.
     * @param VisitRemark 备注.
     * @param ProjectCode 项目编号.
     */
    @PublishMethod
    Visit addVisit(String Token, String VisitPlanTime, String VisitPlanContent, String VisitFactTime, String VisitFactContent, String VisitRemark, String ProjectCode) throws ParseException;

//    /**
//     * 修改计划拜访  .
//     *
//     * @param Token token.
//     * @param VisitId 拜访ID.
//     * @param VisitPlanTime 计划拜访时间.
//     * @param VisitPlanContent 计划拜访内容.
//     * @param VisitRemark 备注.
//     */
//    @PublishMethod
//    int updatePlanVisit(String Token, int VisitId, Date VisitPlanTime, String VisitPlanContent, String VisitRemark);
//
//    /**
//     * 修改实际拜访  .
//     *
//     * @param Token token.
//     * @param VisitId 拜访ID.
//     * @param VisitFactTime 实际拜访时间.
//     * @param VisitFactContent 实际拜访内容.
//     * @param VisitRemark 备注.
//     */
//    @PublishMethod
//    int updateFactVisit(String Token, int VisitId, Date VisitFactTime, String VisitFactContent, String VisitRemark);

    /**
     * (销售主管)删除拜访  .
     *
     * @param Token token.
     * @param VisitId 拜访Id.
     */
    @PublishMethod
    int deleteVisit(String Token, int VisitId);

    /**
     * 修改联系人  .
     *
     * @param Token token.
     * @param ProjectCode 项目编号.
     * @param ContactName 联系人姓名.
     * @param ContactTel 联系人电话.
     * @param ContactDuty 联系人职务.
     */
    @PublishMethod
    int updateProjectContact(String Token, String ProjectCode, String ContactName, String ContactTel, String ContactDuty);

    /**
     * 修改项目P级  .
     *
     * @param Token token.
     * @param ProjectCode 项目编号.
     * @param ProjectPLevel 项目P级别.
     */
    @PublishMethod
    int updateProjectPLevel(String Token, String ProjectCode, int ProjectPLevel);

    /**
     * 近期拜访列表
     * @param Token
     * @param Option
     * @return
     */
    @PublishMethod
    List<Object> getRecentVisitList(String Token, int Option);


    /**
     * 销售关注项目
     * @param Token
     * @param ProjectCode
     * @return
     */
    @PublishMethod
    Attention addAttentionProject(String Token,String ProjectCode);


    /**
     * 模糊查询项目信息
     * @param StrField 模糊查询字段.
     * @param Token 查询人token.
//     * @param SkipNum 页数.
//     * @param SizeNum 每页数量.
     * @return
     */
    @PublishMethod
    ProjectList getProjectByLike(String Token,String StrField,int Skip,int Size,int Option,int SimpleOrRich);

    /**
     * 修改拜访  .
     *
     * @param Token token.
     * @param VisitId 拜访ID.
     * @param VisitPlanTime 计划拜访时间.
     * @param VisitPlanContent 计划拜访内容.
     * @param VisitFactTime 实际拜访时间.
     * @param VisitFactContent 实际拜访内容.
     * @param VisitRemark 备注.
     */
    @PublishMethod
    int updateVisit(String Token, int VisitId, String VisitPlanTime,String VisitPlanContent,  String VisitFactTime, String VisitFactContent, String VisitRemark);


    /**
     * 手机app首页统计每个销售各项总数
     * @param Token
     * @return
     */
    @PublishMethod
    Map<String,Double> appFirstPageCount(String Token);

    /**
     * 销售查看自己的关注
     * @return
     */
    @PublishMethod
    List<Object> getAttentionList(String Token,int SkipNum,int SizeNum);


    /**
     * 删除收藏的项目
     * @param Token
     * @param AttentionId
     * @return
     */
    @PublishMethod
    int deleteAttention(String Token,int AttentionId);


    /**
     * 销售主管app首页统计
     * @param Token
     * @return
     */
    @PublishMethod
    Map<String,Object> appFirstPageCountByCharge(String Token);

    /**
     * 销售主管pc端首页统计
     * @param Token
//     * @param Option
     * @return
     */
    @PublishMethod
    List<Object> getPcFirstPage(String Token,int Option);
//    List<Object> getPcFirstPage(String Token);


    /**
     * 销售主管查看所有销售长时间未拜访的项目
     * @param Token
     * @return
     */
    @PublishMethod
    List<Project> longTimeNotHaveVisit(String Token,int Option,int SizeNum,int SkipNum);

}


