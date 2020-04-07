package com.gmail.ptimofejev;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    @Target(value= ElementType.METHOD)
    @Retention(value= RetentionPolicy.RUNTIME)
    public @interface DataDelivery {
        int first();
        int second();
    }

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
       Class<?> cls1 = Test.class;
        Method[] methods = cls1.getMethods();
        for (Method mthd : methods) {
            if (mthd.isAnnotationPresent(DataDelivery.class)){
                DataDelivery dd = mthd.getAnnotation(DataDelivery.class);
                int result = (Integer) mthd.invoke(null, dd.first(), dd.second());
                System.out.println("Result: " + result);
            }
        }
    }
}
