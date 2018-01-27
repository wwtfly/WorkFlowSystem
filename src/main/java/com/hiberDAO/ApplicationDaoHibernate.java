package com.hiberDAO;

import com.ImplDAO.ImplApplicationDAO;
import com.PO.Application;
import com.PO.Employee;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * @Descrintion:
 * @Author: wentao
 * @Date: Created in 18-1-25 下午8:45
 */
public class ApplicationDaoHibernate extends HibernateDaoSupport implements ImplApplicationDAO {
    /**
     * 根据标识属性来加载Application实例
     * @param id 需要加载的Application实例的标示属性值
     * @return 指定标识属性对应的Application实例
     */
    @Override
    public Application get(Integer id) {
        return getHibernateTemplate().get(Application.class, id);
    }

    /**
     * 持久化指定的Application实例
     * @param application 传入需要被持久化的Application实例
     * @return Application实例被持久化后的标识属性
     */
    @Override
    public Integer save(Application application) {
        return (Integer) getHibernateTemplate().save(application);
    }

    /**
     * 修改指定的Application实例
     * @param application 传入需要被修改的Application实例
     */
    @Override
    public void update(Application application) {
        getHibernateTemplate().delete(application);
    }

    /**
     * 删除指定的Application实例
     * @param application 传入需要删除的Application实例
     */
    @Override
    public void delete(Application application) {
        getHibernateTemplate().delete(application);
    }

    /**
     * 根据标识属性删除Application实例
     * @param id 需要被删除的Application实例的标识属性
     */
    @Override
    public void delete(Integer id) {
        getHibernateTemplate().delete(get(id));
    }

    /**
     *
     * 查询全部的Application实例
     * @return 数据库中全部的Application实例
     */
    @Override
    public List<Application> findAll() {
        return (List<Application>) getHibernateTemplate().find("from Application");
    }

    /**
     * 根据员工查询未处理的异常申请
     * @param employee 需要查询的员工
     * @return 该员工对应的未处理的异常申请
     */
    @Override
    public List<Application> findByEmp(Employee employee) {
        return (List<Application>) getHibernateTemplate().find("from Application as a where " + "a.attend.employee=?", employee);
    }
}
