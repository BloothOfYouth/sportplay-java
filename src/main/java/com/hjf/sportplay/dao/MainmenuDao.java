package com.hjf.sportplay.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hjf.sportplay.entity.Mainmenu;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author hjf
 */
@Repository
public interface MainmenuDao extends BaseMapper<Mainmenu> {
    List<Mainmenu> selectList();
}
