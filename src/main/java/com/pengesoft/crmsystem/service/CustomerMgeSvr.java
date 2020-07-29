package com.pengesoft.crmsystem.service;

import com.pengesoft.crmsystem.component.tools;
import com.pengesoft.crmsystem.domain.QueryPara.ContractQueryPara;
import com.pengesoft.crmsystem.domain.QueryPara.CustomerQueryPara;
import com.pengesoft.crmsystem.domain.QueryPara.ProjectQueryPara;
import com.pengesoft.crmsystem.domain.dao.IContractDao;
import com.pengesoft.crmsystem.domain.dao.ICustomerDao;
import com.pengesoft.crmsystem.domain.dao.IProjectDao;
import com.pengesoft.crmsystem.domain.entity.*;
import com.pengesoft.crmsystem.domain.entitylist.PhaseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pengesoft.account.Person;
import pengesoft.account.PersonQueryPara;
import pengesoft.account.dao.IPersonDao;
import pengesoft.auth.annotation.RequiresPermissions;
import pengesoft.auth.role.dao.IAuthRoleDao;
import pengesoft.common.IPSFNetException;
import pengesoft.service.ApplicationBase;
import pengesoft.utils.AssertUtils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * ICustomerMgeSvr 接口实现。客户服务.
 *
 * @auther: 曾小锐.
 * @date: 2020/3/30 15:55:41.
 * <p>
 * Copyright (C) 2008 - 鹏业软件公司
 */
@Service
@Transactional
public class CustomerMgeSvr extends ApplicationBase implements ICustomerMgeSvr {


    @Autowired
    ICustomerDao customerDao;
    @Autowired
    IProjectDao projectDao;
    @Autowired
    IPersonDao personDao;
    @Autowired
    IAuthRoleDao authRoleDao;
    @Autowired
    IContractDao contractDao;

    /**
     * 添加客户  .
     *
     * @param token          token.
     * @param CustName       客户名称.
     * @param CustEmail      邮箱.
     * @param CustTel        手机.
     * @param CustPhone      座机.
     * @param CustRemark     备注.
     * @param CustRegionCode 地区代码.
     * @param CustAddress    详细地址.
     * @param ContactName    联系人姓名.
     * @param ContactTel     联系人电话.
     * @param ContactDuty    联系人职务.
     */
    @Override
    @RequiresPermissions("customer:addCustomer")
    public Customer addCustomer(String token, String CustName, String CustEmail, String CustTel, String CustPhone, String CustRemark, int CustRegionCode, String CustAddress, String ContactName, String ContactTel, String ContactDuty) {
        // TODO: 2020/4/1 已测试
        AssertUtils.ThrowArgNullException(CustName, "CustName", true);
//        AssertUtils.ThrowArgNullException(CustTel, "CustTel",true);
        AssertUtils.ThrowArgNullException(CustPhone, "CustPhone", true);
        AssertUtils.ThrowArgNullException(CustAddress, "CustAddress", true);
        AssertUtils.ThrowArgNullException(ContactName, "ContactName", true);
        AssertUtils.ThrowArgNullException(ContactTel, "ContactTel", true);
//        AssertUtils.ThrowArgZeroException(CustRegionCode, "CustRegionCode");

        Customer customer = new Customer();
        customer.setCustName(CustName);
        customer.setCustEmail(CustEmail);
        customer.setContactName(ContactName);
        customer.setContactTel(ContactTel);
        customer.setContactDuty(ContactDuty);
        customer.setCustPhone(CustPhone);
        customer.setCustRemark(CustRemark);
        customer.setCustRegionCode(CustRegionCode);
        customer.setCustAddress(CustAddress);
        Date date = new Date();
        customer.setCustCreateTime(date);
        customer.setCustUpdateTime(date);
        String UserId = null;
        try {
            UserId = tools.getUserId(token);
        } catch (IPSFNetException e) {
            e.printStackTrace();
        }
//        customer.setUserId(UserId);
        customerDao.insert(customer);
        CustomerQueryPara para = new CustomerQueryPara();
        List<Customer> list = customerDao.queryList(para, 0, -1);
        customer.setCustId(list.get(0).getCustId());
        return customer;
    }

