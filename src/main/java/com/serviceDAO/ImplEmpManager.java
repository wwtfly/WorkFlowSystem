package com.serviceDAO;

import com.PO.Attend;
import com.PO.AttendType;
import com.PO.Manager;
import com.PO.Payment;

import java.util.List;

/**
 * @Descrintion:
 * @Author: wentao
 * @Date: Created in 18-1-27 下午7:40
 */
public interface ImplEmpManager {
    /**
     * 登录验证，以经理身份来验证登录
     *
     * @param manager 登录的经理身份
     * @return 规定，0为登录失败，1为登录emp，2为登录mgr
     */
    public int validlogin(Manager manager);

    /**
     * 自动打卡
     */
    public void autoPunch();

    /**
     * 自动结算工资，每月1号，结算上个月工资
     */
    public void autoPay();

    /**
     * 打卡验证
     *
     * @param user
     * @param dutyDay
     * @return
     */
    public int validPanch(String user, String dutyDay);

    /**
     * 打卡
     *
     * @param user    员工名称
     * @param dutyDay 打卡日期
     * @param isCome  是否是上班打卡
     * @return 打卡结果
     */
    public int punch(String user, String dutyDay, boolean isCome);

    /**
     * 根据员工浏览自己的工资
     *
     * @param empName 员工名
     * @return 返回该员工的工资列表
     */
    public List<Payment> empSalary(String empName);

    /**
     * 员工查看自己最近三天非正常打卡
     *
     * @param empName 员工名
     * @return 该员工的最近三天的非正常打卡
     */
    public List<Attend> unAttend(String empName);

    /**
     * 返回全部的出勤类别
     *
     * @return 全部的出勤类别
     */
    public List<AttendType> getAllType();

    /**
     * 添加申请
     *
     * @param attId  申请的出勤ID
     * @param typeId 申请的类型ID
     * @param reason 申请理由
     * @return 添加结果
     */
    public boolean addApplication(int attId, int typeId, String reason);
}
