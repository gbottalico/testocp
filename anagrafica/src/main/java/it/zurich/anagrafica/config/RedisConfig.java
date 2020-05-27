package it.zurich.anagrafica.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

//@Configuration
/**
 * This class establish the connection with Redis
 */
public class RedisConfig {

    @Value("${spring.redis.host}")

    private String REDIS_HOSTNAME;

    @Value("${spring.redis.port}")

    private int REDIS_PORT;

    //@Bean
    protected JedisConnectionFactory jedisConnectionFactory() {
    	//This class used for setting up the connection for single node Redis installation.
        RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(REDIS_HOSTNAME, REDIS_PORT);
        //This class provides an optional feature for SSLSocketFactory and JedisPoolConfig specific to Jedis client features.
        JedisClientConfiguration jedisClientConfiguration = JedisClientConfiguration.builder().usePooling().build();
        //This is the connection factory for the Jedis base connection. It uses the JedisClientConfiguration and RedisStandaloneConfiguration
        JedisConnectionFactory factory = new JedisConnectionFactory(configuration,jedisClientConfiguration);
        factory.afterPropertiesSet();

        return factory;

    }

    //@Bean
    public RedisTemplate<String,Object> redisTemplate() {
    	//This helper simplifies data access for Redis. It uses automatic serialization and deserialization 
    	//for a given object and underlying binary data in the Redis store
        final RedisTemplate<String,Object> redisTemplate = new RedisTemplate<String,Object>();

        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new GenericToStringSerializer<Object>(Object.class));
        redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setConnectionFactory(jedisConnectionFactory());

        return redisTemplate;

    }

}