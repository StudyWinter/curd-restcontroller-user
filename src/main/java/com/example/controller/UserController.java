package com.example.controller;


import com.example.mapper.UserMapper;
import com.example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;


    //1、返回所有用户信息
    @RequestMapping("/rest/getAllUser")
    public List<User>getAllUser(){
        List<User> list = userMapper.getAllUser();
        return list;
    }

    //2、查找一个用户
    @RequestMapping("/rest/getUser")
    public User getUser(String userName){
        User user = userMapper.getUser(userName);
        return user;
    }

    //3、添加用户
    @RequestMapping("/rest/addUser")
    public String addUser(String userName,String passWord){
        //先查找
        User user = userMapper.getUser(userName);
        if(user!=null){
            //有该用户，不能添加
            return "the user has been registered,please register again";
        }else{
            userMapper.addUser(userName,passWord);
            return "the user "+userName+"  added";
        }
    }

    //4、删除用户
    @RequestMapping("/rest/delUser")
    public String delUser(String userName){
        //先查找
        User user = userMapper.getUser(userName);
        if(user != null){
            //有该用户，可删除
            userMapper.delUser(userName);
            return "the user has been deleted";
        }else{
            return "no found";
        }

    }

    //5、修改用户信息
    @RequestMapping("/rest/updateUser")
    public String updateUser(String userName,String passWord){
        //先查找
        User user = userMapper.getUser(userName);

        if(user!=null){
            //有该用户，可以修改
            userMapper.updateUser(userName, passWord);
            return "update successfully";
        }else{
            return "update......no found";
        }

    }




}
