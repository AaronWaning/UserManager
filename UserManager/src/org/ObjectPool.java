package org;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.config.SystemConfig;

/**
 * �����
 * @author Administrator
 *
 */
public class ObjectPool {
	
	public static Map<String,Object> pool = new ConcurrentHashMap<String, Object>();
	
	
	@SuppressWarnings("unchecked")
	public static <T> T get(String key) {
		return (T) pool.get(key);
	}

	public static Object put(String key, Object value) {
		return pool.put(key, value);
	}

	public static SystemConfig getSystemConfig(){
		return ObjectPool.get(SystemConfig.class.getName());
	}
	
	public static void setSystemConfig(SystemConfig config){
		ObjectPool.put(SystemConfig.class.getName(),config);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void putAll(Map m) {
		pool.putAll(m);
	}
	public static void clear() {
		pool.clear();
	}
	
}
