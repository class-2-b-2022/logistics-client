package Utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ParserObj {

    public <T> T parseData(Object data, Class<T> obj) {
        ObjectMapper mapper = new ObjectMapper();
        T convertedData = null;
        try {
            byte[] dataToparse = mapper.writeValueAsBytes(data);
            convertedData = (T) mapper.readValue(dataToparse, obj);
            System.out.println(convertedData);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return convertedData;
    }
}