    /**
     * 修改客户基本信息  .
     *
     * @param token      token.
     * @param CustId     客户Id.
     * @param CustName   客户名称.
     * @param CustEmail  邮箱.
     * @param CustTel    手机.
     * @param CustPhone  座机.
     * @param CustRemark 备注.
     * @param CustAddress 地址.
     */
    @Override
    @RequiresPermissions("customer:updateCustomer")
    public int updateCustomer(String token, int CustId, String CustName, String CustEmail, String CustTel, String CustPhone, String CustRemark,String CustAddress) {
        //TODO: 实现.
        AssertUtils.ThrowArgZeroException(CustId, "CustId");
        AssertUtils.ThrowArgNullException(CustName, "CustName", true);
        AssertUtils.ThrowArgNullException(CustPhone, "CustPhone", true);
        Customer customer = new Customer();
        customer.setCustId(CustId);
        customer.setCustTel(CustTel);
        customer.setCustName(CustName);
        customer.setCustEmail(CustEmail);
        customer.setCustPhone(CustPhone);
        customer.setCustRemark(CustRemark);
        customer.setCustAddress(CustAddress);
//        设置更新时间
        Date date = new Date();
        customer.setCustUpdateTime(date);
        customerDao.ExecuteUpdate("updateSomeCustomer", customer);
        return 1;
    }

    /**
     * 修改客户联系人  .
     *
     * @param token       token.
     * @param CustId      客户Id.
     * @param ContactName 联系人姓名.
     * @param ContactTel  联系人电话.
     * @param ContactDuty 联系人职务.
     */
    @Override
    @RequiresPermissions("customer:updateCustomerContact")
    public int updateCustomerContact(String token, int CustId, String ContactName, String ContactTel, String ContactDuty) {
        //TODO: 已测试.
        AssertUtils.ThrowArgZeroException(CustId, "CustId");
        AssertUtils.ThrowArgNullException(ContactName, "ContactName", true);
        AssertUtils.ThrowArgNullException(ContactTel, "ContactTel", true);
        AssertUtils.ThrowArgNullException(ContactTel, "ContactDuty", true);
        Date date = new Date();
        CustomerQueryPara para = new CustomerQueryPara();
        para.setParamByCustId(CustId);
        para.setParamByContactName(ContactName);
        para.setParamByContactDuty(ContactDuty);
        para.setParamByContactTel(ContactTel);
        para.setParamByCustUpdateTime(date);
        customerDao.ExecuteUpdate("updateCustomerContact", para);
        return 1;
    }

    /**
     * 删除客户  .
     *
     * @param token      token.
     * @param CustomerId 客户Id.
     */
    @Override
    @RequiresPermissions("customer:deleteCustomer")
    public int deleteCustomer(String token, String CustomerId) {

        AssertUtils.ThrowArgNullException(CustomerId, "CustomerId", true);
        int[] array = tools.StringToint(CustomerId);

        if (array.length == 0) {
            return 0;
        }
        for (int i = 0; i <= array.length; i++) {
            Customer customer = new Customer();
            customer.setCustId(array[i]);
            customerDao.delete(customer);
        }
        return 1;
    }

    /**
     * 分配客户  .
     * 批量分配
     *
     * @param token      token.
     * @param UserId     销售人Id.
     * @param CustomerId 客户Id.
     */
    @Override
    @RequiresPermissions("customer:distributeCustomer")
    public int distributeCustomer(String token, String UserId, String CustomerId) {
        //TODO: 实现.
        AssertUtils.ThrowArgNullException(CustomerId, "CustomerId", true);
        AssertUtils.ThrowArgNullException(UserId, "UserId", true);
        int[] array = tools.StringToint(CustomerId);
        for (int i = 0; i < array.length; i++) {
            Customer customer = new Customer();
            customer.setCustId(array[i]);
            customer.setUserId(UserId);
            //设置更新时间
            Date date = new Date();
            customer.setCustUpdateTime(date);
            customerDao.ExecuteUpdate("updateCustomerDistribute", customer);
            ProjectQueryPara projectQueryPara = new ProjectQueryPara();
            projectQueryPara.setParamByCustId(array[i]);
            List<Project> projectList = projectDao.queryList(projectQueryPara,0,-1);
            for (Project project:projectList){
                project.setUserId(UserId);
                projectDao.update(project);
            }
        }
        return 1;
    }

