//package rabbitmqcl;
//
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.CountDownLatch;
//
//import java.util.concurrent.CountDownLatch;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Receiver {
//
//    private CountDownLatch latch = new CountDownLatch(1);
//
//    public void receiveMessage(double message) {
//        System.out.println("Received <" + message + ">");
//        latch.countDown();
//    }
//
//    public CountDownLatch getLatch() {
//        return latch;
//    }
//
//}