package com.ImplDAO;

import com.PO.Employee;
import com.PO.Payment;

import java.util.List;

/**
 * @Descrintion:
 * @Author: wentao
 * @Date: Created in 18-1-27 下午8:22
 */
public interface ImplPaymentDAO {
    /**
     * 根据标识id查询Payment对象
     *
     * @param id 输入要查询的Payment对象id
     * @return 返回查询到的Payment对象
     */
    Payment get(Integer id);

    /**
     * 持久化Payment对象
     *
     * @param payment 输入需要持久化的Payment对象
     * @return 返回持久化后的Payment标识id
     */
    Integer save(Payment payment);

    /**
     * 修改Payment对象
     *
     * @param payment 输入要修改的Payment对象
     */
    void update(Payment payment);

    /**
     * 删除指定的Payment对象
     *
     * @param payment 输入需要删除的Payment对象
     */
    void delete(Payment payment);

    /**
     * 根据标识id删除指定的Payment对象
     *
     * @param id 输入需要删除的Payment对象的标识ID
     */
    void delele(Integer id);

    /**
     * 查询全部的Payment对象
     *
     * @return 返回查询到的Payment对象集合
     */
    List<Payment> findAll();

    /**
     * 查询指定雇员对象的薪水
     *
     * @param employee 输入需要查询的雇员
     * @return 返回该雇员的薪水集合
     */
    List<Payment> findByEmp(Employee employee);

    /**
     * 根据雇员和发薪月份查询月结薪水
     * @param payment 发薪月份
     * @param employee 输入要查询的员工
     * @return 返回指定员工和指定月份的月结薪水
     */
    List<Payment> findMonthAndEmp(String payment, Employee employee);
}
