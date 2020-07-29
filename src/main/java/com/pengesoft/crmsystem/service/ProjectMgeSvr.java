package com.pengesoft.crmsystem.service;

import com.alibaba.fastjson.JSONObject;
import com.pengesoft.crmsystem.component.tools;
import com.pengesoft.crmsystem.domain.QueryPara.AttentionQueryPara;
import com.pengesoft.crmsystem.domain.QueryPara.ContractQueryPara;
import com.pengesoft.crmsystem.domain.QueryPara.ProjectQueryPara;
import com.pengesoft.crmsystem.domain.QueryPara.VisitQueryPara;
import com.pengesoft.crmsystem.domain.dao.*;
import com.pengesoft.crmsystem.domain.entity.*;
import com.pengesoft.crmsystem.domain.entitylist.ProjectList;
import com.pengesoft.crmsystem.domain.entitylist.ReceivableList;
import com.pengesoft.crmsystem.domain.entitylist.VisitList;
import com.pengesoft.crmsystem.utils.GetNowTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import pengesoft.account.Person;
import pengesoft.account.PersonQueryPara;
import pengesoft.account.dao.PersonDao;
import pengesoft.auth.annotation.RequiresPermissions;
import pengesoft.common.IPSFNetException;
import pengesoft.core.PsCoreRuntimeException;
import pengesoft.service.ApplicationBase;
import pengesoft.service.PublishMethod;
import pengesoft.utils.AssertUtils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * IProjectMgeSvr 接口实现。合同服务.
 *
 * @auther: 司童.
 * @date: 2020/3/30 17:21:03.
 *
 * Copyright (C) 2008 - 鹏业软件公司
 */
@Service
@Transactional
public class ProjectMgeSvr extends ApplicationBase implements IProjectMgeSvr {


    @Autowired
    private ProjectDao projectDao;

    @Autowired
    private VisitDao visitDao;

    @Autowired
    private ContractDao contractDao;

    @Autowired
    private AttentionDao attentionDao;

    @Autowired
    private PersonDao personDao;

    @Autowired
    private ProjectMgeSvr projectMgeSvr;

    @Autowired
    private CustomerDao customerDao;

    /**
     * 构造方法
     */
    @Autowired
    public ProjectMgeSvr() {
        //TODO: 通过构造方法参数设置依赖注入.
    }


    /**
     * 添加项目信息  .
     *
     * @param Token           token.
     * @param ProjectName     项目名称.
     * @param ProjectDescribe 项目描述.
     * @param ProjectType     项目分类.
     * @param ProjectRemark   备注.
     * @param ProjectPLevel   项目p级
     * @param ProjectStatus   项目状态
     * @param CustId          客户id.
     * @param UserId          销售id.
     * @param ContactName     联系人名字
     * @param ContactTel      联系人电话
     * @param ContactDuty     联系人职务
     */
    @Override
    @RequiresPermissions("ProjectMgeSvr:addProject")
    public Project addProject(String Token, String ProjectName, int ProjectPLevel,int ProjectStatus,String ProjectDescribe, int ProjectType, String ProjectRemark, int CustId, String UserId, String ContactName, String ContactTel, String ContactDuty) {
        /**
         * 解析token
         * 销售主管创建和销售创建
         */

        /**
         * 验证非空
         */
        AssertUtils.ThrowArgNullException(ProjectName, "ProjectName", true);
        AssertUtils.ThrowArgNullException(ProjectDescribe, "ProjectDescribe", true);
        AssertUtils.ThrowArgZeroException(CustId, "CustId");
        AssertUtils.ThrowArgNullException(UserId, "UserId", true);


        /**
         * 添加项目
         * uuid生成项目编码
         * 判断项目是否已经存在1
         */
        String projectCode = UUID.randomUUID().toString();
        Project project = new Project();
        project.setProjectName(ProjectName);
//        project.setUserId(UserId);
        Project selectProject = (Project)projectDao.ExecuteQueryForObject("projectNameIsOrExist",project);
        if (selectProject != null) {
            System.out.println("开始");
            throw new PsCoreRuntimeException("该项目名已存在",403);
        }
        project.setProjectCode(projectCode);
        project.setProjectType(ProjectType);
        project.setProjectName(ProjectName);
        project.setProjectDescribe(ProjectDescribe);
        project.setProjectRemark(ProjectRemark);
        project.setCustId(CustId);
        project.setUserId(UserId);
        project.setContactName(ContactName);
        project.setContactDuty(ContactDuty);
        project.setContactTel(ContactTel);
        project.setProjectStatus(ProjectStatus);
        project.setProjectPLevel(ProjectPLevel);
        project.setProjectCreateTime(GetNowTime.getNowTime());
        /**
         * 联系人信息是只能单独添加 还是在创建项目的就可以选择性添加 看下项目和客户是否同一个联系人
         */
        projectDao.insert(project);
        return project;
    }

    @Override
    public Project adddProject(String UserName, String ProjectName, int ProjectPLevel,int ProjectStatus,String ProjectDescribe, int ProjectType, String ProjectRemark, int CustId, String UserId, String ContactName, String ContactTel, String ContactDuty) {

        PersonQueryPara personQueryPara = new PersonQueryPara();
        personQueryPara.setParamByName(UserName);
        List<Person> list= personDao.queryList(personQueryPara,0,-1);


        /**
         * 验证非空
         */
        AssertUtils.ThrowArgNullException(ProjectName, "ProjectName", true);
        AssertUtils.ThrowArgNullException(ProjectDescribe, "ProjectDescribe", true);


        /**
         * 添加项目
         * uuid生成项目编码
         * 判断项目是否已经存在1
         */
        String projectCode = UUID.randomUUID().toString();
        Project project = new Project();
        project.setProjectName(ProjectName);
        Project selectProject = (Project)projectDao.ExecuteQueryForObject("projectNameIsOrExist",project);
        if (selectProject != null) {
            System.out.println("开始");
            throw new PsCoreRuntimeException("该项目名已存在",403);
        }
        //添加销售的id
        project.setUserId(list.get(0).getUniqID());
        project.setProjectCode(projectCode);
        project.setProjectType(ProjectType);
        project.setProjectName(ProjectName);
        project.setProjectDescribe(ProjectDescribe);
        project.setProjectRemark(ProjectRemark);
        project.setCustId(CustId);
        project.setUserId(UserId);
        project.setContactName(ContactName);
        project.setContactDuty(ContactDuty);
        project.setContactTel(ContactTel);
        project.setProjectStatus(ProjectStatus);
        project.setProjectPLevel(ProjectPLevel);
        project.setProjectCreateTime(GetNowTime.getNowTime());
        /**
         * 联系人信息是只能单独添加 还是在创建项目的就可以选择性添加 看下项目和客户是否同一个联系人
         */
        projectDao.insert(project);
        return project;
    }



