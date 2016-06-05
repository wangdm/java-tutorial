package org.wangdm.tutorial.redistutorial;

import java.util.HashMap;
import java.util.Map;

import redis.clients.jedis.JedisPool;

public class RedisUtil {

	private static RedisUtil instance = null;
	
    private  Map<String,JedisPool> maps  = new HashMap<String,JedisPool>();  
	
	private RedisUtil(){}
	
	public RedisUtil getInstance(){
		if(instance==null){
			instance = new RedisUtil();
		}
		return instance;
	}
	
	public JedisPool getPool(){
		return null;
	}
}
