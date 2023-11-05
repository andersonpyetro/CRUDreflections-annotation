package br.com.pyetro.register.domain.dao;

import br.com.pyetro.reflections.SingletonMap;
import br.com.pyetro.register.domain.Client;
import br.com.pyetro.register.domain.dao.generics.GenericDAO;

import java.util.Map;
import java.util.HashMap;

public class ClientMapDAO extends GenericDAO<Client> implements IClienteDAO {
    public ClientMapDAO(){
        super();
        Map<Long, Client> innerMap = (Map<Long, Client>) SingletonMap.getInstance().getMap().get(getTypeClass());
        if(innerMap == null){
            innerMap = new HashMap<>();
            SingletonMap.getInstance().getMap().put(getTypeClass(), innerMap);
        }

    }

    @Override
    public Class<Client> getTypeClass() {
        return Client.class;
    }

    @Override
    public void updateData(Client client, Client entityRegistered) {
        entityRegistered.setName(client.getName());
        entityRegistered.setCel(client.getCel());
        entityRegistered.setAddress(client.getAddress());
        entityRegistered.setCity(client.getCity());
        entityRegistered.setCpf(client.getCpf());
        entityRegistered.setState(client.getState());
        entityRegistered.setNum(client.getNum());
    }
}
