package com.PO;

import java.io.Serializable;

/**
 * @Descrintion: 员工的考勤申请批复信息
 * @Author: wentao
 * @Date: Created in 18-1-22 下午10:42
 */
public class CheckBack implements Serializable {
    //定义CheckBack的属性id
    private Integer id;
    //定义CheckBack的reason属性，用于描述批复的原因
    private String reason;
    //定义CheckBack的Result属性，用于描述批复的结果
    private String result;
    //定义CheckBack的Application属性，用于关联员工的考勤申请
    private Application application;
    //定义CheckBack的Manager属性，用于关联批复经理
    private Manager manager;

    //定义无参构造函数
    public CheckBack() {

    }

    /**
     * 定义一个初始化参数的构造函数
     * @param id
     * @param reason
     * @param result
     * @param application
     * @param manager
     */
    public CheckBack(Integer id, String reason, String result, Application application, Manager manager) {
        this.id = id;
        this.reason = reason;
        this.result = result;
        this.application = application;
        this.manager = manager;
    }

    /**
     * 获取CheckBack的标识ID
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置CheckBack的标识ID
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取CheckBack的Reason属性
     * @return
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置CheckBack的Reason属性
     * @param reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * 获取CheckBack的Result属性
     * @return
     */
    public String getResult() {
        return result;
    }

    /**
     * 设置CheckBack的Result属性
     * @param result
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * 获取CheckBack的员工申请
     * @return
     */
    public Application getApplication() {
        return application;
    }

    /**
     * 设置CheckBack的员工申请
     * @param application
     */
    public void setApplication(Application application) {
        this.application = application;
    }

    /**
     * 获取CheckBack的Manager属性，对应的是申请的批复经理
     * @return
     */
    public Manager getManager() {
        return manager;
    }

    /**
     * 设置CheckBack的Manager属性
     * @param manager
     */
    public void setManager(Manager manager) {
        this.manager = manager;
    }
}
