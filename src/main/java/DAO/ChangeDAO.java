package DAO;

import BDAction.Connect.CreateConnectionToBD;
import Entities.Change;
import Entities.EntitiesInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ChangeDAO implements DAO{
    @Override
    public List<EntitiesInterface> selectAll() {
        String sql="select * from change";
        List<EntitiesInterface> arrayList=new ArrayList<>();
        try {
            CreateConnectionToBD createConnectionToBD=new CreateConnectionToBD();
            Statement statement = createConnectionToBD.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
               Change  change=new Change(resultSet.getInt(1), resultSet.getDate(2),resultSet.getString(3), resultSet.getInt(4));
                arrayList.add(change);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    @Override
    public void delete(int id) {
        String sql="delete from change where id_change= "+ id;
        try {
            CreateConnectionToBD createConnectionToBD=new CreateConnectionToBD();

            Connection connection = createConnectionToBD.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(EntitiesInterface entity , Map value) {
        String name = null;
        Object q = null;
        if(value.get("date_production")!=null){
            q=value.get("date_production");
            name="date_production";
        } else if( value.get("name_detail")!=null){
            q=value.get("name_detail");
            name="name_detail";
        }else if( value.get("number_detail")!=null){
            q=value.get("number_detail");
            name="number_detail";
        }
        String sql="update change set " + name+ "='"+ q+ "' where id_change=" +entity.getId() ;
        System.out.println(sql);
        try {
            CreateConnectionToBD createConnectionToBD=new CreateConnectionToBD();

            Connection connection = createConnectionToBD.createConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void add(EntitiesInterface entitiesInterface) {
        String sql="insert into change(date_production, name_detail, number_detail) values(?, ?, ?)";
        try {
            CreateConnectionToBD createConnectionToBD=new CreateConnectionToBD();

            Connection connection = createConnectionToBD.createConnection();
            PreparedStatement preparedStatement=connection.prepareStatement(sql);

            preparedStatement.setDate(1, (Date) entitiesInterface.getAllParam().get(0));
            preparedStatement.setString(2, (String) entitiesInterface.getAllParam().get(1));
            preparedStatement.setInt(3, (Integer) entitiesInterface.getAllParam().get(2));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public EntitiesInterface selectOne(int id) {
        String sql="select * from change where id_change="+id;
        Change change = null;

        try {
            CreateConnectionToBD createConnectionToBD=new CreateConnectionToBD();
            Statement statement = createConnectionToBD.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);
            while (resultSet.next()){
                  change=new Change(resultSet.getInt(1), resultSet.getDate(2),resultSet.getString(3), resultSet.getInt(4));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return change;
    }
}
