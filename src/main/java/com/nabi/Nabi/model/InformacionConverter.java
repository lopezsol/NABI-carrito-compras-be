
package com.nabi.Nabi.model;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Converter
public class InformacionConverter implements AttributeConverter<Informacion, String> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public String convertToDatabaseColumn(Informacion informacion) {
        try {
            return objectMapper.writeValueAsString(informacion);
        } catch (JsonProcessingException e) {
            // Manejar la excepción según sea necesario
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Informacion convertToEntityAttribute(String json) {
        try {
            return objectMapper.readValue(json, Informacion.class);
        } catch (JsonProcessingException e) {
            // Manejar la excepción según sea necesario
            e.printStackTrace();
            return null;
        }
    }
}
