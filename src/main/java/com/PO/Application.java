package com.PO;

/**
 * @Descrintion:员工的考勤申请，包括申请理由、是否被批复以及申请改变的类型等属性。
 * @Author: wentao
 * @Date: Created in 18-1-22 下午10:41
 */
public class Application {
    //定义标识属性id
    private Integer id;
    //定义String属性，用于描述申请原因
    private String reason;
    //定义boolean变量，用于描述申请结果
    private boolean result;
    //定义AttendType对象属性，用于关联AttendType中的考勤类别
    private AttendType type;
    //定义Attend对象属性，用于关联Attend中的考勤信息
    private Attend attend;
    //定义CheckBack对象属性，用于关联CheckBack中对应的批复
    private CheckBack checkBack;

    //定义无参构造函数
    public Application() {

    }

    /**
     * 定义初始化构造函数，用于初始化所有的属性
     *
     * @param id
     * @param reason
     * @param result
     * @param type
     * @param attend
     * @param checkBack
     */
    public Application(Integer id, String reason, boolean result, AttendType type, Attend attend, CheckBack checkBack) {
        this.id = id;
        this.reason = reason;
        this.result = result;
        this.type = type;
        this.attend = attend;
        this.checkBack = checkBack;
    }

    //以下定义所有的getter、setter方法用于在spring中依赖注入中进行设置注入

    /**
     * 获取标识属性ID
     * @return
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置标识属性ID
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取Reason属性
     * @return
     */
    public String getReason() {
        return reason;
    }

    /**
     * 设置Reason属性
     * @param reason
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * 获取Result属性
     * @return
     */
    public boolean getResult() {
        return result;
    }

    /**
     * 设置Result属性
     * @param result
     */
    public void setResult(boolean result) {
        this.result = result;
    }

    /**
     * 设置AttendType属性
     * @return
     */
    public AttendType getType() {
        return type;
    }

    /**
     * 获取AttendType属性
     * @param type
     */
    public void setType(AttendType type) {
        this.type = type;
    }

    /**
     * 获取Attend属性
     * @return
     */
    public Attend getAttend() {
        return attend;
    }

    /**
     * 设置Attend属性
     * @param attend
     */
    public void setAttend(Attend attend) {
        this.attend = attend;
    }

    /**
     * 获取CheckBack属性
     * @return
     */
    public CheckBack getCheckBack() {
        return checkBack;
    }

    /**
     * 设置CheckBack属性
     * @param checkBack
     */
    public void setCheckBack(CheckBack checkBack) {
        this.checkBack = checkBack;
    }
}
