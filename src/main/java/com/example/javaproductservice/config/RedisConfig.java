package com.example.javaproductservice.config;

//import com.fasterxml.jackson.annotation.JsonTypeInfo;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.SerializationFeature;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//import org.springframework.cache.CacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializationContext;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//
//import java.time.Duration;
//
//@Configuration
//public class RedisConfig {
//    @Bean
//    public CacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
//        ObjectMapper objectMapper = new ObjectMapper()
//                .registerModule(new JavaTimeModule())
//                .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
//
//        objectMapper.activateDefaultTyping( // Вместо enableDefaultTyping
//                objectMapper.getPolymorphicTypeValidator(), // Валидатор типов
//                ObjectMapper.DefaultTyping.EVERYTHING, // Аналогичная политика типизации
//                JsonTypeInfo.As.WRAPPER_ARRAY // Как включать информацию о типе
//                //JsonTypeInfo.As.PROPERTY // Как включать информацию о типе
//        );
//        //.enableDefaultTyping(ObjectMapper.DefaultTyping.EVERYTHING);
//        //objectMapper.deactivateDefaultTyping();
//
//        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
//                .entryTtl(Duration.ofMinutes(30))
//                .disableCachingNullValues()
//                .prefixCacheNameWith("myapp:")
//                .computePrefixWith(cacheName -> "custom:" + cacheName + ":")
//                .serializeKeysWith(RedisSerializationContext.SerializationPair
//                        .fromSerializer(new StringRedisSerializer()))
//                .serializeValuesWith(RedisSerializationContext.SerializationPair
//                        .fromSerializer(new GenericJackson2JsonRedisSerializer(objectMapper)));
//
//        return RedisCacheManager.builder(redisConnectionFactory)
//                .cacheDefaults(config)
//                .build();
//    }
//}
