package Service;

import DAO.*;
import DAO.RequestDAO;
import Entities.EntitiesInterface;

import java.util.List;
import java.util.Map;

public class RequestServiceImpl implements Service{
    private DAO requestDAO=new RequestDAO();
    @Override
    public List<EntitiesInterface> selectAll() {
        return requestDAO.selectAll();
    }

    @Override
    public void delete(int id) {
        requestDAO.delete(id);
    }

    @Override
    public void update(EntitiesInterface entity, Map value) {
        requestDAO.update(entity, value);
    }

    @Override
    public void add(EntitiesInterface entitiesInterface) {
        requestDAO.add(entitiesInterface);
    }

    @Override
    public EntitiesInterface selectOne(int id) {
        return requestDAO.selectOne(id);
    }
}
