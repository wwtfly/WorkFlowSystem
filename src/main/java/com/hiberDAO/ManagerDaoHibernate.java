package com.hiberDAO;

import com.ImplDAO.ImplManagerDAO;
import com.PO.Manager;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * @Descrintion:
 * @Author: wentao
 * @Date: Created in 18-1-27 下午11:10
 */
public class ManagerDaoHibernate extends HibernateDaoSupport implements ImplManagerDAO {
    /**
     * 通过标识id查询Manager对象
     *
     * @param id 输入需要查询Manager对象的标识Id
     * @return 返回查询到的Manager对象
     */
    @Override
    public Manager get(Integer id) {
        return getHibernateTemplate().get(Manager.class, id);
    }

    /**
     * 持久化Manager对象
     *
     * @param manager 输入需要持久化的Manager对象
     * @return 返回持久化后的Manager对象的标识属性值
     */
    @Override
    public Integer save(Manager manager) {
        return (Integer) getHibernateTemplate().save(manager);
    }

    /**
     * 修改Manager对象
     *
     * @param manager 输入修改的Manager对象
     */
    @Override
    public void update(Manager manager) {
        getHibernateTemplate().update(manager);
    }

    /**
     * 删除指定的Manager对象
     *
     * @param manager 输入要删除的Manager对象
     */
    @Override
    public void delete(Manager manager) {
        getHibernateTemplate().delete(manager);
    }

    /**
     * 删除指定标识id的Manager对象
     *
     * @param id 输入需要删除的标识id
     */
    @Override
    public void delete(Integer id) {
        getHibernateTemplate().delete(get(id));
    }

    /**
     * 查询全部的额Manager对象
     *
     * @return 返回查询到的Manager对象集合
     */
    @Override
    public List<Manager> findAll() {
        return (List<Manager>) getHibernateTemplate().find("from Manager");
    }

    /**
     * 根据用户名称和密码查询manager
     *
     * @param manager 输入包含指定用户名、密码的manager
     * @return 返回查询到的Manager对象
     */
    @Override
    public List<Manager> findByNameAndPass(Manager manager) {
        //return (List<Manager>)getHibernateTemplate().find("from Manager as a where a.name");
        return null;
    }

    /**
     * 根据名称查找manager
     *
     * @param name 输入要查询Manager的名称
     * @return 返回查询到额Manager
     */
    @Override
    public Manager findByName(String name) {
        return (List<Manager>)getHibernateTemplate().find("from Manager as a where a.name=?");
    }
}
