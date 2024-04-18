package com.nabi.Nabi.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Informacion {

    private String descripcion;
    private String modoUso;


    // Método para convertir a JSON (puede usar cualquier librería como Jackson)
    public String toJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Método para construir desde JSON (puede usar cualquier librería como Jackson)
    public static Informacion fromJson(String json) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(json, Informacion.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
   

}
