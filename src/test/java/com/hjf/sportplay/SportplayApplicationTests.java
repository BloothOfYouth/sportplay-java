package com.hjf.sportplay;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.pagehelper.PageInfo;
import com.hjf.sportplay.dao.EasyuserDao;
import com.hjf.sportplay.entity.Easyuser;
import com.hjf.sportplay.entity.Mainmenu;
import com.hjf.sportplay.entity.QueryInfo;
import com.hjf.sportplay.service.IEasyuserService;
import com.hjf.sportplay.service.impl.MainmenuServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SportplayApplicationTests {
    @Autowired
    private EasyuserDao easyuserDao;

    @Autowired
    private MainmenuServiceImpl mainmenuService;

    @Autowired
    private IEasyuserService easyuserService;

    @Test
    void contextLoads() {
        QueryWrapper<Easyuser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("state",1);
        List<Easyuser> easyusers = easyuserDao.selectList(queryWrapper);
        easyusers.forEach(easyuser -> System.out.println(easyuser));
    }

    @Test
    void test1(){
        List<Mainmenu> mainmenus = mainmenuService.selectList();
        mainmenus.forEach(mainmenu -> System.out.println(mainmenu));
    }

    @Test
    void test2(){
        PageInfo<Easyuser> pageInfo = easyuserService.selectList(new QueryInfo());
        String jsonString = JSON.toJSONString(pageInfo);
        System.out.println(jsonString);
    }

}
