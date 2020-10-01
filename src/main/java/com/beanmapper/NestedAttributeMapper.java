package com.beanmapper;

import com.beanmapper.annotation.ColumnMapping;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

public class NestedAttributeMapper {
    /**
     * Copies Nested attributes of a source bean to destination bean. Refer to Readme for Usage instruction.
     * @param dest
     * @param source
     * @return
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public static Object mapNestedElement(Object dest, Object source) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Field[] fields = source.getClass().getDeclaredFields();

        for (Field field : fields) {
            Class<?> type = field.getType();
            if (field.isAnnotationPresent(ColumnMapping.class)) {
                String destAttr = field.getAnnotation(ColumnMapping.class).value();
                field.setAccessible(true);
                PropertyUtils.setNestedProperty(dest, destAttr, field.get(source));
            } else {
                if (isUserDefinedType(type)) {
                    field.setAccessible(true);
                    return mapNestedElement(dest, field.get(source));
                }
            }

        }
        return dest;
    }

    /**
     * Similar {@link com.beanmapper.NestedAttributeMapper#mapNestedElement(Object, Object)}to Useful in case when you don't have control over source POJO , it takes a map of source to dest attribute mapping and sets the property.
     *
     * @param dest
     * @param source
     * @param fieldMap
     * @return
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public static Object mapNestedElementFromMap(Object dest, Object source, Map<String, String> fieldMap) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Field[] fields = source.getClass().getDeclaredFields();

        for (Field field : fields) {
            Class<?> type = field.getType();
            if (fieldMap.containsKey(field.getName())) {
                String destAttr = fieldMap.get(field.getName());
                PropertyUtils.setNestedProperty(dest, destAttr, field.get(source));
            } else {
                if (isUserDefinedType(type)) {
                    return mapNestedElementFromMap(dest, field.get(source), fieldMap);
                }
            }
        }
        return dest;
    }

    /**
     * Check whether a class is user defined or not, Currently Any type excluding primitive,Enum and all Wrapper inside [[java.lang]] is considered as user defined class.
     *
     * @param clazz
     * @return true if class type is primitive or ENUM or belongs to java.lang package.
     */
    public static boolean isUserDefinedType(Class<?> clazz) {
        if (clazz.isPrimitive() || clazz.isEnum() || clazz.getName().startsWith("java.lang")) {
            return false;
        }
        return true;
    }
}
