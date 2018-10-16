package hk.com.hsbc.peak.poc.configclient.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;

@RefreshScope
@Configuration
public class AppConfig {

    @Value("${object.anotherkey.nestedkey.nestnestedkey: missing}")
    private String nestNestedKey;

    @Value("${object.anotherkey.nestedkey.anothernestnestedkey: missing}")
    private String anothernestnestedkey;

    @Value("${config_identifier.source_database: missing}")
    private String source_database;

    @Value("${paragraph: missing}")
    private String paragraph;

    @Value("${object.array[1].boolean: missing}")
    private String obj_array_1_bool;

    public String getNestNestedKey() {
        return nestNestedKey;
    }

    public String getAnothernestnestedkey() {
        return anothernestnestedkey;
    }

    public String getSource_database() {
        return source_database;
    }

    public String getParagraph() {
        return paragraph;
    }

    public String getObj_array_1_bool() {
        return obj_array_1_bool;
    }

}