    /**
     * 获取客户详情  .
     *
     * @param token  token.
     * @param CustId 客户Id.
     * @param Option 选项.
     */
    @Override
    @RequiresPermissions("customer:getCustomerDetail")
    public Customer getCustomerDetail(String token, int CustId, int Option) {
        //TODO: 未实现.
        AssertUtils.ThrowArgZeroException(CustId, "CustId");
        AssertUtils.ThrowArgZeroException(Option, "Option");
        switch (Option) {
            case 1:
                CustomerQueryPara para = new CustomerQueryPara();
                para.setParamByCustId(CustId);
                List<Customer> list = customerDao.queryList(para, 0, -1);
                PersonQueryPara personQueryPara = new PersonQueryPara();
                if (list.get(0).getUserId() == null||list.get(0).getUserId() == ""){
                    return list.get(0);
                }else {
                    personQueryPara.setParamByUniqID(list.get(0).getUserId());
                    List<Person> people = personDao.queryList(personQueryPara, 0, -1);
                    list.get(0).setName(people.get(0).getName());
                    return list.get(0);
                }
        }
        return null;
    }

//

    /**
     * 销售主管获取自身客户列表(token取自己ID)（销售主管获取销售员工或全部客户列表）  .
     *
     * @param token   token.
     * @param skipNum skipNum.
     * @param sizeNum sizeNum.
     * @param Option  选项 0查询的所有 1查询简单信息 2查询详细信息 4按照销售id查询所有.
     */
    @Override
    @RequiresPermissions("customer:getCustomerList")
    public List<Object> getCustomerList(String token, int skipNum, int sizeNum, int Option) {
        //TODO: 已经测试.
        CustomerQueryPara para = new CustomerQueryPara();
        switch (Option) {
            //查询的所有
            case 0:
                List list = customerDao.queryList(para, skipNum, sizeNum);
                return list;
            //查询简单信息
            case 1:
                return customerDao.ExecuteQueryForList("getSimpleInfo", para, skipNum, sizeNum);
        }
        return null;
    }

    /**
     * 根据销售id查询用户自己的客户列表
     *
     * @param token
     * @param Option 1.为全部信息  2.简单信息
     * @return
     */
    @Override
    @RequiresPermissions("customer:getCustumerListByUserId")
    public List<Object> getCustumerListByUserId(String token, int skipNum, int sizeNum, int Option) {
        String UserId = null;
        try {
            UserId = tools.getUserId(token);
        } catch (IPSFNetException e) {
            e.printStackTrace();
        }
        CustomerQueryPara para = new CustomerQueryPara();
        para.setParamByUserId(UserId);
        switch (Option) {
            case 1:
                List list = customerDao.queryList(para, skipNum, sizeNum);
                return list;
                default:
        }
        return null;
    }

    /**
     * 查询所有与客户有关的拜访
     *
     * @param token
     * @param Option
     * @return
     */
    @RequiresPermissions("customer:getCustomerOutVisit")
    public List<Object> getCustomerOutVisit(String token, int Option) {
        //Todo:未实现
        switch (Option) {
            case 1:

            case 2:

        }
        return null;
    }

