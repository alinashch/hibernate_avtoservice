package Service;

import Entities.EntitiesInterface;

import java.util.List;
import java.util.Map;

public interface Service {
    List<EntitiesInterface> selectAll();
    void delete(int id);
    void update(EntitiesInterface entity , Map value);
    void add(EntitiesInterface entitiesInterface);
    EntitiesInterface selectOne(int id);
}
