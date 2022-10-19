package com.telus.workforcemgmt.softordebooking.callback;

import com.telus.workforcemgmt.async.pubsub.AsyncRequestCallBack;
import com.telus.workforcemgmt.async.pubsub.AsyncWarnException;
import com.telus.workforcemgmt.async.pubsub.SubscriptionMessage;
import com.telus.workforcemgmt.il.common.logging.Logging;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Logging
public class SoftOrderBookingSubscriptionMessageCallBack implements AsyncRequestCallBack {
    private static final Logger logger = LoggerFactory.getLogger(SoftOrderBookingSubscriptionMessageCallBack.class);

    public SoftOrderBookingSubscriptionMessageCallBack() {
    }

    @Override
    public SubscriptionMessage process(SubscriptionMessage req) throws AsyncWarnException {
        logger.info("Message arrived for pubsub.softBooking! Payload: " + req.toString());
        return req;
    }
}