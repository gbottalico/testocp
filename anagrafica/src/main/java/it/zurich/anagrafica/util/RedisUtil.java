package it.zurich.anagrafica.util;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * As it is a generic class, you have to just create an instance of this class with the required type you want to cache.
 * @author zurich
 *
 * @param <T>
 */
 //@Configuration
public class RedisUtil<T> {

    private RedisTemplate<String,T> redisTemplate;

    private HashOperations<String,Object,T> hashOperation;

    private ListOperations<String,T>  listOperation;
    
    private ValueOperations<String,T> valueOperations;

    //@Autowired
    RedisUtil(RedisTemplate<String,T> redisTemplate){

        this.redisTemplate = redisTemplate;
        this.hashOperation = redisTemplate.opsForHash();//return the HashOperations<K,HK,HV> class. This class use for hash operations on Redis
        this.listOperation = redisTemplate.opsForList();//return the ListOperations<K,V> used for list operations.
        this.valueOperations = redisTemplate.opsForValue();//return the ValueOperations<K,V> Perform simple key value operations; each key will have an entry in Redis for its associated value

     }

     public void putMap(String redisKey,Object key,T data) {

        hashOperation.put(redisKey, key, data);

     }

     public T getMapAsSingleEntry(String redisKey,Object key) {

        return  hashOperation.get(redisKey,key);

     }

     public Map<Object, T> getMapAsAll(String redisKey) {

        return hashOperation.entries(redisKey);

     }

     public void putValue(String key,T value) {

        valueOperations.set(key, value);

     }

     public void putValueWithExpireTime(String key,T value,long timeout,TimeUnit unit) {

        valueOperations.set(key, value, timeout, unit);

     }

     public T getValue(String key) {

        return valueOperations.get(key);

     }

     public void setExpire(String key,long timeout,TimeUnit unit) {

       redisTemplate.expire(key, timeout, unit);

     }

}