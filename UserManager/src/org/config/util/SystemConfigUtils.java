package org.config.util;

import java.io.IOException;

import org.ObjectPool;
import org.apache.commons.io.IOUtils;
import org.config.SystemConfig;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
public class SystemConfigUtils {
	public static Gson gson = new GsonBuilder().create();

	public static SystemConfig load() throws JsonParseException, IOException {
		SystemConfig config = gson.fromJson(
				IOUtils.toString(SystemConfigUtils.class.getClassLoader()
						.getResourceAsStream("systemconfig.dat")),
				SystemConfig.class);
		ObjectPool.setSystemConfig(config);
		return config;
	}
	
}
