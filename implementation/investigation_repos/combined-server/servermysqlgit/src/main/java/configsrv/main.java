package configsrv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.config.server.environment.JGitEnvironmentRepository;
import org.springframework.cloud.config.server.environment.JdbcEnvironmentRepository;
import org.springframework.context.annotation.Import;


@EnableConfigServer
@SpringBootApplication
@Import({
        JdbcEnvironmentRepository.class,
        JGitEnvironmentRepository.class
})



public class main {


    public static void main(String[] args) {
        SpringApplication.run(main.class, args);
    }
}

//http://localhost:8888/latest/properties-production.properties