package com.PO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @Descrintion: 定义用户信息类
 * @Author: wentao
 * @Date: Created in 18-1-22 下午10:31
 */
public class Employee implements Serializable {

    //定义一个版本常量
    private static final long serialVersionUID = 48L;
    //标示属性
    private Integer id;
    //员工名称
    private String name;
    //员工密码
    private String password;
    //员工工资
    private double salary;
    //员工对应的经理
    private Manager manager;
    //员工对应的出勤记录
    private Set<Attend> attends = new HashSet<Attend>();
    //员工对应的工资支付记录
    private Set<Payment> payments = new HashSet<Payment>();

    //定义无参构造函数
    public Employee() {
    }

    //初始化所有参数
    public Employee(Integer id, String name, String pass, double salary, Manager manager, Set<Attend> attends, Set<Payment> payments) {

    }

    /**
     * 获取id
     *
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取员工名称
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 设置员工名称
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取用户密码
     *
     * @return
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置用户密码
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 设置用户薪资
     *
     * @return
     */
    public double getSalary() {
        return salary;
    }

    /**
     * 获取用户薪资
     *
     * @param salary
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * 获取经理信息
     *
     * @return
     */
    public Manager getManager() {
        return manager;
    }

    /**
     * 设置经理信息
     *
     * @param manager
     */
    public void setManager(Manager manager) {
        this.manager = manager;
    }

    /**
     * 获取出勤记录集合对象
     *
     * @return 返回是出勤对象的集合
     */
    public Set<Attend> getAttends() {
        return attends;
    }

    /**
     * 设置出现记录对象
     *
     * @param attends
     */
    public void setAttends(Set<Attend> attends) {
        this.attends = attends;
    }

    /**
     * 获取员工薪资
     *
     * @return 返回的是结合对象，员工可以多次领取薪水
     */
    public Set<Payment> getPayments() {
        return payments;
    }

    /**
     * 设置员工薪水
     *
     * @param payments
     */
    public void setPayments(Set<Payment> payments) {
        this.payments = payments;
    }

    /**
     * 复写equals方法，判断两个对象是否为同一个对象
     * @param obj
     * @return 返回的是一个boolean类型
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass() == Employee.class) {
            Employee employee = (Employee) obj;
            return this.getName().equals(employee.getName()) && this.getPassword().equals(employee.getPassword());
        }
        return false;
    }

    /**
     * 复写hashcode方法，使用name和passwor组合生成hashcode。
     * @return
     */
    @Override
    public int hashCode() {
        return name.hashCode()+password.hashCode()*17;
    }
}
