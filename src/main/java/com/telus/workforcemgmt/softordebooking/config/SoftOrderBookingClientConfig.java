package com.telus.workforcemgmt.softordebooking.config;

import com.telus.workforcemgmt.async.webhook.state.TopicMessageFilter;
import com.telus.workforcemgmt.softordebooking.callback.SoftOrderBookingSubscriptionMessageCallBack;
import com.telus.workforcemgmt.softordebooking.filter.SoftOrderBookingFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SoftOrderBookingClientConfig {

    @Value("${eventFilterList}")
    private List<String> eventFilterList;

    @Bean(name = "topicMessageFilter")
    public TopicMessageFilter topicMessageFilter() {
        return new SoftOrderBookingFilter(eventFilterList, new SoftOrderBookingSubscriptionMessageCallBack());
    }
}
