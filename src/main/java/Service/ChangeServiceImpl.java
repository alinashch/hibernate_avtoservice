package Service;

import DAO.*;
import Entities.EntitiesInterface;

import java.util.List;
import java.util.Map;

public class ChangeServiceImpl implements Service {
    private static DAO changeDAO=new ChangeDAO();

    @Override
    public List<EntitiesInterface> selectAll() {
        ChangeDAO changeDAO1=new ChangeDAO();
        changeDAO= changeDAO1;
        return changeDAO.selectAll();
    }

    @Override
    public void delete(int id) {
        ChangeDAO changeDAO1=new ChangeDAO();
        changeDAO= changeDAO1;
        changeDAO.delete(id);
    }

    @Override
    public void update(EntitiesInterface entity, Map value) {
        ChangeDAO changeDAO1=new ChangeDAO();
        changeDAO= changeDAO1;
        changeDAO.update(entity, value);
    }

    @Override
    public void add(EntitiesInterface entitiesInterface) {
        ChangeDAO changeDAO1=new ChangeDAO();
        changeDAO= changeDAO1;
        changeDAO.add(entitiesInterface);
    }

    @Override
    public EntitiesInterface selectOne(int id) {
        ChangeDAO changeDAO1=new ChangeDAO();
        changeDAO= changeDAO1;
        return changeDAO.selectOne(id);
    }
}
