package com.goorm.profileboxcomm.service;

import com.goorm.profileboxcomm.entity.Member;
import com.goorm.profileboxcomm.repository.MemberRedisRepository;
import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberRedisService {

    private final MemberRedisRepository memberRedisRepository;
    private final RedisTemplate<String, Object> redisTemplate;

    public void saveMemberToRedis(String jwtToken, Member member){
        String key = "member:" + jwtToken;
        redisTemplate.opsForValue().set(key, member);
    }

    public Member getMemberFromRedis(String jwtToken){
        String key = "member:" + jwtToken;
        return (Member) redisTemplate.opsForValue().get(key);
    }

    public void saveCacheTest(){
        RedisClient redisClient = RedisClient.create("redis://example-replication-group.eigq1z.ng.0001.apn2.cache.amazonaws.com:6379/0");
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> syncCommands = connection.sync();

        syncCommands.set("key", "Hello, Redis!");
    }

    public void getCacheTest(){
        RedisClient redisClient = RedisClient.create("redis://example-replication-group.eigq1z.ng.0001.apn2.cache.amazonaws.com:6379/0");
        StatefulRedisConnection<String, String> connection = redisClient.connect();
        RedisCommands<String, String> syncCommands = connection.sync();

        syncCommands.get("key");
    }
}
