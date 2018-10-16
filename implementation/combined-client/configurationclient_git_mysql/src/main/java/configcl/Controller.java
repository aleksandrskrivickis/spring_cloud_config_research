package configcl;

import configcl.util.MySqlConnMan;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.util.*;

@RefreshScope
@RestController
class Controller {

//    @RequestMapping("/connectmysql")
//    String establishConnectiton() {
//        Connection conn = MySqlConnMan.establishConnection("localhost", "3306","root", "");
//        return MySqlConnMan.selectData(conn);
//    }


//    Test urls:
//    http://localhost:8888/latest/properties-production.json
//    http://127.0.0.1:8080/swagger-ui.html#
//    http://localhost:8080/user
//    http://localhost:8080/user/keys
//    http://localhost:8080/user/json-data


    @Value("${config_identifier.source_database: missing}")
    private String propertySources;
    @RequestMapping("/1")
    String getpropertySources() {
        return this.propertySources;
    }

    @Value("${paragraph: missing}")
    private String configService;
    @RequestMapping("/2")
    String getconfigService() {
        return this.configService;
    }

    @Value("${object.array[1].boolean: missing}")
    private String properties;
    @RequestMapping("/3")
    String getproperties() {
        return this.properties;
    }
//
//    @Value("${MSSQL_HOST}")
//    private String msSqlHost;
//    @RequestMapping("/properties-production")
//    String getMsSqlHost() {
//        return this.msSqlHost;
//    }


//    @Value("${CC_HOST}")
//    private String CC_HOST;
//    @RequestMapping("/CC_HOST")
//    String getCcHost() {
//        return this.CC_HOST;
//    }
//
//    @Value("${CC_PORT}")
//    private String CC_PORT;
//    @RequestMapping("/CC_PORT")
//    String getCcPort() {
//        return this.CC_PORT;
//    }
//
//    @Value("${MSSQL_HOST}")
//    private String MSSQL_HOST;
//    @RequestMapping("/MSSQL_HOST")
//    String getMssqlHost() {
//        return this.MSSQL_HOST;
//    }
//
//    @Value("${MSSQL_TOKEN}")
//    private String MSSQL_TOKEN;
//    @RequestMapping("/MSSQL_TOKEN")
//    String getMssqlToken() {
//        return this.MSSQL_TOKEN;
//    }

    @RequestMapping("/")
    public HashMap index() {
        HashMap<String, String> map = new HashMap<>();
        map.put("!content", "This is a demonstration of Spring Cloud Config features.");
        map.put("Current features", "* Get variable(message) from GitHub based config. http://127.0.0.1:8080/message;\nUpdate Actuator endpoint(config) from GitHub. POST http://127.0.0.1:8080/actuator/refresh");
        map.put("Config sources", "https://github.com/aleksandrskrivickis/spring_cloud_config_research_config.git; \nDBMS");
        return map;

    }

}