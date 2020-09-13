package com.hjf.sportplay.controller;

import com.hjf.sportplay.entity.Mainmenu;
import com.hjf.sportplay.model.ResultMap;
import com.hjf.sportplay.service.IMainmenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author hjf
 */
@RestController
public class MenuController {

    @Autowired
    private IMainmenuService mainmenuService;

    @Autowired
    private ResultMap resultMap;

    @GetMapping("/getAllMenus")
    public ResultMap getAllMenus(){
        List<Mainmenu> mainmenus = mainmenuService.selectList();
        if (mainmenus!=null) {
            return resultMap.success().code(200).message(mainmenus);
        }else {
            return resultMap.fail().code(401);
        }
    }

}
