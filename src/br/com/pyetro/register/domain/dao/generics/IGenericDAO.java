package br.com.pyetro.register.domain.dao.generics;

import br.com.pyetro.exception.TypeKeyNotFoundException;
import br.com.pyetro.register.domain.Persistent;

import java.util.Collection;

public interface IGenericDAO <T extends Persistent> {

    public Boolean register(T entity) throws TypeKeyNotFoundException;
    public void remove(Long valor);
    public void update(T entity) throws TypeKeyNotFoundException;
    public T search(Long valor);
    public Collection<T> searchAll();
}
