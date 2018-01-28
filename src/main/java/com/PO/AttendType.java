package com.PO;

/**
 * @Descrintion: 员工的考勤类型，包含考勤的名称、迟到、早退等信息
 * @Author: wentao
 * @Date: Created in 18-1-22 下午10:42
 */
public class AttendType {
    //定义考勤的标识属性
    private Integer id;
    //定义考勤的名称
    private String name;
    //定义考勤的一次次数
    private double amerce;

    //定义无参构造函数
    public AttendType() {

    }

    public AttendType(Integer id, String name, double amerce) {
        this.id = id;
        this.name = name;
        this.amerce = amerce;
    }

    /**
     * 获取AttendType的标识属性
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置AttendType的标识属性
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取AttendType的name属性
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * 设置AttendType的name属性
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取异常考勤的属性值
     * @return
     */
    public double getAmerce() {
        return amerce;
    }

    /**
     * 设置异常开启的属性值
     * @param amerce
     */
    public void setAmerce(double amerce) {
        this.amerce = amerce;
    }
}
