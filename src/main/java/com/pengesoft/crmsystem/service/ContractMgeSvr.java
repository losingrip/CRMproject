package com.pengesoft.crmsystem.service;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.pengesoft.crmsystem.component.tools;
import com.pengesoft.crmsystem.domain.QueryPara.ContractQueryPara;
import com.pengesoft.crmsystem.domain.dao.ContractDao;
import com.pengesoft.crmsystem.domain.dao.ProjectDao;
import com.pengesoft.crmsystem.domain.entity.*;
import com.pengesoft.crmsystem.domain.entitylist.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pengesoft.account.Person;
import pengesoft.account.dao.PersonDao;
import pengesoft.auth.annotation.RequiresPermissions;
import pengesoft.common.IPSFNetException;
import pengesoft.core.PsCoreRuntimeException;
import pengesoft.service.ApplicationBase;
import pengesoft.utils.AssertUtils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * IContractMgeSvr 接口实现。项目服务.
 *
 * @auther: 余展鹏.
 * @date: 2020/3/31 14:02:06.
 * <p>
 * Copyright (C) 2008 - 鹏业软件公司
 */
@Service
@Transactional
public class ContractMgeSvr extends ApplicationBase implements IContractMgeSvr {

    @Autowired
    private ContractDao contractDao;
    @Autowired
    private ProjectDao projectDao;
    @Autowired
    private CustomerMgeSvr customerMgeSvr;
    @Value("${dayNum}")
    private int dayNum;
    @Value("${dayNum2}")
    private int dayNum2;
    @Value("${dayNum3}")
    private int dayNum3;

    @Autowired
    private PersonDao personDao;

    /**
     * 构造方法
     */
    @Autowired
    public ContractMgeSvr() {
        //TODO: 通过构造方法参数设置依赖注入.
    }

    /**
     * 添加合同  .
     *
     * @param token                token.
     * @param ContractCode         合同编号.
     * @param ProjectCode          项目编号.
     * @param ContractName         合同名称.
     * @param ContractType         合同类型.
     * @param ContractStatus       合同状态.
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
    @Override
    @RequiresPermissions("Contract:addContract")
    public Contract addContract(String token, String ContractCode, String ProjectCode, String ContractName, int ContractType, int ContractStatus, String PartyA, String PartyB, String PartyC, double ContractAmount, String ContractParentCode, Date ContractSignTime, Date ContractEndTime, Date ContractEffectTime, Date ContractNoEffectTime, String ContractRemark) {
        AssertUtils.ThrowArgNullException(ContractCode, "ContractCode");
        AssertUtils.ThrowArgNullException(ContractName, "ContractName");
        AssertUtils.ThrowArgZeroException(ContractAmount, "ContractAmount");
        AssertUtils.ThrowArgNullException(ContractSignTime, "ContractSignTime");

        Contract contract = new Contract();
        contract.setContractCode(ContractCode);
        Contract contract_db = contractDao.getDetail(contract);
        if (contract_db == null) {
            contract.setContractName(ContractName);
            contract.setContractType(ContractType);

            contract.setPartyB("成都鹏业软件股份有限公司");
            contract.setPartyC(PartyC);
            contract.setContractAmount(ContractAmount);
            contract.setContractNotYetRec(ContractAmount);
            contract.setContractAlreadyRec(0);
            if (ContractParentCode != null) {
                contract.setContractParentCode(ContractParentCode);
            }

            contract.setProjectCode(ProjectCode);
            contract.setPartyA(PartyA);

            contract.setContractSignTime(ContractSignTime);
            contract.setContractEndTime(ContractEndTime);
            contract.setContractEffectTime(ContractEffectTime);
            contract.setContractNoEffectTime(ContractNoEffectTime);
            contract.setContractStatus(ContractStatus);
            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            contract.setContractCreateTime(timestamp);
            contract.setContractRemark(ContractRemark);
            contractDao.insert(contract);
            Contract newContract = contractDao.getDetail(contract);
            return newContract;
        } else {
            throw new PsCoreRuntimeException("合同编号已存在", 801);
        }
    }

    /**
     * 修改合同信息  .
     *
     * @param token                token.
     * @param ContractCode         合同编号.
     * @param ProjectCode          项目编号.
     * @param ContractEffectTime   合同生效时间.
     * @param ContractNoEffectTime 合同失效时间.
     * @param ContractName         合同名称.
     * @param ContractType         合同类型.
     * @param ContractStatus       合同状态.
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
    @Override
    @RequiresPermissions("Contract:updateContract")
    public int updateContract(String token, String ContractCode, String ProjectCode, Date ContractEffectTime, Date ContractNoEffectTime, String ContractName, int ContractType, int ContractStatus, String PartyA, String PartyB, String PartyC, double ContractAmount, String ContractParentCode, Date ContractSignTime, Date ContractEndTime, String ContractRemark) {
        //TODO: 
        AssertUtils.ThrowArgNullException(ContractCode, "ContractCode");
        AssertUtils.ThrowArgNullException(PartyA, "PartyA");
        Contract contract = new Contract();
        contract.setContractCode(ContractCode);
        Contract contract_db = contractDao.getDetail(contract);


        if (contract_db != null) {
            contract_db.setContractCode(ContractCode);

            contract_db.setProjectCode(ProjectCode);
            contract_db.setContractEffectTime(ContractEffectTime);
            contract_db.setContractNoEffectTime(ContractNoEffectTime);
            contract_db.setContractName(ContractName);
            contract_db.setContractType(ContractType);
            contract_db.setPartyA(PartyA);
            contract_db.setPartyB(PartyB);
            contract_db.setPartyC(PartyC);
            contract_db.setContractStatus(ContractStatus);
            contract_db.setContractAmount(ContractAmount);
            contract_db.setContractParentCode(ContractParentCode);
            contract_db.setContractSignTime(ContractSignTime);
            contract_db.setContractEndTime(ContractEndTime);
            contract_db.setContractRemark(ContractRemark);
            Contract contract_dbNew = setContractInnerListTotalCount(contract_db);
            contractDao.update(contract_dbNew);
            int n = contractDao.ExecuteUpdate("updateContractByContractCode", contract_dbNew);
            return n;
        } else {
            throw new PsCoreRuntimeException("原合同编号不存在", 802);
        }

    }

    /**
     * 删除合同信息  .
     *
     * @param token        token.
     * @param ContractCode 合同编号.
     */
    @Override
    @RequiresPermissions("Contract:deleteContract")
    public int deleteContract(String token, String ContractCode) {
        //TODO: .
        AssertUtils.ThrowArgNullException(ContractCode, "ContractCode");
        String[] ContractCode_Arr = AnalyseStr(ContractCode);
        int n = contractDao.ExecuteDelete("batchDeleteContractByContractCode", ContractCode_Arr);
        return n;
    }


