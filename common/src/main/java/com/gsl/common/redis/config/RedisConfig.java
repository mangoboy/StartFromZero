package com.gsl.common.redis.config;

import com.gsl.common.redis.porp.RedisProp;
import jodd.util.StringPool;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Configuration
@EnableCaching
@ConditionalOnBean(RedisProp.class)
public class RedisConfig extends CachingConfigurerSupport {

    @Resource
    RedisProp redisProp;

    private static String REDIS_PREFIX = "redis://";

    private static String SINGLE_MODE = "single";
    private static String SENTINEL_MODE = "sentinel";
    private static String CLUSTER_MODE = "cluster";

    @Bean
    @SuppressWarnings(value = {"unchecked", "rawtypes"})
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        FastJson2JsonRedisSerializer serializer = new FastJson2JsonRedisSerializer(Object.class);
        // 使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(serializer);
        // Hash的key也采用StringRedisSerializer的序列化方式
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashValueSerializer(serializer);
        template.afterPropertiesSet();
        return template;
    }


    @Bean
    public Redisson redisson() {
        Config config = new Config();
        if (CLUSTER_MODE.equals(redisProp.getRedisActive())) {
            //集群版
            List<String> addressList = redisProp.getCluster().stream().map(item -> REDIS_PREFIX + item).collect(Collectors.toList());
            String[] addressArray = addressList.toArray(new String[addressList.size()]);
            config.useClusterServers().addNodeAddress(addressArray)
                    .setPassword(redisProp.getPassword())
                    .setMasterConnectionPoolSize(redisProp.getConnectionPoolSize())
                    .setMasterConnectionMinimumIdleSize(redisProp.getConnectionMinimumIdleSize())
                    .setTimeout(redisProp.getTimeout());
            log.info("=======redisson===配置====集群===");
            log.info("redisson cluster Address={}", addressList);
        } else {
            //单机版 "redis://192.168.1.1:8001"
            StringBuilder sb = new StringBuilder();
            sb.append(REDIS_PREFIX).append(redisProp.getHost())
                    .append(StringPool.COLON).append(redisProp.getPort());
            config.useSingleServer().setAddress(sb.toString())
                    .setDatabase(redisProp.getDatabase())
                    .setPassword(redisProp.getPassword())
                    .setConnectionPoolSize(redisProp.getConnectionPoolSize())
                    .setConnectionMinimumIdleSize(redisProp.getConnectionMinimumIdleSize())
                    .setTimeout(redisProp.getTimeout());
            log.info("=======redisson===配置====单机===");
            log.info("redisson single Address={}", sb);
        }
        return (Redisson) Redisson.create(config);
    }


}