    /**
     * 修改项目信息  .
     *
     * @param Token           token.
     * @param ProjectCode     项目编号.
     * @param ProjectName     项目名称.
     * @param ProjectDescribe 项目描述.
     * @param ProjectType     项目分类.
     * @param ProjectRemark   备注.
     * @param ProjectPLevel   项目p级
     * @param ProjectStatus   项目状态
     * @param CustId          客户id.
     * @param UserId          销售id.
     * @param ContactName     联系人名字
     * @param ContactTel      联系人电话
     * @param ContactDuty     联系人职务
     * @param CustId          客户id
     */
    @Override
    @RequiresPermissions("ProjectMgeSvr:updateProject")
    public int updateProject(String Token, String ProjectCode, String ProjectName, int ProjectPLevel, int ProjectStatus, String ProjectDescribe, int ProjectType, String ProjectRemark, int CustId, String UserId, String ContactName, String ContactTel, String ContactDuty) {


        AssertUtils.ThrowArgNullException(ProjectCode, "ProjectCode", true);
        AssertUtils.ThrowArgNullException(ProjectName, "ProjectName", true);
        AssertUtils.ThrowArgNullException(ProjectDescribe, "ProjectDescribe", true);
        AssertUtils.ThrowArgZeroException(CustId, "CustId");
        AssertUtils.ThrowArgNullException(UserId, "UserId", true);

        /**
         * 更新非空值
         */
        Project project = new Project();
        project.setProjectCode(ProjectCode);
        Project selectProject = projectDao.getDetail(project);

        if (selectProject != null) {

            /**
             * 如果联系人发生改变 则将现有联系人添加进历史联系人
             */
            if(!selectProject.getContactName().equals(ContactName)){
                project.setContactHistory(selectProject.getContactHistory() + selectProject.getContactName()+",");
            }

            project.setProjectName(ProjectName);
            project.setProjectDescribe(ProjectDescribe);
            project.setProjectType(ProjectType);
            project.setProjectRemark(ProjectRemark);
            project.setProjectType(ProjectType);
            project.setProjectRemark(ProjectRemark);
            project.setCustId(CustId);
            project.setUserId(UserId);
            project.setContactName(ContactName);
            project.setContactTel(ContactTel);
            project.setContactDuty(ContactDuty);
            project.setProjectPLevel(ProjectPLevel);
            project.setProjectStatus(ProjectStatus);
            project.setProjectUpdateTime(GetNowTime.getNowTime());
            System.out.println("projectStatus+++" + ProjectStatus);
            int updateCode = projectDao.ExecuteUpdate("updateByPart", project);
            return updateCode;
        } else {
            throw new PsCoreRuntimeException("项目不存在",401);
        }


    }


    /**
     * 获取项目详情  .
     *
     * @param Token       token.
     * @param ProjectCode 项目编号.
     * @param Option      选项.
     */
    @Override
    @RequiresPermissions("ProjectMgeSvr:getProjectDetail")
    public Object getProjectDetail(String Token, String ProjectCode, int Option) {

        AssertUtils.ThrowArgNullException(Token, "Token", true);
        AssertUtils.ThrowArgNullException(ProjectCode, "ProjectCode", true);
        /**
         * 解析token
         */

        /**
         * 判断option
         * option 0 : app 销售所有项目信息   项目 合同  拜访
         *        1： app 首页 最近拜访项目详情   常用信息  项目名称 客户名称 联系人 联系电话 拜访时间 销售人员名字 + 拜访计划+拜访记录
         * com.fasterxml.jackson.databind.JsonMappingException: Object is null (through reference chain: net.sf.json.JSONObject["allVisitList"]->net.sf.json.JSONArray[2]->net.sf.json.JSONObject["visitPlanTime"]->net.sf.json.JSONNull["Empty"])
         * 用阿里 jsonObject
         * 可以转换date类型为空的情况
         */
        Project project = new Project();
        project.setProjectCode(ProjectCode);
        Visit visit = new Visit();
        visit.setProjectCode(ProjectCode);
        VisitQueryPara param = new VisitQueryPara();
        param.setParamByProjectCode(ProjectCode);
        project = (Project) projectDao.ExecuteQueryForObject("getProjectDetail", project);


        List<Integer> attentionId = attentionDao.ExecuteQueryForList("attentionProjectDetail", ProjectCode);
        if (attentionId.size() > 0) {
            project.setAttentionId(attentionId.get(0));
        }
        if (project == null) {
            throw new PsCoreRuntimeException("项目不存在",401);
        }
        List<Visit> visitListPlan = visitDao.ExecuteQueryForList("queryVisitList1", visit);
        List<Visit> aloneVisit = visitDao.ExecuteQueryForList("queryVisitList2", visit);
        Object project1;
        JSONObject jsonObject1 = new JSONObject();
        switch (Option) {
            case 0:
                /**
                 * 查询项目
                 * 查询拜访计划信息
                 * 查询项目所有合同信息
                 * pc销售主管
                 */
                List<Contract> contractList = contractDao.ExecuteQueryForList("queryContractListByProjectCodeOp0", ProjectCode);
                project = projectMgeSvr.getOneProjectMoney(Token,project);
                jsonObject1.put("projectDetail", project);
                jsonObject1.put("contractList", contractList);
                jsonObject1.put("visitListPlan", visitListPlan);
                jsonObject1.put("aloneVisit", aloneVisit);
                return jsonObject1;
            case 1:
                /**
                 * com.fasterxml.jackson.databind.JsonMappingException: Object is null (through reference chain: net.sf.json.JSONObject["allVisitList"]->net.sf.json.JSONArray[2]->net.sf.json.JSONObject["visitPlanTime"]->net.sf.json.JSONNull["Empty"])
                 * 用阿里 jsonObject
                 * 可以转换date类型为空的情况
                 * app销售
                 */
                project1 = projectDao.ExecuteQueryForObject("getAppProjectDetail", project);
                /**
                 * 拜访记录和拜访计划
                 */
                jsonObject1.put("projectDetail", project1);
                jsonObject1.put("visitListPlan", visitListPlan);
                jsonObject1.put("aloneVisit", aloneVisit);
                return jsonObject1;
        }
        throw new PsCoreRuntimeException("Option不存在",601);
    }