    /**
     * 销售获取自己的合同列表
     *
     * @param token   token.
     * @param Option  选项.
     * @param SortNum 排序选项.
     */
    @Override
    @RequiresPermissions("Contract:getOwnContractList")
    public ProjectContractRetList getOwnContractList(String token, String ProjectCode, int Option, int SortNum) {
        //(单独查看自己合同列表，销售身份)
        String UserId = null;
        try {
            UserId = tools.getUserId(token);
        } catch (IPSFNetException e) {
            e.printStackTrace();
        }
        if (UserId == null) {
            throw new PsCoreRuntimeException("用户Id为空", 701);
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("UserId", UserId);
        hashMap.put("ProjectCode", ProjectCode);
        if (ProjectCode != null) {//角色条件没加
            List<ProjectContractRet> projectContractRetList_db = contractDao.ExecuteQueryForList("queryContractProjectByProjectCodeForSeller", hashMap);
            List<ProjectContractRet> projectContractRets = new ArrayList<>();
            for (ProjectContractRet pcr :
                    projectContractRetList_db) {
                if (pcr.getPhaseList() != null) {
                    List<Phase> phases = pcr.getPhaseList().getItems();
                    for (int i = 0; i < phases.size(); i++) {
                        for (int j = 1; j < phases.size() - i; j++) {
                            Phase p = new Phase();
                            if ((phases.get(j - 1).getPlanTime()).compareTo(phases.get(j).getPlanTime()) > 0) { // 比较两个整数的大小

                                p = phases.get(j - 1);
                                phases.set((j - 1), phases.get(j));
                                phases.set(j, p);
                            }
                        }
                    }

                    PhaseList phaseList = new PhaseList();
                    phaseList.addFrom(phases);
                    phaseList.setTotalCount(phases.size());
                    pcr.setPhaseList(phaseList);

                    for (int i = 0; i < phases.size(); i++) {
                        if (phases.get(i).getFactTime() != null) {
                            phases.remove(i);
                        }
                    }
                    if (phases != null) {
                        pcr.setRecentPhase(phases.get(0));
                    }
                    projectContractRets.add(pcr);
                } else {
                    projectContractRets.add(pcr);
                }
            }


            ProjectContractRetList projectContractRetList = new ProjectContractRetList();
            projectContractRetList.addFrom(projectContractRets);
            projectContractRetList.setTotalCount(projectContractRets.size());
            return projectContractRetList;
        } else {


            switch (Option) {
                case 0: {
                    if (SortNum == 0) {
                        List<ProjectContractRet> projectContractRetList_db = contractDao.ExecuteQueryForList("queryProjectContractForApp", UserId);
                        ProjectContractRetList projectContractRetList = new ProjectContractRetList();
                        projectContractRetList.setTotalCount(projectContractRetList_db.size());
                        projectContractRetList.addFrom(projectContractRetList_db);
                        return projectContractRetList;
                    } else if (SortNum == 1) {
                        List<ProjectContractRet> projectContractRetList_db1 = contractDao.ExecuteQueryForList("queryProjectContractForAppSortNum1", UserId);
                        List<ProjectContractRet> projectContractRetList_db = setContractInvAndRecStatus(projectContractRetList_db1);
                        ProjectContractRetList projectContractRetList = new ProjectContractRetList();
                        projectContractRetList.addFrom(projectContractRetList_db);
                        projectContractRetList.setTotalCount(projectContractRetList.size());
                        return projectContractRetList;
                    } else if (SortNum == 2) {
                        List<ProjectContractRet> projectContractRetList_db1 = contractDao.ExecuteQueryForList("queryProjectContractForAppSortNum2", UserId);
                        List<ProjectContractRet> projectContractRetList_db = setContractInvAndRecStatus(projectContractRetList_db1);
                        ProjectContractRetList projectContractRetList = new ProjectContractRetList();
                        projectContractRetList.addFrom(projectContractRetList_db);
                        projectContractRetList.setTotalCount(projectContractRetList.size());
                        return projectContractRetList;
                    } else if (SortNum == 3) {
                        List<ProjectContractRet> projectContractRetList_db1 = contractDao.ExecuteQueryForList("queryProjectContractForAppSortNum3", UserId);
                        List<ProjectContractRet> projectContractRetList_db = setContractInvAndRecStatus(projectContractRetList_db1);
                        ProjectContractRetList projectContractRetList = new ProjectContractRetList();
                        projectContractRetList.addFrom(projectContractRetList_db);
                        projectContractRetList.setTotalCount(projectContractRetList.size());
                        return projectContractRetList;
                    } else if (SortNum == 4) {
                        List<ProjectContractRet> projectContractRetList_db1 = contractDao.ExecuteQueryForList("queryProjectContractForAppSortNum4", UserId);
                        List<ProjectContractRet> projectContractRetList_db = setContractInvAndRecStatus(projectContractRetList_db1);
                        ProjectContractRetList projectContractRetList = new ProjectContractRetList();
                        projectContractRetList.addFrom(projectContractRetList_db);
                        projectContractRetList.setTotalCount(projectContractRetList.size());
                        return projectContractRetList;
                    }
                }
                case 1: {
                    List<ProjectContractRet> projectContractRetList_db = contractDao.ExecuteQueryForList("queryProjectContractForAppOption1", UserId);
                    ProjectContractRetList projectContractRetList = new ProjectContractRetList();
                    projectContractRetList.setTotalCount(projectContractRetList_db.size());
                    projectContractRetList.addFrom(projectContractRetList_db);
                    return projectContractRetList;
                }
                case 2: {
                    List<ProjectContractRet> projectContractRetList_db = contractDao.ExecuteQueryForList("queryProjectContractForAppOption2", UserId);
                    ProjectContractRetList projectContractRetList = new ProjectContractRetList();
                    projectContractRetList.setTotalCount(projectContractRetList_db.size());
                    projectContractRetList.addFrom(projectContractRetList_db);
                    return projectContractRetList;
                }
                case 3: {
                    List<ProjectContractRet> projectContractRetList_db = contractDao.ExecuteQueryForList("queryProjectContractForAppCase3", UserId);
                    List<ProjectContractRet> projectContractRets = new ArrayList<>();
                    for (ProjectContractRet pcr :
                            projectContractRetList_db) {
                        List<String> list = new ArrayList<>();
                        for (Phase phase :
                                pcr.getPhaseList().getItems()) {
                            if (phase.getFactTime() == null) {
                                //半年前的时间
                                Calendar cal1 = Calendar.getInstance();
                                cal1.add(Calendar.MONTH, -6);
                                cal1.set(Calendar.DAY_OF_MONTH, cal1.getActualMinimum(Calendar.DAY_OF_MONTH));
                                //一个月以后
                                Calendar cal2 = Calendar.getInstance();
                                cal2.add(Calendar.MONTH, 1);//获取当前时间的下一个月
                                cal2.set(Calendar.DAY_OF_MONTH, cal2.getActualMaximum(Calendar.DAY_OF_MONTH));//获取下一个月的最后一天
                                if (!(phase.getPlanTime().before(cal1.getTime())) || !phase.getPlanTime().after(cal2.getTime())) {
                                    list.add(pcr.getContractName());
                                }
                            }
                        }
                        if (list.size() != 0) {
                            projectContractRets.add(pcr);
                        }
                    }
                    ProjectContractRetList projectContractRetList = new ProjectContractRetList();
                    projectContractRetList.setTotalCount(projectContractRets.size());
                    projectContractRetList.addFrom(projectContractRets);
                    return projectContractRetList;
                }
            }
        }
        return null;
    }


    /**
     * (从项目进)获取合同列表（如果有项目编号就从项目进，如果没有就是从合同进）  .
     *
     * @param token       token.
     * @param sizeNum     sizeNum.
     * @param skipNum     skipNum.
     * @param ProjectCode 项目编号.
     * @param Option      选项.
     * @param SortNum     排序数字.
     */
    @Override
    @RequiresPermissions("Contract:getContractList")
    public ProjectContractRetList getContractList(String token, int sizeNum, int skipNum, String ProjectCode, int Option, int SortNum) {


        int a = (skipNum - 1) * sizeNum;
        if (skipNum == 0) {
            a = 0;
        }
        if (sizeNum == 0) {
            sizeNum = -1;
        }
//查询项目下对应合同列表
        if (ProjectCode != null) {//角色条件没加
            List<ProjectContractRet> projectContractRetList_db = contractDao.ExecuteQueryForList("queryContractProjectByProjectCode", ProjectCode, a, sizeNum);
            List<ProjectContractRet> projectContractRets = new ArrayList<>();
            for (ProjectContractRet pcr :
                    projectContractRetList_db) {
                if (pcr.getPhaseList() != null) {
                    List<Phase> phases = pcr.getPhaseList().getItems();
                    for (int i = 0; i < phases.size(); i++) {
                        for (int j = 1; j < phases.size() - i; j++) {
                            Phase p = new Phase();
                            if ((phases.get(j - 1).getPlanTime()).compareTo(phases.get(j).getPlanTime()) > 0) { // 比较两个整数的大小

                                p = phases.get(j - 1);
                                phases.set((j - 1), phases.get(j));
                                phases.set(j, p);
                            }
                        }
                    }

                    PhaseList phaseList = new PhaseList();
                    phaseList.addFrom(phases);
                    phaseList.setTotalCount(phases.size());
                    pcr.setPhaseList(phaseList);

                    for (int i = 0; i < phases.size(); i++) {
                        if (phases.get(i).getFactTime() != null) {
                            phases.remove(i);
                        }
                    }
                    if (phases.size() != 0) {
                        pcr.setRecentPhase(phases.get(0));
                    }
                    projectContractRets.add(pcr);
                } else {
                    projectContractRets.add(pcr);
                }
            }


            ProjectContractRetList projectContractRetList = new ProjectContractRetList();
            projectContractRetList.addFrom(projectContractRets);
            projectContractRetList.setTotalCount(projectContractRets.size());

            return setSellerNameByContractCode(projectContractRetList);
        }//单独查看所有合同列表(销售主管或领导等)
        else if (ProjectCode == null || ProjectCode == "") {//角色条件没加
            switch (Option) {
                case 0: {
                    if (SortNum == 0) {
                        List<ProjectContractRet> projectContractRetList_db1 = contractDao.ExecuteQueryForList("queryContractProject", null, a, sizeNum);
                        List<ProjectContractRet> projectContractRetList_db = setContractInvAndRecStatus(projectContractRetList_db1);
                        ProjectContractRetList projectContractRetList = new ProjectContractRetList();
                        projectContractRetList.addFrom(projectContractRetList_db);
                        projectContractRetList.setTotalCount(projectContractRetList.size());
                        return setSellerNameByContractCode(projectContractRetList);
                    } else if (SortNum == 1) {
                        List<ProjectContractRet> projectContractRetList_db1 = contractDao.ExecuteQueryForList("queryContractProjectSortNum1", null, a, sizeNum);
                        List<ProjectContractRet> projectContractRetList_db = setContractInvAndRecStatus(projectContractRetList_db1);
                        ProjectContractRetList projectContractRetList = new ProjectContractRetList();
                        projectContractRetList.addFrom(projectContractRetList_db);
                        projectContractRetList.setTotalCount(projectContractRetList.size());
                        return setSellerNameByContractCode(projectContractRetList);
                    } else if (SortNum == 2) {
                        List<ProjectContractRet> projectContractRetList_db1 = contractDao.ExecuteQueryForList("queryContractProjectSortNum2", null, a, sizeNum);
                        List<ProjectContractRet> projectContractRetList_db = setContractInvAndRecStatus(projectContractRetList_db1);
                        ProjectContractRetList projectContractRetList = new ProjectContractRetList();
                        projectContractRetList.addFrom(projectContractRetList_db);
                        projectContractRetList.setTotalCount(projectContractRetList.size());
                        return setSellerNameByContractCode(projectContractRetList);
                    } else if (SortNum == 3) {
                        List<ProjectContractRet> projectContractRetList_db1 = contractDao.ExecuteQueryForList("queryContractProjectSortNum3", null, a, sizeNum);
                        List<ProjectContractRet> projectContractRetList_db = setContractInvAndRecStatus(projectContractRetList_db1);
                        ProjectContractRetList projectContractRetList = new ProjectContractRetList();
                        projectContractRetList.addFrom(projectContractRetList_db);
                        projectContractRetList.setTotalCount(projectContractRetList.size());
                        return setSellerNameByContractCode(projectContractRetList);
                    } else if (SortNum == 4) {
                        List<ProjectContractRet> projectContractRetList_db1 = contractDao.ExecuteQueryForList("queryContractProjectSortNum4", null, a, sizeNum);
                        List<ProjectContractRet> projectContractRetList_db = setContractInvAndRecStatus(projectContractRetList_db1);
                        ProjectContractRetList projectContractRetList = new ProjectContractRetList();
                        projectContractRetList.addFrom(projectContractRetList_db);
                        projectContractRetList.setTotalCount(projectContractRetList.size());
                        return setSellerNameByContractCode(projectContractRetList);
                    }
                }
                case 1: {
                    List<ProjectContractRet> projectContractRetList_db = contractDao.ExecuteQueryForList("queryContractProjectOption1", null, a, sizeNum);
                    ProjectContractRetList projectContractRetList = new ProjectContractRetList();
                    projectContractRetList.addFrom(projectContractRetList_db);
                    projectContractRetList.setTotalCount(projectContractRetList.size());

                    return setSellerNameByContractCode(projectContractRetList);
                }
                case 2: {
                    List<ProjectContractRet> projectContractRetList_db = contractDao.ExecuteQueryForList("queryContractProjectOption2", null, a, sizeNum);
                    ProjectContractRetList projectContractRetList = new ProjectContractRetList();
                    projectContractRetList.addFrom(projectContractRetList_db);
                    projectContractRetList.setTotalCount(projectContractRetList.size());

                    return setSellerNameByContractCode(projectContractRetList);
                }
                case 3: {
                    List<ProjectContractRet> projectContractRetList_db1 = contractDao.ExecuteQueryForList("queryContractProjectOption3", null, a, sizeNum);
                    List<ProjectContractRet> projectContractRetList_db = setContractInvAndRecStatus(projectContractRetList_db1);
                    ProjectContractRetList projectContractRetList = new ProjectContractRetList();
                    projectContractRetList.addFrom(projectContractRetList_db);
                    projectContractRetList.setTotalCount(projectContractRetList.size());

                    return setSellerNameByContractCode(projectContractRetList);
                }


            }


        }
        return null;
    }


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
    @Override
    @RequiresPermissions("Contract:fuzzySearchContract")
    public ProjectContractRetList fuzzySearchContract(String token, int sizeNum, int skipNum, String SearchCondition, Date ContractStartTime, Date ContractEndTime, int Option) {
        //TODO: .
        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//设置日期格式
        String startTime = "";
        String endTime = "";
        double allmoney=0.0,readymoney=0.0;
        Map<Object,Object> map =new HashMap<Object, Object>();
        if (ContractStartTime != null) {
            startTime = df.format(ContractStartTime);

        }
        if (ContractEndTime != null) {
            endTime = df.format(ContractEndTime);
        }
        int a = (skipNum - 1) * sizeNum;
        if (skipNum == 0) {
            a = 0;
        }
        if (sizeNum == 0) {
            sizeNum = 10;
        }
        HashMap<String, Object> conditionMap = new HashMap<>();

        switch (Option) {
            case 1: {
                if (SearchCondition == null || SearchCondition == "") {
                    conditionMap.put("SearchCondition", null);
                } else {
                    conditionMap.put("SearchCondition", SearchCondition);
                }

                if (ContractStartTime == null) {
                    conditionMap.put("ContractStartTime", null);
                } else {
                    conditionMap.put("ContractStartTime", startTime);
                }

                if (ContractEndTime == null) {
                    conditionMap.put("ContractEndTime", null);
                } else {
                    conditionMap.put("ContractEndTime", endTime);
                }
                List<ProjectContractRet> projectContractRetList_db = contractDao.ExecuteQueryForList("queryContractProjectBySearchCondition", conditionMap);
                //查出来的统计
                for (ProjectContractRet projectContractRet:projectContractRetList_db){
                    allmoney += projectContractRet.getContractAmount();
                    readymoney += projectContractRet.getContractNotYetRec();
                }
                ProjectContractRetList projectContractRetList = new ProjectContractRetList();
                projectContractRetList.addFrom(projectContractRetList_db);
                projectContractRetList.setTotalCount(projectContractRetList.size());
                map.put("projectContractRetList",projectContractRetList);
                map.put("allmoney",allmoney);
                map.put("readymoney",readymoney);
                return projectContractRetList;
//                return projectContractRetList;
            }
            case 2: {
                if (SearchCondition == null || SearchCondition == "") {
                    conditionMap.put("SearchCondition", null);
                } else {
                    conditionMap.put("SearchCondition", SearchCondition);
                }
                try {
                    conditionMap.put("UniqID", tools.getUserId(token));

                } catch (IPSFNetException e) {
                    e.printStackTrace();
                }
                List<ProjectContractRet> projectContractRetList_db = contractDao.ExecuteQueryForList("queryOwnContractProjectBySearchCondition", conditionMap);
                //查出来的统计
                for (ProjectContractRet projectContractRet:projectContractRetList_db){
                    allmoney += projectContractRet.getContractAmount();
                    readymoney += projectContractRet.getContractNotYetRec();
                }
                map.put("allmoney",allmoney);
                map.put("readymoney",readymoney);

                ProjectContractRetList projectContractRetList = new ProjectContractRetList();
                projectContractRetList.addFrom(projectContractRetList_db);
                projectContractRetList.setTotalCount(projectContractRetList.size());
                map.put("projectContractRetList",projectContractRetList);
                return projectContractRetList;
            }
            case 3: {
                if (SearchCondition == null || SearchCondition == "") {
                    conditionMap.put("SearchCondition", null);
                } else {
                    conditionMap.put("SearchCondition", SearchCondition);
                }
                List<ProjectContractRet> projectContractRetList_db = contractDao.ExecuteQueryForList("queryContractNameBySearchCondition", conditionMap);
                //查出来的统计
                for (ProjectContractRet projectContractRet:projectContractRetList_db){
                    allmoney += projectContractRet.getContractAmount();
                    readymoney += projectContractRet.getContractNotYetRec();
                }
                map.put("allmoney",allmoney);
                map.put("readymoney",readymoney);
                ProjectContractRetList projectContractRetList = new ProjectContractRetList();
                projectContractRetList.addFrom(projectContractRetList_db);
                projectContractRetList.setTotalCount(projectContractRetList.size());
                map.put("projectContractRetList",projectContractRetList);
                return projectContractRetList;
            }
            case 4: {
                if (SearchCondition == null || SearchCondition == "") {
                    conditionMap.put("SearchCondition", null);
                } else {
                    conditionMap.put("SearchCondition", SearchCondition);
                }
                try {
                    conditionMap.put("UniqID", tools.getUserId(token));

                } catch (IPSFNetException e) {
                    e.printStackTrace();
                }
              //  List<ProjectContractRet> projectContractRetList_db = contractDao.ExecuteQueryForList("queryOwnContractProjectBySearchConditionForSeller", conditionMap);
              //不能sql来进行模糊
                ProjectContractRetList projectContractRetList_db  =   getOwnContractList(token,null,3,0);
                ProjectContractRetList projectContractRetList = new ProjectContractRetList();
                List<ProjectContractRet> projectContractRetList1 = new ArrayList<>();
                if(projectContractRetList_db!=null){
                    List<ProjectContractRet> projectContractRets =projectContractRetList_db.getItems();
                    Pattern pattern = Pattern.compile(SearchCondition);
                    for (ProjectContractRet pcr:
                    projectContractRets) {
                     /*   ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                                .withMatcher("ContractCode",ExampleMatcher.GenericPropertyMatchers.contains())
                                .withMatcher("ContractName",ExampleMatcher.GenericPropertyMatchers.contains())
                                .withMatcher("ContractType",ExampleMatcher.GenericPropertyMatchers.contains())
                                .withMatcher("PartyA",ExampleMatcher.GenericPropertyMatchers.contains())
                                .withMatcher("PartyB",ExampleMatcher.GenericPropertyMatchers.contains())
                                .withMatcher("PartyC",ExampleMatcher.GenericPropertyMatchers.contains())
                                .withMatcher("ContractParentCode",ExampleMatcher.GenericPropertyMatchers.contains())
                                .withMatcher("ContractRemark",ExampleMatcher.GenericPropertyMatchers.contains())
                                .withMatcher("ProjectName",ExampleMatcher.GenericPropertyMatchers.contains());
                        Example<ProjectContractRet> example = Example.of(pcr,exampleMatcher);
                        projectContractRetList1.add(example.getProbe());*/
                        Matcher matcher = pattern.matcher(pcr.getContractCode());
                        Matcher matcher1 = pattern.matcher(pcr.getContractName());
                        Matcher matcher2 = pattern.matcher(Integer.toString(pcr.getContractType()));
                        Matcher matcher3 ;
                        if(pcr.getPartyA()!=null){
                            matcher3 = pattern.matcher(pcr.getPartyA());
                        }else{
                            matcher3 =  pattern.matcher("");
                        }
                        Matcher matcher4 ;
                        if(pcr.getPartyB()!=null){
                            matcher4  = pattern.matcher(pcr.getPartyB());
                        }else{
                            matcher4 =  pattern.matcher("");
                        }
                        Matcher matcher5 ;
                        if(pcr.getPartyC()!=null){
                            matcher5  = pattern.matcher(pcr.getPartyC());
                        }else{
                            matcher5 = pattern.matcher("");
                        }
                        Matcher matcher6 ;
                        if(pcr.getContractParentCode()!=null){
                            matcher6  = pattern.matcher(pcr.getContractParentCode());
                        }else{
                            matcher6 =  pattern.matcher("");
                        }
                        Matcher matcher7 ;
                        if(pcr.getContractRemark()!=null){
                            matcher7  = pattern.matcher(pcr.getContractRemark());
                        }else{
                            matcher7 =  pattern.matcher("");
                        }
                        Matcher matcher8 = pattern.matcher(pcr.getProjectName());
                        if(matcher.find()||matcher1.find()||matcher2.find()||matcher3.find()||matcher4.find()||matcher5.find()||matcher6.find()||matcher7.find()||matcher8.find()){
                            projectContractRetList1.add(pcr);
                        }
                    }
                }
                projectContractRetList.addFrom(projectContractRetList1);
                projectContractRetList.setTotalCount(projectContractRetList1.size());
                return projectContractRetList;
            }
        }
        return null;
    }

    /**
     * 获取合同详情（包含阶段信息、收款、发票）  .
     *
     * @param token        token.
     * @param ContractCode 合同编号.
     * @param Option       选项.
     */
    @Override
    @RequiresPermissions("Contract:getContractDetail")
    public ProjectContractRet getContractDetail(String token, String ContractCode, int Option) {
        //TODO: .
        HashMap<String, Object> map = new HashMap<>();
        Contract contract = new Contract();
        contract.setContractCode(ContractCode);

        switch (Option) {
            case 0: {
                ProjectContractRet pcr = (ProjectContractRet) contractDao.ExecuteQueryForObject("queryContractDetail", ContractCode);
                List<Receivable> receivables = new ArrayList<>();
                double contractAlreadyRec = 0;
                double contractNotYetRec = 0;
                int resultRec = (int) contractDao.ExecuteQueryForObject("queryReceivableColumn", pcr.getContractCode());
                if (resultRec == 0) {
                    contractNotYetRec = pcr.getContractAmount();
                } else {
                    receivables = pcr.getReceivableList().getItems();
                    for (Receivable r :
                            receivables) {
                        contractAlreadyRec += r.getRecAmount();
                    }
                    contractNotYetRec = pcr.getContractAmount() - contractAlreadyRec;
                }
                pcr.setContractAlreadyRec(contractAlreadyRec);
                pcr.setContractNotYetRec(contractNotYetRec);


                double invoiceTotalAmount = 0;
                if (pcr.getInvoiceList() != null) {
                    for (Invoice invoice :
                            pcr.getInvoiceList().getItems()) {
                        invoiceTotalAmount += invoice.getInvoiceAmount();
                    }
                    if (invoiceTotalAmount < pcr.getContractAmount()) {
                        pcr.setContractCanInv(1);
                    } else {
                        pcr.setContractCanInv(0);
                    }
                } else {
                    pcr.setContractCanInv(1);
                }

                if (pcr.getReceivableList() != null) {
                    if (pcr.getContractAlreadyRec() < pcr.getContractAmount()) {
                        pcr.setContractCanRec(1);
                    } else {
                        pcr.setContractCanRec(0);
                    }


                } else {
                    if (pcr.getContractAlreadyRec() < pcr.getContractAmount()) {
                        pcr.setContractCanRec(1);
                    } else {
                        pcr.setContractCanRec(0);
                    }
                }
                return pcr;


            }
/*            case 1: {
                ProjectContractRet projectContractRet = (ProjectContractRet) contractDao.ExecuteQueryForObject("queryContractDetail", ContractCode);
                List<Receivable>  receivables = new ArrayList<>();
                double contractAlreadyRec = 0;
                receivables = projectContractRet.getReceivableList().getItems();
                for (Receivable r:
                        receivables) {
                    contractAlreadyRec +=r.getRecAmount();
                }
                projectContractRet.setContractAlreadyRec(contractAlreadyRec);
                projectContractRet.setContractNotYetRec(projectContractRet.getContractAmount()-contractAlreadyRec);
                return projectContractRet;
            }
            case 2: {
                ProjectContractRet projectContractRet = (ProjectContractRet) contractDao.ExecuteQueryForObject("queryContractDetail", ContractCode);
                List<Receivable>  receivables = new ArrayList<>();
                double contractAlreadyRec = 0;
                receivables = projectContractRet.getReceivableList().getItems();
                for (Receivable r:
                        receivables) {
                    contractAlreadyRec +=r.getRecAmount();
                }
                projectContractRet.setContractAlreadyRec(contractAlreadyRec);
                projectContractRet.setContractNotYetRec(projectContractRet.getContractAmount()-contractAlreadyRec);
                return projectContractRet;
            }*/
        }
        throw new PsCoreRuntimeException("Option参数异常", 601);
    }

    /**
     * 添加阶段信息  .
     *
     * @param token         token.
     * @param ContractCode  合同编号.
     * @param PhaseId       合同编号.
     * @param PhaseDescribe 阶段描述.
     * @param PhasePlanTime 预期完成时间.
     * @param PhaseFactTime 预期完成时间.
     * @param PhaseType     阶段类型.
     * @param PhaseAmount   应收金额.
     */
    @Override
    @RequiresPermissions("Contract:addPhase")
    public Phase addPhase(String token, String ContractCode, String PhaseId, String PhaseDescribe, Date PhasePlanTime, int PhaseType, double PhaseAmount, Date PhaseFactTime) {
        //TODO: .
        AssertUtils.ThrowArgNullException(ContractCode, "ContractCode");
        AssertUtils.ThrowArgNullException(PhaseDescribe, "PhaseDescribe");
        AssertUtils.ThrowArgNullException(PhaseAmount, "PhaseAmount");
        AssertUtils.ThrowArgNullException(PhasePlanTime, "PhasePlanTime");
        Phase phase = new Phase();
        if (PhaseId == null || PhaseId == "") {

            phase.setPhaseId(UUID.randomUUID().toString());
        } else {
            phase.setPhaseId(PhaseId);
        }

        phase.setPhaseDescribe(PhaseDescribe);
        phase.setPlanTime(PhasePlanTime);
        phase.setFactTime(PhaseFactTime);
        phase.setPhaseType(PhaseType);
        phase.setPhaseAmount(PhaseAmount);
        Contract contract = new Contract();
        contract.setContractCode(ContractCode);
        Contract contract_db = contractDao.getDetail(contract);


        int result = (int) contractDao.ExecuteQueryForObject("queryPhaseColumn", ContractCode);

        if (result == 0) {
            if (phase.getPhaseAmount() > contract_db.getContractAmount()) {
                throw new PsCoreRuntimeException("该阶段金额已超过合同总额，添加失败。", 901);
            } else {
                PhaseList phaseList = new PhaseList();
                phaseList.add(phase);
                phaseList.setTotalCount(phaseList.size());
                contract_db.setPhaseList(phaseList);
                Contract contract_dbNew = setContractInnerListTotalCount(contract_db);
                contractDao.update(contract_dbNew);
                PopSortPhaseByPlanTime(contract_dbNew, 0);
            }

        } else if (result == 1) {
            PhaseList phaseList = contract_db.getPhaseList();
            List<Phase> phases = new ArrayList<>();
            phases.addAll(phaseList.getItems());
            List<String> PhaseIdList = new ArrayList<>();
            double allPhaseAmountSum = 0;
            for (Phase p :
                    phases) {
                PhaseIdList.add(p.getPhaseId());
                allPhaseAmountSum += p.getPhaseAmount();
            }
            for (int i = 0; i < phases.size(); i++) {
                if (phase.getPhaseId().equals(phases.get(i).getPhaseId())) {
                    if (phases.get(i).getFactTime() == null) {
                        phases.get(i).setFactTime(PhaseFactTime);
                        phases.get(i).setPlanTime(PhasePlanTime);
                        if ((allPhaseAmountSum - phases.get(i).getPhaseAmount() + PhaseAmount) > contract_db.getContractAmount()) {
                            throw new PsCoreRuntimeException("该阶段金额已超过合同总额，修改阶段失败。", 911);
                        } else {
                            phases.get(i).setPhaseAmount(PhaseAmount);
                        }
                        phases.get(i).setPhaseType(PhaseType);
                        phases.get(i).setPhaseDescribe(PhaseDescribe);

                    } else {
                        throw new PsCoreRuntimeException("该阶段已收款无法更改。", 902);
                    }
                }

            }
            phaseList.clear();
            phaseList.addAll(phases);
            phaseList.setTotalCount(phases.size());
            contract_db.setPhaseList(phaseList);
            contract_db = sortPhaseListByPlanTime(contract_db);
            Contract contract_dbNew = setContractInnerListTotalCount(contract_db);
            contractDao.update(contract_dbNew);
            PopSortPhaseByPlanTime(contract_dbNew, 0);
            if (!PhaseIdList.contains(phase.getPhaseId())) {

                if ((allPhaseAmountSum + phase.getPhaseAmount()) > contract_db.getContractAmount()) {
                    throw new PsCoreRuntimeException("该阶段金额已超过合同总额，添加失败。", 901);
                } else {
                    phaseList.add(phase);
                    phaseList.setTotalCount(phaseList.size());
                    contract_db.setPhaseList(phaseList);
                    contract_db = sortPhaseListByPlanTime(contract_db);
                    Contract contract_dbNew1 = setContractInnerListTotalCount(contract_db);
                    contractDao.update(contract_dbNew1);
                    PopSortPhaseByPlanTime(contract_dbNew1, 0);
                }

            }

        }

        return phase;
    }


    /**
     * 删除阶段信息  .
     *
     * @param token        token.
     * @param ContractCode 合同编号.
     * @param PhaseId      阶段序号.
     */
    @Override
    @RequiresPermissions("Contract:deletePhase")
    public int deletePhase(String token, String ContractCode, String PhaseId) {
        //TODO: .
        AssertUtils.ThrowArgNullException(ContractCode, "ContractCode");
        AssertUtils.ThrowArgNullException(PhaseId, "PhaseId");

        String[] PhaseIdArr = AnalyseStr(PhaseId);

        Contract contract = new Contract();
        contract.setContractCode(ContractCode);
        Contract contract_db = contractDao.getDetail(contract);

        PhaseList phaseList = contract_db.getPhaseList();
        List<Phase> phases = new ArrayList<>();
        phases.addAll(phaseList.getItems());
        for (int i = 0; i < phases.size(); i++) {
            if (PhaseIdArr[i].equals(phases.get(i).getPhaseId())) {
                phases.remove(phases.get(i));
            }
        }
        if (phases.size() == 0) {

            contract_db.setPhaseList(null);
            Contract contract_dbNew = setContractInnerListTotalCount(contract_db);
            int n = contractDao.update(contract_dbNew);
            return n;
        }
        phaseList.clear();
        phaseList.addFrom(phases);
        phaseList.setTotalCount(phases.size());
        contract_db.setPhaseList(phaseList);
        Contract contract_dbNew = setContractInnerListTotalCount(contract_db);
        int n = contractDao.update(contract_dbNew);

        return n;
    }

    /**
     * 添加发票信息  .
     *
     * @param token          token.
     * @param ContractCode   合同编号.
     * @param InvoiceCode    发票编号.
     * @param InvoiceAmount  发票金额.
     * @param InvoicePerson  开票人(财务人员id).
     * @param InvoiceType    开票类型.
     * @param InvoiceTime    开票时间.
     * @param InvoiceApplyId 开票申请Id.
     */
    @Override
    @RequiresPermissions("Contract:addInvoice")
    public Invoice addInvoice(String token, Date InvoiceTime, String InvoiceApplyId, String ContractCode, String InvoiceCode, double InvoiceAmount, String InvoicePerson, int InvoiceType) {
        //TODO: .
        AssertUtils.ThrowArgNullException(ContractCode, "ContractCode");
        AssertUtils.ThrowArgNullException(InvoiceCode, "InvoiceCode");
        AssertUtils.ThrowArgNullException(InvoiceAmount, "InvoiceAmount");
        Invoice invoice = new Invoice();
        invoice.setInvoiceCode(InvoiceCode);


        invoice.setInvoiceAmount(InvoiceAmount);

        invoice.setInvoicePerson(InvoicePerson);
        invoice.setInvoiceType(InvoiceType);
        invoice.setInvoiceTime(InvoiceTime);
        //找合同
        Contract contract = new Contract();
        contract.setContractCode(ContractCode);
        Contract contract_db = contractDao.getDetail(contract);
        int result = (int) contractDao.ExecuteQueryForObject("queryInvoiceColumn", ContractCode);
        if (result == 0) {
            if (InvoiceApplyId != null) {
                List<InvoiceApply> invoiceApplies = contract_db.getInvoiceApplyList().getItems();
                for (InvoiceApply invoiceApply :
                        invoiceApplies) {
                    if (InvoiceApplyId.equals(invoiceApply.getInvoiceApplyId())) {
                        invoiceApply.setInvoiceApplyIsDeal(1);
                    }
                }
            }
            if (invoice.getInvoiceAmount() > contract_db.getContractAmount()) {
                throw new PsCoreRuntimeException("发票金额已超过合同总金额，开票失败", 907);
            } else {
                InvoiceList invoiceList = new InvoiceList();
                invoiceList.add(invoice);
                invoiceList.setTotalCount(invoiceList.size());
                contract_db.setInvoiceList(invoiceList);
                Contract contract_dbNew = setContractInnerListTotalCount(contract_db);
                contractDao.update(contract_dbNew);
                PopSortPhaseByPlanTime(contract_dbNew, 2);
            }

        } else if (result == 1) {
            InvoiceList invoicelist = contract_db.getInvoiceList();
            List<Invoice> invoices = new ArrayList<>();
            invoices.addAll(invoicelist.getItems());
            List<String> invoiceIdList = new ArrayList<>();
            double invoiceTotalAmount = 0;
            for (Invoice i :
                    invoices) {
                invoiceIdList.add(i.getInvoiceCode());
                invoiceTotalAmount += i.getInvoiceAmount();
            }
            for (int i = 0; i < invoices.size(); i++) {
                if (invoice.getInvoiceCode().equals(invoices.get(i).getInvoiceCode())) {
                    invoices.get(i).setInvoiceTime(InvoiceTime);
                    invoices.get(i).setInvoiceType(InvoiceType);
                    invoices.get(i).setInvoicePerson(InvoicePerson);
                    if ((invoiceTotalAmount - invoices.get(i).getInvoiceAmount() + invoice.getInvoiceAmount()) > contract_db.getContractAmount()) {
                        throw new PsCoreRuntimeException("该发票金额已超过合同总金额，修改发票失败", 912);
                    } else {
                        invoices.get(i).setInvoiceAmount(InvoiceAmount);
                    }
                    invoices.get(i).setInvoiceCode(InvoiceCode);

                }
            }
            invoicelist.clearItems();
            invoicelist.setItems(invoices);
            invoicelist.setTotalCount(invoicelist.size());
            contract_db.setInvoiceList(invoicelist);
            Contract contract_dbNew = setContractInnerListTotalCount(contract_db);
            contractDao.update(contract_dbNew);
            PopSortPhaseByPlanTime(contract_dbNew, 2);
            if (!invoiceIdList.contains(invoice.getInvoiceCode())) {
                if ((invoice.getInvoiceAmount() + invoiceTotalAmount) > contract_db.getContractAmount()) {
                    throw new PsCoreRuntimeException("发票金额已超过合同总金额，开票失败", 907);
                } else {
                    if (InvoiceApplyId != null) {
                        List<InvoiceApply> invoiceApplies = contract_db.getInvoiceApplyList().getItems();
                        for (InvoiceApply invoiceApply :
                                invoiceApplies) {
                            if (InvoiceApplyId.equals(invoiceApply.getInvoiceApplyId())) {
                                invoiceApply.setInvoiceApplyIsDeal(1);
                            }
                        }
                    }
                    invoices.add(invoice);
                    invoicelist.clearItems();
                    invoicelist.setItems(invoices);
                    invoicelist.setTotalCount(invoicelist.size());
                    contract_db.setInvoiceList(invoicelist);
                    Contract contract_dbNew1 = setContractInnerListTotalCount(contract_db);
                    contractDao.update(contract_dbNew1);
                    PopSortPhaseByPlanTime(contract_dbNew1, 2);
                }
            }

        }


        return invoice;
    }

    /**
     * 删除发票信息  .
     *
     * @param token        token.
     * @param ContractCode 合同编号.
     * @param InvoiceCode  发票编号.
     */
    @Override
    @RequiresPermissions("Contract:deleteInvoice")
    public int deleteInvoice(String token, String ContractCode, String InvoiceCode) {
        //TODO: .
        AssertUtils.ThrowArgNullException(ContractCode, "ContractCode");
        AssertUtils.ThrowArgNullException(InvoiceCode, "InvoiceCode");
        String[] InvoiceCodeArr = AnalyseStr(InvoiceCode);

        Contract contract = new Contract();
        contract.setContractCode(ContractCode);
        Contract contract_db = contractDao.getDetail(contract);


        InvoiceList invoicelist = contract_db.getInvoiceList();
        List<Invoice> invoices = new ArrayList<>();
        invoices.addAll(invoicelist.getItems());
        for (int i = 0; i < invoices.size(); i++) {
            if (InvoiceCodeArr[i].equals(invoices.get(i).getInvoiceCode())) {
                invoices.remove(invoices.get(i));
            }
        }
        if (invoices.size() == 0) {

            contract_db.setInvoiceList(null);
            Contract contract_dbNew = setContractInnerListTotalCount(contract_db);
            int n = contractDao.update(contract_dbNew);
            /*int n = contractDao.update(contract_db);*/
            return n;
        }
        invoicelist.clear();
        invoicelist.addFrom(invoices);
        invoicelist.setTotalCount(invoices.size());
        contract_db.setInvoiceList(invoicelist);
        Contract contract_dbNew = setContractInnerListTotalCount(contract_db);
        int n = contractDao.update(contract_dbNew);
        //  int n = contractDao.update(contract_db);
        return n;

    }

    /**
     * 添加收款信息  .
     *
     * @param token        token.
     * @param ContractCode 合同编号.
     * @param RecId        收款Id.
     * @param RecAmount    收款金额.
     * @param RecTime      收款时间.
     * @param RecType      收款类型.
     */
    @Override
    @RequiresPermissions("Contract:addReceivable")
    public Receivable addReceivable(String token, String RecId, String ContractCode, double RecAmount, Date RecTime, int RecType) {
        //TODO: .
        AssertUtils.ThrowArgNullException(ContractCode, "ContractCode");
        AssertUtils.ThrowArgZeroException(RecAmount, "RecAmount");
        AssertUtils.ThrowArgNullException(RecTime, "RecTime");
        Receivable receivable = new Receivable();
        if (RecId == null || RecId == "") {
            receivable.setRecId(UUID.randomUUID().toString());
        } else {
            receivable.setRecId(RecId);
        }
        receivable.setRecAmount(RecAmount);
        receivable.setRecTime(RecTime);
        receivable.setRecType(RecType);
        Contract contract = new Contract();
        contract.setContractCode(ContractCode);
        Contract contract_db = contractDao.getDetail(contract);
        int result = (int) contractDao.ExecuteQueryForObject("queryReceivableColumn", ContractCode);

        if (result == 0 && (RecId == null || RecId == "")) {
            if (receivable.getRecAmount() > contract_db.getContractAmount()) {
                throw new PsCoreRuntimeException("回款金额超过了合同总额，回款失败。", 905);
            } else {
                ReceivableList receivableList = new ReceivableList();
                receivableList.add(receivable);
                receivableList.setTotalCount(receivableList.size());

                contract_db.setReceivableList(receivableList);
                contract_db.setContractAlreadyRec(receivable.getRecAmount());
                contract_db.setContractNotYetRec(contract_db.getContractAmount() - receivable.getRecAmount());

                if (contract_db.getContractAlreadyRec() == contract_db.getContractAmount()) {
                    contract_db.setContractStatus(1);
                }

                Contract contract_dbNew = setContractInnerListTotalCount(contract_db);
                contractDao.update(contract_dbNew);
                Contract contract1 = PopSortPhaseByPlanTime(contract_dbNew, 1);
                setContractPhaseFactTime(contract1.getContractCode(), receivable);
            }

        } else if (result == 1) {
            ReceivableList receivableList = contract_db.getReceivableList();
            List<Receivable> receivables = new ArrayList<>();
            receivables.addAll(receivableList.getItems());
            double contractAlreadyRec = 0;
            List<String> RecIdList = new ArrayList<>();
            for (int i = 0; i < receivables.size(); i++) {
                RecIdList.add(receivables.get(i).getRecId());
                if (receivable.getRecId().equals(receivables.get(i).getRecId())) {
                    receivables.get(i).setRecType(RecType);
                    receivables.get(i).setRecTime(RecTime);
                    if ((contract_db.getContractAlreadyRec() - receivables.get(i).getRecAmount() + RecAmount) <= contract_db.getContractAmount()) {
                        receivables.get(i).setRecAmount(RecAmount);
                    } else {
                        throw new PsCoreRuntimeException("回款金额超过了合同总额，修改回款失败。", 906);
                    }
                }

                contractAlreadyRec += receivables.get(i).getRecAmount();

            }
            receivableList.clearItems();
            receivableList.setItems(receivables);
            receivableList.setTotalCount(receivableList.size());
            contract_db.setReceivableList(receivableList);
            contract_db.setContractAlreadyRec(contractAlreadyRec);
            contract_db.setContractNotYetRec(contract_db.getContractAmount() - contract_db.getContractAlreadyRec());

            if (contract_db.getContractAlreadyRec() == contract_db.getContractAmount()) {
                contract_db.setContractStatus(1);
            }
            Contract contract_dbNew = setContractInnerListTotalCount(contract_db);
            contractDao.update(contract_dbNew);
            Contract contract1 = PopSortPhaseByPlanTime(contract_dbNew, 1);
            setContractPhaseFactTime(contract1.getContractCode(), receivable);

            if (!RecIdList.contains(receivable.getRecId())) {
                if (receivable.getRecAmount() + contract_db.getContractAlreadyRec() > contract_db.getContractAmount()) {
                    throw new PsCoreRuntimeException("回款金额超过了合同总额，回款失败。", 905);
                } else {
                    receivableList.add(receivable);
                    receivableList.setTotalCount(receivableList.size());
                    contract_db.setReceivableList(receivableList);
                    contract_db.setContractAlreadyRec(contract_db.getContractAlreadyRec() + receivable.getRecAmount());
                    contract_db.setContractNotYetRec(contract_db.getContractAmount() - contract_db.getContractAlreadyRec());
                    if (contract_db.getContractAlreadyRec() == contract_db.getContractAmount()) {
                        contract_db.setContractStatus(1);
                    }

                    Contract contract_dbNew1 = setContractInnerListTotalCount(contract_db);
                    contractDao.update(contract_dbNew1);
                    Contract contract2 = PopSortPhaseByPlanTime(contract_dbNew1, 1);
                    setContractPhaseFactTime(contract2.getContractCode(), receivable);
                }

            }

        }
        return receivable;
    }

    /**
     * 删除收款信息  .
     *
     * @param token        token.
     * @param ContractCode 合同编号.
     * @param RecId        收款序号.
     */
    @Override
    @RequiresPermissions("Contract:deleteReceivable")
    public int deleteReceivable(String token, String ContractCode, String RecId) {
        //TODO: .
        AssertUtils.ThrowArgNullException(ContractCode, "ContractCode");
        AssertUtils.ThrowArgNullException(RecId, "RecId");
        String[] RecIdArr = AnalyseStr(RecId);

        Contract contract = new Contract();
        contract.setContractCode(ContractCode);
        Contract contract_db = contractDao.getDetail(contract);

        ReceivableList receivableList = contract_db.getReceivableList();
        List<Receivable> receivables = new ArrayList<>();
        receivables.addAll(receivableList.getItems());
        for (int i = 0; i < receivables.size(); i++) {
            if (RecIdArr[i].equals(receivables.get(i).getRecId())) {
                receivables.remove(receivables.get(i));
            }
        }
        if (receivables.size() == 0) {

            contract_db.setReceivableList(null);
            Contract contract_dbNew = setContractInnerListTotalCount(contract_db);
            int n = contractDao.update(contract_dbNew);
            //   int n = contractDao.update(contract_db);
            return n;
        }
        double ContractAlreadyRec = 0;

        for (Receivable receivable :
                receivables) {
            ContractAlreadyRec += receivable.getRecAmount();
        }


        receivableList.clear();
        receivableList.addFrom(receivables);
        receivableList.setTotalCount(receivables.size());
        contract_db.setReceivableList(receivableList);
        contract_db.setContractAlreadyRec(ContractAlreadyRec);
        contract_db.setContractNotYetRec(contract_db.getContractAmount() - ContractAlreadyRec);
        Contract contract_dbNew = setContractInnerListTotalCount(contract_db);
        int n = contractDao.update(contract_dbNew);
        // int n = contractDao.update(contract_db);


        return n;
    }


    /**
     * app首页项目合同信息列表  .
     *
     * @param token  token.
     * @param Option Option.
     */
    @Override
    public ProjectContractRetList getProjectContractList(String token, int Option) {
        //TODO: .

        return null;
    }

    /*
     * 解析字符串
     * */
    @Override
    public String[] AnalyseStr(String str) {
        String[] strArr = str.split(",");
//        int[] array = Arrays.asList(strArr).stream().mapToInt(Integer::parseInt).toArray();
        return strArr;
    }


    /**
     * 合同统计接口  .
     *
     * @param token      token.
     * @param QueryYear  查询年份.
     * @param QueryYear2 查询年份.
     */
    @Override
    @RequiresPermissions("Contract:getProjectStatistic")
    public HashMap<String, Object> getProjectStatistic(String token, int QueryYear, int QueryYear2) {
        //TODO: .
        HashMap<String, Object> map = new HashMap<>();
        //当前执行中合同总额
        ContractQueryPara contractQueryPara = new ContractQueryPara();
        contractQueryPara.setParamByContractStatus(0);
        //当前执行中合同列表
        List<Contract> contractList = contractDao.queryList(contractQueryPara, 0, -1);


        List<Receivable> receivables = new ArrayList<>();
        List<Phase> phases = new ArrayList<>();


        double CurrentAllContractAmount = 0;
        double CurrentAllContractRecAmount = 0;
        double CurrentAllContractShouldRecTillThisMonth = 0;


        //本月所有合同应收（本月及以前）
        //查有阶段的合同,遍历合同,再遍历合同的阶段信息,
        //再判断阶段预计时间满足截至本月及以前的该合同应收,再把这些合同的本月前应收全加起来
        for (Contract c :
                contractList) {
            CurrentAllContractAmount += c.getContractAmount();
            int resultPhase = (int) contractDao.ExecuteQueryForObject("queryPhaseColumn", c.getContractCode());
            double everyContractShouldRecTillThisMonth = 0;
            double everyContractPhaseShouldRecTillThisMonth = 0;
            double everyContractAlreadyRecTillThisMonth = 0;
            CurrentAllContractRecAmount += c.getContractAlreadyRec();
            if (resultPhase == 0) {
                continue;
            } else {
                phases = c.getPhaseList().getItems();
                for (int i = 0; i < phases.size(); i++) {
                    //再判断阶段预计时间满足截至本月及以前的该合同应收,再把这些合同的本月前应收全加起来

                    //获取Calendar
                    Calendar calendar = Calendar.getInstance();
                    //设置日期为本月最大日期
                    calendar.set(Calendar.DATE, calendar.getActualMaximum(calendar.DATE));
                    if (!phases.get(i).getPlanTime().after(calendar.getTime())) {
                        everyContractPhaseShouldRecTillThisMonth += phases.get(i).getPhaseAmount();
                    }

                }
                if (c.getReceivableList() != null) {
                    List<Receivable> receivables1 = c.getReceivableList().getItems();
                    for (int i = 0; i < receivables1.size(); i++) {
                        //获取Calendar
                        Calendar calendar = Calendar.getInstance();
                        //设置日期为本月最大日期
                        calendar.set(Calendar.DATE, calendar.getActualMaximum(calendar.DATE));
                        if (!receivables1.get(i).getRecTime().after(calendar.getTime())) {
                            everyContractAlreadyRecTillThisMonth += receivables1.get(i).getRecAmount();
                        }
                    }
                } else {
                    everyContractAlreadyRecTillThisMonth = 0;
                }
                everyContractShouldRecTillThisMonth = everyContractPhaseShouldRecTillThisMonth - everyContractAlreadyRecTillThisMonth;
                CurrentAllContractShouldRecTillThisMonth += everyContractShouldRecTillThisMonth;
            }
        }


        List<Invoice> invoices = new ArrayList<>();


        //按年份项目总数
        List<Project> projects = new ArrayList<>();
        if (QueryYear2 != 0) {
            projects = projectDao.ExecuteQueryForList("queryProjectNumByYear", QueryYear2);
        } else {
            projects = projectDao.ExecuteQueryForList("queryProjectNum", null);
        }
        int ProjectNum = projects.size();

        //按年份项目收款情况

        int AlreadyFinishRecProjectNum = 0;

        int NotFinishRecProjectNum = 0;

        for (Project p :
                projects) {
            ContractQueryPara contractQueryPara1 = new ContractQueryPara();
            contractQueryPara1.setParamByProjectCode(p.getProjectCode());
            //项目下合同列表
            List<Contract> contracts = contractDao.queryList(contractQueryPara1, 0, -1);
            double AllContractAmount = 0;
            double ContractAlreadyAmount = 0;
            for (Contract c :
                    contracts) {
                AllContractAmount += c.getContractAmount();
                ContractAlreadyAmount += c.getContractAlreadyRec();

            }
            if (contracts.size() != 0) {//没有合同的项目不算进来
                if (ContractAlreadyAmount == AllContractAmount) {
                    AlreadyFinishRecProjectNum++;
                } else {
                    NotFinishRecProjectNum++;
                }

            }

        }


        map.put("CurrentAllContractAmount", CurrentAllContractAmount);
        map.put("CurrentAllContractRecAmount", CurrentAllContractRecAmount);
        map.put("CurrentAllContractNoRecAmount", CurrentAllContractAmount - CurrentAllContractRecAmount);
        map.put("CurrentAllContractShouldRecTillThisMonth", CurrentAllContractShouldRecTillThisMonth);
        map.put("CurrentAllPerformingContractNum", contractList.size());
        //    map.put("CurrentAllPerformingContractList", contractList);
        map.put("ProjectNum", ProjectNum);
        map.put("AlreadyFinishRecProjectNum", AlreadyFinishRecProjectNum);
        map.put("NotFinishRecProjectNum", NotFinishRecProjectNum);

        //当前执行中合同已收款


        return map;
    }

    /**
     * 销售获取待办数据  .
     *
     * @param token token.
     */
    @Override
    @RequiresPermissions("Contract:getBacklogDataForSeller")
    public HashMap<String, Object> getBacklogDataForSeller(String token) {
        //TODO: .
        HashMap<String, Object> map = new HashMap<>();
        int[] roleIdIntArr = customerMgeSvr.getUserRole(token);
        List<String> roleIdArrList = new ArrayList<>();
        for (int i = 0; i < roleIdIntArr.length; i++) {
            roleIdArrList.add(Integer.toString(roleIdIntArr[i]));
        }
        if (roleIdArrList.contains("1")) {


            //本月所有合同应收（本月及以前）
            //查有阶段的合同,遍历合同,再遍历合同的阶段信息,
            //再判断阶段预计时间满足截至本月及以前的该合同应收,再把这些合同的本月前应收全加起来
            //销售主管获取有多少个待添加阶段信息的合同列表
            List<ProjectContractRet> contractsWithoutPhase = contractDao.ExecuteQueryForList("queryContractWithoutPhase", null);
            //销售主管获取有多少个按阶段信息待收款合同列表(预计完成时间离当前时间只剩7天，且收款总额不足总金额)
            //有阶段信息的所有合同列表
            List<ProjectContractRet> contractsWithPhase = contractDao.ExecuteQueryForList("queryContractWithPhase", null);
            List<ProjectContractRet> contractsWaitRec = new ArrayList<>();//本月计划收款改为本月所有合同应收（本月及以前）

            for (ProjectContractRet pcr :
                    contractsWithPhase) {
                List<Phase> phases = new ArrayList<>();
                double contractAlreadyRec = 0;
                phases = pcr.getPhaseList().getItems();
                contractAlreadyRec = pcr.getContractAlreadyRec();
                if (pcr.getContractAmount() > contractAlreadyRec) {
                    //  contractsWaitRec.add(pcr);
                    for (int i = 0; i < phases.size(); i++) {
                        long timeNum = ((phases.get(i).getPlanTime().getTime() - new Date().getTime()) / (1000 * 3600 * 24));
                        if ((timeNum <= dayNum) && (timeNum >= 0) && (phases.get(i).getFactTime() == null)) {
                            contractsWaitRec.add(pcr);
                        }
                    }

                }
            }


            map.put("ContractWithoutPhaseNum", contractsWithoutPhase.size());
            map.put("ContractWithoutPhase", contractsWithoutPhase);
            map.put("ContractsWaitRecNum", contractsWaitRec.size());
            map.put("ContractsWaitRec", contractsWaitRec);
        } else if (roleIdArrList.contains("5")) {
            String userId = "";
            try {
                userId = tools.getUserId(token);
            } catch (IPSFNetException e) {
                e.printStackTrace();
            }
            //销售获取有多少个待添加阶段信息的合同列表
            List<ProjectContractRet> contractsWithoutPhaseForSeller = contractDao.ExecuteQueryForList("queryContractWithoutPhaseForSeller", userId);
            //销售获取有多少个按阶段信息待收款合同列表(预计完成时间离当前时间只剩7天，且收款总额不足总金额)
            //有阶段信息的用户的合同列表
            List<ProjectContractRet> contractsWithPhaseForSeller = contractDao.ExecuteQueryForList("queryContractWithPhaseForSeller", userId);
            List<ProjectContractRet> contractsWaitRecForSeller = new ArrayList<>();
            System.out.println("contractsWithPhaseForSeller::" + contractsWithPhaseForSeller);
            for (ProjectContractRet pcr :
                    contractsWithPhaseForSeller) {
                List<Phase> phases = new ArrayList<>();
                double contractAlreadyRec = 0;
                phases = pcr.getPhaseList().getItems();
                contractAlreadyRec = pcr.getContractAlreadyRec();

                if (pcr.getContractAmount() > contractAlreadyRec) {
                    for (int i = 0; i < phases.size(); i++) {
                        long timeNum = ((phases.get(i).getPlanTime().getTime() - new Date().getTime()) / (1000 * 3600 * 24));
                        if ((timeNum <= dayNum) && (timeNum >= 0) && (phases.get(i).getFactTime() == null)) {
                            contractsWaitRecForSeller.add(pcr);
                        }
                    }

                }
            }

            map.put("ContractWithoutPhaseForSellerNum", contractsWithoutPhaseForSeller.size());
            map.put("ContractWithoutPhaseForSeller", contractsWithoutPhaseForSeller);
            map.put("ContractsWaitRecForSellerNum", contractsWaitRecForSeller.size());
            map.put("ContractsWaitRecForSeller", contractsWaitRecForSeller);
        }

        return map;
    }


    /**
     * 财务获取待办数据  .
     *
     * @param token token.
     */
    @Override
    @RequiresPermissions("Contract:getBacklogDataForFinance")
    public HashMap<String, Object> getBacklogDataForFinance(String token) {
        //TODO: .

        HashMap<String, Object> map = new HashMap<>();


        //财务收款角色有票无款的待办(收款总额不足开票总额)
        //有发票的合同列表
        List<ProjectContractRet> contractsWithInvNoRec_db = contractDao.ExecuteQueryForList("queryContractWithInvNoRec", null);
        List<ProjectContractRet> contractsWithInvNoRec = new ArrayList<>();


        for (ProjectContractRet pcr :
                contractsWithInvNoRec_db) {
            double invoiceTotalAmountByContract = 0;
            double recTotalAmountByContract = 0;

            int resultRec = (int) contractDao.ExecuteQueryForObject("queryReceivableColumn", pcr.getContractCode());
            if (resultRec == 0) {
                contractsWithInvNoRec.add(pcr);
            } else {

                List<Receivable> receivables = new ArrayList<>();
                List<Invoice> invoices = new ArrayList<>();
                receivables = pcr.getReceivableList().getItems();
                invoices = pcr.getInvoiceList().getItems();
                for (Receivable receivable :
                        receivables) {
                    recTotalAmountByContract += receivable.getRecAmount();
                }
                for (Invoice invoice :
                        invoices) {
                    invoiceTotalAmountByContract += invoice.getInvoiceAmount();
                }
                if (recTotalAmountByContract < invoiceTotalAmountByContract) {
                    contractsWithInvNoRec.add(pcr);
                }

            }

        }

        //财务收款角色有款无票的待办(开票总额不足收款总额)
        List<ProjectContractRet> contractsWithRecNoInv_db = contractDao.ExecuteQueryForList("queryContractsWithRecNoInv", null);
        List<ProjectContractRet> contractsWithRecNoInv = new ArrayList<>();

        for (ProjectContractRet pcr :
                contractsWithRecNoInv_db) {
            int resultInv = (int) contractDao.ExecuteQueryForObject("queryInvoiceColumn", pcr.getContractCode());
            if (resultInv == 0) {
                contractsWithRecNoInv.add(pcr);

            } else {
                double invoiceTotalAmountByContract = 0;
                double recTotalAmountByContract = 0;
                List<Receivable> receivables = new ArrayList<>();
                List<Invoice> invoices = new ArrayList<>();
                receivables = pcr.getReceivableList().getItems();
                invoices = pcr.getInvoiceList().getItems();
                for (Receivable receivable :
                        receivables) {
                    recTotalAmountByContract += receivable.getRecAmount();
                }
                for (Invoice invoice :
                        invoices) {
                    invoiceTotalAmountByContract += invoice.getInvoiceAmount();
                }
                if (recTotalAmountByContract > invoiceTotalAmountByContract) {
                    contractsWithRecNoInv.add(pcr);
                }
            }


        }

        //需要申请开票的合同
        List<ProjectContractRet> contractsNeedInvoice = new ArrayList<>();
        //有开票申请的合同
        List<ProjectContractRet> projectContractRetList_db = contractDao.ExecuteQueryForList("queryProjectContractWithInvoiceApply", null);
        for (ProjectContractRet pcr :
                projectContractRetList_db) {
            List<InvoiceApply> invoiceApplies = new ArrayList<>();
            List<String> invoiceApplyIdListIsNotDeal = new ArrayList<>();
            invoiceApplies = pcr.getInvoiceApplyList().getItems();
            for (int i = 0; i < invoiceApplies.size(); i++) {
                if (invoiceApplies.get(i).getInvoiceApplyIsDeal() == 0) {
                    invoiceApplyIdListIsNotDeal.add(invoiceApplies.get(i).getInvoiceApplyId());
                }
            }
            if (invoiceApplyIdListIsNotDeal.size() != 0) {
                contractsNeedInvoice.add(pcr);
            }
        }
        ProjectContractRetList projectContractRetList = new ProjectContractRetList();
        projectContractRetList.setItems(contractsNeedInvoice);
        projectContractRetList.setTotalCount(contractsNeedInvoice.size());
       ProjectContractRetList projectContractRets = setSellerNameByContractCode(projectContractRetList);

        map.put("ContractsWithInvNoRecNum", contractsWithInvNoRec.size());
        map.put("ContractsWithInvNoRec", contractsWithInvNoRec);
        map.put("ContractsWithRecNoInvNum", contractsWithRecNoInv.size());
        map.put("ContractsWithRecNoInv", contractsWithRecNoInv);
        map.put("ContractsNeedInvoice", projectContractRets.getItems());
        map.put("ContractsNeedInvoiceNum", contractsNeedInvoice.size());
        return map;
    }

    @Override
    @RequiresPermissions("Contract:getBacklogData")
    public HashMap<String, Object> getBacklogData(String token) {
        //TODO: .
        HashMap<String, Object> map = new HashMap<>();
        //销售/销售主管获取有多少个待添加阶段信息的合同列表
        List<ProjectContractRet> contractsWithoutPhase = contractDao.ExecuteQueryForList("queryContractWithoutPhase", null);
        //销售/销售主管获取有多少个按阶段信息待收款合同列表(预计完成时间离当前时间只剩7天，且收款总额不足总金额)
        //有阶段信息的合同列表
        List<ProjectContractRet> contractsWithPhase = contractDao.ExecuteQueryForList("queryContractWithPhase", null);
        List<ProjectContractRet> contractsWaitRec = new ArrayList<>();
        for (ProjectContractRet pcr :
                contractsWithPhase) {
            List<Phase> phases = new ArrayList<>();
            double contractAlreadyRec = 0;
            phases = pcr.getPhaseList().getItems();
            contractAlreadyRec = pcr.getContractAlreadyRec();
            if (pcr.getContractAmount() > contractAlreadyRec) {
                for (int i = 0; i < phases.size(); i++) {
                    long timeNum = ((phases.get(i).getPlanTime().getTime() - new Date().getTime()) / (1000 * 3600 * 24));
                    if ((timeNum <= dayNum) && (timeNum >= 0) && (phases.get(i).getFactTime() == null)) {
                        contractsWaitRec.add(pcr);
                    }
                }

            }
        }


        //财务收款角色有票无款的待办(收款总额不足开票总额)
        List<ProjectContractRet> contractsWithInvNoRec_db = contractDao.ExecuteQueryForList("queryContractWithInvNoRec", null);
        List<ProjectContractRet> contractsWithInvNoRec = new ArrayList<>();

        for (ProjectContractRet pcr :
                contractsWithInvNoRec_db) {
            double invoiceTotalAmountByContract = 0;
            double recTotalAmountByContract = 0;
            List<Invoice> invoices = new ArrayList<>();
            List<Receivable> receivables = new ArrayList<>();
            invoices = pcr.getInvoiceList().getItems();
            //receivables = pcr.getReceivableList().getItems();
            for (int i = 0; i < invoices.size(); i++) {
                invoiceTotalAmountByContract += invoices.get(i).getInvoiceAmount();
            }
            if (pcr.getReceivableList() != null) {
                recTotalAmountByContract = pcr.getContractAlreadyRec();
                if (invoiceTotalAmountByContract > recTotalAmountByContract) {
                    contractsWithInvNoRec.add(pcr);
                }
            } else {
                contractsWithInvNoRec.add(pcr);
            }


        }


        //财务收款角色有款无票的待办(开票总额不足收款总额)
        List<ProjectContractRet> contractsWithRecNoInv_db = contractDao.ExecuteQueryForList("queryContractsWithRecNoInv", null);
        List<ProjectContractRet> contractsWithRecNoInv = new ArrayList<>();

        for (ProjectContractRet pcr :
                contractsWithRecNoInv_db) {
            double invoiceTotalAmountByContract = 0;
            double recTotalAmountByContract = 0;
            List<Invoice> invoices = new ArrayList<>();
            List<Receivable> receivables = new ArrayList<>();
            receivables = pcr.getReceivableList().getItems();
            //receivables = pcr.getReceivableList().getItems();

            recTotalAmountByContract = pcr.getContractAlreadyRec();

            if (pcr.getInvoiceList() != null) {
                invoices = pcr.getInvoiceList().getItems();
                for (int i = 0; i < invoices.size(); i++) {
                    invoiceTotalAmountByContract += invoices.get(i).getInvoiceAmount();
                }
                if (invoiceTotalAmountByContract < recTotalAmountByContract) {
                    contractsWithRecNoInv.add(pcr);
                }
            } else {
                contractsWithRecNoInv.add(pcr);
            }


        }

        map.put("ContractWithoutPhaseNum", contractsWithoutPhase.size());
        map.put("ContractWithoutPhase", contractsWithoutPhase);
        map.put("ContractsWaitRecNum", contractsWaitRec.size());
        map.put("ContractsWaitRec", contractsWaitRec);
        map.put("ContractsWithInvNoRecNum", contractsWithInvNoRec.size());
        map.put("ContractsWithInvNoRec", contractsWithInvNoRec);
        map.put("ContractsWithRecNoInvNum", contractsWithRecNoInv.size());
        map.put("ContractsWithRecNoInv", contractsWithRecNoInv);
        return map;
    }

    /**
     * 判断单个合同是否可以开票或收款  .
     *
     * @param token        token.
     * @param ContractCode 合同编号.
     */
    @Override
    @RequiresPermissions("Contract:judgeContractCanInvOrRec")
    public HashMap<String, Boolean> judgeContractCanInvOrRec(String token, String ContractCode) {
        //TODO: .
        HashMap<String, Boolean> map = new HashMap<>();
        AssertUtils.ThrowArgNullException(ContractCode, "ContractCode");
        Contract contract = new Contract();
        contract.setContractCode(ContractCode);
        Contract contract_db = contractDao.getDetail(contract);
        List<Invoice> invoices = new ArrayList<>();
        List<Receivable> receivables = new ArrayList<>();
        if (contract_db.getInvoiceList() != null) {
            double InvoiceTotalAmount = 0;
            invoices = contract_db.getInvoiceList().getItems();
            for (Invoice i :
                    invoices) {
                InvoiceTotalAmount += i.getInvoiceAmount();
            }
            if (InvoiceTotalAmount < contract_db.getContractAmount()) {
                map.put("JudgeContractCanInv", true);
            } else {
                map.put("JudgeContractCanInv", false);
            }
        }

        if (contract_db.getReceivableList() != null) {
            double ReceivableTotalAmount = 0;
            receivables = contract_db.getReceivableList().getItems();
            for (Receivable r :
                    receivables) {
                ReceivableTotalAmount += r.getRecAmount();
            }
            if (ReceivableTotalAmount < contract_db.getContractAmount()) {
                map.put("JudgeContractCanRec", true);
            } else {
                map.put("JudgeContractCanRec", false);
            }
        }
        return null;
    }


    /**
     * 判断单个合同是否过期(过期则改状态为1)  .
     *
     * @param token token.
     */
    @Override
    @RequiresPermissions("Contract:judgeContractIsDue")
    public int judgeContractIsDue(String token) {
        List<Contract> contracts = contractDao.queryList(null, 0, -1);
        int n = 0;
        if (contracts.size() != 0) {
            for (Contract contract :
                    contracts) {
                if (!contract.getContractEndTime().before(new Date()) || !contract.getContractNoEffectTime().before(new Date())) {
                    n = contractDao.ExecuteUpdate("updateContractStatus", contract.getContractCode());
                }
            }
        }
        return n;
    }

    private static List<ProjectContractRet> setContractInvAndRecStatus(List<ProjectContractRet> projectContractRetList_db) {
        for (ProjectContractRet pcr :
                projectContractRetList_db) {
            List<Invoice> invoices = new ArrayList<>();
            double InvoiceTotalAmount = 0;
            //判断合同是否未开完票
            if (pcr.getInvoiceList() != null) {

                invoices = pcr.getInvoiceList().getItems();
                for (int i = 0; i < invoices.size(); i++) {
                    InvoiceTotalAmount += invoices.get(i).getInvoiceAmount();
                }
                if (InvoiceTotalAmount < pcr.getContractAmount()) {
                    pcr.setContractCanInv(1);
                } else {
                    pcr.setContractCanInv(0);
                }
            } else {
                pcr.setContractCanInv(1);
            }

            //判断合同是否未收完款
            if (pcr.getReceivableList() != null) {
                if (pcr.getContractAlreadyRec() < pcr.getContractAmount()) {
                    pcr.setContractCanRec(1);
                } else {
                    pcr.setContractCanRec(0);
                }
            } else {
                pcr.setContractCanRec(1);
            }


        }
        return projectContractRetList_db;
    }

    /**
     * 批量添加阶段信息  .
     *
     * @param token        token.
     * @param ContractCode 合同编号.
     * @param PhaseStr     阶段对象.
     */
    @Override
    @RequiresPermissions("Contract:addPhaseBatch")
    public PhaseList addPhaseBatch(String token, String ContractCode, String PhaseStr) {
        //TODO: .
        JSONObject jsonObject = JSONObject.parseObject(PhaseStr);
        PhaseList phaseList = new PhaseList();
        List<Phase> phases = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            if (jsonObject.getString(Integer.toString(i)) != null) {
                JSONObject jsonObject1 = JSONObject.parseObject(jsonObject.getString(Integer.toString(i)));
                String jsonStr = JSONObject.toJSONString(jsonObject1);
                Phase phase = (Phase) JSON.parseObject(jsonStr, Phase.class);
                Phase phase_added = addPhase(token, ContractCode, null, phase.getPhaseDescribe(), phase.getPlanTime(), phase.getPhaseType(), phase.getPhaseAmount(), null);
                phases.add(phase_added);
            }
        }
        phaseList.addFrom(phases);
        phaseList.setTotalCount(phases.size());
        return phaseList;
    }

