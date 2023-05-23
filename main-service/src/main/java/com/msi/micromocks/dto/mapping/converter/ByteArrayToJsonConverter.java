package com.msi.micromocks.dto.mapping.converter;

import org.dozer.CustomConverter;
import org.dozer.MappingException;

public class ByteArrayToJsonConverter implements CustomConverter {

    @Override
    public Object convert(Object destination, Object source, Class<?> destinationClass, Class<?> sourceClass) {
    	System.out.println("CONVERT!!!!");
        if (source == null) {
            return null;
        }

        if (source instanceof byte[]) {
            try {
                return new String((byte[]) source, "UTF-8"); // Convert byte[] to JSON string
            } catch (Exception e) {
                throw new MappingException("Error converting byte[] to JSON string", e);
            }
        }

        throw new MappingException("Converter ByteArrayToJsonConverter used incorrectly. Arguments passed were: " +
                destination + " and " + source);
    }


}
