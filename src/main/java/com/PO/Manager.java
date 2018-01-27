package com.PO;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @Descrintion:经理信息
 * @Author: wentao
 * @Date: Created in 18-1-22 下午10:43
 */
public class Manager extends Employee implements Serializable {
    private static final long serialVersionUID = 48L;
    //该经理管理的部门
    private String dept;
    //该经理对应的所有员工
    private Set<Employee> employees = new HashSet<Employee>();
    //该经理签署的所有批复
    private Set<CheckBack> checkBacks = new HashSet<CheckBack>();

    //无参构造函数
    public Manager() {

    }

    public Manager(String dept, Set<Employee> employees, Set<CheckBack> checkBacks) {
        this.dept = dept;
        this.employees = employees;
        this.checkBacks = checkBacks;
    }

    /**
     * 获取部门名称
     * @return 返回的是部门的名称
     */
    public String getDept() {
        return dept;
    }

    /**
     * 设置部门名称
     * @param dept 输入的是部门的名称
     */
    public void setDept(String dept) {
        this.dept = dept;
    }

    /**
     * 获取经理可以管理的员工
     * @return 返回是员工的集合
     */
    public Set<Employee> getEmployees() {
        return employees;
    }

    /**
     * 设置经理可以管理的员工集合
     * @param employees 传入的是员工对象的集合
     */
    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    /**
     * 获取经理已经批复的流程
     * @return 返回是批复流程的集合
     */
    public Set<CheckBack> getCheckBacks() {
        return checkBacks;
    }

    /**
     * 设置经理已经批复的流程
     * @param checkBacks 输入的是批复流程的集合
     */
    public void setCheckBacks(Set<CheckBack> checkBacks) {
        this.checkBacks = checkBacks;
    }
}