    /**
     * 申请开票  .
     *
     * @param token              token.
     * @param ContractCode       合同编号.
     * @param PhaseId            阶段序号.
     * @param InvoiceApplyAmount 申请开票金额.
     */
    @Override
    @RequiresPermissions("Contract:addInvoiceApply")
    public InvoiceApply addInvoiceApply(String token, String ContractCode, String PhaseId, double InvoiceApplyAmount) {
        //TODO: .

        AssertUtils.ThrowArgNullException(ContractCode, "ContractCode");
        AssertUtils.ThrowArgNullException(InvoiceApplyAmount, "InvoiceApplyAmount");
        AssertUtils.ThrowArgNullException(PhaseId, "PhaseId");

        Contract contract = new Contract();
        contract.setContractCode(ContractCode);
        Contract contract_db = contractDao.getDetail(contract);
        double invoiceTotalAmount = 0;
        List<Invoice> invoices = new ArrayList<>();


        InvoiceApply invoiceApply = new InvoiceApply();
        invoiceApply.setInvoiceApplyId(UUID.randomUUID().toString());
        String UserId = "";
        try {
            UserId = tools.getUserId(token);
        } catch (IPSFNetException e) {
            e.printStackTrace();
        }
        invoiceApply.setUserId(UserId);
        Person person = new Person();
        person.setUniqID(UserId);
        Person person_db = personDao.getDetail(person);
        invoiceApply.setName(person_db.getName());
        invoiceApply.setContractCode(ContractCode);
        invoiceApply.setInvoiceApplyIsDeal(0);
        invoiceApply.setPhaseId(PhaseId);

        invoiceApply.setInvoiceApplyTime(new Date());
        invoiceApply.setInvoiceApplyAmount(InvoiceApplyAmount);
        invoiceApply.setContractName(contract_db.getContractName());

        String PhaseDescribeMapstr = "";
        String[] PhaseIdArr = AnalyseStr(PhaseId);
        if (contract_db.getPhaseList() == null) {
            throw new PsCoreRuntimeException("无阶段信息，请先添加阶段信息再申请，以便财务核实.", 903);
        } else {
            double PhaseTotalAmountByPhaseId = 0;
            List<Phase> phases = contract_db.getPhaseList().getItems();
            for (int i = 0; i < phases.size(); i++) {
                for (int j = 0; j < PhaseIdArr.length; j++) {
                    if (phases.get(i).getPhaseId().equals(PhaseIdArr[j])) {
                        PhaseTotalAmountByPhaseId += phases.get(i).getPhaseAmount();
                        System.out.println("PhaseTotalAmountByPhaseId:" + PhaseTotalAmountByPhaseId);
                        PhaseDescribeMapstr += PhaseIdArr[j].toString() + ":";
                        PhaseDescribeMapstr += phases.get(i).getPhaseDescribe() + ",";
                    }
                }
            }
            if (invoiceApply.getInvoiceApplyAmount() > PhaseTotalAmountByPhaseId) {
                throw new PsCoreRuntimeException("该开票申请的金额超过了你所申请开票阶段的金额，申请开票失败", 908);
            }
            if (invoiceApply.getInvoiceApplyAmount() > contract_db.getContractAmount()) {
                throw new PsCoreRuntimeException("该开票申请的金额超过了该合同总金额，申请开票失败", 909);
            }
            invoiceApply.setPhaseDescribeMapString(PhaseDescribeMapstr);
            if (contract_db.getInvoiceList() != null) {

                invoices = contract_db.getInvoiceList().getItems();
                for (Invoice invoice :
                        invoices) {
                    invoiceTotalAmount += invoice.getInvoiceAmount();
                }
                if (invoiceTotalAmount < contract_db.getContractAmount()) {
                    if (contract_db.getInvoiceApplyList() != null) {
                        double InvoiceApplyTotalAmount = 0;
                        for (InvoiceApply ia :
                                contract_db.getInvoiceApplyList().getItems()) {
                            InvoiceApplyTotalAmount += ia.getInvoiceApplyAmount();
                        }
                        if ((invoiceApply.getInvoiceApplyAmount() + InvoiceApplyTotalAmount) > contract_db.getContractAmount()) {
                            throw new PsCoreRuntimeException("该开票申请的金额超过了该合同总金额，申请开票失败", 909);
                        }
                        InvoiceApplyList invoiceApplyList = contract_db.getInvoiceApplyList();
                        invoiceApplyList.add(invoiceApply);
                        invoiceApplyList.setTotalCount(invoiceApplyList.size());

                        contract_db.setInvoiceApplyList(invoiceApplyList);
                        Contract contract_dbNew = setContractInnerListTotalCount(contract_db);
                        contractDao.update(contract_dbNew);
                    } else {
                        InvoiceApplyList invoiceApplyList = new InvoiceApplyList();
                        invoiceApplyList.add(invoiceApply);
                        invoiceApplyList.setTotalCount(invoiceApplyList.size());

                        contract_db.setInvoiceApplyList(invoiceApplyList);
                        Contract contract_dbNew = setContractInnerListTotalCount(contract_db);
                        contractDao.update(contract_dbNew);
                    }
                    return invoiceApply;
                } else {
                    throw new PsCoreRuntimeException("已开发票的总金额已满足该合同总金额，申请开票失败", 904);
                }
            } else {
                if (contract_db.getInvoiceApplyList() != null) {
                    double InvoiceApplyTotalAmount = 0;
                    for (InvoiceApply ia :
                            contract_db.getInvoiceApplyList().getItems()) {
                        InvoiceApplyTotalAmount += ia.getInvoiceApplyAmount();
                    }
                    System.out.println("InvoiceApplyTotalAmount:" + InvoiceApplyTotalAmount);
                    if ((invoiceApply.getInvoiceApplyAmount() + InvoiceApplyTotalAmount) > contract_db.getContractAmount()) {
                        throw new PsCoreRuntimeException("该开票申请的金额超过了该合同总金额，申请开票失败", 909);
                    }
                    if ((invoiceApply.getInvoiceApplyAmount() + InvoiceApplyTotalAmount) > PhaseTotalAmountByPhaseId) {
                        throw new PsCoreRuntimeException("该开票申请的金额超过了你所申请开票阶段的金额，申请开票失败", 908);
                    }
                    InvoiceApplyList invoiceApplyList = contract_db.getInvoiceApplyList();
                    invoiceApplyList.setTotalCount(invoiceApplyList.size());
                    invoiceApplyList.add(invoiceApply);
                    contract_db.setInvoiceApplyList(invoiceApplyList);
                    Contract contract_dbNew = setContractInnerListTotalCount(contract_db);
                    contractDao.update(contract_dbNew);
                } else {

                    InvoiceApplyList invoiceApplyList = new InvoiceApplyList();
                    invoiceApplyList.add(invoiceApply);

                    invoiceApplyList.setTotalCount(invoiceApplyList.size());
                    contract_db.setInvoiceApplyList(invoiceApplyList);

                    Contract contract_dbNew = setContractInnerListTotalCount(contract_db);
                    contractDao.update(contract_dbNew);
                }

                return invoiceApply;
            }
        }


    }


