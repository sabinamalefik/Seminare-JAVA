package org.example;

import java.lang.reflect.Field;

public class JsonSerializer {

    public static String toJson(Object obj) {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        StringBuilder json = new StringBuilder();
        json.append("{");

        for (int i = 0; i < fields.length; i++) {
            try {
                Field field = fields[i];
                field.setAccessible(true);

                json.append("\"").append(field.getName()).append("\":");

                Object value = field.get(obj);

                if (value instanceof String) {
                    json.append("\"").append(value).append("\"");
                } else {
                    json.append(value);
                }

                if (i < fields.length - 1) {
                    json.append(",");
                }

            } catch (IllegalAccessException e) {
                System.out.println("Cannot serialize field.");
            }
        }

        json.append("}");

        return json.toString();
    }
}