    /**
     * 删除项目  .
     * 删除可能添加错的项目
     * 项目负责人的权限
     *
     * @param Token       token.
     * @param ProjectCode 项目编号.
     */
    @Override
    @RequiresPermissions("ProjectMgeSvr:getProjectDetail")
    public int deleteProject(String Token, String ProjectCode) {

        AssertUtils.ThrowArgNullException(Token, "Token", true);
        AssertUtils.ThrowArgNullException(ProjectCode, "ProjectCode", true);

        /**
         * 验证token
         */
        Project project = new Project();
        project.setProjectCode(ProjectCode);
        Project selectProject = projectDao.getDetail(project);
        VisitQueryPara param = new VisitQueryPara();
        param.setParamByProjectCode(selectProject.getProjectCode());
        List<Visit> visits = visitDao.queryList(param, 0, -1);
        HashMap<String, Object> map = new HashMap<>();
        if (selectProject != null) {
            /**
             * 删除项目
             * 删除和项目相关的拜访计划
             * 查询拜访计划列表
             */
            if (visits.size() > 0) {
                /**
                 * 获取和项目相关的拜访id 批量删除
                 */
                List<Integer> list = new ArrayList<>();
                for (Visit v : visits) {
                    list.add(v.getVisitId());
                }
                map.put("visitIdList", list);
                int deleteVisits = visitDao.ExecuteDelete("deleteByVisits", map);
            }
            int deleteCode = projectDao.delete(project);
            return deleteCode;
        } else {
            throw new PsCoreRuntimeException("项目不存在",401);
        }

    }

    /**
     * (app销售)获取自己项目列表  .
     *
     * @param Token  token.
     * @param Option 选项.
     * @param SortField 排序字段 默认0：项目创建时间(最近到最远） 1：项目创建时间（最远到最近）  2：项目总金额（多到少） 3：项目总金额（由少到多）.
     */
    @Override
    @RequiresPermissions("ProjectMgeSvr:getOwnProjectList")
    public List<Object> getOwnProjectList(String Token, int Option,int SortField) {


        /**
         * 验证token
         * 获取userId
         * 之后参数就没有UserId
         */
        AssertUtils.ThrowArgNullException(Token, "Token", true);
        String UserId = null;
        try {
            UserId = tools.getUserId(Token);
        } catch (IPSFNetException e) {
            e.printStackTrace();
        }
        List<Object> projectList = new ArrayList<>();
        Project project = new Project();
        project.setUserId(UserId);
        /**
         * 判断option
         * option 0 : 所有信息
         *        1： 常用信息  项目名称 创建项目时间  项目编号        暂定：客户名称 联系人 联系电话 项目金额
         *        2： 项目名 客户名 项目状态 合同已收款 合同代收款  下一阶段  代收款合同列表
         */
        switch (Option) {
            case 0:
                /**
                 * 通过销售编号  查询
                 */
                ProjectQueryPara param = new ProjectQueryPara();
                param.setParamByUserId(UserId);
                Attention attention = new Attention();
                /**
                 * pc端项目列表信息
                 *
                 */

                double notReceiveTotal = 0.0;
                double projectTotal = 0.0;
                List<Project> list = new ArrayList<>();
                if(0==SortField || 1==SortField){
                    list = projectDao.ExecuteQueryForList("getProjectListByTime", project);
                    if(1==SortField){
                        Collections.reverse(list);
                    }

                }else{
                    list = projectDao.ExecuteQueryForList("getProjectListByMoney", project);
                    if(3==SortField){
                        Collections.reverse(list);
                    }
                }
                for (Project p : list) {
                    double alreadyReceiveTotal = 0.0;
                    attention.setUserId(p.getUserId());
                    attention.setProjectCode(p.getProjectCode());
                    List<Contract> contractList = contractDao.ExecuteQueryForList("queryContractListByProjectCodeOp0", p.getProjectCode());
                    if (contractList.size() > 0) {
                        projectTotal = (double) projectDao.ExecuteQueryForObject("getContractAmountByProjectCode", p.getProjectCode());
                        for (Contract c : contractList) {
                            if (c.getReceivableList() != null) {
                                for (Receivable r1 : c.getReceivableList()) {
                                    alreadyReceiveTotal += r1.getRecAmount();
                                    projectTotal += r1.getRecAmount();

                                }
                            } else {
                                projectTotal += 0;
                            }
                        }
                        p.setReceiveTotal(alreadyReceiveTotal);
                        p.setContractTotal(projectTotal);
                    }
                    /**
                     * 判断是否关注此项目
                     */
                    List<Integer> tempList = attentionDao.ExecuteQueryForList("isAttention", attention);
                    if (tempList.size() > 0) {
                        p.setAttentionId(tempList.get(0));
                    } else {
                        p.setAttentionId(0);
                    }
                    projectList.add(p);
                }

                return projectList;
            case 1:
                /**
                 * 塞选项目部分信息
                 */
                projectList = projectDao.ExecuteQueryForList("getProjectByUser", project);
                return projectList;

        }
        throw new PsCoreRuntimeException("option不存在",601);
    }


    /**
     * 手机app主管统计
     * 销售主管pc端首页统计
     *
     * @param Token
     * @return
     */
    @Override
    @RequiresPermissions("ProjectMgeSvr:getPcFirstPage")
    public List<Object> getPcFirstPage(String Token, int Option) {

        /**
         * 解析token
         */
        AssertUtils.ThrowArgNullException(Token, "Token", true);
        Person person = new Person();
        List<Object> projectList = new ArrayList<>();
        PersonQueryPara personParam = new PersonQueryPara();
        String UserId = null;
        try {
            UserId = tools.getUserId(Token);
        } catch (IPSFNetException e) {
            e.printStackTrace();
        }
        person.setUniqID(UserId);
        Person person1 = personDao.getDetail(person);
        personParam.setParamByOrganization(person1.getOrganization());
        List<Person> personList = personDao.queryList(personParam, 0, -1);
        Map<String, Object> plevelMap = new HashMap<>();
        plevelMap.put("plevelMap", personList);
        List<Map<String, Integer>> plevelList = projectDao.ExecuteQueryForList("customerPlevel", plevelMap);

        switch (Option) {
            case 0:
                List<Project> projectLists = projectDao.ExecuteQueryForList("allProjectList", plevelMap);
                int contractCount = 0;
                for (Project p : projectLists) {

                    /**
                     * 获取项目所有合同总额
                     */
                    double receiveTotal = 0.0;
                    double contractTotal = 0.0;

                    /**
                     * 获取所有合同已回款信息
                     */
                    List<Contract> contractList = contractDao.ExecuteQueryForList("queryContractListByProjectCodeOp0", p.getProjectCode());
                    if (contractList.size() > 0) {
                        contractTotal = (double) projectDao.ExecuteQueryForObject("getContractAmountByProjectCode", p.getProjectCode());
                        for (Contract c : contractList) {
                            if (c.getReceivableList() != null) {
                                for (Receivable r1 : c.getReceivableList()) {
                                    receiveTotal += r1.getRecAmount();
                                }
                            } else {
                                System.out.println("没有汇款");
                            }
                        }
                        p.setReceiveTotal(receiveTotal);
                    }
                    p.setContractTotal(contractTotal);
                    p.setPlevelCount(projectLists.size());
                    if (receiveTotal == 0.0 && contractTotal == 0.0) {
                        p.setPercentage(0.0);
                    } else {
                        double percentage = receiveTotal / contractTotal;
                        p.setPercentage(percentage);
                    }
                    p.setContractCount(contractList.size());
                    projectList.add(p);
                }
                Map<String, Object> maps = new HashMap<>();
                maps.put("plevelList", plevelList);
                projectList.add(maps);
                return projectList;
            case 1:
                /**
                 *         map.put("projectTotal",projectTotal);
                 *         map.put("alreadyReceivable",receiveTotal);
                 *         map.put("projectNumber",lists.size());
                 *         map.put("contractTotal",contractTotal);
                 *         map.put("waitReceivable",projectTotal-receiveTotal);
                 *         map.put("plevelCount",plevelList);
                 */
                double projectTotal = 0;
                double alreadyReceivable = 0;
                double projectNumber = 0;
                double contractTotal = 0;
                double waitReceivable = 0;
                for (Person p : personList) {
                    Map<String, Double> map = new HashMap<>();
                    map = projectMgeSvr.appFirstPage(p.getUniqID());
                    projectTotal += map.get("projectTotal");
                    alreadyReceivable += map.get("alreadyReceivable");
                    projectNumber += map.get("projectNumber");
                    contractTotal += map.get("contractTotal");
                    waitReceivable += map.get("waitReceivable");
                }

                Map<String, Object> map1 = new HashMap<>();
                map1.put("projectTotal", projectTotal);
                map1.put("alreadyReceivable", alreadyReceivable);
                map1.put("projectNumber", projectNumber);
                map1.put("contractTotal", contractTotal);
                map1.put("waitReceivable", waitReceivable);
                map1.put("plevelCount", plevelList);
                projectList.add(map1);
                return projectList;
        }

        throw new PsCoreRuntimeException("Option不存在",601);

    }