    /**
     * 撤销开票申请  .
     *
     * @param token          token.
     * @param ContractCode   合同编号.
     * @param InvoiceApplyId 申请Id.
     */
    @Override
    public int deleteInvoiceApply(String token, String ContractCode, String InvoiceApplyId) {
        //TODO: .
        AssertUtils.ThrowArgNullException(ContractCode, "ContractCode");
        AssertUtils.ThrowArgNullException(InvoiceApplyId, "InvoiceCode");
        String[] InvoiceApplyCodeArr = AnalyseStr(InvoiceApplyId);

        Contract contract = new Contract();
        contract.setContractCode(ContractCode);
        Contract contract_db = contractDao.getDetail(contract);


        InvoiceApplyList invoiceApplyList = contract_db.getInvoiceApplyList();
        List<InvoiceApply> invoiceApplies = new ArrayList<>();
        invoiceApplies.addAll(invoiceApplyList.getItems());
        for (int i = 0; i < invoiceApplies.size(); i++) {
            if (InvoiceApplyCodeArr[i].equals(invoiceApplies.get(i).getInvoiceApplyId())) {
                if (invoiceApplies.get(i).getInvoiceApplyIsDeal() == 0) {
                    invoiceApplies.remove(invoiceApplies.get(i));
                } else {
                    throw new PsCoreRuntimeException("该申请已被处理，无法撤销。", 910);
                }
            }
        }
        if (invoiceApplies.size() == 0) {
            contract_db.setInvoiceApplyList(null);
            Contract contract_dbNew = setContractInnerListTotalCount(contract_db);
            int n = contractDao.update(contract_dbNew);
            //  int n = contractDao.update(contract_db);
            return n;
        }
        invoiceApplyList.clear();
        invoiceApplyList.addFrom(invoiceApplies);
        invoiceApplyList.setTotalCount(invoiceApplies.size());
        contract_db.setInvoiceApplyList(invoiceApplyList);
        Contract contract_dbNew = setContractInnerListTotalCount(contract_db);
        int n = contractDao.update(contract_dbNew);
        // int n = contractDao.update(contract_db);
        return n;

    }

