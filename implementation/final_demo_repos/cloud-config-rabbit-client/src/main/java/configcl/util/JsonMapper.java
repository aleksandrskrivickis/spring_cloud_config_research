package configcl.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class JsonMapper {
    public static Map<String, Object> convertStrToHashMap(String content) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> jsonMap = null;
        try {
            jsonMap = mapper.readValue(content, new TypeReference<Map<String, Object>>() {
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonMap;
    }
}
