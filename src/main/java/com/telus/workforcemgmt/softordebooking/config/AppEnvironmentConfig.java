package com.telus.workforcemgmt.softordebooking.config;

import com.telus.workforcemgmt.il.common.envconfig.EnvConfigBase;
import com.telus.workforcemgmt.il.common.envconfig.EnvConfigException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AppEnvironmentConfig extends EnvConfigBase{
	
	@Value("${pathToFolderApplications}")
	private String pathToFolderApplications;
	@Value("${pathToGcpProjectServiceAccountJson}")
	private String pathToGcpProjectServiceAccountJson;
	@Value("${gcpProjectId}")
	private String gcpProjectId;
	@Value("${bucketName}")
	private String bucketName;
	@Value("${appEnvName}")
	private String appEnvName;

	private String appName = "soft-order-booking-receiver";

	@Autowired
	Environment environment;

	@Autowired
	private BuildProperties buildProperties;

	@Bean("appConfigEnv")
	public Map<String, String> envConfig() throws EnvConfigException {
		Map<String, String> map = loadConfigEnv(environment, pathToGcpProjectServiceAccountJson, gcpProjectId,
				bucketName, pathToFolderApplications, appName, appEnvName);
		return map;
	}

	@Bean("apiVersionInfo")
	public Map<String, String> apiVersionInfo() throws EnvConfigException {
		Map<String, String> map = apiVersionInfo(appName, appEnvName, buildProperties);
		return map;
	}
	
}