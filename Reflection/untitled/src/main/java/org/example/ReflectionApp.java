package org.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionApp {

    public static void main(String[] args) {

        try {
            Class<?> clazz = Student.class;

            System.out.println("=== 1. Print class information ===");
            System.out.println("Class name: " + clazz.getName());
            System.out.println("Simple name: " + clazz.getSimpleName());
            System.out.println("Package name: " + clazz.getPackageName());
            System.out.println("Superclass: " + clazz.getSuperclass().getName());

            Class<?>[] interfaces = clazz.getInterfaces();

            System.out.println("Interfaces:");
            for (Class<?> interf : interfaces) {
                System.out.println(interf.getName());
            }

            System.out.println("\n=== 2. List all fields ===");
            Field[] fields = clazz.getDeclaredFields();

            for (Field field : fields) {
                System.out.println(
                        Modifier.toString(field.getModifiers()) + " " +
                                field.getType().getSimpleName() + " " +
                                field.getName()
                );
            }

            System.out.println("\n=== 3. List all methods ===");
            Method[] methods = clazz.getDeclaredMethods();

            for (Method method : methods) {
                System.out.print(
                        Modifier.toString(method.getModifiers()) + " " +
                                method.getReturnType().getSimpleName() + " " +
                                method.getName() + "("
                );

                Class<?>[] parameters = method.getParameterTypes();

                for (int i = 0; i < parameters.length; i++) {
                    System.out.print(parameters[i].getSimpleName());

                    if (i < parameters.length - 1) {
                        System.out.print(", ");
                    }
                }

                System.out.println(")");
            }

            System.out.println("\n=== 4. Create object dynamically ===");
            Object studentObject = clazz.getDeclaredConstructor().newInstance();
            System.out.println(studentObject);

            System.out.println("\n=== 5. Call public method ===");
            Method sayHelloMethod = clazz.getDeclaredMethod("sayHello");
            sayHelloMethod.invoke(studentObject);

            System.out.println("\n=== 6. Access private field ===");
            Field nameField = clazz.getDeclaredField("name");
            nameField.setAccessible(true);

            System.out.println("Old name: " + nameField.get(studentObject));

            nameField.set(studentObject, "Ana");

            System.out.println("New name: " + nameField.get(studentObject));

            System.out.println("\n=== 7. Invoke private method ===");
            Method secretMethod = clazz.getDeclaredMethod("secretMethod");
            secretMethod.setAccessible(true);
            secretMethod.invoke(studentObject);

            System.out.println("\n=== 8. Constructor selection ===");

            Constructor<?> constructor1 = clazz.getConstructor();
            Object s1 = constructor1.newInstance();
            System.out.println(s1);

            Constructor<?> constructor2 = clazz.getConstructor(String.class);
            Object s2 = constructor2.newInstance("Maria");
            System.out.println(s2);

            Constructor<?> constructor3 = clazz.getConstructor(String.class, int.class);
            Object s3 = constructor3.newInstance("Andrei", 21);
            System.out.println(s3);

            System.out.println("\n=== 9. Object inspector ===");
            ObjectInspector.inspect(s3);

            System.out.println("\n=== 10. JSON serializer ===");
            String json = JsonSerializer.toJson(s3);
            System.out.println(json);

            System.out.println("\n=== 11. CSV mapper ===");
            Student csvStudent = CsvMapper.fromCsv(
                    "name,age,grade",
                    "Ioana,20,9.5",
                    Student.class
            );

            System.out.println(csvStudent);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}