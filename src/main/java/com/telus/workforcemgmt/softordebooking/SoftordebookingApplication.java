package com.telus.workforcemgmt.softordebooking;

import com.telus.workforcemgmt.async.pubsub.AsyncProcessConfig;
import com.telus.workforcemgmt.async.webhook.WebhookApplicationConfig;
import com.telus.workforcemgmt.il.common.utils.RestResponseEntityExceptionHandler;
import com.telus.workforcemgmt.softordebooking.config.AppEnvironmentConfig;
import com.telus.workforcemgmt.softordebooking.config.DatasourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan({"com.telus.workforcemgmt.il.common.logging"})
@ComponentScan(basePackageClasses = {AppEnvironmentConfig.class, DatasourceConfig.class, WebhookApplicationConfig.class, AsyncProcessConfig.class, RestResponseEntityExceptionHandler.class})
public class SoftordebookingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoftordebookingApplication.class, args);
    }

}
