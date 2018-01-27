package com.hiberDAO;

import com.ImplDAO.ImplAttendTypeDAO;
import com.PO.Attend;
import com.PO.AttendType;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * @Descrintion:
 * @Author: wentao
 * @Date: Created in 18-1-27 下午11:03
 */
public class AttendTypeDaoHibernate extends HibernateDaoSupport implements ImplAttendTypeDAO {
    /**
     * 根据标识属性查询AttendType对象
     *
     * @param id 输入需要加载的Attend实例的标识属性值
     * @return 返回的是AttendType对象
     */
    @Override
    public AttendType get(Integer id) {
        return getHibernateTemplate().get(AttendType.class, id);
    }

    /**
     * 持久化指定的AttendType对象
     *
     * @param attendType 输入需要持久化的AttendType对象
     * @return 返回持久化后的标识属性
     */
    @Override
    public Integer save(AttendType attendType) {
        return (Integer) getHibernateTemplate().save(attendType);
    }

    /**
     * 修改指定的AttendType对象
     *
     * @param attendType 输入需要修改的AttendType对象
     */
    @Override
    public void update(AttendType attendType) {
        getHibernateTemplate().update(attendType);
    }

    /**
     * 删除指定的AttendType对象
     *
     * @param attendType 输入需要删除的AttendType对象
     */
    @Override
    public void delete(AttendType attendType) {
        getHibernateTemplate().delete(attendType);
    }

    /**
     * 删除指定标识属性的AttendType对象
     *
     * @param id 输入指定的标识属性id
     */
    @Override
    public void delete(Integer id) {
        getHibernateTemplate().delete(get(id));
    }

    /**
     * 查询全部的AttendType对象
     *
     * @return
     */
    @Override
    public List<AttendType> findAll() {
        return (List<AttendType>) getHibernateTemplate().find("from AttendType");
    }
}