    private Contract setContractInnerListTotalCount(Contract contract_db) {
        if (contract_db.getPhaseList() != null) {
            contract_db.getPhaseList().setTotalCount(contract_db.getPhaseList().getItems().size());
        }
        if (contract_db.getReceivableList() != null) {
            contract_db.getReceivableList().setTotalCount(contract_db.getReceivableList().getItems().size());
        }
        if (contract_db.getInvoiceList() != null) {
            contract_db.getInvoiceList().setTotalCount(contract_db.getInvoiceList().getItems().size());
        }
        if (contract_db.getInvoiceApplyList() != null) {
            contract_db.getInvoiceApplyList().setTotalCount(contract_db.getInvoiceApplyList().getItems().size());
        }
        return contract_db;
    }

    //收款满足阶段，填完成时间
    private Contract setContractPhaseFactTime(String ContractCode, Receivable receivable) {
        Contract contract = new Contract();
        contract.setContractCode(ContractCode);
        Contract contract_db = contractDao.getDetail(contract);
        if (contract_db.getPhaseList() != null) {
            List<Phase> phases = contract_db.getPhaseList().getItems();
            for (int i = 0; i < phases.size(); i++) {

                // if (phases.get(i).getFactTime() == null) {
                if ((contract_db.getContractAlreadyRec() - getTotalAmountBeforeThisPhase(contract_db, phases.get(i))) >= phases.get(i).getPhaseAmount()) {
                    phases.get(i).setFactTime(receivable.getRecTime());
                } else {
                    phases.get(i).setFactTime(null);
                }

                //}
            }
        }
        Contract contract_dbNew = setContractInnerListTotalCount(contract_db);
        contractDao.update(contract_dbNew);
        return contract_db;
    }

