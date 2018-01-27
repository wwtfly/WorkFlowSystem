package com.ImplDAO;

import com.PO.Attend;
import com.PO.Employee;

import java.util.List;

/**
 * @Descrintion:
 * @Author: wentao
 * @Date: Created in 18-1-27 下午8:20
 */
public interface ImplAttendDAO {
    /**
     *根据标识属性来加载Attend实例
     * @param id 需要加载的attend实例的标识属性
     * @return
     */
    Attend get(Integer id);

    /**
     * 持久化指定的Attend实例
     *
     * @param attend 输入需要持久化的Attend实例
     * @return 返回持久化后的标识属性
     */
    Integer save(Attend attend);

    /**
     * 修改指定的Attend实例
     * @param attend 需要被删除的Attend实例
     */
    void update(Attend attend);

    /**
     * 删除指定的Attend实例
     * @param attend 输入需要删除的Attend实例
     */
    void delete(Attend attend);

    /**
     * 根据标识属性删除Attend实例
     * @param id 输入属性的标识id
     */
    void delete(Integer id);

    /**
     * 查询全部的额Attend实例
     * @return 返回是一个集合，存储所有查到的Attend实例
     */
    List<Attend> findAll();

    /**
     * 根据员工查询该员工的打卡记录
     *
     * @param employee
     * @return 返回该员工的全部出勤记录
     */
    List<Attend> findByEmp(Employee employee);

    /**
     * 根据员工，日期查询该员工的打卡记录集合
     *
     * @param employee 员工
     * @param dutyDay  打卡日期
     * @return 该员工的某天的打卡记录集合
     */
    List<Attend> findByEmpAndDutyDay(Employee employee, String dutyDay);

    /**
     * 根据员工、日期、上下班查询该员工的打卡记录集合
     *
     * @param employee 员工
     * @param dutyDay  日期
     * @param isCome   是否上下班
     * @return 该员工的某天上下班的打卡记录
     */
    List<Attend> findByEmpAndDutyDayAndCome(Employee employee, String dutyDay, boolean isCome);

    /**
     * 查看员工前三天的非正常打卡
     * @param employee 员工
     * @return 该员工的前三天的非正常打卡
     */
    List<Attend> findByEmpUnAttend(Employee employee);
}
