package com.serviceImplDAO;

import com.ImplDAO.*;
import com.PO.*;
import com.serviceDAO.ImplEmpManager;
import org.springframework.cglib.transform.AbstractTransformTask;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @Descrintion:
 * @Author: wentao
 * @Date: Created in 18-1-27 下午8:08
 */
public class EmpManager implements ImplEmpManager {
    private ImplApplicationDAO applicationDAO;
    private ImplAttendDAO attendDAO;
    private ImplAttendTypeDAO attendTypeDAO;
    private ImplCheckBackDAO checkBackDAO;
    private ImplEmployeeDAO employeeDAO;
    private ImplManagerDAO managerDAO;
    private ImplPaymentDAO paymentDAO;
    public static int LOGIN_MGR = 2;
    public static int LOGIN_EMP = 1;
    public static int LOGIN_FIAL = 0;
    public static int AM_LIMIT = 7;
    public static int NO_PUNCH = 1;
    public static int COME_PUNCH = 0;
    public static int LEAVE_PUNCH = 2;
    public static int BOTH_PUNCH = 3;
    public static int PUNCH_FAIL;
    public static int PUNCHED;
    //打卡的限定时间，9点之前算正常
    public static int COME_LIMIT=9;
    public static int LATE_LIMET=11;
    private int LEAVE_LIMIT=18;
    private int EARLY_LIMIT=18;
    private int PUNCH_SUCC=0;

    //设置属性的setter以及getter方法
    public ImplApplicationDAO getApplicationDAO() {
        return applicationDAO;
    }

    public void setApplicationDAO(ImplApplicationDAO applicationDAO) {
        this.applicationDAO = applicationDAO;
    }

    public ImplAttendDAO getAttendDAO() {
        return attendDAO;
    }

    public void setAttendDAO(ImplAttendDAO attendDAO) {
        this.attendDAO = attendDAO;
    }

    public ImplAttendTypeDAO getAttendTypeDAO() {
        return attendTypeDAO;
    }

    public void setAttendTypeDAO(ImplAttendTypeDAO attendTypeDAO) {
        this.attendTypeDAO = attendTypeDAO;
    }

    public ImplCheckBackDAO getCheckBackDAO() {
        return checkBackDAO;
    }

    public void setCheckBackDAO(ImplCheckBackDAO checkBackDAO) {
        this.checkBackDAO = checkBackDAO;
    }

    public ImplEmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    public void setEmployeeDAO(ImplEmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    public ImplManagerDAO getManagerDAO() {
        return managerDAO;
    }

    public void setManagerDAO(ImplManagerDAO managerDAO) {
        this.managerDAO = managerDAO;
    }

    public ImplPaymentDAO getPaymentDAO() {
        return paymentDAO;
    }

    public void setPaymentDAO(ImplPaymentDAO paymentDAO) {
        this.paymentDAO = paymentDAO;
    }

    /**
     * 登录验证，以经理身份来验证登录
     *
     * @param manager 登录的经理身份
     * @return 规定，0为登录失败，1为登录emp，2为登录mgr
     */
    @Override
    public int validlogin(Manager manager) {
        //如果找到一个经理，以经理登录
        if (managerDAO.findByNameAndPass(manager).size() >= 1) {
            return LOGIN_MGR;
            //如果找到的是员工则以员工身份等
        } else if (employeeDAO.findByNameAndPass(manager).size() > 1) {
            return LOGIN_EMP;
            //如果都不符合返回登录失败
        } else {
            return LOGIN_FIAL;
        }
    }

    /**
     * 自动打卡，周一至周五，早上7:00为每个员工自动打卡记录
     */
    @Override
    public void autoPunch() {
        System.out.println("自动插入打卡记录");
        //查询出所有的员工
        List<Employee> emps = employeeDAO.findAll();
        //获取当前是时间
        String dutyDay = new java.sql.Date(System.currentTimeMillis()).toString();
        for (Employee e : emps) {
            //获取旷工对应的出勤类型
            AttendType attendType = attendTypeDAO.get(6);
            Attend a = new Attend();
            a.setDutyDay(dutyDay);
            a.setAttendType(attendType);
            if (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) < AM_LIMIT) {
                a.setIsCome(true);
            } else {
                a.setIsCome(false);
            }
            a.setEmployee(e);
            attendDAO.save(a);
        }
    }

