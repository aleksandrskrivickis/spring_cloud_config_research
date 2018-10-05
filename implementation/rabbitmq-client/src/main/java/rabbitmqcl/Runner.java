package rabbitmqcl;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        for(int a = 0; a < 1000000; a++){
            a--;
            double rand_var = Math.random();
            System.out.println("Sending message...");
            rabbitTemplate.convertAndSend(Application.topicExchangeName, "foo.bar.baz", rand_var);
            Thread.sleep(2000);
        }
        receiver.getLatch().await(100000, TimeUnit.MILLISECONDS);
    }

}