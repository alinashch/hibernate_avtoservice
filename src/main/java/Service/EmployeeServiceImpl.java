package Service;

import DAO.*;
import Entities.EntitiesInterface;

import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements Service{
    private DAO employeeDAO= new EmployeeDAO();
    @Override
    public List<EntitiesInterface> selectAll() {
        return employeeDAO.selectAll();
    }

    @Override
    public void delete(int id) {
        employeeDAO.delete(id);
    }

    @Override
    public void update(EntitiesInterface entity, Map value) {
        employeeDAO.update(entity, value);
    }

    @Override
    public void add(EntitiesInterface entitiesInterface) {
        employeeDAO.add(entitiesInterface);
    }

    @Override
    public EntitiesInterface selectOne(int id) {
        return employeeDAO.selectOne(id);
    }
}
