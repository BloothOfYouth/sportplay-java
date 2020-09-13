package com.hjf.sportplay.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.hjf.sportplay.entity.Mainmenu;

import java.util.List;

/**
 * @author hjf
 */
public interface IMainmenuService {
    /**
     * 增加Mainmenu
     * @param mainmenu
     * @return
     */
    int insert(Mainmenu mainmenu);

    /**
     * 根据id删除Mainmenu
     * @param id
     * @return
     */
    int deleteById(Integer id);

    /**
     * 根据id更新Mainmenu
     * @param mainmenu
     * @return
     */
    int updateById(Mainmenu mainmenu);

    /**
     * 根据id查询Mainmenu
     * @param id
     * @return
     */
    Mainmenu selectById(Integer id);

    /**
     * 有条件的查询list<Mainmenu>
     * @return
     */
    List<Mainmenu> selectList();
}
