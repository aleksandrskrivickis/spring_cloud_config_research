package hk.com.hsbc.peak.poc.configclient.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(double message) {
        System.out.println(LocalDateTime.now() + " " + "Subscriber - received \"noise\" message <" + message + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}