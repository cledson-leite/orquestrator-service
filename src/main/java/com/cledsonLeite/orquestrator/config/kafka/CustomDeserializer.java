package com.cledsonLeite.orquestrator.config.kafka;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import com.cledsonLeite.orquestrator.adapter.out.message.SaleMessage;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomDeserializer implements Deserializer<SaleMessage> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public SaleMessage deserialize(String topic, byte[] data) {
        try {
            if (data == null){
                return null;
            }
            return objectMapper.readValue(new String(data, "UTF-8"), SaleMessage.class);
        } catch (Exception e) {
            throw new SerializationException("Erro ao deserializar byte[] para SaleMessage");
        }
    }

}
