package com.hiberDAO;

import com.ImplDAO.ImplEmployeeDAO;
import com.PO.Employee;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * @Descrintion: 使用Hibernate方式实例化ImpiEmployeeDAO接口
 * 使用spring的hibernate的支持类HibernateDaoSupport
 * @Author: wentao
 * @Date: Created in 18-1-26 下午8:43
 */
public class EmployeeDaoHibernate extends HibernateDaoSupport implements ImplEmployeeDAO {
    /**
     *
     * @param id
     * @return
     */
    @Override
    public Employee get(Integer id) {
        return getHibernateTemplate().get(Employee.class, id);
    }

    @Override
    public Integer save(Employee employee) {
        return (Integer) getHibernateTemplate().save(employee);
    }

    @Override
    public void update(Employee employee) {
        getHibernateTemplate().update(employee);
    }

    @Override
    public void delete(Employee employee) {
        getHibernateTemplate().delete(employee);
    }

    @Override
    public void delete(Integer id) {
        getHibernateTemplate().delete(get(id));
    }

    @Override
    public List<Employee> findAll() {
        return (List<Employee>) getHibernateTemplate().find("from employee");
    }
}

