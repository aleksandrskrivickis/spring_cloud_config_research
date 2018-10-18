package configsrv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.mongodb.EnableMongoConfigServer;

@SpringBootApplication
@EnableMongoConfigServer

public class main {
    public static void main(String[] args) {
        SpringApplication.run(main.class, args);
    }
    //Endpoints:
    //http://localhost:8888/master/gateway-prod.properties
    //http://localhost:8888/latest/properties-production.properties
    //http://localhost:8888/latest/properties-production.json
    //http://localhost:8888/latest/properties-production.yml
}

