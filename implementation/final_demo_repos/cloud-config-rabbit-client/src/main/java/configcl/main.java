package configcl;

import configcl.Commons.LatestConfig;
import configcl.util.JsonMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class main {
    public static void main(String[] args) {
        SpringApplication.run(main.class, args);
    }
}
