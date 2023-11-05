package br.com.pyetro.factory;

public class Factory implements IFactory{
    @Override
    public FactoryPersistent createFactory(String optionGeneralMenu) {
        if("1".equals(optionGeneralMenu)){
            return new FactoryClient();
        } else{
            return new FactoryProduct();
        }
    }
}
