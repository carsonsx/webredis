package com.carsonsx.web;

import com.carsonsx.model.KeyVal;
import com.carsonsx.redis.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * Created by carsonsx on 2017/3/17.
 */

@RestController
public class RedisController {

    @Autowired
    RedisDao redisDao;

    @RequestMapping(value = "/set/{key}/{val}")
    public ResponseMessage set(@PathVariable("key") String key, @PathVariable("val") String val) {
        redisDao.set(new KeyVal(key, val));
        return ResponseMessage.ok();
    }

    @RequestMapping(value = "/get/{key}")
    public ResponseMessage get(@PathVariable("key") String key) {
        String val = redisDao.get(key);
        if (val == null) {
            return ResponseMessage.notExists(val);
        } else {
            return ResponseMessage.data(val);
        }
    }

}
