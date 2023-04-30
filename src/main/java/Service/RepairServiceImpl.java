package Service;

import DAO.*;
import DAO.RepairDAO;
import Entities.EntitiesInterface;

import java.util.List;
import java.util.Map;

public class RepairServiceImpl implements Service{
    private DAO repairDAO=new RepairDAO();
    @Override
    public List<EntitiesInterface> selectAll() {
        return repairDAO.selectAll();
    }

    @Override
    public void delete(int id) {
        repairDAO.delete(id);
    }

    @Override
    public void update(EntitiesInterface entity, Map value) {
        repairDAO.update(entity, value);
    }

    @Override
    public void add(EntitiesInterface entitiesInterface) {
        repairDAO.add(entitiesInterface);
    }

    @Override
    public EntitiesInterface selectOne(int id) {
        return repairDAO.selectOne(id);
    }
}
