package com.pengesoft.crmsystem;

import com.pengesoft.crmsystem.domain.entity.*;
import com.pengesoft.crmsystem.domain.entitylist.ProjectContractRetList;
import com.pengesoft.crmsystem.service.ContractMgeSvr;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pengesoft.service.PublishMethod;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

@SpringBootTest
class ContractMgeSvrTest {
    public static final String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIxIiwiZXhwIjoxNTg3NTIwNDMzfQ.KiQEghM0csQpM94r_CXWZNaT8rSHeoTfUn8bs63DdyM";
    @Autowired
    private ContractMgeSvr contractMgeSvr;

    @Test
    void contextLoads() {
    }

    @Test
    public Contract addContractTest() throws ParseException {
        String ContractCode = "TestingContractC9IK1265MVQZ9";
        String ContractName = "关于为东京老年活动中心开发老年网上冲浪系统合同样例";
        int ContractType = 3;
        String ProjectCode = "e49be271-2f83-44d2-a560-327427bae2ad";
        String PartyA = "东京老年活动中心";
        String PartyB = "日本发改委";
        String PartyC = "pycompany";
        double ContractAmount = 7055080.0;
        String ContractParentCode = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        int ContractStatus = 0;
        Date ContractSignTime = sdf.parse("2019-04-05");
        Date ContractEndTime = sdf.parse("2020-04-05");
        Date ContractEffectTime = sdf.parse("2019-04-10");
        Date ContractNoEffectTime = sdf.parse("2020-04-01");
        String ContractRemark = "好好完成";
        Contract contract = contractMgeSvr.addContract(token, ContractCode,ProjectCode, ContractName, ContractType,ContractStatus, PartyA, PartyB, PartyC, ContractAmount, ContractParentCode, ContractSignTime, ContractEndTime, ContractEffectTime, ContractNoEffectTime, ContractRemark);
        return contract;
    }

    @Test
    public int updateContract() throws ParseException {
        String ContractCode = "TestingContractC9IK1265MVQZ9";

        String ProjectCode = "e49be271-2f83-44d2-a560-327427bae2ad";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Date ContractEffectTime = sdf.parse("2019-04-06");
        Date ContractNoEffectTime = sdf.parse("2020-04-02");
        String ContractName = "关于为日本东京老年活动中心开发老年网上冲浪系统合同样例";
        int ContractType = 3;
        String PartyA = "东京老年活动中心";
        String PartyB = "日本国务院";
        String PartyC = "pycompany";
        double ContractAmount = 6981780.0;
        String ContractParentCode = null;
        Date ContractSignTime = sdf.parse("2019-04-05");
        Date ContractEndTime = sdf.parse("2020-04-05");
        String ContractRemark = "争取2020干完";
        int ContractStatus = 0;
        int n = contractMgeSvr.updateContract(token, ContractCode, ProjectCode, ContractEffectTime,ContractNoEffectTime, ContractName, ContractType,ContractStatus, PartyA, PartyB, PartyC, ContractAmount, ContractParentCode, ContractSignTime, ContractEndTime, ContractRemark);
        return n;
    }

    /**
     * 删除合同信息  .
     */
    @Test
    int deleteContract() {
        String ContractCode = "TestingContractC9IK1265MVQZ9";
        int n = contractMgeSvr.deleteContract(token, ContractCode);
        return n;
    }

    @Test
    ProjectContractRetList getOwnContractList() {

        int Option = 0;
        int SortNum = 0;
        String ProjectNum = "asdasd";
        ProjectContractRetList projectContractRetList = contractMgeSvr.getOwnContractList(token,ProjectNum, Option,SortNum);
        return projectContractRetList;
    }

    /**
     * (从项目进)获取合同列表（如果有项目编号就从项目进，如果没有就是从合同进）  .
     *
     */
    @Test
    ProjectContractRetList getContractList() {
        int sizeNum = 5;
        int skipNum = 1;
        int Option = 0;
        String ProjectCode ="e49be271-2f83-44d2-a560-327427bae2ad";
        int SortNum=0;
        ProjectContractRetList projectContractRetList = contractMgeSvr.getContractList(token,sizeNum,skipNum,ProjectCode,Option,SortNum);
        return projectContractRetList;
    }


//
//    @Test
//    ProjectContractRetList fuzzySearchContract() {
//        int sizeNum=5;
//        int skipNum=1;
//        String SearchCondition="老年";
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        Date ContractStartTime=null;
//        Date ContractEndTime=null;
//        int Option =0;
//
//      ProjectContractRetList projectContractRetList = contractMgeSvr.fuzzySearchContract(token,  sizeNum,  skipNum,  SearchCondition,  ContractStartTime,  ContractEndTime,  Option);
//        return projectContractRetList;
//    }


    /**
     * 获取合同详情（包含阶段信息、收款、发票）  .
     *
     */
  /*  @Test
    ProjectContractRet getContractDetail(String token, String ContractCode, int Option) {
    }*/

    /**
     * 添加阶段信息  .
     */
/*    @Test
    Phase addPhase(String token, String ContractCode, String PhaseId, String PhaseDescribe, Date PhasePlanTime, int PhaseType, double PhaseAmount, Date PhaseFactTime) {
    }*/


    /**
     * 删除阶段信息  .
 /*   @Test
    int deletePhase(String token, String ContractCode, String PhaseId) {
    }*/

    /**
     * 添加发票信息  .
     */
/*    @Test
    Invoice addInvoice(String token, Date InvoiceTime, String ContractCode, String InvoiceCode, double InvoiceAmount, String InvoicePerson, int InvoiceType) {
    }*/

    /**
     * 删除发票信息  .
     *
     */
/*    @Test
    int deleteInvoice(String token, String ContractCode, String InvoiceCode) {
    }*/

    /**
     * 添加收款信息  .
     *
     */
 /*   @Test
    Receivable addReceivable(String token, String InvoiceCode, String ContractCode, double RecAmount, Date RecTime, int RecType) {
    }*/

    /**
     * 删除收款信息  .
     *
     */
/*    @Test
    int deleteReceivable(String token, String ContractCode, String RecId) {
    }*/


    /**
     * app首页项目合同信息列表  .
     */
/*    @Test
    ProjectContractRetList getProjectContractList(String token, int Option) {
    }*/


    /**
     * 合同统计接口  .
     *
     */
/*    @Test
    HashMap<String, Object> getProjectStatistic(String token, int QueryYear, int QueryYear2) {
    }*/


    /**
     * 获取待办数据  .
     *
     */
    @Test
    HashMap<String, Object> getBacklogDataForSeller() {
        HashMap<String, Object> map = contractMgeSvr.getBacklogDataForSeller(token);
        return map;
    }

    @Test
    HashMap<String, Object> getBacklogDataForFinance(String token) {
        HashMap<String, Object> map = contractMgeSvr.getBacklogDataForFinance(token);
        return map;
    }

 /*   @Test
    HashMap<String, Object> getBacklogData(String token) {
    }*/


}