    /**
     * pc获取单个项目详情的总收款总未收款合同总数
     * @param Token
     * @param project
     * @return
     */
    public Project getOneProjectMoney(String Token, Project project) {

        /**
         * 获取项目所有合同总额
         */
        double receiveTotal = 0.0;
        double contractTotal = 0.0;

        /**
         * 获取所有合同已回款信息
         */
        List<Contract> contractList = contractDao.ExecuteQueryForList("queryContractListByProjectCodeOp0", project.getProjectCode());
        if (contractList.size() > 0) {
            contractTotal = (double) projectDao.ExecuteQueryForObject("getContractAmountByProjectCode", project.getProjectCode());
            for (Contract c : contractList) {
                if (c.getReceivableList() != null) {
                    for (Receivable r1 : c.getReceivableList()) {
                        receiveTotal += r1.getRecAmount();
                    }
                } else {
                    System.out.println("没有汇款");
                }
            }
            project.setReceiveTotal(receiveTotal);
        }
        project.setContractTotal(contractTotal);
        if (receiveTotal == 0.0 && contractTotal == 0.0) {
            project.setPercentage(0.0);
        } else {
            double percentage = receiveTotal / contractTotal;
            project.setPercentage(percentage);
        }
        project.setContractCount(contractList.size());
        return project;
    }




    /**
     * (销售主管)获取销售员工或全部项目列表  .
     *
     * @param Token token.
     * @param Option 选项.
     * @param SizeNum 每页数量.
     * @param SkipNum 页数.
     */
    @Override
    @RequiresPermissions("ProjectMgeSvr:getProjectList")
    public List<Object> getProjectList(String Token,int Option, int SizeNum, int SkipNum) {
        /**
         * 销售主管
         * 若显示有代收合同的，先查询代收合同 在找到项目  在找到合同的回款信息
         * 先查看销售的项目  在从项目看到合同  在查看合同有无代收款  阶段信息里通过合同查找
         * 怎样查看合同待收款信息
         * 回款 阶段信息 都是列表在合同表里面  合同的收款信息  找出来在加收款总额 然后当做收款金额  显示合同阶段信息
         */
        /**
         * 验证token
         * 获取userId
         */
        AssertUtils.ThrowArgNullException(Token, "Token", true);

        /**
         * 获取销售主管所管得人  包含自己
         */
        PersonQueryPara personParam = new PersonQueryPara();
        Person person = new Person();

        String UserId = null;
        try {
            UserId = tools.getUserId(Token);
        } catch (IPSFNetException e) {
            e.printStackTrace();
        }
        person.setUniqID(UserId);
        Person person1 = personDao.getDetail(person);
        personParam.setParamByOrganization(person1.getOrganization());
        List<Person> personList = personDao.queryList(personParam,0,-1);
        List<Object> projectList = new ArrayList<>();

        /**
         * 判断option
         * option 0 : 所有信息
         *        1： 常用信息  项目名称 创建项目时间  项目编号        暂定：客户名称 联系人 联系电话 项目金额
         *        2： 项目名 客户名 项目状态 合同已收款 合同代收款  下一阶段  代收款合同列表
         */
        switch (Option) {
            case 0:
                /**
                 * 存储销售主管下销售人员的map
                 */
                Map<String,Object> plevelMap = new HashMap<>();
                plevelMap.put("plevelMap",personList);
                Attention attention = new Attention();
                List<Project> projectLists = projectDao.ExecuteQueryForList("allProjectList",plevelMap);
                for (Project pt : projectLists) {
                    ContractQueryPara param = new ContractQueryPara();
                    param.setParamByProjectCode(pt.getProjectCode());
                    attention.setUserId(UserId);
                    attention.setProjectCode(pt.getProjectCode());
                    /**
                     * 判断是否关注此项目
                     */
                    int contractCount = contractDao.queryCount(param);
                    pt.setContractCount(contractCount);
                    List<Integer> tempList = attentionDao.ExecuteQueryForList("isAttention", attention);
                    if (tempList.size() > 0) {
                        pt.setAttentionId(tempList.get(0));
                    } else {
                        pt.setAttentionId(0);
                    }
                    projectList.add(pt);
                }

                /**
                 * 通过销售编号  查询
                 */
                /**
                 * 分页
                 */
                int fromIndex = 0; // 开始索引
                int toIndex = 0; // 结束索引
                if (-1 == SizeNum) {
                    fromIndex = 0;
                    toIndex = projectList.size();
                } else {
                    fromIndex = (SkipNum - 1) * SizeNum;
                    toIndex = fromIndex + SizeNum;
                    if(toIndex>projectList.size()){
                        toIndex = projectList.size();
                    }
                }
                List<Object> pageList = projectList.subList(fromIndex, toIndex);
                return pageList;

        }
        throw new PsCoreRuntimeException("option不存在",601);
    }


    /**
     * 手机app首页统计每个销售各项总数
     * 项目总额  待回款 我的项目 我的合同
     * @param Token
     * @return
     */
    @Override
    @RequiresPermissions("ProjectMgeSvr:appFirstPageCount")
    public Map<String,Double> appFirstPageCount(String Token) {

        /**
         * 解析token
         */
        AssertUtils.ThrowArgNullException(Token,"Token",true);
        String UserId = null;
        try {
            UserId = tools.getUserId(Token);
        } catch (IPSFNetException e) {
            e.printStackTrace();
        }
        Map<String,Double> map = new HashMap<>();
        map = projectMgeSvr.appFirstPage(UserId);
        return  map;
    }


