package br.com.pyetro.factory;

import br.com.pyetro.Product;
import br.com.pyetro.exception.InvalidDataException;
import br.com.pyetro.register.domain.Persistent;

public class FactoryProduct implements FactoryPersistent {
    @Override
    public Persistent createObject(String[] data) throws InvalidDataException {
        try{
            Product product = new Product();
            product.setCode(Long.parseLong(data[0].trim()));
            product.setName(data[1]);
            return product;
        } catch(IndexOutOfBoundsException e){
            throw new InvalidDataException("Invalid product data.");
        }
    }
}
