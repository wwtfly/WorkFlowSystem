package com.ImplDAO;

import com.PO.Manager;

import java.util.List;

/**
 * @Descrintion:
 * @Author: wentao
 * @Date: Created in 18-1-27 下午8:22
 */
public interface ImplManagerDAO {
    /**
     * 通过标识id查询Manager对象
     *
     * @param id 输入需要查询Manager对象的标识Id
     * @return 返回查询到的Manager对象
     */
    Manager get(Integer id);

    /**
     * 持久化Manager对象
     *
     * @param manager 输入需要持久化的Manager对象
     * @return 返回持久化后的Manager对象的标识属性值
     */
    Integer save(Manager manager);

    /**
     * 修改Manager对象
     *
     * @param manager 输入修改的Manager对象
     */
    void update(Manager manager);

    /**
     * 删除指定的Manager对象
     *
     * @param manager 输入要删除的Manager对象
     */
    void delete(Manager manager);

    /**
     * 删除指定标识id的Manager对象
     * @param id 输入需要删除的标识id
     */
    void delete(Integer id);

    /**
     * 查询全部的额Manager对象
     * @return 返回查询到的Manager对象集合
     */
    List<Manager> findAll();

    /**
     * 根据用户名称和密码查询manager
     *
     * @param manager 输入包含指定用户名、密码的manager
     * @return 返回查询到的Manager对象
     */
    List<Manager> findByNameAndPass(Manager manager);

    /**
     * 根据名称查找manager
     * @param name 输入要查询Manager的名称
     * @return 返回查询到额Manager
     */
    Manager findByName(String name);

}
