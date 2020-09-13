package com.hjf.sportplay.controller;

import com.github.pagehelper.PageInfo;
import com.hjf.sportplay.entity.Easyuser;
import com.hjf.sportplay.entity.QueryInfo;
import com.hjf.sportplay.model.ResultMap;
import com.hjf.sportplay.service.IEasyuserService;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author hjf
 */
@RestController
@RequiresRoles("超级管理员")
public class UserController {

    @Autowired
    private IEasyuserService easyuserService;

    @Autowired
    private ResultMap resultMap;

    @PostMapping("/getUserList")
    public PageInfo<Easyuser> getUserList(@RequestBody QueryInfo queryInfo){
        PageInfo<Easyuser> pageInfo = easyuserService.selectList(queryInfo);
        return pageInfo;
    }

    @PutMapping("/updateUserState")
    public ResultMap updateUserState(Integer id,Boolean state){
        Easyuser easyuser = easyuserService.selectById(id);
        easyuser.setState(state);
        int update = easyuserService.updateById(easyuser);
        if (update > 0) {
            return resultMap.success().code(200).message("成功更新状态");
        }
        return resultMap.fail().code(401).message("更新状态失败");
    }

    @PostMapping("/addUser")
    public ResultMap addUser(@RequestBody Easyuser easyuser){
        easyuser.setRole("普通用户");
        easyuser.setState(false);
        int insert = easyuserService.insert(easyuser);
        if (insert > 0) {
            return resultMap.success().code(200).message("添加成功");
        }
        return resultMap.fail().code(401).message("添加失败 用户名已有");
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResultMap deleteUser(@PathVariable Integer id){
        int delete = easyuserService.deleteById(id);
        if (delete > 0) {
            return resultMap.success().code(200).message("删除成功");
        }
        return resultMap.fail().code(401).message("删除失败");
    }

    @GetMapping("/getUser/{id}")
    public ResultMap getUser(@PathVariable Integer id){
        Easyuser easyuser = easyuserService.selectById(id);
        if (easyuser != null) {
            return resultMap.success().code(200).message(easyuser);
        }
        return resultMap.fail().code(401).message("查询失败");
    }

    @PutMapping("/updateUser")
    public ResultMap updateUser(@RequestBody Easyuser easyuser){
        int update = easyuserService.updateById(easyuser);
        if (update > 0) {
            return resultMap.success().code(200).message("修改成功");
        }
        return resultMap.fail().code(401).message("修改失败");
    }
}