    /**
     * 模糊查询
     *
     * @param token
     * @param Str
     * @param Option
     * @return
     */
    @Override
    @RequiresPermissions("customer:getCustomerLike")
    public List<Customer> getCustomerLike(String token, String Str, int Option, int skipNum, int sizeNum) {
        String UserId = null;
        try {
            UserId = tools.getUserId(token);
        } catch (IPSFNetException e) {
            e.printStackTrace();
        }
        if (Str == null || Str == "") {
            CustomerQueryPara paraa = new CustomerQueryPara();
            return customerDao.queryList(paraa, 0, -1);
        }
        CustomerQueryPara para = new CustomerQueryPara();
        ArrayList<Integer> idlist = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<String, Object>();
        List<Customer> customerList = new ArrayList<>();

        switch (Option) {
            case 0:
                List<Customer> list = customerDao.queryList(para, 0, -1);
                for (Customer customer : list) {
                    idlist.add(customer.getCustId());
                }
                map.put("idlist", idlist);
                map.put("Str", Str);
                List<Customer> list1 = customerDao.ExecuteQueryForList("queryCustomerLike", map);
                for (Customer customer : list1) {
                    PersonQueryPara personQueryPara = new PersonQueryPara();
                    personQueryPara.setParamByUniqID(customer.getUserId());
                    List<Person> people = personDao.queryList(personQueryPara, 0, -1);
                    customer.setName(people.get(0).getName());
                }
                return devidePage(skipNum, sizeNum, list1);
            case 1:
                List<Person> peoplelist = getUser(token, 0, -1);
                for (Person person : peoplelist) {
                    para.setParamByUserId(person.getUniqID());
                    List<Customer> list3 = customerDao.queryList(para, 0, -1);
                    for (Customer cus : list3) {
                        idlist.add(cus.getCustId());
                    }
                }
                System.out.println(idlist);
                if (idlist.size() != 0) {
                    map.put("idlist", idlist);
                    map.put("Str", Str);
                    List<Customer> list4 = customerDao.ExecuteQueryForList("queryCustomerLike", map);
                    for (Customer customer : list4) {
                        PersonQueryPara personQueryPara = new PersonQueryPara();
                        personQueryPara.setParamByUniqID(customer.getUserId());
                        List<Person> people = personDao.queryList(personQueryPara, 0, -1);
                        customer.setName(people.get(0).getName());
                    }
                    return devidePage(skipNum, sizeNum, list4);
                }
            case 2:
                List<Customer> listsea = getCustomerSeaList(token, 0, -1, 0);
                for (Customer cli : listsea) {
                    idlist.add(cli.getCustId());
                }
                if (idlist.size() != 0) {
                    map.put("idlist", idlist);
                    map.put("Str", Str);
                    List<Customer> lissea = customerDao.ExecuteQueryForList("queryCustomerLike", map);
                    for (Customer customer : lissea) {
                        PersonQueryPara personQueryPara = new PersonQueryPara();
                        personQueryPara.setParamByUniqID(customer.getUserId());
                        List<Person> people = personDao.queryList(personQueryPara, 0, -1);
                        customer.setName(people.get(0).getName());
                    }
                    return devidePage(skipNum, sizeNum, lissea);
                }
        }
        return null;
    }

    /**
     * 分页工具
     *
     * @param skipNum
     * @param sizeNum
     * @param list
     * @return
     */
    public List<Customer> devidePage(int skipNum, int sizeNum, List<Customer> list) {
        int fromIndex = 0;
        int toIndex = 0;
        if (-1 == sizeNum) {
            fromIndex = 0;
            toIndex = list.size();
        } else {
            fromIndex = (skipNum - 1) * sizeNum;
            toIndex = fromIndex + sizeNum;
            if (toIndex > list.size()) {
                toIndex = list.size();
            }
        }
        List<Customer> pageList = list.subList(fromIndex, toIndex);
        return pageList;
    }

