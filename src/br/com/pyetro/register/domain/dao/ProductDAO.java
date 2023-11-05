package br.com.pyetro.register.domain.dao;

import br.com.pyetro.reflections.SingletonMap;
import br.com.pyetro.register.domain.Product;
import br.com.pyetro.register.domain.dao.generics.GenericDAO;

import java.util.HashMap;
import java.util.Map;

public class ProductDAO extends GenericDAO<Product> implements IProductDAO {

    public ProductDAO(){
        super();
        Map<Long,Product> innerMap = (Map<Long, Product>) SingletonMap.getInstance().getMap().get(getTypeClass());
        if(innerMap == null) {
            innerMap = new HashMap<>();
            SingletonMap.getInstance().getMap().put(getTypeClass(), innerMap);
        }
    }
    @Override
    public Class<Product> getTypeClass() {
        return Product.class;
    }

    @Override
    public void updateData(Product entity, Product entityRegistered) {
        entityRegistered.setName(entity.getName());
        entityRegistered.setCode(entity.getCode());

    }
}
