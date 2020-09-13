package com.hjf.sportplay.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hjf.sportplay.dao.MainmenuDao;
import com.hjf.sportplay.dao.SubmenuDao;
import com.hjf.sportplay.entity.Mainmenu;
import com.hjf.sportplay.entity.Submenu;
import com.hjf.sportplay.service.IMainmenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hjf
 */
@Service
public class MainmenuServiceImpl implements IMainmenuService {

    @Autowired
    private MainmenuDao mainmenuDao;

    @Autowired
    private SubmenuDao submenuDao;

    /**
     * 增加Mainmenu
     * @param mainmenu
     * @return
     */
    @Override
    public int insert(Mainmenu mainmenu) {
        int insert = mainmenuDao.insert(mainmenu);
        return insert;
    }

    /**
     * 根据id删除Mainmenu
     * @param id
     * @return
     */
    @Override
    public int deleteById(Integer id) {
        int delete = mainmenuDao.deleteById(id);
        return delete;
    }

    /**
     * 根据id更新Mainmenu
     * @param mainmenu
     * @return
     */
    @Override
    public int updateById(Mainmenu mainmenu) {
        int update = mainmenuDao.updateById(mainmenu);
        return update;
    }

    /**
     * 根据id查询Mainmenu
     * @param id
     * @return
     */
    @Override
    public Mainmenu selectById(Integer id) {
        Mainmenu mainmenu = mainmenuDao.selectById(id);
        if (mainmenu == null) {
            return null;
        }
        QueryWrapper<Submenu> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("mid",id);
        List<Submenu> submenus = submenuDao.selectList(queryWrapper);
        mainmenu.setSubmenus(submenus);
        return mainmenu;
    }

    /**
     * 有条件的查询list<Mainmenu>
     * @return
     */
    @Override
    public List<Mainmenu> selectList() {
        List<Mainmenu> mainmenus = mainmenuDao.selectList();
        return mainmenus;
    }
}
