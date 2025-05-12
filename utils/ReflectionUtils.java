package com.hitchainapi.utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionUtils {

    /**
     * Get the value of a private field from an object using reflection.
     * @param obj The object from which the field value will be fetched.
     * @param fieldName The name of the field.
     * @return The value of the field.
     * @throws NoSuchFieldException if the field is not found.
     * @throws IllegalAccessException if the field cannot be accessed.
     */
    public static Object getPrivateField(Object obj, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        return field.get(obj);
    }

    /**
     * Set the value of a private field in an object using reflection.
     * @param obj The object in which the field value will be set.
     * @param fieldName The name of the field.
     * @param value The value to set to the field.
     * @throws NoSuchFieldException if the field is not found.
     * @throws IllegalAccessException if the field cannot be accessed.
     */
    public static void setPrivateField(Object obj, String fieldName, Object value) throws NoSuchFieldException, IllegalAccessException {
        Field field = obj.getClass().getDeclaredField(fieldName);
        field.setAccessible(true);
        field.set(obj, value);
    }

    /**
     * Invoke a private method on an object using reflection.
     * @param obj The object on which the method will be invoked.
     * @param methodName The name of the method.
     * @param parameters The parameters to pass to the method.
     * @return The result of the method invocation.
     * @throws Exception if any reflection-related error occurs.
     */
    public static Object invokePrivateMethod(Object obj, String methodName, Object... parameters) throws Exception {
        Method method = obj.getClass().getDeclaredMethod(methodName, getParameterTypes(parameters));
        method.setAccessible(true);
        return method.invoke(obj, parameters);
    }

    /**
     * Get the types of the parameters for a method.
     * @param parameters The parameters to get the types for.
     * @return The array of parameter types.
     */
    private static Class<?>[] getParameterTypes(Object... parameters) {
        Class<?>[] parameterTypes = new Class<?>[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            parameterTypes[i] = parameters[i].getClass();
        }
        return parameterTypes;
    }
}

