package DAO;

import BDAction.Connect.CreateConnectionToBD;
import Entities.Employee;
import Entities.EntitiesInterface;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EmployeeDAO implements DAO{


    @Override
    public List<EntitiesInterface> selectAll() {
        String sql="select * from employee";
        List<EntitiesInterface> arrayList=new ArrayList<>();
        try {
            CreateConnectionToBD createConnectionToBD=new CreateConnectionToBD();

            Connection connection = createConnectionToBD.createConnection();
            Statement statement = createConnectionToBD.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next()){
                Employee employee=new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getDate(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8), resultSet.getInt(9), resultSet.getInt(10), resultSet.getString(11), resultSet.getInt(12));
                arrayList.add(employee);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return arrayList;
    }

    @Override
    public void delete(int id) {
        String sql="delete from employee where id_employee= "+ id;
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
        if(value.get("FIRST_NAME_EMPLOYEE")!=null){
            q=value.get("FIRST_NAME_EMPLOYEE");
            name="FIRST_NAME_EMPLOYEE";
        } else if( value.get("SECOND_NAME_EMPLOYEE")!=null){
            q=value.get("SECOND_NAME_EMPLOYEE");
            name="SECOND_NAME_EMPLOYEE";
        }else if( value.get("THIRD_NAME_EMPLOYEE")!=null){
            q=value.get("THIRD_NAME_EMPLOYEE");
            name="THIRD_NAME_EMPLOYEE";
        }else if( value.get("DATE_BIRTH_EMPLOYEE")!=null){
            q=value.get("DATE_BIRTH_EMPLOYEE");
            name="DATE_BIRTH_EMPLOYEE";
        }else if( value.get("ADDRESS_EMPLOYEE")!=null){
            q=value.get("ADDRESS_EMPLOYEE");
            name="ADDRESS_EMPLOYEE";
        }else if( value.get("TELEPHONE_EMPLOYEE")!=null){
            q=value.get("TELEPHONE_EMPLOYEE");
            name="TELEPHONE_EMPLOYEE";
        }else if( value.get("POST")!=null){
            q=value.get("POST");
            name="POST";
        }else if( value.get("SALARY")!=null){
            q=value.get("SALARY");
            name="SALARY";
        }else if( value.get("EXPERIENCE")!=null){
            q=value.get("EXPERIENCE");
            name="EXPERIENCE";
        }else if( value.get("OPERATING_MODE")!=null){
            q=value.get("OPERATING_MODE");
            name="OPERATING_MODE";
        }else if( value.get("ALLOWANCE")!=null){
            q=value.get("ALLOWANCE");
            name="ALLOWANCE";
        }
        String sql="update employee set " + name+ "='"+ q+ "' where id_employee=" +entity.getId() ;
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
        String sql="insert into EMPLOYEE (FIRST_NAME_EMPLOYEE,SECOND_NAME_EMPLOYEE, THIRD_NAME_EMPLOYEE,DATE_BIRTH_EMPLOYEE, ADDRESS_EMPLOYEE,TELEPHONE_EMPLOYEE, POST, SALARY, EXPERIENCE, OPERATING_MODE, ALLOWANCE) values (?, ?, ?, ?, ?, ?, ?, ?,?, ?, ? )";
        try {
            CreateConnectionToBD createConnectionToBD=new CreateConnectionToBD();

            Connection connection = createConnectionToBD.createConnection();
            Statement statement = createConnectionToBD.createStatement();
            PreparedStatement preparedStatement=connection.prepareStatement(sql);

            preparedStatement.setString(1, (String) entitiesInterface.getAllParam().get(0));
            preparedStatement.setString(2, (String) entitiesInterface.getAllParam().get(1));
            preparedStatement.setString(3, (String) entitiesInterface.getAllParam().get(2));
            preparedStatement.setDate(4 , (Date) entitiesInterface.getAllParam().get(3));
            preparedStatement.setString(5, (String) entitiesInterface.getAllParam().get(4));
            preparedStatement.setString(6, (String) entitiesInterface.getAllParam().get(5));
            preparedStatement.setInt(7, (Integer) entitiesInterface.getAllParam().get(6));
            preparedStatement.setInt(8, (Integer) entitiesInterface.getAllParam().get(7));
            preparedStatement.setInt(9, (Integer) entitiesInterface.getAllParam().get(8));
            preparedStatement.setInt(11, (Integer) entitiesInterface.getAllParam().get(9));
            preparedStatement.setString(10, (String) entitiesInterface.getAllParam().get(10));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public EntitiesInterface selectOne(int id) {
        String sql="select * from employee where id_employee=" +id;
        Employee employee = null;
        try {
            CreateConnectionToBD createConnectionToBD=new CreateConnectionToBD();

            Connection connection = createConnectionToBD.createConnection();
            Statement statement = createConnectionToBD.createStatement();
            ResultSet resultSet=statement.executeQuery(sql);

            while (resultSet.next()){
                 employee=new Employee(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getDate(5), resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8), resultSet.getInt(9), resultSet.getInt(10), resultSet.getString(11), resultSet.getInt(12));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employee ;
    }
}
