package br.com.pyetro;

import br.com.pyetro.Product;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AppReflection {
    public static void main(String[] args){
        Class clazz = Product.class;

        System.out.println(clazz);

        Product prod = new Product();
        Class clazz1 = prod.getClass();
        System.out.println(clazz1);

        try {
            Constructor cons = clazz.getConstructor();
            Product prod1 = (Product) cons.newInstance();
            System.out.println(cons);
            System.out.println(prod1);

            Field[] fields = prod1.getClass().getDeclaredFields();
            for (Field field : fields){
                Class<?> type = field.getType();
                String name = field.getName();
                System.out.println(type);
                System.out.println(name);
            }

            Method[] methods =  prod1.getClass().getDeclaredMethods();
            for(Method method : methods){
                Class<?> type = method.getReturnType();
                String name = method.getName();
                System.out.println(type);
                System.out.println(name);

                System.out.println("Executing method");
                if (method.getName().startsWith("get")){
                    System.out.println(method.invoke(prod1));
                } else {
                    for(Class classesTypes : method.getParameterTypes()){
                        if (classesTypes.equals(String.class)) {
                            System.out.println(method.invoke(prod1,"Anderson"));
                        } else if (classesTypes.equals(Long.class)){
                            System.out.println(method.invoke(prod1,1l));
                        } else {
                            System.out.println(method.invoke(prod1,2d));
                        }
                    }
                }


            }

        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
