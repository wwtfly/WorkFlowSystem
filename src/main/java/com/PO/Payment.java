package com.PO;

/**
 * @Descrintion: 对应每月所发的薪水信息，保函发薪的月份、领薪员工以及薪资数等信息。
 * @Author: wentao
 * @Date: Created in 18-1-22 下午10:43
 */
public class Payment {
    //定义标识属性
    private Integer id;
    //定义发薪月份
    private String payMonth;
    //定义发薪总计
    private double amount;
    //薪水对应的员工
    private Employee employee;

    //定义无参构造函数
    public Payment() {

    }

    /**
     * 定义构造函数初始化所有属性
     * @param id
     * @param payMonth
     * @param amount
     * @param employee
     */
    public Payment(Integer id, String payMonth, double amount, Employee employee) {
        this.id = id;
        this.payMonth = payMonth;
        this.amount = amount;
        this.employee = employee;
    }

    /**
     * 获取属性id
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置属性id
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 设置发薪时间
     * @return
     */
    public String getPayMonth() {
        return payMonth;
    }

    /**
     * 设置发薪时间
     * @param payMonth
     */
    public void setPayMonth(String payMonth) {
        this.payMonth = payMonth;
    }

    /**
     * 获取薪水总计
     * @return
     */
    public double getAmount() {
        return amount;
    }

    /**
     * 设置薪水
     * @param amount
     */
    public void setAmount(double amount) {
        this.amount = amount;
    }

    /**
     * 获取员工
     * @return
     */
    public Employee getEmployee() {
        return employee;
    }

    /**
     * 设置员工
     * @param employee
     */
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
