package com.serviceImplDAO;

import com.ImplDAO.*;
import com.PO.*;
import com.serviceDAO.ImplEmpManager;

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
        if (managerDAO.)
    }

    /**
     * 自动打卡
     */
    @Override
    public void autoPunch() {

    }

    /**
     * 自动结算工资，每月1号，结算上个月工资
     */
    @Override
    public void autoPay() {

    }

    /**
     * 打卡验证
     *
     * @param user
     * @param dutyDay
     * @return
     */
    @Override
    public int validPanch(String user, String dutyDay) {
        return 0;
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
        return 0;
    }

    /**
     * 根据员工浏览自己的工资
     *
     * @param empName 员工名
     * @return 返回该员工的工资列表
     */
    @Override
    public List<Payment> empSalary(String empName) {
        return null;
    }

    /**
     * 员工查看自己最近三天非正常打卡
     *
     * @param empName 员工名
     * @return 该员工的最近三天的非正常打卡
     */
    @Override
    public List<Attend> unAttend(String empName) {
        return null;
    }

    /**
     * 返回全部的出勤类别
     *
     * @return 全部的出勤类别
     */
    @Override
    public List<AttendType> getAllType() {
        return null;
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
        return false;
    }
}
