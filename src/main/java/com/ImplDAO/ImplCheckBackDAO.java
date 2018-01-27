package com.ImplDAO;

import com.PO.CheckBack;

import java.util.List;

/**
 * @Descrintion:
 * @Author: wentao
 * @Date: Created in 18-1-27 下午8:21
 */
public interface ImplCheckBackDAO {
    /**
     * 根据标识属性id查询checkBack对象
     *
     * @param id 输入需要查询的标识id
     * @return
     */
    CheckBack get(Integer id);

    /**
     * 持久化CheckBack对象
     *
     * @param checkBack 输入需要吃就好的CheckBack对象
     * @return 返回该持久化对象的标识属性id
     */
    Integer save(CheckBack checkBack);

    /**
     * 修改CheckBack持久化对象
     *
     * @param checkBack 输入需要持久化CheckBack参数
     */
    void update(CheckBack checkBack);

    /**
     * 根据标识属性id修改CheckBack对象
     *
     * @param id 输入标识属性id
     */
    void update(Integer id);

    /**
     * 查询全部的CheckBack对象
     * @return 返回查询的奥的Che对象集合
     */
    List<CheckBack> findAll();
}
