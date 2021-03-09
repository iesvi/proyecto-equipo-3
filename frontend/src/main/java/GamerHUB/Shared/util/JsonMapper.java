package GamerHUB.Shared.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.Serializable;

public class JsonMapper {
    public static String fromJavaToJson(Serializable object)
            throws JsonGenerationException, JsonMappingException, IOException {
        ObjectMapper jsonMapper = new ObjectMapper();

        return jsonMapper.writeValueAsString(object);
    }


    public static Object fromJsonToJava(String json, Class type) throws JsonParseException,
            JsonMappingException, IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        return jsonMapper.readValue(json, type);
    }
}
