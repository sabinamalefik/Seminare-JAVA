package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ObjectInspector {

    public static void inspect(Object obj) {
        Class<?> clazz = obj.getClass();

        System.out.println("Inspecting object of class: " + clazz.getName());

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            try {
                field.setAccessible(true);

                System.out.println(
                        Modifier.toString(field.getModifiers()) + " " +
                                field.getType().getSimpleName() + " " +
                                field.getName() + " = " +
                                field.get(obj)
                );

            } catch (IllegalAccessException e) {
                System.out.println("Cannot access field: " + field.getName());
            }
        }
    }
}