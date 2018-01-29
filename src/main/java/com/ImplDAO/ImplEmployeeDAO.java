package com.ImplDAO;

import com.PO.Employee;

import java.util.List;

/**
 * @Descrintion: get(Serializable id)
 * save(Object entity)
 * update(Object entity)
 * delete(Object entity)
 * delete(Serializable)
 * findAll()
 * @Author: wentao
 * @Date: Created in 18-1-26 下午9:02
 */
public interface ImplEmployeeDAO {
    /**
     * 通过指定雇员ID来查询雇员
     *
     * @param id
     * @return
     */
    Employee get(Integer id);

    /**
     * 持久化雇员对象
     *
     * @param employee 返回持久化对象的标识属性
     */
    Integer save(Employee employee);

    /**
     * 更新一个持久化对象
     *
     * @param employee 输入需要持久化的对象
     */
    void update(Employee employee);

    /**
     * 删除一个持久化对象
     *
     * @param employee 输入为一个雇员对象
     * @return 返回删除的Employee对象的标识属性
     */
    void delete(Employee employee);

    /**
     * 通过持久化对象的标识属性删除一个持久化对象
     *
     * @param id 输入持久化对象的标识属性
     * @return 返回删除持久化对象的标识属性
     */
    void delete(Integer id);

    /**
     * 查询所有的持久化对象
     *
     * @return 返回的是list集合
     */
    List<Employee> findAll();

    /**
     * 根据用户名和密码查询员工
     * @param employee 输入指定用户的名称和密码
     * @return 符合指定用户名和密码的员工集合
     */
    List<Employee> findByNameAndPass(Employee employee);

    /**
     * 根据用户的名字查找雇员信息
     * @param name
     * @return
     */
    Employee findByName(String name);
}
