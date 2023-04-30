package DAO;

import BDAction.Connect.CreateConnectionToBD;
import Entities.EntitiesInterface;
import Entities.Request;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RequestDAO implements DAO{

    @Override
    public List<EntitiesInterface> selectAll() {
        String sql="select * from request";
        List<EntitiesInterface> arrayList=new ArrayList<>();
        try {
            CreateConnectionToBD createConnectionToBD=new CreateConnectionToBD();

            Connection connection = createConnectionToBD.createConnection();
            Statement statement = createConnectionToBD.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next()){
              Request  request=new Request(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getDate(6));

                arrayList.add(request);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    @Override
    public void delete(int id) {
        String sql="delete from request where id_request= "+ id;
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
        if(value.get("first_name")!=null){
            q=value.get("first_name");
            name="first_name";
        } else if( value.get("second_name")!=null){
            q=value.get("second_name");
            name="second_name";
        }else if( value.get("third_name")!=null){
            q=value.get("third_name");
            name="third_name";
        }else if( value.get("telephone")!=null){
            q=value.get("telephone");
            name="telephone";
        }else if( value.get("request_date")!=null){
            q=value.get("request_date");
            name="request_date";
        }
        String sql="update request set " + name+ "='"+ q+ "' where id_request=" +entity.getId() ;
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
        String sql="insert into request( first_name, second_name, third_name, telephone, request_date) values( ?, ?, ?, ?, ?)";
        try {
            CreateConnectionToBD createConnectionToBD=new CreateConnectionToBD();

            Connection connection = createConnectionToBD.createConnection();
            Statement statement = createConnectionToBD.createStatement();
            PreparedStatement preparedStatement=connection.prepareStatement(sql);


            preparedStatement.setString(1, (String) entitiesInterface.getAllParam().get(0));
            preparedStatement.setString(2, (String) entitiesInterface.getAllParam().get(1));
            preparedStatement.setString(3, (String) entitiesInterface.getAllParam().get(2));
            preparedStatement.setString(4, (String) entitiesInterface.getAllParam().get(3));
            preparedStatement.setDate(5, Date.valueOf(String.valueOf(entitiesInterface.getAllParam().get(4))));


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public EntitiesInterface selectOne(int id) {
        String sql="select * from request where id_request="+id;
        Request request=null;
        try {
            CreateConnectionToBD createConnectionToBD=new CreateConnectionToBD();

            Connection connection = createConnectionToBD.createConnection();
            Statement statement = createConnectionToBD.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next()){
                  request=new Request(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getString(5), resultSet.getDate(6));

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return request;
    }
}
