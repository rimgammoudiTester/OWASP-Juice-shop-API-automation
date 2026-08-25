package owaspJuiceShop.configUtility.jsonReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tools.jackson.core.JacksonException;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class JsonReader {
    private static final Logger log = LoggerFactory.getLogger(JsonReader.class);



    /**
     * @Author Rim Gammoudi
     ***/


    //Method useful to readJson file
    public static HashMap<String, Object> readJson(String jsonFileName) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(new File(jsonFileName), new TypeReference<>() {
            });
        } catch (JacksonException e) {
            log.error("Failed to load json File {} ", jsonFileName, e);
            throw new RuntimeException("failure of loading json file :" + jsonFileName, e);
        }
    }
}

