package com.ImplDAO;

import com.PO.AttendType;

import java.util.List;

/**
 * @Descrintion:
 * @Author: wentao
 * @Date: Created in 18-1-27 下午8:21
 */
public interface ImplAttendTypeDAO {
    /**
     * 根据标识属性查询AttendType对象
     *
     * @param id 输入需要加载的Attend实例的标识属性值
     * @return 返回的是AttendType对象
     */
    AttendType get(Integer id);

    /**
     * 持久化指定的AttendType对象
     *
     * @param attendType 输入需要持久化的AttendType对象
     * @return 返回持久化后的标识属性
     */
    Integer save(AttendType attendType);

    /**
     * 修改指定的AttendType对象
     *
     * @param attendType 输入需要修改的AttendType对象
     */
    void update(AttendType attendType);

    /**
     * 删除指定的AttendType对象
     *
     * @param attendType 输入需要删除的AttendType对象
     */
    void delete(AttendType attendType);

    /**
     * 删除指定标识属性的AttendType对象
     *
     * @param id 输入指定的标识属性id
     */
    void delete(Integer id);

    /**
     * 查询全部的AttendType对象
     * @return
     */
    List<AttendType> findAll();
}
