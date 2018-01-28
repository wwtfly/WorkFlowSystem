package com.PO;

import java.io.Serializable;
import java.util.Date;

/**
 * @Descrintion:员工的考勤记录，包含考勤时间、考勤员工、是否上班以及考勤类别等信息
 * @Author: wentao
 * @Date: Created in 18-1-22 下午10:41
 */
public class Attend implements Serializable {
    private static final long serialVersionUID = 48L;
    //定义标示属性，使用的是int的包装类，在DAO层基本数据类型都使用包装类
    private Integer id;
    //定义出勤日期
    private String dutyDay;
    //定义打开时间属性
    private Date punchTime;
    //代表本次打开是否为上班打卡
    private boolean isCome;
    //本次出勤的类型
    private AttendType attendType;
    //本次出勤的员工
    private Employee employee;

    //定义无参构造函数
    public Attend() {

    }

    /**
     * 初始化全部属性的构造器
     *
     * @param id
     * @param dutyDay
     * @param punchTime
     * @param isCome
     * @param attendType
     * @param employee
     */
    public Attend(Integer id, String dutyDay, Date punchTime, boolean isCome, AttendType attendType, Employee employee) {
        this.id = id;
        this.dutyDay = dutyDay;
        this.punchTime = punchTime;
        this.isCome = isCome;
        this.attendType = attendType;
        this.employee = employee;
    }

    /**
     * 获取流程id
     *
     * @return 返回类型为一个包装类
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置流程ID
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取出勤日期
     *
     * @return 返回是一个String类型
     */
    public String getDutyDay() {
        return dutyDay;
    }

    /**
     * 设置出勤日期
     *
     * @param dutyDay 传入的是一个String类型
     */
    public void setDutyDay(String dutyDay) {
        this.dutyDay = dutyDay;
    }

    /**
     * 获取本次用户的打卡时间
     *
     * @return
     */
    public Date getPunchTime() {
        return punchTime;
    }

    /**
     * 设置用户本次的打卡时间
     *
     * @param punchTime
     */
    public void setPunchTime(Date punchTime) {
        this.punchTime = punchTime;
    }

    /**
     * 判断用户本次是打卡
     *
     * @return
     */
    public boolean getIsCome() {
        return isCome;
    }

    /**
     * 如果用户打过卡，设置用户打卡信息
     *
     * @param iscome
     */
    public void setIsCome(boolean iscome) {
        this.isCome = iscome;
    }

    /**
     * 获取流程申请类型
     *
     * @return
     */
    public AttendType getAttendType() {
        return attendType;
    }

    /**
     * 设置流程申请类型
     *
     * @param attendType
     */
    public void setAttendType(AttendType attendType) {
        this.attendType = attendType;
    }

    /**
     * 获取本次打卡的用户
     *
     * @return
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * 设置本次打卡的用户
     *
     * @param employee
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        if (getIsCome()) {
            return dutyDay.hashCode() + 29 * employee.hashCode() + 1;
        }
        return dutyDay.hashCode() + 29 * employee.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == Attend.class) {
            Attend attend = (Attend) obj;
            return getEmployee().equals(attend.getEmployee()) && getDutyDay().equals(attend.getDutyDay()) &&
                    getIsCome() == attend.getIsCome();
        }
        return false;
    }
}
