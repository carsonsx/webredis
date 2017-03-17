package com.carsonsx.redis;

import com.carsonsx.model.KeyVal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * Created by carsonsx on 2017/3/17.
 */
@Repository
public class RedisDao {

    @Autowired
    protected StringRedisTemplate redisTemplate;

    public void set(KeyVal kv) {
        redisTemplate.execute((RedisCallback<Boolean>) connection -> {
            connection.set(kv.getKeyBytes(), kv.getValBytes(),null, null);
            return true;
        });
    }

    public boolean setNX(KeyVal kv) {
        return redisTemplate.execute((RedisCallback<Boolean>) connection -> connection.setNX(kv.getKeyBytes(), kv.getValBytes()));
    }

    public String get(String key) {
        return redisTemplate.execute((RedisCallback<String>) connection -> redisTemplate.getStringSerializer().deserialize(connection.get(redisTemplate.getStringSerializer().serialize(key))));
    }

}
