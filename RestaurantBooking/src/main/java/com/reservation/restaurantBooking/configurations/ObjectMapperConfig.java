package com.reservation.restaurantBooking.configurations;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

/**
 * {@link ObjectMapper} configuration and post-configuration for use across the application context.
 * <p>
 * <p>
 * Цей клас в програмі містить конфігурацію та після-конфігурацію для об'єкта ObjectMapper,
 * який використовується в усьому контексті додатка.
 * Об'єкт ObjectMapper використовується для конвертації JSON-об'єктів в Java-об'єкти та навпаки.
 * <p>
 * Ця конфігурація додає функціонал ObjectMapper, який відповідає за строгу десеріалізацію,
 * тобто якщо в запитах передаються невідомі властивості JSON, то вони будуть оброблені як помилка і викликатимуть
 * виняток JsonMappingException. Це забезпечує більшу безпеку і стабільність програми.
 */
@Configuration
public class ObjectMapperConfig {

    /**
     * Enables strict deserialization so that unknown properties passed
     * as part of HTTP request bodies will cause the API to throw JsonMappingException.
     *
     * @param objectMapper already configured, spring-provided, ObjectMapper instance
     * @return same object mapper with {@link DeserializationFeature#FAIL_ON_UNKNOWN_PROPERTIES} enabled
     */
    @Autowired
    public ObjectMapper objectMapper(ObjectMapper objectMapper) {
        return objectMapper.enable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

}
