package com.hiberDAO;

import com.ImplDAO.ImplCheckBackDAO;
import com.PO.CheckBack;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

/**
 * @Descrintion:
 * @Author: wentao
 * @Date: Created in 18-1-27 下午11:07
 */
public class CheckBackDaoHibernate extends HibernateDaoSupport implements ImplCheckBackDAO {
    /**
     * 根据标识属性id查询checkBack对象
     *
     * @param id 输入需要查询的标识id
     * @return
     */
    @Override
    public CheckBack get(Integer id) {
        return getHibernateTemplate().get(CheckBack.class, id);
    }

    /**
     * 持久化CheckBack对象
     *
     * @param checkBack 输入需要吃就好的CheckBack对象
     * @return 返回该持久化对象的标识属性id
     */
    @Override
    public Integer save(CheckBack checkBack) {
        return (Integer) getHibernateTemplate().save(checkBack);
    }

    /**
     * 修改CheckBack持久化对象
     *
     * @param checkBack 输入需要持久化CheckBack参数
     */
    @Override
    public void update(CheckBack checkBack) {
        getHibernateTemplate().update(checkBack);
    }

    /**
     * 根据标识属性id修改CheckBack对象
     *
     * @param id 输入标识属性id
     */
    @Override
    public void update(Integer id) {
        getHibernateTemplate().update(get(id));
    }

    /**
     * 查询全部的CheckBack对象
     *
     * @return 返回查询的奥的Che对象集合
     */
    @Override
    public List<CheckBack> findAll() {
        return (List<CheckBack>) getHibernateTemplate().find("from CheckBack");
    }
}
