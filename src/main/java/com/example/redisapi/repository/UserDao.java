package com.example.redisapi.repository;


import com.example.redisapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class UserDao {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    private static final String KEY="newuser";

    public User save(User user){
        redisTemplate.opsForHash().put(KEY,user.getId(),user);
        return user;
    }

    public User get(String id){
        return (User) redisTemplate.opsForHash().get(KEY,id);
    }

    public Map<Object,Object> findAll(){
        return redisTemplate.opsForHash().entries(KEY);
    }

    public void delete(String id){
        redisTemplate.opsForHash().delete(KEY,id);
    }

}
