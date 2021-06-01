//
///** 
// * @单位名称：暂无公司
// * @Copyright (c) 2018 All Rights Reserved.
// * @系统名称：Victor
// * @工程名称：world-api
// * @文件名称: MyRedisServiceImpl.java
// * @类路径: com.world.system.service.impl
// */
//
//		package org.one.system.service.impl;
//
//import java.util.concurrent.TimeUnit;
//
//import org.one.system.service.RedisService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.stereotype.Service;
//
///** 
// *
// * @see
// * @author  wangyao
// * @date	2018年1月30日 下午7:41:08
// * @version
// */
//@Service("redisService")
//public class RedisServiceImp implements RedisService {
//	/**
//	 * 注入redisTemplate
//	 */
//	@Autowired
//	private RedisTemplate<String, Object> redisTemplate;
//
//	/**
//	 * 根据key获取对象
//	 * @Title get
//	 * @author wangyao
//	 * @param key
//	 * @return String
//	 */
//	public Object get(final String key) {
//		Object result = "";
//		if (redisTemplate != null) {
//			result = redisTemplate.opsForValue().get(key);
//			/*
//			 * if(redisTemplate.expireAt(key, new Date())){ return ""; }
//			 */
//		}
//		return result;
//	}
//	/**
//	 * 根据key删除
//	 * @Title del
//	 * @param key
//	 * @return boolean
//	 */
//	public boolean del(final String key) {
//		if (redisTemplate != null) {
//			try {
//				redisTemplate.delete(key);
//				return true;
//			} catch (Exception e) {
//				e.printStackTrace();
//				return false;
//			}
//		} else {
//			return false;
//		}
//	}
//	/**
//	 * 设置key和value
//	 * @Title set
//	 * @param key
//	 * @param value
//	 * @return Boolean
//	 */
//	public Boolean set(final String key, final Object value) {
//		return set(key, value, -1L, TimeUnit.DAYS);
//	}
//	/**
//	 * set
//	 * @Title set
//	 * @param key
//	 * @param value
//	 * @param time
//	 * @param timeUnit
//	 * @return Boolean
//	 */
//	public Boolean set(final String key, final Object value, long time, TimeUnit timeUnit) {
//		if (redisTemplate != null) {
//			try {
//				redisTemplate.opsForValue().set(key, value);
//				if (time > 0) {
//					redisTemplate.expire(key, time, timeUnit);
//				}
//				return true;
//			} catch (Exception e) {
//				e.printStackTrace();
//				return false;
//			}
//		} else {
//			return false;
//		}
//	}
//}
//
//		