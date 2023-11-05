package br.com.pyetro.factory;

import br.com.pyetro.register.domain.Client;
import br.com.pyetro.register.domain.Persistent;
import br.com.pyetro.exception.InvalidDataException;

public class FactoryClient implements FactoryPersistent {
    @Override
    public Persistent createObject(String splitData[]) throws InvalidDataException {
        try {
            return new Client(splitData[0],splitData[1],splitData[2],splitData[3],splitData[4],splitData[5],splitData[6]);
        } catch (IndexOutOfBoundsException e) {
            throw new InvalidDataException("Invalid client data.");
        }
    }
}
