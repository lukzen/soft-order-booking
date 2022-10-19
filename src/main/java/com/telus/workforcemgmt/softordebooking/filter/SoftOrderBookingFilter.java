package com.telus.workforcemgmt.softordebooking.filter;

import com.telus.workforcemgmt.async.pubsub.AsyncRequestCallBack;
import com.telus.workforcemgmt.async.webhook.state.TopicMessageFilter;
import com.telus.workforcemgmt.softordebooking.callback.SoftOrderBookingSubscriptionMessageCallBack;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Component
public class SoftOrderBookingFilter extends TopicMessageFilter {

    private static final Logger logger = LoggerFactory.getLogger(SoftOrderBookingFilter.class);

    private List<String> eventFilterList;

    private SoftOrderBookingSubscriptionMessageCallBack softOrderBookingSubscriptionMessageCallBack;

    public SoftOrderBookingFilter(List<String> eventFilterList, SoftOrderBookingSubscriptionMessageCallBack softOrderBookingSubscriptionMessageCallBack) {
        this.eventFilterList = eventFilterList;
        this.softOrderBookingSubscriptionMessageCallBack = softOrderBookingSubscriptionMessageCallBack;
    }

    public SoftOrderBookingFilter() {
    }

    @Override
    public AsyncRequestCallBack getAsyncRequestCallBack(List<String> eventNames) {
        return softOrderBookingSubscriptionMessageCallBack;
    }

    @Override
    protected List<String> getEventNames() {
        return new ArrayList<>(Optional.ofNullable(eventFilterList).orElseGet(Collections::emptyList));
    }

    @Override
    public boolean acceptAllEvents() {
        return false;
    }

}