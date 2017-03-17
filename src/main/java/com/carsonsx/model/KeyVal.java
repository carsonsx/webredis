package com.carsonsx.model;

import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.security.Key;

/**
 *
 * Created by carsonsx on 2017/3/17.
 */
public class KeyVal {

    private static StringRedisSerializer serializer = new StringRedisSerializer();

    private String key;

    private String val;

    private byte[] keyBytes;

    private byte[] valBytes;

    public KeyVal() {

    }

    public KeyVal(String key, String val) {
        this.setKey(key);
        this.setVal(val);
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
        this.keyBytes = serializer.serialize(key);
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
        this.valBytes = serializer.serialize(val);
    }

    public byte[] getKeyBytes() {
        return keyBytes;
    }

    public byte[] getValBytes() {
        return valBytes;
    }
}
