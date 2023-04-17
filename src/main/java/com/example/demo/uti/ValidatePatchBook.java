package com.example.demo.uti;

import com.example.demo.entity.Book;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.*;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class ValidatePatchBook {

    private static ObjectMapper objectMapper = null;

    @Autowired
    ObjectMapper commonObjectMapper;

    @PostConstruct
    @SuppressWarnings("squid:S2696")
    public void initObjectMapper(){
        objectMapper = commonObjectMapper;
    }

    public static <T> T deserializeFromJson(String jsonStr, Class<T> clazz) throws IOException {
        try {
            return objectMapper.readValue(jsonStr, clazz);
        } catch (JsonMappingException me) {
            throw me;
        } catch (JsonParseException pe) {
            throw pe;
        } catch (IOException e) {
            throw e;
        }
    }

    public void validate(String input) throws Exception {
        try {
            Book inputEntity =deserializeFromJson(input, Book.class);
            checkIdForPatch(inputEntity);
        }catch (IOException e){
            throw e;
        }
    }

    public void checkIdForPatch(Object o) throws Exception {

        Class objectClass = o.getClass();
        List<Field> patchFields = getAllFields(objectClass).stream()
                .filter(f -> f.getName().equals("id"))
                .collect(Collectors.toList());

        for (Field field : patchFields) {
            field.setAccessible(true);

            Object value = field.get(o);
            if (value != null) {
                throw new Exception("You can not update this field " + field.getName() + ": => " + value);
            }
        }
    }

    public static List<Field> getAllFields(Class<?> type) {
        List<Field> fields = new ArrayList<>();
        for (Class<?> c = type; c != null; c = c.getSuperclass()) {
            fields.addAll(Arrays.asList(c.getDeclaredFields()));
        }
        return fields;
    }
}