    /**
     * 按部门的数量统计
     *
     * @param token
     * @param Option
     * @return map
     */
    @Override
    @RequiresPermissions("customer:getCustomerListCount")
    public Map<String, Integer> getCustomerListCount(String token, int Option) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int usercount=0, userscount = 0, seacount, potcount = 0, cationcount = 0;
        //部门的里客户数量
        List<Customer> customers = getCustomerListByAdmin(token, 0, -1, 0);
        usercount = customers.size();
        //公司所有的客户
        CustomerQueryPara para = new CustomerQueryPara();
        userscount = customerDao.queryCount(para);
        //公海数量
        CustomerQueryPara paraSea = new CustomerQueryPara();
        seacount = customerDao.queryCount("queryCustomerCountSea", paraSea);
        //潜在客户数量
        List<Customer> list = customerDao.queryList(para, 0, -1);
        ProjectQueryPara project = new ProjectQueryPara();
        Date nowdate = new Date();
        for (Customer c : list) {
            project.setParamByCustId(c.getCustId());
            List<Project> list1 = projectDao.queryList(project, 0, -1);
            if (list1.size() == 0) {
                potcount++;
                //待分配数量
                if (tools.getDayTime(nowdate, c.getCustCreateTime()) >= 30) {
                    cationcount++;
                }
            }
        }
        map.put("userscount", userscount);
        map.put("usercount", usercount);
        map.put("seacount", seacount);
        map.put("potcount", potcount);
        map.put("cationcount", cationcount);
        return map;
    }


    /**
     * 统计每一个销售的各个数量
     *
     * @param token
     * @param Option
     * @return
     */

    @Override
    @RequiresPermissions("customer:getCountByuser")
    public List<Object> getCountByuser(String token, int Option) {

        Date now = new Date();
        List<Object> listmap = new ArrayList<>();
        List<Person> people = getUser(token, 0, -1);
        for (Person person : people) {
            int customercount = 0, projectcount = 0, concount = 0;
            double countmoney = 0.0, recmoney = 0.0, allcountmoney = 0.0,notmoney=0.0;
            CustomerQueryPara customerQueryPara = new CustomerQueryPara();
            customerQueryPara.setParamByUserId(person.getUniqID());
            //客户数量
            customercount = customerDao.queryCount(customerQueryPara);
            ProjectQueryPara projectQueryPara = new ProjectQueryPara();
            projectQueryPara.setParamByUserId(person.getUniqID());
            List<Project> list = projectDao.queryList(projectQueryPara, 0, -1);
            List<Project> normallist = new ArrayList<>();
            //正在跟进的项目
            for (Project project : list) {
                if (project.getProjectStatus() != 2) {
                    normallist.add(project);
                    if (project.getProjectPLevel() != 5) {
                        projectcount++;
                    }
                }
            }
            for (Project project : normallist) {
                ContractQueryPara contractQueryPara = new ContractQueryPara();
                contractQueryPara.setParamByProjectCode(project.getProjectCode());
                //合同数
                concount += contractDao.queryCount(contractQueryPara);
                List<Contract> contractList = contractDao.queryList(contractQueryPara, 0, -1);
                for (Contract contract : contractList) {
                    if (contract.getPhaseList() != null) {
                        for (Phase phase : contract.getPhaseList()) {
                            Date PlanTime;
                            Date nowdate = new Date();
                            PlanTime = phase.getPlanTime();
                            //所有代收款
                            allcountmoney += phase.getPhaseAmount();
                            if (tools.getDayTime(PlanTime,nowdate)<0){
                                if (phase.getFactTime()==null){
                                    //到目前为止未收
                                    notmoney += phase.getPhaseAmount();
                                }
                            }
                            if (tools.sameyear(PlanTime)) {
                                //今年所有待收款
                                countmoney += phase.getPhaseAmount();
                            }
                        }
                    }
                    if (contract.getReceivableList() != null) {
                        for (Receivable receivable : contract.getReceivableList()) {
                            Date Rectime;
                            Rectime = receivable.getRecTime();
                            if (tools.sameyear(Rectime)) {
                                //今年所有已收款
                                recmoney += receivable.getRecAmount();
                                System.out.println(recmoney);
                            }
                        }
                    }
                }

            }
            Map<Object, Object> map = new HashMap<Object, Object>();
            map.put("username", person.getName());
            map.put("userid", person.getUniqID());
            map.put("customercount", customercount);
            map.put("projectcount", projectcount);
            map.put("concount", concount);
            map.put("countmoney", countmoney);
            map.put("notmoney",(countmoney-recmoney));
            map.put("allcountmoney", allcountmoney);
            map.put("recmoney", recmoney);
            if (countmoney != 0) {
                double a = 0.0;
                a = recmoney / countmoney;
                map.put("progress", a);
            } else {
                map.put("progress", 0);
            }
            listmap.add(map);
        }
        return listmap;
    }

    /**
     * 查询公海的客户
     *
     * @param token
     * @param skipNum
     * @param sizeNum
     * @param Option
     * @return
     */
    @Override
    @RequiresPermissions("customer:getCustomerSeaList")
    public List<Customer> getCustomerSeaList(String token, int skipNum, int sizeNum, int Option) {
        CustomerQueryPara para = new CustomerQueryPara();
        List<Customer> list = customerDao.ExecuteQueryForList("customersea", para);
        return devidePage(skipNum, sizeNum, list);
    }

    /**
     * 查询待分配的客户
     *
     * @param token
     * @param skipNum
     * @param sizeNum
     * @param Option
     * @return
     */
    @Override
    @RequiresPermissions("customer:getCustomerSeaListCat")
    public List<Customer> getCustomerSeaListCat(String token, int skipNum, int sizeNum, int Option) {
        CustomerQueryPara para = new CustomerQueryPara();
        List<Customer> list = customerDao.ExecuteQueryForList("customersea", para);
        Date nowdate = new Date();
        List<Customer> catlist = new ArrayList<>();
        for (Customer c : list) {
            if (tools.getDayTime(nowdate, c.getCustCreateTime()) >= 30) {
                catlist.add(c);
            }
        }
        return devidePage(skipNum, sizeNum, catlist);
    }

    /**
     * 查询潜在的客户
     *
     * @param token
     * @param skipNum
     * @param sizeNum
     * @param Option
     * @return
     */
    @Override
    @RequiresPermissions("customer:getCutimerListpot")
    public List<Customer> getCutimerListpot(String token, int skipNum, int sizeNum, int Option) {
        CustomerQueryPara para = new CustomerQueryPara();
        List<Customer> list = customerDao.queryList(para, 0, -1);
        ProjectQueryPara project = new ProjectQueryPara();
        List<Customer> customerList = new ArrayList<>();
        for (Customer customer : list) {
            project.setParamByCustId(customer.getCustId());
            List<Project> list1 = projectDao.queryList(project, 0, -1);
            if (list1.size() == 0) {
                customerList.add(customer);
            }
        }
        return devidePage(skipNum, sizeNum, customerList);
    }


    /**
     * 查看部门里的客户
     *
     * @param token
     * @param skipNum
     * @param sizeNum
     * @param Option
     * @return
     */
    @RequiresPermissions("customer:getCustomerListByAdmin")
    @Override
    public List<Customer> getCustomerListByAdmin(String token, int skipNum, int sizeNum, int Option) {

        String UserId = null;
        try {
            UserId = tools.getUserId(token);
        } catch (IPSFNetException e) {
            e.printStackTrace();
        }
        //取到自己的组织人员
            List<Person> orgain = getUser(token, 0, -1);
            //取到部门的所有人的客户
            CustomerQueryPara customer = new CustomerQueryPara();
            List<Customer> customerslist = new ArrayList<>();
            for (Person p : orgain) {
                customer.setParamByUserId(p.getUniqID());
                List<Customer> list = customerDao.queryList(customer, 0, -1);
                for (Customer c : list) {
                    c.setName(p.getName());
                }
            customerslist.addAll(list);
        }
        if (Option == 2){
                List<Customer> customerList = getCustomerSeaList(token,0,-1,0);
                customerslist.addAll(customerList);
        }

        return devidePage(skipNum, sizeNum, customerslist);
    }

    /**
     * 按id获取客户的角色
     *
     * @param token
     * @return 角色id
     */
    @Override
    @RequiresPermissions("customer:getUserRole")
    public int[] getUserRole(String token) {
        String UserId = null;
        try {
            UserId = tools.getUserId(token);
        } catch (IPSFNetException e) {
            e.printStackTrace();
        }
        PersonQueryPara para = new PersonQueryPara();
        para.setParamByUniqID(UserId);
        List<Person> list = personDao.queryList(para, 0, -1);
        return list.get(0).getRoleIds();
    }


    /**
     * 获取部门成员
     *
     * @param token
     * @return
     */
    @Override
    @RequiresPermissions("customer:getUser")
    public List<Person> getUser(String token, int skipNum, int sizeNum) {
        String UserId = null;
        try {
            UserId = tools.getUserId(token);
        } catch (IPSFNetException e) {
            e.printStackTrace();
        }
        //取到用户的信息
        PersonQueryPara person = new PersonQueryPara();
        person.setParamByUniqID(UserId);
        ArrayList<String> idlist = new ArrayList<>();
        List<Person> people = personDao.queryList(person, 0, -1);
        //取到用户的部门人员
        PersonQueryPara para = new PersonQueryPara();
        para.setParamByOrganization(people.get(0).getOrganization());
        List<Person> orgain = personDao.queryList(para, 0, -1);

        //分页
        int fromIndex = 0; // 开始索引
        int toIndex = 0; // 结束索引
        if (-1 == sizeNum) {
            fromIndex = 0;
            toIndex = orgain.size();
        } else {
            fromIndex = (skipNum - 1) * sizeNum;
            toIndex = fromIndex + sizeNum;
            if (toIndex > orgain.size()) {
                toIndex = orgain.size();
            }
        }
        List<Person> pageList = orgain.subList(fromIndex, toIndex);
        return pageList;
    }

}