    /**
     * 销售主管app首页统计
     * @param Token
     * @return
     */
    @Override
    @RequiresPermissions("ProjectMgeSvr:appFirstPageCountByCharge")
    public Map<String,Object> appFirstPageCountByCharge(String Token) {

        /**
         * 解析token
         */
        AssertUtils.ThrowArgNullException(Token,"Token",true);
        Person person = new Person();
        PersonQueryPara personParam = new PersonQueryPara();
        String UserId = null;
        try {
            UserId = tools.getUserId(Token);
        } catch (IPSFNetException e) {
            e.printStackTrace();
        }
        person.setUniqID(UserId);
        Person person1 = personDao.getDetail(person);
        personParam.setParamByOrganization(person1.getOrganization());
        List<Person> personList = personDao.queryList(personParam,0,-1);
        Map<String,Object> plevelMap = new HashMap<>();
        plevelMap.put("plevelMap",personList);
        List<Integer> plevelList = projectDao.ExecuteQueryForList("customerPlevel",plevelMap);

        /**
         *         map.put("projectTotal",projectTotal);
         *         map.put("alreadyReceivable",receiveTotal);
         *         map.put("projectNumber",lists.size());
         *         map.put("contractTotal",contractTotal);
         *         map.put("waitReceivable",projectTotal-receiveTotal);
         *         map.put("plevelCount",plevelList);
         */
        double projectTotal = 0;
        double alreadyReceivable = 0;
        double projectNumber = 0;
        double contractTotal = 0;
        double waitReceivable = 0;
        for(Person p:personList){
            Map<String,Double> map = new HashMap<>();
            map = projectMgeSvr.appFirstPage(p.getUniqID());
            projectTotal += map.get("projectTotal");
            alreadyReceivable += map.get("alreadyReceivable");
            projectNumber += map.get("projectNumber");
            contractTotal += map.get("contractTotal");
            waitReceivable += map.get("waitReceivable");
        }

        Map<String,Object> map1 = new HashMap<>();
        map1.put("projectTotal",projectTotal);
        map1.put("alreadyReceivable",alreadyReceivable);
        map1.put("projectNumber",projectNumber);
        map1.put("contractTotal",contractTotal);
        map1.put("waitReceivable",waitReceivable);
        map1.put("plevelCount",plevelList);
        return  map1;
    }


    /**
     * 封装单个销售的app首页统计
     * @param UserId
     * @return
     */
    public Map<String,Double> appFirstPage(String UserId){
        ProjectQueryPara param = new ProjectQueryPara();
        param.setParamByUserId(UserId);
        /**
         * 销售所有项目
         */
        List<Project> lists = projectDao.queryList(param, 0, -1);
        Map<String,Double> map = new HashMap<>();
        double projectTotal = 0;
        double receiveTotal = 0;
        double contractTotal = 0;
        for (Project p : lists) {
            /**
             * 获取项目所有合同总额
             */
            List<Contract> contractList = contractDao.ExecuteQueryForList("queryContractListByProjectCodeOp0",p.getProjectCode());
            contractTotal += contractList.size();
            /**
             * 获取所有合同所有回款总和
             */
            if(contractList.size()>0){
                projectTotal += (double) projectDao.ExecuteQueryForObject("getContractAmountByProjectCode", p.getProjectCode());
                for(Contract c:contractList){
                    if(c.getReceivableList()!=null){
                        for(Receivable r1:c.getReceivableList()){
                            receiveTotal += r1.getRecAmount();
                        }
                    }
                }
            }

        }
        map.put("projectTotal",projectTotal);
        map.put("alreadyReceivable",receiveTotal);
        map.put("projectNumber",(double)lists.size());
        map.put("contractTotal",contractTotal);
        map.put("waitReceivable",projectTotal-receiveTotal);
        return  map;
    }



    /**
     * 模糊查询项目信息
     * @param StrField 模糊查询字段.
     * @param Token 查询人token.
     * @param Skip 页数.
     * @param Size 每页数量.
     * @param SimpleOrRich pc端搜索得到简单信息 还是丰富信息
     * @return
     */
    @Override
    @RequiresPermissions("ProjectMgeSvr:getProjectByLike")
    public ProjectList getProjectByLike(String Token,String StrField,int Skip,int Size,int Option,int SimpleOrRich){


        /**
         * 验证token
         * 通过身份查询能看的项目
         * 目前没有身份验证 看的是项目表里所有信息
         */
        String UserId = null;
        try {
            UserId = tools.getUserId(Token);
        } catch (IPSFNetException e) {
            e.printStackTrace();
        }
        /**
         * strField为空则查所有
         * Option:0  模糊查询自己的项目
         * Option:1  模糊查询自己关注的项目
         */
        Attention attention = new Attention();
        HashMap<String,Object> map = new HashMap<>();
        List<Project> strList = new ArrayList<>();
        ProjectList projectList = new ProjectList();
        map.put("StrField",StrField);
        map.put("UserId",UserId);

        switch (Option) {
            case 0:
                /**
                 * app销售存储模糊查询后的列表
                 */
                strList = projectDao.ExecuteQueryForList("getProjectListByLike", map);

                for (Project p : strList) {
                    attention.setUserId(UserId);
                    attention.setProjectCode(p.getProjectCode());
                    /**
                     * 判断是否关注此项目
                     */
                    List<Integer> tempList = attentionDao.ExecuteQueryForList("isAttention", attention);
                    if (tempList.size() > 0) {
                        p.setAttentionId(tempList.get(0));
                    } else {
                        p.setAttentionId(0);
                    }
                }
                break;
            case 1:
                strList = projectDao.ExecuteQueryForList("getAttentionProjectListByLike", map);
                break;

            case 2:
                /**
                 * pc销售主管模糊查询
                 */
                PersonQueryPara personParam = new PersonQueryPara();
                Person person = new Person();
                person.setUniqID(UserId);
                Person person1 = personDao.getDetail(person);
                personParam.setParamByOrganization(person1.getOrganization());
                List<Person> personList = personDao.queryList(personParam, 0, -1);
                Map<String, Object> plevelMap = new HashMap<>();
                plevelMap.put("plevelMap", personList);
                plevelMap.put("StrField",StrField);
                if(0 == SimpleOrRich){
                    strList = projectDao.ExecuteQueryForList("getAllProjectListLike", plevelMap);
                    for (Project p : strList) {

                        ContractQueryPara param = new ContractQueryPara();
                        param.setParamByProjectCode(p.getProjectCode());
                        attention.setUserId(UserId);
                        attention.setProjectCode(p.getProjectCode());
                        /**
                         * 判断是否关注此项目
                         */
                        int contractCount = contractDao.queryCount(param);
                        p.setContractCount(contractCount);
                        List<Integer> tempList = attentionDao.ExecuteQueryForList("isAttention", attention);
                        if (tempList.size() > 0) {
                            p.setAttentionId(tempList.get(0));
                        } else {
                            p.setAttentionId(0);
                        }

                    }
                }else if(1 == SimpleOrRich){
                    strList = projectDao.ExecuteQueryForList("getProjectListByLikeProjectName",plevelMap);
                }
                break;

        }
        /**
         * 分页
         */
        int fromIndex = 0; // 开始索引
        int toIndex = 0; // 结束索引
        if (-1 == Size) {
            fromIndex = 0;
            toIndex = strList.size();
        } else {
            fromIndex = (Skip - 1) * Size;
            toIndex = fromIndex + Size;
        }
        List<Project> pageList = strList.subList(fromIndex, toIndex);
        projectList.addFrom(pageList);
        return projectList;
    }



