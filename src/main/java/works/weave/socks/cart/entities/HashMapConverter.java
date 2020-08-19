package works.weave.socks.cart.entities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.AttributeConverter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HashMapConverter implements AttributeConverter<List<Item>, String> {

    @Override
    public String convertToDatabaseColumn(List<Item> items) {
        String customerInfoJson = null;
        try {
            customerInfoJson = new ObjectMapper().writeValueAsString(items);
        } catch (final JsonProcessingException e) {
            e.printStackTrace();
        }

        return customerInfoJson;
    }

    @Override
    public List<Item> convertToEntityAttribute(String s) {
        try {
            return new ObjectMapper().readValue(s, new TypeReference<List<Item>>() {});
        } catch (final IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }
}