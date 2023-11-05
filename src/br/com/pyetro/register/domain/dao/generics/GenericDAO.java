package br.com.pyetro.register.domain.dao.generics;

import br.com.pyetro.exception.TypeKeyNotFoundException;
import br.com.pyetro.reflections.SingletonMap;
import br.com.pyetro.register.domain.Persistent;
import br.com.pyetro.register.domain.annotation.TypeKey;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Map;

public abstract class GenericDAO<T extends Persistent> implements IGenericDAO<T> {

    private SingletonMap singletonMap;

    public abstract Class<T> getTypeClass();

    public abstract void updateData(T entity, T entityRegistered);

    public GenericDAO() {
        this.singletonMap = SingletonMap.getInstance();
    }

    public Long getKey(T entity) throws TypeKeyNotFoundException {
        Field[] fields = entity.getClass().getDeclaredFields();
        Long returnValue = null;
        for (Field field : fields) {
            if (field.isAnnotationPresent(TypeKey.class)) {
                TypeKey typeKey = field.getAnnotation(TypeKey.class);
                String nameMethod = typeKey.value();
                try {
                    Method method = entity.getClass().getMethod(nameMethod);
                    returnValue = (Long) method.invoke(entity);
                    return returnValue;

                } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                    throw new TypeKeyNotFoundException("Main objects key" + entity.getClass() + "not found.", e);
                }
            }
        }
        if (returnValue == null) {
            String msg = "Main objects key" + entity.getClass() + " not found";
            System.out.println("****ERROR*****" + msg);
            throw new TypeKeyNotFoundException(msg);
        }
        return null;
    }

    @Override
    public Boolean register(T entity) throws TypeKeyNotFoundException {
        Map<Long, T> innerMap = (Map<Long, T>) this.singletonMap.getMap().get(getTypeClass());
        Long key = getKey(entity);
        if(innerMap.containsKey(key)){
            return false;
        }
        innerMap.put(key, entity);
        return true;
    }

    @Override
    public void remove(Long valor) {
        Map<Long, T> innernMap = (Map<Long,T>) this.singletonMap.getMap().get(getTypeClass());
        T registeredObject = innernMap.get(valor);
        if(registeredObject != null){
            innernMap.remove(valor, registeredObject);
        }
    }
    @Override
    public void update(T entity) throws TypeKeyNotFoundException {
        Map<Long, T> innerMap = (Map<Long, T>) this.singletonMap.getMap().get(getTypeClass());
        Long key = getKey(entity);
        T registeredObject = innerMap.get(key);
        if(registeredObject != null){
            updateData(entity, registeredObject);
        }

    }

    @Override
    public T search(Long valor) {
        Map<Long, T> innerMap = (Map<Long, T>) this.singletonMap.getMap().get(getTypeClass());
        return innerMap.get(valor);
    }

    @Override
    public Collection<T> searchAll() {
        Map<Long, T> innerMap = (Map<Long, T>) this.singletonMap.getMap().get(getTypeClass());
        return innerMap.values();
    }
}
