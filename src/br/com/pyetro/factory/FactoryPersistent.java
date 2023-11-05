package br.com.pyetro.factory;


import br.com.pyetro.exception.InvalidDataException;
import br.com.pyetro.register.domain.Persistent;

public interface FactoryPersistent {
    Persistent createObject(String data[]) throws InvalidDataException;
}