    /**
     * 修改项目销售负责人  .
     *
     * @param Token token.
     * @param ProjectCode 项目编号.
     */
    @Override
    @RequiresPermissions("ProjectMgeSvr:updateProjectCharger")
    public int updateProjectCharger(String Token,String ProjectCode) {

        /**
         * 解析token 看角色是否有权限
         */
        String UserId = null;
        try {
            UserId = tools.getUserId(Token);
        } catch (IPSFNetException e) {
            e.printStackTrace();
        }
        /**
         * 判断非空
         */
        AssertUtils.ThrowArgNullException(UserId,"UserId",true);
        AssertUtils.ThrowArgNullException(ProjectCode,"ProjectCode",true);
        Project project = new Project();
        project.setUserId(UserId);
        project.setProjectCode(ProjectCode);
        Project selectProject = projectDao.getDetail(project);
        if(selectProject != null){
            int updateCode = projectDao.ExecuteUpdate("updateByPart",project);
            return updateCode;
        }else{
            throw new PsCoreRuntimeException("项目不存在",401);
        }

    }

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
    @Override
    @RequiresPermissions("ProjectMgeSvr:addVisit")
    public Visit addVisit(String Token, String VisitPlanTime, String VisitPlanContent, String VisitFactTime, String VisitFactContent, String VisitRemark, String ProjectCode) throws ParseException {

        /**
         * 验证token
         */
        String UserId = null;
        try {
            UserId = tools.getUserId(Token);
        } catch (IPSFNetException e) {
            e.printStackTrace();
        }

        Visit visit = new Visit();
        visit.setProjectCode(ProjectCode);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        /**
         * 转换时间格式
         */
        if(VisitPlanTime != null && VisitPlanTime !=""){
            AssertUtils.ThrowArgNullException(VisitPlanContent,"VisitPlanContent",true);
            Date newVisitPlanTime = f.parse(VisitPlanTime);
            visit.setVisitPlanTime(newVisitPlanTime);


            Map<String,Object> map = new HashMap<>();
            map.put("VisitPlanTime",VisitPlanTime);
            map.put("UserId",UserId);
            List<Integer> list = visitDao.ExecuteQueryForList("getAllVisitPlan",map);
//            if(list.size()>0){
//                /**
//                 * 当天已经有拜访计划
//                 */
//                throw new PsCoreRuntimeException("当天已经有拜访计划",302);
//
//            }

        }
        if(VisitFactTime != null && VisitFactTime !=""){
            AssertUtils.ThrowArgNullException(VisitFactContent,"VisitFactContent",true);
            Date newVisitFactTime = f.parse(VisitFactTime);//Date格式
            /**
             * 拜访记录选择时间应该只能小于当前时间
             */
            if(newVisitFactTime.getTime() > GetNowTime.getNowTime().getTime()){
                throw new PsCoreRuntimeException("拜访记录选择时间应该只能小于当前时间",303);
            }
            visit.setVisitFactTime(newVisitFactTime);
        }

        /**
         * 拜访计划和单独拜访结果 区分是  单独拜访结果 没有计划时间
         */
        visit.setVisitPlanContent(VisitPlanContent);
        visit.setVisitFactContent(VisitFactContent);
        visit.setVisitRemark(VisitRemark);
        visitDao.insert(visit);
        return visit;
    }

    /**
     * 修改拜访  .
     * 记录和计划都可以在这里修改
     * @param Token token.
     * @param VisitId 拜访ID.
     * @param VisitPlanTime 计划拜访时间.
     * @param VisitPlanContent 计划拜访内容.
     * @param VisitFactTime 实际拜访时间.
     * @param VisitFactContent 实际拜访内容.
     * @param VisitRemark 备注.
     */
    @Override
    @RequiresPermissions("ProjectMgeSvr:updateVisit")
    public int updateVisit(String Token, int VisitId, String VisitPlanTime,String VisitPlanContent,  String VisitFactTime, String VisitFactContent, String VisitRemark){

        /**
         * 验证token
         */
        AssertUtils.ThrowArgZeroException(VisitId,"VisitId");
        Visit visit = new Visit();
        visit.setVisitId(VisitId);
        Visit selectVisit = visitDao.getDetail(visit);
        if(selectVisit != null){
            if(VisitPlanTime != null && VisitPlanTime !=""){
                Date newVisitPlanTime = GetNowTime.parseTime(VisitPlanTime);
                visit.setVisitPlanTime(newVisitPlanTime);
            }
            if(VisitFactTime != null && VisitFactTime !=""){
                Date newVisitFactTime = GetNowTime.parseTime(VisitFactTime);//Date格式
                visit.setVisitFactTime(newVisitFactTime);
            }
            visit.setVisitFactContent(VisitFactContent);
            visit.setVisitPlanContent(VisitPlanContent);
            visit.setVisitRemark(VisitRemark);
            int updateCode = visitDao.ExecuteUpdate("updateVisitPart",visit);
            return updateCode;
        }else{
            throw new PsCoreRuntimeException("拜访记录不存在",301);
        }

    }


    /**
     * (销售主管)删除拜访  .
     *
     * @param Token token.
     * @param VisitId 拜访Id.
     */
    @Override
    @RequiresPermissions("ProjectMgeSvr:deleteVisit")
    public int deleteVisit(String Token, int VisitId) {
        /**
         * 验证token
         */
        AssertUtils.ThrowArgZeroException(VisitId,"VisitId");
        Visit visit = new Visit();
        visit.setVisitId(VisitId);
        Visit selectVisit = visitDao.getDetail(visit);
        if(selectVisit != null){
            int deleteCode = visitDao.delete(visit);
            return deleteCode;
        }else {
            throw new PsCoreRuntimeException("拜访计划不存在",301);
        }

    }