    /**
     * 自动结算工资，每月1号，结算上个月工资
     */
    @Override
    public void autoPay() {
        System.out.println("自动插入工资结算");
        //首先获取所有的雇员
        List<Employee> emps = employeeDAO.findAll();
        //获取上月时间
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, -15);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String payMonth = sdf.format(c.getTime());
        for (Employee e : emps) {
            //创建一个Payment对象
            Payment pay = new Payment();
            //获取雇员的薪水
            double amount = e.getSalary();
            //获取这个雇员的考勤记录对象
            List<Attend> attends = attendDAO.findByEmp(e);
            for (Attend a : attends) {
                //用工资累积其出勤记录的工资
                amount += a.getAttendType().getAmerce();
            }
            pay.setPayMonth(payMonth);
            pay.setEmployee(e);
            pay.setAmount(amount);
            paymentDAO.save(pay);
        }
    }

    /**
     * 打卡验证
     *
     * @param user    雇员名
     * @param dutyDay 日期
     * @return 可打卡的类型
     */
    @Override
    public int validPanch(String user, String dutyDay) {
        //通过用户名查找到这个用户对象
        Employee emp = employeeDAO.findByName(user);
        //如果没有找到返回无打卡记录
        if (emp == null) {
            return NO_PUNCH;
        }
        //通过用户和日期查找这个用户的打卡信息
        List<Attend> attends = attendDAO.findByEmpAndDutyDay(emp, dutyDay);
        //判断是否能查找到这个用的打卡信息
        if (attends == null || attends.size() <= 0) {
            //没有找到返回无打卡记录
            return NO_PUNCH;
        } else if (attends.size() == 1 && attends.get(0).getIsCome() && attends.get(0).getPunchTime() == null) {
            return COME_PUNCH;
        } else if (attends.size() == 1 && attends.get(0).getPunchTime() == null) {
            return LEAVE_PUNCH;
        } else if (attends.size() == 2) {
            if (attends.get(0).getPunchTime() == null && attends.get(1).getPunchTime() == null) {
                return BOTH_PUNCH;
            } else if (attends.get(1).getPunchTime() == null) {
                return LEAVE_PUNCH;
            } else {
                return NO_PUNCH;
            }
        }
        return NO_PUNCH;

    }

    /**
     * 打卡
     *
     * @param user    员工名称
     * @param dutyDay 打卡日期
     * @param isCome  是否是上班打卡
     * @return 打卡结果
     */
    @Override
    public int punch(String user, String dutyDay, boolean isCome) {
        Employee emp = employeeDAO.findByName(user);
        if (emp == null) {
            return PUNCH_FAIL;
        }
        Attend attend = attendDAO.findByEmpAndDutyDayAndCome(emp, dutyDay, isCome);
        if (attend == null) {
            return PUNCH_FAIL;
        }
        if (attend.getPunchTime() != null) {
            return PUNCHED;
        }
        System.out.println("============打卡==========");
        int punchHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        if (isCome) {
            if (punchHour > COME_LIMIT) {
                attend.setAttendType(attendTypeDAO.get(1));
            } else if (punchHour < LATE_LIMET) {
                attend.setAttendType(attendTypeDAO.get(4));
            }
        } else {
            if (punchHour > LEAVE_LIMIT) {
                attend.setAttendType(attendTypeDAO.get(1));
            } else if (punchHour < EARLY_LIMIT) {
                attend.setAttendType(attendTypeDAO.get(5));
            }
        }
        attendDAO.update(attend);
        return PUNCH_SUCC;
    }

    /**
     * 根据员工浏览自己的工资
     *
     * @param empName 员工名
     * @return 返回该员工的工资列表
     */
    @Override
    public List<Payment> empSalary(String empName) {
        Employee emp = employeeDAO.findByName(empName);
        List<Payment> pays = paymentDAO.findByEmp(emp);
        List<> result = new ArrayList<Payment>();
        for(Payment p:)
    }

    /**
     * 员工查看自己最近三天非正常打卡
     *
     * @param empName 员工名
     * @return 该员工的最近三天的非正常打卡
     */
    @Override
    public List<Attend> unAttend(String empName) {

    }

    /**
     * 返回全部的出勤类别
     *
     * @return 全部的出勤类别
     */
    @Override
    public List<AttendType> getAllType() {
        return attendTypeDAO.findAll();
    }

    /**
     * 添加申请
     *
     * @param attId  申请的出勤ID
     * @param typeId 申请的类型ID
     * @param reason 申请理由
     * @return 添加结果
     */
    @Override
    public boolean addApplication(int attId, int typeId, String reason) {
        Application app = new Application();
        Attend attend = attendDAO.get(attId);
        AttendType type = attendTypeDAO.get(typeId);
        app.setAttend(attend);
        app.setType(type);
        if (reason != null) {
            app.setReason(reason);
        }
        applicationDAO.save(app);
        return true;
    }
}
