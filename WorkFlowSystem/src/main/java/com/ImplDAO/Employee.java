package com.ImplDAO;

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

}