    //求该阶段之前阶段金额总额
    private double getTotalAmountBeforeThisPhase(Contract contract_db, Phase phase) {
        double TotalAmountBeforeThisPhase = 0;
        for (Phase p :
                contract_db.getPhaseList().getItems()) {
            if (p.getPhaseId().equals(phase.getPhaseId())) {
                break;
            } else {
                TotalAmountBeforeThisPhase += p.getPhaseAmount();
            }


        }
        return TotalAmountBeforeThisPhase;
    }

    /**
     * 销售查看自己开票申请列表  .
     *
     * @param token  token.
     * @param Option 选项.
     */
    @Override
    @RequiresPermissions("Contract:getOwnInvoiceApplyList")
    public InvoiceApplyList getOwnInvoiceApplyList(String token, int Option) {
        String UserId = null;
        try {
            UserId = tools.getUserId(token);
        } catch (IPSFNetException e) {
            e.printStackTrace();
        }
        if (UserId == null) {
            throw new PsCoreRuntimeException("用户Id为空", 701);
        }
        switch (Option) {
            case 0: {
                List<ProjectContractRet> projectContractRetList_db = contractDao.ExecuteQueryForList("queryProjectContractForApp", UserId);
                List<InvoiceApply> invoiceApplies = new ArrayList<>();
                for (ProjectContractRet pcr :
                        projectContractRetList_db) {
                    if (pcr.getInvoiceApplyList() != null) {
                        for (InvoiceApply invoiceApply :
                                pcr.getInvoiceApplyList().getItems()) {
                            invoiceApplies.add(invoiceApply);
                        }
                    }
                }


                InvoiceApplyList invoiceApplyList = new InvoiceApplyList();
                invoiceApplyList.setItems(invoiceApplies);
                invoiceApplyList.setTotalCount(invoiceApplies.size());
                return invoiceApplyList;
            }
        }
        return null;
    }

