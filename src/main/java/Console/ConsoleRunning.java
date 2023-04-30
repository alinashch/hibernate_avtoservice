package Console;

import Entities.Employee;
import Entities.EntitiesInterface;
import Service.ChangeServiceImpl;
import Service.EmployeeServiceImpl;
import Service.RepairServiceImpl;
import Service.RequestServiceImpl;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsoleRunning {
    public static void main(String[] args) {
        ChangeServiceImpl changeService=new ChangeServiceImpl();
        EmployeeServiceImpl employeeService=new EmployeeServiceImpl();
        RepairServiceImpl repairService=new RepairServiceImpl();
        RequestServiceImpl requestService=new RequestServiceImpl();
        Console console=new Console();

        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter employee change repair request");
            String entity = scanner.nextLine();
            System.out.println("Choose select update add delete selectOne");
            String action = scanner.nextLine();
            if (entity.equals("employee")) {
                console.ConsoleAction(employeeService, action, entity);
            } else if (entity.equals("change")) {
                console.ConsoleAction(changeService, action, entity);

            } else if (entity.equals("repair")) {
                console.ConsoleAction(repairService, action, entity);

            } else if (entity.equals("request")) {
                console.ConsoleAction(requestService, action, entity);

            } else {
                break;
            }
        }
    }
}
