package com.sarcobjects.tables;

import com.sarcobjects.tables.model.Table;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@SpringBootApplication
@EnableRedisRepositories
public class TablesApplication {

    public static void main(String[] args) {
        SpringApplication.run(TablesApplication.class, args);
    }


    @Bean
    public RedisConnectionFactory connectionFactory() {
        return new LettuceConnectionFactory(new RedisStandaloneConfiguration("192.168.1.140"));
    }

    @Bean
    public RedisTemplate<Long, Table> RedisTemplate(
            RedisConnectionFactory connectionFactory) {


        RedisTemplate<Long, Table> redisTemplate = new RedisTemplate<>();
        RedisSerializationContext<String, Table> serializationContext = RedisSerializationContext
                .<String, Table>newSerializationContext(new StringRedisSerializer())
                .hashKey(new StringRedisSerializer())
                .hashValue(new Jackson2JsonRedisSerializer<>(Table.class))
                .build();
        redisTemplate.setConnectionFactory(connectionFactory);

        return redisTemplate;
    }
}