    /**
     * 修改联系人  .
     *
     * @param Token token.
     * @param ProjectCode 项目编号.
     * @param ContactName 联系人姓名.
     * @param ContactTel 联系人电话.
     * @param ContactDuty 联系人职务.
     */
    @Override
    @RequiresPermissions("ProjectMgeSvr:updateProjectContact")
    public int updateProjectContact(String Token, String ProjectCode, String ContactName, String ContactTel, String ContactDuty) {

        /**
         * 验证token
         */
        AssertUtils.ThrowArgNullException(ProjectCode,"ProjectCode",true);
        Project project = new Project();
        project.setProjectCode(ProjectCode);
        Project project1 = projectDao.getDetail(project);
        if(!project1.getContactName().equals(ContactName)){
            project.setContactHistory(project1.getContactHistory() + project1.getContactName()+",");
        }

        project.setContactName(ContactName);
        project.setContactTel(ContactTel);
        project.setContactDuty(ContactDuty);
        int updateCode = projectDao.ExecuteUpdate("updateByPart",project);
        return updateCode;
    }

    /**
     * 修改项目P级  .
     *
     * @param Token token.
     * @param ProjectCode 项目编号.
     * @param ProjectPLevel 项目P级别.
     */
    @Override
    @RequiresPermissions("ProjectMgeSvr:updateProjectPLevel")
    public int updateProjectPLevel(String Token, String ProjectCode, int ProjectPLevel) {
        /**
         * 验证token
         */
        AssertUtils.ThrowArgNullException(ProjectCode,"ProjectCode",true);
        Project project = new Project();
        project.setProjectCode(ProjectCode);
        project.setProjectPLevel(ProjectPLevel);
        int updateCode = projectDao.ExecuteUpdate("updateByPart",project);
        return updateCode;
    }

    /**
     * 近期拜访列表
     * pc销售主管
     * 和app销售
     * @param Token
     * @param Option
     * @return
     */
    @Override
    @RequiresPermissions("ProjectMgeSvr:getRecentVisitList")
    public List<Object> getRecentVisitList(String Token,int Option){

        /**
         * 验证token
         */
        String UserId = null;
        try {
            UserId = tools.getUserId(Token);
        } catch (IPSFNetException e) {
            e.printStackTrace();
        }

        /**
         * 开始时间和范围时间
         */
        HashMap<String,Object> map = new HashMap<>();
        /**
         * 塞选时间范围
         * 暂定一个月之内
         */
        map.put("startTime",GetNowTime.getNowTime());
        map.put("endTime",GetNowTime.getWatiVisitTime(1));


        switch (Option){
            case 0:

                /**
                 * 四个表里取信息
                 * 表联查  获取项目名称 客户名称 联系人 联系电话 销售人员名字 拜访时间
                 */
                map.put("UserId",UserId);
                List<Object> lists = projectDao.ExecuteQueryForList("getRecentVisitList",map);
                return lists;
            case 1:

                Person person = new Person();
                PersonQueryPara personParam = new PersonQueryPara();
                person.setUniqID(UserId);
                Person person1 = personDao.getDetail(person);
                personParam.setParamByOrganization(person1.getOrganization());
                List<Person> personList = personDao.queryList(personParam,0,-1);
                map.put("personList",personList);
                List<Project> saleLists = projectDao.ExecuteQueryForList("getSaleRecentVisitList",map);
                Map<String,Object> plevelMap = new HashMap<>();
                Map<String,Object> map1 = new HashMap<>();
                plevelMap.put("plevelMap",personList);
                List<Map<String,Integer>> plevelList = projectDao.ExecuteQueryForList("customerPlevel",plevelMap);
                List<Project> projectLists = projectDao.ExecuteQueryForList("allProjectList",plevelMap);
                List<Object> list2 = new ArrayList<>();
                int contractCount = 0;
                for(Project p:saleLists){

                    /**
                     * 获取项目所有合同总额
                     */
                    double receiveTotal = 0.0;
                    double contractTotal = 0.0;

                    /**
                     * 获取所有合同已回款信息
                     */
                    List<Contract> contractList = contractDao.ExecuteQueryForList("queryContractListByProjectCodeOp0",p.getProjectCode());
                    if(contractList.size()>0){
                        contractTotal = (double)projectDao.ExecuteQueryForObject("getContractAmountByProjectCode",p.getProjectCode());
                        for(Contract c:contractList){
                            if(c.getReceivableList()!=null){
                                for(Receivable r1:c.getReceivableList()){
                                    receiveTotal += r1.getRecAmount();
                                }
                            }else{
                                System.out.println("没有汇款");
                            }
                        }
                        p.setReceiveTotal(receiveTotal);
                    }
                    p.setContractTotal(contractTotal);
                    p.setPlevelCount(projectLists.size());
                    if(receiveTotal == 0.0 && contractTotal == 0.0){
                        p.setPercentage(0.0);
                    }else{
                        double percentage = receiveTotal / contractTotal;
                        p.setPercentage(percentage);
                    }
                    p.setContractCount(contractList.size());
                    list2.add(p);
                }
                map1.put("plevelList",plevelList);
                list2.add(map1);
                return list2;
        }
        throw new PsCoreRuntimeException("option不存在",601);
    }


    /**
     * 销售关注项目
     * @param Token
     * @param ProjectCode
     * @return
     */
    @Override
    @RequiresPermissions("ProjectMgeSvr:addAttentionProject")
    public Attention addAttentionProject(String Token,String ProjectCode){

        /**
         * 验证token
         */
        AssertUtils.ThrowArgNullException(ProjectCode,"ProjectCode",true);
        String UserId = null;
        try {
            UserId = tools.getUserId(Token);
        } catch (IPSFNetException e) {
            e.printStackTrace();
        }
        AttentionQueryPara param = new AttentionQueryPara();
        param.setParamByUserId(UserId);
        param.setParamByProjectCode(ProjectCode);

        List<Attention> list = attentionDao.queryList(param,0,-1);
        if(list.size()>0){
            throw new PsCoreRuntimeException("项目已经被收藏",501);
        }
        Attention attention = new Attention();
        attention.setProjectCode(ProjectCode);
        attention.setUserId(UserId);
        attentionDao.insert(attention);
        return attention;

    }

    /**
     * 删除关注的项目
     * @param Token
     * @param AttentionId
     * @return
     */
    @Override
    @RequiresPermissions("ProjectMgeSvr:deleteAttention")
    public int deleteAttention(String Token,int AttentionId){

        AssertUtils.ThrowArgZeroException(AttentionId,"AttentionId");
        Attention attention = new Attention();
        attention.setAttentionId(AttentionId);
        Attention selectAttention = attentionDao.getDetail(attention);
        int deleteCode;
        if(selectAttention != null){
            deleteCode = attentionDao.delete(attention);
        }else{
            throw new PsCoreRuntimeException("项目未关注",502);
        }
        return deleteCode;
    }