    @Override
    @RequiresPermissions("Contract:getContractStatistic")
    public HashMap<String, Object> getContractStatistic(String token, Date QueryDate) {
        HashMap<String, Object> map = new HashMap<>();
        //当前执行中合同总额
        ContractQueryPara contractQueryPara = new ContractQueryPara();
        contractQueryPara.setParamByContractStatus(0);
        //当前执行中合同列表
        List<Contract> contractList = contractDao.queryList(contractQueryPara, 0, -1);

        double allContractInvoiceShouldRecByQueryDate = 0;//
        double allContractShouldRecByQueryDate = 0;
        for (Contract c :
                contractList) {
            int resultPhase = (int) contractDao.ExecuteQueryForObject("queryPhaseColumn", c.getContractCode());
            if (resultPhase == 0) {
                continue;
            } else {
                if (QueryDate == null) {
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.DATE, -1);
                    QueryDate = calendar.getTime();
                }

                double everyContractInvoiceShouldRecByQueryDate = 0;
                double everyContractInvoiceNotRecTotalAmountByQueryDate = 0;
                double everyContractRecTotalAmountByQueryDate = 0;

                double everyContractShouldRecByQueryDate = 0;
                double everyContractPhaseAmountByQueryDate = 0;
                if (c.getInvoiceList() != null) {
                    for (Invoice invoice :
                            c.getInvoiceList().getItems()) {
                        if (!invoice.getInvoiceTime().after(QueryDate)) {
                            everyContractInvoiceNotRecTotalAmountByQueryDate += invoice.getInvoiceAmount();
                        }
                    }
                } else {
                    everyContractInvoiceNotRecTotalAmountByQueryDate = 0;
                }

                if (c.getReceivableList() != null) {
                    for (Receivable receivable :
                            c.getReceivableList().getItems()) {
                        if (!receivable.getRecTime().after(QueryDate)) {
                            everyContractRecTotalAmountByQueryDate += receivable.getRecAmount();
                        }
                    }
                } else {
                    everyContractRecTotalAmountByQueryDate = 0;
                }

                everyContractInvoiceShouldRecByQueryDate = everyContractInvoiceNotRecTotalAmountByQueryDate - everyContractRecTotalAmountByQueryDate;

                allContractInvoiceShouldRecByQueryDate += everyContractInvoiceShouldRecByQueryDate;
                if (c.getPhaseList() != null) {
                    for (Phase phase :
                            c.getPhaseList().getItems()) {
                            if (!phase.getPlanTime().after(QueryDate)) {
                                everyContractPhaseAmountByQueryDate += phase.getPhaseAmount();
                            }
                    }
                } else {
                    everyContractPhaseAmountByQueryDate = 0;
                }
                everyContractShouldRecByQueryDate = everyContractPhaseAmountByQueryDate - everyContractRecTotalAmountByQueryDate;
                allContractShouldRecByQueryDate += everyContractShouldRecByQueryDate;

            }
        }

