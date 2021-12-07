package com.api.dao;

import com.model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserDao {

    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "age", column = "age")
    })

    @Select("SELECT * FROM user WHERE id = #{id}")
    User get(String id);

    @Insert("INSERT INTO user (id, name, age) VALUES (#{id}, #{name}, #{age})")
    void insert(User user);

}
