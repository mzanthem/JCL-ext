/*
 * ReflectUtils.java Created On 2018年11月23日
 * Copyright(c) 2018 Mazan Inc.
 * ALL Rights Reserved.
 */
package io.github.mzanthem.util;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.base.Optional;

/**
 * ReflectUtils
 * 反射工具类
 * 
 * @time: 下午6:49:14
 * @author mazan
 * 
 * @see https://github.com/neoremind/dynamic-proxy 
 */
public class ReflectionUtils {
	
	private static Logger logger = LoggerFactory.getLogger(ReflectionUtils.class);
	
	private ReflectionUtils() {
	}
	
	/**
	 * 获得field
	 * @param target
	 * @param fieldName
	 * @return
	 */
	public static Object getValue(Object target, String fieldName) {
		Field f;
		try {
			f = target.getClass().getDeclaredField(fieldName);
			f.setAccessible(true);
			return f.get(target);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Object getValue(Class clz, String fieldName) {
		Field f;
		try {
			f = clz.getDeclaredField(fieldName);
			f.setAccessible(true);
			return f.get(null);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void setValue(Object target, String fieldName, Object value) {
		Field f;
		try {
			f = target.getClass().getDeclaredField(fieldName);
			f.setAccessible(true);
			f.set(target, value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * 强行设置Field可访问
	 *
	 * @param field 属性
	 */
	private static void makeAccessible(final Field field) {
		if (!Modifier.isPublic(field.getModifiers())
				|| !Modifier.isPublic(field.getDeclaringClass().getModifiers())) {
			field.setAccessible(true);
		}
	}

    /**
     * 判断是否有超类
     *
     * @param clazz 目标类
     *
     * @return 如果有返回<code>true</code>，否则返回<code>false</code>
     */
    public static boolean hasSuperClass(Class<?> clazz) {
        return (clazz != null) && !clazz.equals(Object.class);
    }
    
    /**
     * 获得Class中的方法
     * @param clazz  
     * @param methodName
     * @param parameterTypes
     * @return
     */
    public static Method getMethod(Class<?> clazz, String methodName, Class<?>... parameterTypes) {
        if (clazz == null || StringUtils.isBlank(methodName)) {
            return null;
        }

        for (Class<?> itr = clazz; hasSuperClass(itr); ) {
            Method[] methods = itr.getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().equals(methodName) && Arrays.equals(method.getParameterTypes(), parameterTypes)) {
                    return method;
                }
            }
            itr = itr.getSuperclass();
        }

        return null;

    }
    /**
     * 获得实例中的方法
     * @param object
     * @param methodName
     * @param parameterTypes
     * @return
     */
    public static Method getMethod(Object object, String methodName, Class<?>... parameterTypes) {
        if (object == null || StringUtils.isBlank(methodName)) {
            return null;
        }

        for (Class<?> itr = object.getClass(); hasSuperClass(itr); ) {
            Method[] methods = itr.getDeclaredMethods();
            for (Method method : methods) {
                if (method.getName().equals(methodName) && Arrays.equals(method.getParameterTypes(), parameterTypes)) {
                    return method;
                }
            }
            itr = itr.getSuperclass();
        }
        return null;
    }
    
    /**
     * 实例化
     * @param <T>
     * @param clazz
     * @return
     */
    @SuppressWarnings("unchecked")
	public static <T> T newInstance(final Class<T> clazz) {
        Constructor<?>[] constructors = getAllConstructorsOfClass(clazz, true);
        // impossible ?
        if (ArrayUtils.isEmpty(constructors)) {
            return null;
        }

        Optional<? extends Constructor<?>> optionalConstructor = getDefaultConstructor(constructors);
        // isPresent():如果Optional包含的T实例不为null，则返回true；若T实例为null，返回false
        if (!optionalConstructor.isPresent()) {
            throw new RuntimeException("No default non parameter constructor found for class " + clazz.getName());
        }

        try {
            T instance = (T) optionalConstructor.get().newInstance();
            return instance;
        } catch (Exception e) {
//            e.printStackTrace();
            return null;
        }

    }
    /**
     * 获得Class中所有的构造方法
     * @param clazz
     * @param accessible
     * @return
     */
    public static Constructor<?>[] getAllConstructorsOfClass(final Class<?> clazz, boolean accessible) {
        if (clazz == null) {
            return null;
        }

        Constructor<?>[] constructors = clazz.getDeclaredConstructors();
        if (ArrayUtils.isNotEmpty(constructors)) {
            AccessibleObject.setAccessible(constructors, accessible);
        }
        return constructors;
    }
    
    /**
     * 获得Optional
     * @param constructors
     * @return
     */
    private static Optional<? extends Constructor<?>> getDefaultConstructor(Constructor<?>[] constructors) {
        if (ArrayUtils.isEmpty(constructors)) {
            return Optional.absent(); // 获得一个Optional对象，其内部包含了空值
        }

        for (Constructor<?> constructor : constructors) {
            if (ArrayUtils.isEmpty(constructor.getParameterTypes())) {
                return Optional.of(constructor); // 获得一个Optional对象，其内部包含了一个非null的T数据类型实例，若T=null，则立刻报错
            }
        }
        return Optional.absent();
    }
}
