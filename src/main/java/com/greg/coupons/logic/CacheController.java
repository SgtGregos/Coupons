package com.greg.coupons.logic;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class CacheController {
	//-------------------------------------------
	private Map<String, Object> dataMap;
	//-------------------------------------------
	public CacheController() {
		super();
		this.dataMap = new HashMap<>();
	}
	//-------------------------------------------

	public Object get(String key) {
		return this.dataMap.get(key);
	}

	public void put(String key, Object value) {
		this.dataMap.put(key, value);
	}
	//-------------------------------------------
	
	
}
