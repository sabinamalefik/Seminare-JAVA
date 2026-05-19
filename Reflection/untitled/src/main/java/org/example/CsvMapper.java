package org.example;

import java.lang.reflect.Field;

public class CsvMapper {

    public static <T> T fromCsv(String headerLine, String valueLine, Class<T> clazz) {
        try {
            T obj = clazz.getDeclaredConstructor().newInstance();

            String[] headers = headerLine.split(",");
            String[] values = valueLine.split(",");

            for (int i = 0; i < headers.length; i++) {
                String fieldName = headers[i].trim();
                String value = values[i].trim();

                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true);

                if (field.getType() == String.class) {
                    field.set(obj, value);
                } else if (field.getType() == int.class) {
                    field.set(obj, Integer.parseInt(value));
                } else if (field.getType() == double.class) {
                    field.set(obj, Double.parseDouble(value));
                }
            }

            return obj;

        } catch (Exception e) {
            System.out.println("CSV mapping error: " + e.getMessage());
            return null;
        }
    }
}