package com.example.mapper;

import com.example.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    //1、返回所有用户信息
    @Select("select * from user")
    List<User>getAllUser();

    //2、查找一个用户
    @Select("select * from user where userName=#{userName}")
    User getUser(String userName);

    //3、添加用户信息
    @Insert("insert into user (userName,passWord) values (#{userName},#{passWord})")
    void addUser(String userName,String passWord);

    //4、删除用户
    @Delete("delete from user where userName=#{userName}")
    void delUser(String userName);

    //5、修改用户信息
    @Update("update user set passWord = #{passWord} where userName = #{userName}")
    void updateUser(String userName,String passWord);

}
