package configcl.Commons;

import configcl.util.JsonMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

public class LatestConfig {
    private String json;

    public LatestConfig(String conf){
        this.json = conf;
    }

    public String getLatestConfig(){
        return this.json;
    }

    public Map<String, Object> getLatestConfigHashMap(){
        return JsonMapper.convertStrToHashMap(this.json);
    }
}