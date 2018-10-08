package configcl;

import configcl.Commons.LatestConfig;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

@RefreshScope
@RestController
class Controller {

//    Test urls:
//    http://localhost:8888/latest/properties-production.json
//    http://127.0.0.1:8080/swagger-ui.html#
//    http://localhost:8080/user
//    http://localhost:8080/user/keys
//    http://localhost:8080/user/json-data


    //Getting latest config
    @Value("${user}")
    private LatestConfig lc;

    @Value("${message}")
    private String message;
    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }

    @RequestMapping("/user")
    String getUserJson() {
//        Map<String, Object> map = lc.getLatestConfigHashMap();
        return lc.getLatestConfig();
    }

    @Autowired
    protected StandardEnvironment environment;
    private long lastModTime = 0L;
    private Path configPath = null;
    private PropertySource<?> appConfigPropertySource = null;


    @RequestMapping("/user/keys")
    String getUserKeys(String user_json) {
        String returnable = "";
        JSONObject jsonObj = new JSONObject(lc.getLatestConfig());
        return jsonObj.names().toString();
    }

    @RequestMapping(value = "/user/{key}", method = { RequestMethod.GET})
    @ResponseBody
    public String getFoosBySimplePathWithPathVariable(
            @PathVariable("key") String key) {
            JSONObject jsonObj = new JSONObject(lc.getLatestConfig());
            return jsonObj.get(key).toString();
    }

    @Value("${CC_HOST}")
    private String CC_HOST;
    @RequestMapping("/CC_HOST")
    String getCcHost() {
        return this.CC_HOST;
    }

    @Value("${CC_PORT}")
    private String CC_PORT;
    @RequestMapping("/CC_PORT")
    String getCcPort() {
        return this.CC_PORT;
    }

    @Value("${MSSQL_HOST}")
    private String MSSQL_HOST;
    @RequestMapping("/MSSQL_HOST")
    String getMssqlHost() {
        return this.MSSQL_HOST;
    }

    @Value("${MSSQL_TOKEN}")
    private String MSSQL_TOKEN;
    @RequestMapping("/MSSQL_TOKEN")
    String getMssqlToken() {
        return this.MSSQL_TOKEN;
    }

    @RequestMapping("/")
    public HashMap index() {
        HashMap<String, String> map = new HashMap<>();
        map.put("!content", "This is a demonstration of Spring Cloud Config features.");
        map.put("Current features", "* Get variable(message) from GitHub based config. http://127.0.0.1:8080/message;\nUpdate Actuator endpoint(config) from GitHub. POST http://127.0.0.1:8080/actuator/refresh");
        map.put("Config sources", "https://github.com/aleksandrskrivickis/spring_cloud_config_research_config.git; \nDBMS");
        return map;

    }

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