        map.put("AllContractInvoiceShouldRecByQueryDate", allContractInvoiceShouldRecByQueryDate);
        map.put("AllContractShouldRecByQueryDate", allContractShouldRecByQueryDate);

        //当前执行中合同已收款


        return map;
    }

    private Contract sortPhaseListByPlanTime(Contract contract) {
        if (contract.getPhaseList() != null) {
            List<Phase> phases = contract.getPhaseList().getItems();
            for (int i = 0; i < phases.size(); i++) {
                for (int j = 1; j < phases.size() - i; j++) {
                    Phase p = new Phase();
                    if ((phases.get(j - 1).getPlanTime()).compareTo(phases.get(j).getPlanTime()) > 0) { // 比较两个整数的大小

                        p = phases.get(j - 1);
                        phases.set((j - 1), phases.get(j));
                        phases.set(j, p);
                    }
                }
            }

        }
        return contract;
    }

    private ProjectContractRetList setSellerNameByContractCode(ProjectContractRetList projectContractRetList) {
        if (projectContractRetList != null) {
            for (ProjectContractRet pcr :
                    projectContractRetList) {
                Project project = new Project();
                project.setProjectCode(pcr.getProjectCode());
                Project project_db = projectDao.getDetail(project);

                Person person = new Person();
                person.setUniqID(project_db.getUserId());
                Person person_db = personDao.getDetail(person);
                pcr.setName(person_db.getName());
            }
        }
        return projectContractRetList;
    }

    private Contract PopSortPhaseByPlanTime(Contract contract, int Option) {

        switch (Option) {
            case 0: {
                if (contract.getPhaseList() != null) {
                    List<Phase> phases = contract.getPhaseList().getItems();
                    for (int i = 0; i < phases.size(); i++) {
                        for (int j = 1; j < phases.size() - i; j++) {
                            Phase p = new Phase();
                            if ((phases.get(j - 1).getPlanTime()).compareTo(phases.get(j).getPlanTime()) > 0) { // 比较两个整数的大小

                                p = phases.get(j - 1);
                                phases.set((j - 1), phases.get(j));
                                phases.set(j, p);
                            }
                        }
                    }

                    PhaseList phaseList = new PhaseList();
                    phaseList.addFrom(phases);
                    phaseList.setTotalCount(phases.size());
                    contract.setPhaseList(phaseList);
                    contractDao.update(contract);
                }
            }
            case 1: {
                if (contract.getReceivableList() != null) {
                    List<Receivable> receivables = contract.getReceivableList().getItems();
                    for (int i = 0; i < receivables.size(); i++) {
                        for (int j = 1; j < receivables.size() - i; j++) {
                            Receivable p = new Receivable();
                            if ((receivables.get(j - 1).getRecTime()).compareTo(receivables.get(j).getRecTime()) > 0) { // 比较两个整数的大小

                                p = receivables.get(j - 1);
                                receivables.set((j - 1), receivables.get(j));
                                receivables.set(j, p);
                            }
                        }
                    }

                    ReceivableList receivableList = new ReceivableList();
                    receivableList.addFrom(receivables);
                    receivableList.setTotalCount(receivables.size());
                    contract.setReceivableList(receivableList);
                    contractDao.update(contract);
                }
            }
            case 2: {
                if (contract.getInvoiceList() != null) {
                    List<Invoice> invoices = contract.getInvoiceList().getItems();
                    for (int i = 0; i < invoices.size(); i++) {
                        for (int j = 1; j < invoices.size() - i; j++) {
                            Invoice p = new Invoice();
                            if ((invoices.get(j - 1).getInvoiceTime()).compareTo(invoices.get(j).getInvoiceTime()) > 0) { // 比较两个整数的大小

                                p = invoices.get(j - 1);
                                invoices.set((j - 1), invoices.get(j));
                                invoices.set(j, p);
                            }
                        }
                    }

                    InvoiceList invoiceList = new InvoiceList();
                    invoiceList.addFrom(invoices);
                    invoiceList.setTotalCount(invoices.size());
                    contract.setInvoiceList(invoiceList);
                    contractDao.update(contract);
                }
            }

        }
        return contract;
    }


}

