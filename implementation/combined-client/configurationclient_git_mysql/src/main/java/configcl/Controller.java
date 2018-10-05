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


    @Value("${message}")
    private String message;
    @RequestMapping("/message")
    String getMessage() {
        return this.message;
    }

    @Value("${MSSQL_HOST}")
    private String msSqlHost;
    @RequestMapping("/properties-production")
    String getMsSqlHost() {
        return this.msSqlHost;
    }

    @Value("${user}")
    private String userJson;
    @RequestMapping("/user")
    String getUserJson() {
        return this.userJson;
    }

    @Value("${user}")
    private String userKeys;
    @RequestMapping("/user/keys")
    String getUserKeys(String user_json) {
        String returnable = "";
        JSONObject jsonObj = new JSONObject(this.userKeys);
        return jsonObj.names().toString();
    }

    @Value("${user}")
    private String userJson1;
    @RequestMapping(value = "/user/{key}", method = { RequestMethod.GET})
    @ResponseBody
    public String getFoosBySimplePathWithPathVariable(
            @PathVariable("key") String key) {
            JSONObject jsonObj = new JSONObject(this.userJson1);
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

}