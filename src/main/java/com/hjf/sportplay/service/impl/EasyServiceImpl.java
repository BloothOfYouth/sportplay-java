package com.hjf.sportplay.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hjf.sportplay.dao.EasyuserDao;
import com.hjf.sportplay.entity.Easyuser;
import com.hjf.sportplay.entity.QueryInfo;
import com.hjf.sportplay.service.IEasyuserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hjf
 */
@Service
public class EasyServiceImpl implements IEasyuserService {

    @Autowired
    private EasyuserDao dao;

    /**
     * 增加Easyuser
     * @param easyuser
     * @return
     */
    @Override
    public int insert(Easyuser easyuser) {
        QueryWrapper<Easyuser> wrapper = new QueryWrapper<>();
        wrapper.eq("username",easyuser.getUsername());
        if (dao.selectOne(wrapper) != null) {
            return -1;
        }
        int insert = dao.insert(easyuser);
        return insert;
    }

    /**
     * 根据id删除Easyuser
     * @param id
     * @return
     */
    @Override
    public int deleteById(Integer id) {
        int delete = dao.deleteById(id);
        return delete;
    }

    /**
     * 根据id更新Easyuser
     * @param easyuser
     * @return
     */
    @Override
    public int updateById(Easyuser easyuser) {
        int update = dao.updateById(easyuser);
        return update;
    }

    /**
     * 根据id查询Easyuser
     * @param id
     * @return
     */
    @Override
    public Easyuser selectById(Integer id) {
        Easyuser easyuser = dao.selectById(id);
        return easyuser;
    }

    /**
     * 有条件的分页模糊查询list<Easyuser>
     * @param queryInfo
     * @return
     */
    @Override
    public PageInfo<Easyuser> selectList(QueryInfo queryInfo) {
        PageHelper.startPage(queryInfo.getPageNum(), queryInfo.getPageSize());
        QueryWrapper<Easyuser> wrapper = new QueryWrapper<>();
        wrapper.like("username",queryInfo.getQuery());
        List<Easyuser> easyusers = dao.selectList(wrapper);
        PageInfo<Easyuser> pageInfo = new PageInfo<>(easyusers);
        return pageInfo;
    }

    /**
     * 根据账号和密码查询Easyuser
     * @param username
     * @param password
     * @return
     */
    @Override
    public Easyuser selectByUsernameAndPassword(String username, String password) {
        QueryWrapper<Easyuser> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        wrapper.eq("password",password);
        Easyuser easyuser = dao.selectOne(wrapper);
        return easyuser;
    }
}