    /**
     * 销售查看自己的关注的项目
     * 暂时销售和销售主管调用一个接口进行测试
     * @return
     */
    @Override
    @RequiresPermissions("ProjectMgeSvr:getAttentionList")
    public List<Object> getAttentionList(String Token,int SkipNum,int SizeNum) {

        /**
         * 验证token
         */
        AssertUtils.ThrowArgNullException(Token,"token",true);
        String UserId = null;
        try {
            UserId = tools.getUserId(Token);
        } catch (IPSFNetException e) {
            e.printStackTrace();
        }

        /**
         * 显示关注项目列表
         */
        JSONObject jsonObject = new JSONObject();
        List<Object> attentionList = new ArrayList<>();
        List<Object> list = attentionDao.ExecuteQueryForList("getAttentionByUserId", UserId);
        for(Object object:list){
            /**
             * 未收完款的合同列表
             */
            List<Object> notFinishContractList = new ArrayList<>();
            String jsonStr = jsonObject.toJSONString(object);
            jsonObject = jsonObject.parseObject(jsonStr);
            String projectCode = jsonObject.getString("ProjectCode");
            /**
             * 获取项目所有合同总额
             * 项目回款信息
             */
            double projectReceiveTotal = 0;
            double projectAllContractTotal = 0;
            /**
             * 获取所有合同已回款信息
             */
            List<Contract> contractList = contractDao.ExecuteQueryForList("queryContractListByProjectCodeOp0", projectCode);
            jsonObject.put("ContractCount",contractList.size());
            if(contractList.size()>0){
                /**
                 * 项目所有合同总额
                 */

                projectAllContractTotal = (double) projectDao.ExecuteQueryForObject("getContractAmountByProjectCode",projectCode);
                for (Contract c : contractList) {
                    /**
                     * 未收完款的单条合同信息  合同名：待收款
                     */
                    Map<String,Object> map = new HashMap<>();
                    double contractReceiveTotal = 0;
                    if (c.getReceivableList() != null) {
                        for (Receivable r1 : c.getReceivableList()) {
                            projectReceiveTotal += r1.getRecAmount();
                            contractReceiveTotal += r1.getRecAmount();

                        }
                    } else {
                        projectReceiveTotal += 0;
                    }
                    /**
                     *
                     * 获取未收完款的合同
                     */
                    if(contractReceiveTotal != c.getContractAmount()){
                        map.put("notReceivable",c.getContractAmount()-contractReceiveTotal);
                        map.put("contractName",c.getContractName());
                        map.put("contractCode",c.getContractCode());
                        notFinishContractList.add(map);
                    }
                }
            }
            jsonObject.put("notFinishContractList",notFinishContractList);
            jsonObject.put("projectAllContractTotal",projectAllContractTotal);
            jsonObject.put("notReceiveTotal",projectAllContractTotal-projectReceiveTotal);
            jsonObject.put("receiveTotal",projectReceiveTotal);
            jsonObject.put("projectPercentage",projectReceiveTotal/projectAllContractTotal);
            attentionList.add(jsonObject);
        }
        /**
         * 分页
         */
        int fromIndex = 0; // 开始索引
        int toIndex = 0; // 结束索引
        if (-1 == SizeNum) {
            fromIndex = 0;
            toIndex = attentionList.size();
        } else {
            fromIndex = (SkipNum - 1) * SizeNum;
            toIndex = fromIndex + SizeNum;
            if(toIndex>attentionList.size()){
                toIndex = attentionList.size();
            }
        }
        attentionList = attentionList.subList(fromIndex,toIndex);
        return attentionList;
    }


    /**
     * 包含已有项目三个月拜访计划和拜访记录都没有的
     * 已经有计划和记录 但是三个月没有再次完善的
     * option:0 销售主管查看所有销售长时间未拜访的项目
     * option:1 销售查看自己产时间未拜访的项目
     * @param Token
     * @return
     */
    @Override
    @RequiresPermissions("ProjectMgeSvr:longTimeNotHaveVisit")
    public List<Project> longTimeNotHaveVisit(String Token,int Option,int SizeNum,int SkipNum){

        /**
         * 解析token
         */
        String UserId = null;
        try {
            UserId = tools.getUserId(Token);
        } catch (IPSFNetException e) {
            e.printStackTrace();
        }
        Person person = new Person();
        PersonQueryPara personParam = new PersonQueryPara();
        person.setUniqID(UserId);
        Person person1 = personDao.getDetail(person);
        List<Person> personList = new ArrayList<>();
        Map<String,Object> notHaveVisitMap = new HashMap<>();
        switch (Option){
            case 0:
                /**
                 * 获取组织下所有人
                 */
                personParam.setParamByOrganization(person1.getOrganization());
                personList = personDao.queryList(personParam,0,-1);
                notHaveVisitMap.put("personList",personList);
                break;
            case 1:
                /**
                 * 销售消息提醒
                 */
                personList.add(person1);
                notHaveVisitMap.put("personList",personList);
                break;
        }
        /**
         * 当前时间少三个月进行比较
         */
        notHaveVisitMap.put("endTime",GetNowTime.getWatiVisitTime(-3));
        /**
         * 三个月项目都没有拜访计划和记录的
         */
        List<Project> list = projectDao.ExecuteQueryForList("longTimeNotHaveVisit",notHaveVisitMap);


        /**
         * 有拜访计划和记录 但是三个月没有继续跟进的  项目状态为未完成的
         */

        List<String> list1 = projectDao.ExecuteQueryForList("longTimeNotHaveVisitProjectCode",notHaveVisitMap);
        notHaveVisitMap.put("projectCodeList",list1);
        List<Project> projectLists = new ArrayList<>();

        if(list.size()>0){
            for(Project p:list){
                Attention attention = new Attention();
                attention.setProjectCode(p.getProjectCode());
                attention.setUserId(UserId);
                List<Integer> tempList = attentionDao.ExecuteQueryForList("isAttention", attention);
                if(tempList.size()>0){
                    p.setAttentionId(tempList.get(0));
                }
                projectLists.add(p);
            }
        }
        if(list1.size()>0){
            List<Project> list2 = projectDao.ExecuteQueryForList("longTimeNotHaveVisit1",notHaveVisitMap);

            for(Project p:list2){
                Attention attention = new Attention();
                attention.setProjectCode(p.getProjectCode());
                attention.setUserId(UserId);
                List<Integer> tempList = attentionDao.ExecuteQueryForList("isAttention", attention);
                if(tempList.size()>0){
                    p.setAttentionId(tempList.get(0));
                }
                projectLists.add(p);
            }
        }
        /**
         * 分页
         */
        int fromIndex = 0; // 开始索引
        int toIndex = 0; // 结束索引
        if (-1 == SizeNum) {
            fromIndex = 0;
            toIndex = projectLists.size();
        } else {
            fromIndex = (SkipNum - 1) * SizeNum;
            toIndex = fromIndex + SizeNum;
            if(toIndex>projectLists.size()){
                toIndex = projectLists.size();
            }
        }
        List<Project> resultProjectLists = projectLists.subList(fromIndex,toIndex);
        return resultProjectLists;
    }
}


