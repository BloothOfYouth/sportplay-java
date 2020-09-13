package com.hjf.sportplay.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.github.pagehelper.PageInfo;
import com.hjf.sportplay.entity.Easyuser;
import com.hjf.sportplay.entity.QueryInfo;

import java.util.List;

/**
 * @author hjf
 */
public interface IEasyuserService {
    /**
     * 增加Easyuser
     * @param easyuser
     * @return
     */
    int insert(Easyuser easyuser);

    /**
     * 根据id删除Easyuser
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 根据id更新Easyuser
     * @param easyuser
     * @return
     */
    int updateById(Easyuser easyuser);

    /**
     * 根据id查询Easyuser
     * @param id
     * @return
     */
    Easyuser selectById(Integer id);

    /**
     * 有条件的分页模糊查询list<Easyuser>
     * @param queryInfo
     * @return
     */
    PageInfo<Easyuser> selectList(QueryInfo queryInfo);

    /**
     * 根据账号和密码查询Easyuser
     * @return
     */
    Easyuser selectByUsernameAndPassword(String username,String password);
}
