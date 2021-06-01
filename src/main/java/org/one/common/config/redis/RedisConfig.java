//
///** 
// * @单位名称：暂无公司
// * @Copyright (c) 2018 All Rights Reserved.
// * @系统名称：Victor
// * @工程名称：world-api
// * @文件名称: RedisConfig.java
// * @类路径: com.world.system.config.redis
// */
//
//package org.one.common.config.redis;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//
//import redis.clients.jedis.JedisPoolConfig;
//
///**
// *
// * @see
// * @author wangyao
// * @date 2018年1月30日 下午7:32:07
// * @version
// * @desc TODO
// */
//@Configuration
//@EnableAutoConfiguration
//public class RedisConfig {
//
//	private static Logger logger = LoggerFactory.getLogger(RedisConfig.class);
//
//	@Bean
//	@ConfigurationProperties(prefix = "spring.redis")
//	public JedisPoolConfig getRedisConfig() {
//		JedisPoolConfig config = new JedisPoolConfig();
//		return config;
//	}
//
//	@Bean
//	@ConfigurationProperties(prefix = "spring.redis")
//	public JedisConnectionFactory getConnectionFactory() {
//		JedisConnectionFactory factory = new JedisConnectionFactory();
//		JedisPoolConfig config = getRedisConfig();
//		factory.setPoolConfig(config);
//		logger.info("JedisConnectionFactory bean init success.");
//		return factory;
//	}
//
//	@Bean
//	public RedisTemplate<?, ?> getRedisTemplate() {
//		RedisTemplate<?, ?> template = new StringRedisTemplate(getConnectionFactory());
//		return template;
//	}
//}
