package com.ImplDAO;

import com.PO.Application;
import com.PO.Employee;

import java.util.List;

/**
 * @Descrintion:定义application的接口DAO：
 * get(Serializable id)
 * save(Object entity)
 * update(Object entity)
 * delete(Object entity)
 * delete(Serializable)
 * findAll()
 * @Author: wentao
 * @Date: Created in 18-1-24 下午10:35
 */
public interface ImplApplicationDAO {
    /**
     * 根据标示属性来加载Application实例
     *
     * @param id 需要加载的Application实例的标示属性值
     * @return 获得指定标示id的Application实例
     */
    Application get(Integer id);

    /**
     * 持久化指定的Application实例
     *
     * @param application 传入需要被持久化的Application实例
     * @return 返回实例持久化后的标识属性
     */
    Integer save(Application application);

    /**
     * 修改指定的Application实例
     *
     * @param application 传入需要被修改的Application实例
     */
    void update(Application application);

    /**
     * 删除指定的Application实例
     *
     * @param application 传入需要删除的Application实例
     */
    void delete(Application application);

    /**
     * 根据标识属性删除Application实例
     *
     * @param id 需要被删除的Application实例的标识属性
     */

    void delete(Integer id);

    /**
     * 查询全部的Application实例
     *
     * @return 返回全部的Application实例
     */
    List<Application> findAll();

    /**
     * 根据员工查询未处理的异常申请
     *
     * @param employee 需要查询的员工
     * @return 返回该员工未处理的异常申请
     */
    List<Application> findByEmp(Employee employee);

}
