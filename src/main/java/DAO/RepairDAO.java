package DAO;

import BDAction.Connect.CreateConnectionToBD;
import Entities.EntitiesInterface;
import Entities.Repair;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RepairDAO implements DAO {
    @Override
    public List<EntitiesInterface> selectAll() {
        String sql="select * from change";
        List<EntitiesInterface> arrayList=new ArrayList<>();
        try {
            CreateConnectionToBD createConnectionToBD=new CreateConnectionToBD();

            Connection connection = createConnectionToBD.createConnection();
            Statement statement = createConnectionToBD.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next()){
                Repair repair=new Repair(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3), resultSet.getDate(4));
                arrayList.add(repair);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    @Override
    public void delete(int id) {
        String sql="delete from repair where id_repair= "+ id;
        try {
            CreateConnectionToBD createConnectionToBD=new CreateConnectionToBD();

            Connection connection = createConnectionToBD.createConnection();
            Statement statement = createConnectionToBD.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(EntitiesInterface entity, Map value) {
        String name = null;
        Object q = null;
        if(value.get("id_change")!=null){
            q=value.get("id_change");
            name="id_change";
        } else if( value.get("id_request")!=null){
            q=value.get("id_request");
            name="id_request";
        }else if( value.get("repair_date")!=null){
            q=value.get("repair_date");
            name="repair_date";
        }
        String sql="update repair set " + name+ "='"+ q+ "' where id_repair=" +entity.getId() ;
        try {
            CreateConnectionToBD createConnectionToBD=new CreateConnectionToBD();

            Connection connection = createConnectionToBD.createConnection();
            Statement statement = createConnectionToBD.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(EntitiesInterface entitiesInterface) {
        String sql="insert into repair( id_change, id_request, repair_date) values( ?, ?, ?)";
        try {
            CreateConnectionToBD createConnectionToBD=new CreateConnectionToBD();

            Connection connection = createConnectionToBD.createConnection();
            Statement statement = createConnectionToBD.createStatement();
            PreparedStatement preparedStatement=connection.prepareStatement(sql);

            preparedStatement.setInt(1, (Integer) entitiesInterface.getAllParam().get(0));
            preparedStatement.setInt(2, (Integer) entitiesInterface.getAllParam().get(1));
            preparedStatement.setDate(3, (Date) entitiesInterface.getAllParam().get(2));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public EntitiesInterface selectOne(int id) {
        String sql="select * from repair where id_repaire="+id;
        Repair repair = null;
        try {
            CreateConnectionToBD createConnectionToBD=new CreateConnectionToBD();

            Connection connection = createConnectionToBD.createConnection();
            Statement statement = createConnectionToBD.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next()){
                 repair=new Repair(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3), resultSet.getDate(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return repair;
    }
}
