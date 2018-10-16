package hk.com.hsbc.peak.poc.configclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableConfigServer
@SpringBootApplication

public class main {
    public static void main(String[] args) {
        SpringApplication.run(main.class, args);
    }
}

//http://localhost:8888/latest/properties-production.properties