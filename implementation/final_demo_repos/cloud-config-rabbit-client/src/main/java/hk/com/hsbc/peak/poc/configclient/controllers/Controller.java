package hk.com.hsbc.peak.poc.configclient.controllers;

import hk.com.hsbc.peak.poc.configclient.util.Receiver;
import hk.com.hsbc.peak.poc.configclient.util.AppConfig;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.*;

@RestController
class Controller {

//    Test urls:
//    http://localhost:8888/latest/properties-production.json
//    http://127.0.0.1:8080/swagger-ui.html#
//    http://localhost:8080/user
//    http://localhost:8080/user/keys
//    http://localhost:8080/user/json-data

    @Autowired
    private AppConfig appconfig;

    @RequestMapping("/object.anotherkey.nestedkey.nestnestedkey")
    String getconfig_identifier_1() {
        return appconfig.getNestNestedKey();
    }


    @RequestMapping("/object.anotherkey.nestedkey.anothernestnestedkey")
    String getconfig_identifier() {
        return appconfig.getAnothernestnestedkey();
    }


    @RequestMapping("/1")
    String getpropertySources() {
        return appconfig.getSource_database();
    }


    @RequestMapping("/2")
    String getconfigService() {
        return appconfig.getParagraph();
    }


    @RequestMapping("/3")
    String getproperties() {
        return appconfig.getObj_array_1_bool();
    }

//    //Getting latest config
//    @Value("${user}")
//    private LatestConfig lc;

//    @RequestMapping("/user/keys")
//    String getUserKeys(String user_json) {
//        String returnable = "";
//        JSONObject jsonObj = new JSONObject(lc.getLatestConfig());
//        return jsonObj.names().toString();
//    }
//
//    @RequestMapping(value = "/user/{key}", method = { RequestMethod.GET})
//    @ResponseBody
//    public String getFoosBySimplePathWithPathVariable(
//            @PathVariable("key") String key) {
//            JSONObject jsonObj = new JSONObject(lc.getLatestConfig());
//            return jsonObj.get(key).toString();
//    }


    @RequestMapping("/")
    public HashMap index() {
        HashMap<String, String> map = new HashMap<>();
        map.put("!content", "This is a demonstration of Spring Cloud Config features.");
        map.put("Current features", "* Get variable(message) from GitHub based config. http://127.0.0.1:8080/message;\nUpdate Actuator endpoint(config) from GitHub. POST http://127.0.0.1:8080/actuator/refresh");
        map.put("Config sources", "https://github.com/aleksandrskrivickis/spring_cloud_config_research_config.git; \nDBMS");
        return map;

    }

    @Autowired
    protected StandardEnvironment environment;
    private long lastModTime = 0L;
    private Path configPath = null;
    private PropertySource<?> appConfigPropertySource = null;

    static final String topicExchangeName = "testExchange";

    static final String queueName = "testQueue";

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("foo.bar.baz");
    }

    @Bean
    Queue queue() {
        return new Queue(queueName, false);
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    MessageListenerAdapter listenerAdapter(Receiver receiver) {
        return new MessageListenerAdapter(receiver, "receiveMessage");
    }

}