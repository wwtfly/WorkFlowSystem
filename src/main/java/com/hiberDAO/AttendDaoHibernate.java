package com.hiberDAO;

import com.ImplDAO.ImplAttendDAO;
import com.PO.Attend;
import com.PO.AttendType;
import com.PO.Employee;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

/**
 * @Descrintion:
 * @Author: wentao
 * @Date: Created in 18-1-27 下午10:18
 */
public class AttendDaoHibernate extends HibernateDaoSupport implements ImplAttendDAO {
    /**
     * 根据标识属性来加载Attend实例
     *
     * @param id 需要加载的attend实例的标识属性
     * @return 返回查询到的Attend对象
     */
    @Override
    public Attend get(Integer id) {
        return getHibernateTemplate().get(Attend.class, id);
    }

    /**
     * 持久化指定的Attend实例
     *
     * @param attend 输入需要持久化的Attend实例
     * @return 返回持久化后的标识属性
     */
    @Override
    public Integer save(Attend attend) {
        return (Integer) getHibernateTemplate().save(attend);
    }

    /**
     * 修改指定的Attend实例
     *
     * @param attend 需要被修改的Attend实例
     */
    @Override
    public void update(Attend attend) {
        getHibernateTemplate().update(attend);
    }

    /**
     * 删除指定的Attend实例
     *
     * @param attend 输入需要删除的Attend实例
     */
    @Override
    public void delete(Attend attend) {
        getHibernateTemplate().delete(attend);
    }

    /**
     * 根据标识属性删除Attend实例
     *
     * @param id 输入属性的标识id
     */
    @Override
    public void delete(Integer id) {
        getHibernateTemplate().delete(get(id));
    }

    /**
     * 查询全部的额Attend实例
     *
     * @return 返回是一个集合，存储所有查到的Attend实例
     */
    @Override
    public List<Attend> findAll() {
        return (List<Attend>) getHibernateTemplate().find("from Attend");
    }

    /**
     * 根据员工查询该员工的打卡记录
     *
     * @param employee
     * @return 返回该员工的全部出勤记录
     */
    @Override
    public List<Attend> findByEmp(Employee employee) {
        return (List<Attend>) getHibernateTemplate().find("from Attend where employee=?", employee);
    }

    /**
     * 根据员工，日期查询该员工的打卡记录集合
     *
     * @param employee 员工
     * @param dutyDay  打卡日期
     * @return 该员工的某天的打卡记录集合
     */
    @Override
    public List<Attend> findByEmpAndDutyDay(Employee employee, String dutyDay) {
        return (List<Attend>) getHibernateTemplate().find("from Attend as a where a.employee=? and" + "a.dutyDay=?", new
                Object[]{employee, dutyDay});
    }

    /**
     * 根据员工、日期、上下班查询该员工的打卡记录集合
     *
     * @param employee 员工
     * @param dutyDay  日期
     * @param isCome   是否上下班
     * @return 该员工的某天上下班的打卡记录
     */
    @Override
    public Attend findByEmpAndDutyDayAndCome(Employee employee, String dutyDay, boolean isCome) {
        List<Attend> al = findByEmpAndDutyDay(employee, dutyDay);
        if (al != null || al.size() > 1) {
            for (Attend attend : al) {
                if (attend.getIsCome() == isCome) {
                    return attend;
                }
            }
        }
        return null;
    }

    /**
     * 查看员工前三天的非正常打卡
     *
     * @param employee 员工
     * @param attendType 申请类型
     * @return 该员工的前三天的非正常打卡
     */
    @Override
    public List<Attend> findByEmpUnAttend(Employee employee, AttendType attendType) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c=Calendar.getInstance();
        String end = sdf.format(c.getTime());
        c.add(Calendar.DAY_OF_MONTH, -3);
        String start = sdf.format(c.getTime());
        Object[] args = {employee, attendType, start, end};
        return (List<Attend>)getHibernateTemplate().find("from Attend as a where a.employee=? and"+"a.type!=? and a.dutyDay between ? and ？",args);
    }
}

