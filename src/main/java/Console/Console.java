package Console;

import Entities.*;
import Service.Service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Console {
    public void ConsoleAction( Service service, String action, String entity){
        Scanner scanner=new Scanner(System.in);
        if(action.equals("select")){
            List<EntitiesInterface> list= service.selectAll();
            for(EntitiesInterface e:list){
                System.out.println(e);
            }
        }else if(action.equals("update")){
            if (entity.equals("employee")) {
                EmployeeUpdate(service);

            } else if (entity.equals("change")) {
                ChangeUpdate(service);
            } else if (entity.equals("repair")) {
                RepairUpdate(service);
            } else if (entity.equals("request")) {
                RequestUpdate(service);
            }
        } else if (action.equals("add")) {
            if (entity.equals("employee")) {
                service.add(EmployeeAdd());

            } else if (entity.equals("change")) {
                service.add(ChangeAdd());
            } else if (entity.equals("repair")) {
                service.add(RepairAdd());
            } else if (entity.equals("request")) {
                service.add(RequestAdd());
            }
        } else if (action.equals("delete")) {
            System.out.println("Enter id");
            service.delete(scanner.nextInt());
        }else if (action.equals("selectOne")){
            System.out.println("Enter id");
            EntitiesInterface entitiesInterface=service.selectOne(scanner.nextInt());
            System.out.println(entitiesInterface);
        }
    }

    private void RequestUpdate(Service service){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter id");
        EntitiesInterface entitiesInterface=service.selectOne(scanner.nextInt());
        System.out.println("choose first_name, second_name, third_name, telephone, request_date");
        String s=scanner.nextLine();
        System.out.println("Enter value");
        Object o=scanner.nextLine();
        Map<String, Object> map=new HashMap<>();
        map.put(s, o);
        service.update(entitiesInterface,map );

    }

    private EntitiesInterface RequestAdd(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter first_name, second_name, third_name, telephone, request_date");

        EntitiesInterface request=new Request(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), Date.valueOf(scanner.nextLine()));

        return request;
    }

    private void RepairUpdate(Service service){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter id");
        EntitiesInterface entitiesInterface=service.selectOne(scanner.nextInt());
        System.out.println("choose id_change, id_request, repair_date");
        String s=scanner.nextLine();
        System.out.println("Enter value");
        Object o=scanner.nextLine();
        Map<String, Object> map=new HashMap<>();
        map.put(s, o);
        service.update(entitiesInterface,map );

    }

    private EntitiesInterface RepairAdd(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter id_change, id_request, repair_date");

        EntitiesInterface repair=new Repair(scanner.nextInt(), scanner.nextInt(), Date.valueOf(scanner.nextLine()));

        return repair;
    }

    private void ChangeUpdate(Service service){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter id");
        EntitiesInterface entitiesInterface=service.selectOne(scanner.nextInt());
        System.out.println("choose date_production, name_detail, number_detail");
        Scanner scanner1=new Scanner(System.in);
        String s=scanner1.nextLine();

        System.out.println("Enter value");
        Object o=scanner1.nextLine();

        System.out.println(s);
        System.out.println(o);
        Map<String, Object> map=new HashMap<>();
        map.put(s, o);
        service.update(entitiesInterface,map );

    }

    private EntitiesInterface ChangeAdd(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter date_production");
        Date date_production= Date.valueOf(scanner.nextLine());

        System.out.println("Enter name_detail");
        String name_detail=scanner.nextLine();

        System.out.println("Enter number_detail");
        int number_detail=scanner.nextInt();

        EntitiesInterface change=new Change(date_production, name_detail,number_detail);

        return change;
    }
    private void EmployeeUpdate(Service service ){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter id");
        EntitiesInterface entitiesInterface=service.selectOne(scanner.nextInt());
        System.out.println("choose FIRST_NAME_EMPLOYEE,SECOND_NAME_EMPLOYEE, THIRD_NAME_EMPLOYEE,DATE_BIRTH_EMPLOYEE, ADDRESS_EMPLOYEE,TELEPHONE_EMPLOYEE, POST, SALARY, EXPERIENCE, OPERATING_MODE, ALLOWANCE");
        String s=scanner.nextLine();
        System.out.println("Enter value");
        Object o=scanner.nextLine();
        Map<String, Object> map=new HashMap<>();
        map.put(s, o);
        service.update(entitiesInterface,map );
    }
    private EntitiesInterface EmployeeAdd(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("enter FIRST_NAME_EMPLOYEE,SECOND_NAME_EMPLOYEE, THIRD_NAME_EMPLOYEE,DATE_BIRTH_EMPLOYEE, ADDRESS_EMPLOYEE,TELEPHONE_EMPLOYEE, POST, SALARY, EXPERIENCE, OPERATING_MODE, ALLOWANCE");
        EntitiesInterface employee=new Employee(scanner.nextLine(), scanner.nextLine(), scanner.nextLine(), Date.valueOf(scanner.nextLine()), scanner.nextLine(), scanner.nextLine(), scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), scanner.nextLine(), scanner.nextInt());
        return employee;
    }

}
