package hk.com.prudential.assignment.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @author zhnlk
 * @date 2020/4/11
 * @mail tomleader0828@gmail.com
 */
@Slf4j
public class JacksonUtil {

    private static ObjectMapper OBJECT_MAPPER;

    static {
        if (OBJECT_MAPPER == null) {
            OBJECT_MAPPER = new ObjectMapper();
            OBJECT_MAPPER.enable(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY);
            OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
        }
    }

    @SneakyThrows({IllegalArgumentException.class, IOException.class})
    public static <T> T fromString(String string, Class<T> clazz) {
        return OBJECT_MAPPER.readValue(string, clazz);
    }

    @SneakyThrows({IllegalArgumentException.class, IOException.class})
    public static <T> T fromString(String string, TypeReference<T> tr) {
        return OBJECT_MAPPER.readValue(string, tr);
    }

    @SneakyThrows(JsonProcessingException.class)
    public static String toString(Object value) {
        return OBJECT_MAPPER.writeValueAsString(value);
    }

    @SneakyThrows(IOException.class)
    public static JsonNode toJsonNode(String value) {
        return OBJECT_MAPPER.readTree(value);
    }

    public static <T> T clone(T value) {
        return fromString(toString(value), (Class<T>) value.getClass());
    }

}
