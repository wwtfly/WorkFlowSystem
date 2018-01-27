package com.hiberDAO;

import com.ImplDAO.ImplPaymentDAO;
import com.PO.Employee;
import com.PO.Payment;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * @Descrintion:
 * @Author: wentao
 * @Date: Created in 18-1-27 下午11:28
 */
public class PaymentDaoHibernate extends HibernateDaoSupport implements ImplPaymentDAO {
    /**
     * 根据标识id查询Payment对象
     *
     * @param id 输入要查询的Payment对象id
     * @return 返回查询到的Payment对象
     */
    @Override
    public Payment get(Integer id) {
        return getHibernateTemplate().get(Payment.class, id);
    }

    /**
     * 持久化Payment对象
     *
     * @param payment 输入需要持久化的Payment对象
     * @return 返回持久化后的Payment标识id
     */
    @Override
    public Integer save(Payment payment) {
        return (Integer) getHibernateTemplate().save(payment);
    }

    /**
     * 修改Payment对象
     *
     * @param payment 输入要修改的Payment对象
     */
    @Override
    public void update(Payment payment) {
        getHibernateTemplate().update(payment);
    }

    /**
     * 删除指定的Payment对象
     *
     * @param payment 输入需要删除的Payment对象
     */
    @Override
    public void delete(Payment payment) {
        getHibernateTemplate().delete(payment);
    }

    /**
     * 根据标识id删除指定的Payment对象
     *
     * @param id 输入需要删除的Payment对象的标识ID
     */
    @Override
    public void delele(Integer id) {
        getHibernateTemplate().delete(get(id));
    }

    /**
     * 查询全部的Payment对象
     *
     * @return 返回查询到的Payment对象集合
     */
    @Override
    public List<Payment> findAll() {
        return (List<Payment>) getHibernateTemplate().find("from Payment");
    }

    /**
     * 查询指定雇员对象的薪水
     *
     * @param employee 输入需要查询的雇员
     * @return 返回该雇员的薪水集合
     */
    @Override
    public List<Payment> findByEmp(Employee employee) {
        return (List<Payment>) getHibernateTemplate().find("from Payment as a where a.employee=?", employee);
    }

    /**
     * 根据雇员和发薪月份查询月结薪水
     *
     * @param payment  发薪月份
     * @param employee 输入要查询的员工
     * @return 返回指定员工和指定月份的月结薪水
     */
    @Override
    public List<Payment> findMonthAndEmp(String payment, Employee employee) {
        return null;
    }
}
