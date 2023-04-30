package Entities;


import java.sql.Date;
import java.util.List;

public class Employee implements EntitiesInterface {
    private int id;
    private String firstNameEmployee;
    private String secondNameEmployee;
    private String thirdNameEmployee;
    private Date dateBirthEmployee;
    private String addressEmployee;
    private String telephoneEmployee;
    private int post;
    private int salary;
    private int experience;
    private String operatingMode;
    private int allowance;

    public Employee(){

    }

    @Override
    public String toString() {
        return "Employee{" +
                "idEmployee=" + id +
                ", firstNameEmployee='" + firstNameEmployee + '\'' +
                ", secondNameEmployee='" + secondNameEmployee + '\'' +
                ", thirdNameEmployee='" + thirdNameEmployee + '\'' +
                ", dateBirthEmployee=" + dateBirthEmployee +
                ", addressEmployee='" + addressEmployee + '\'' +
                ", telephoneEmployee='" + telephoneEmployee + '\'' +
                ", post=" + post +
                ", salary=" + salary +
                ", experience=" + experience +
                ", operatingMode='" + operatingMode + '\'' +
                ", allowance=" + allowance +
                '}';
    }

    public Employee(int id, String firstNameEmployee, String secondNameEmployee, String thirdNameEmployee, Date dateBirthEmployee, String addressEmployee, String telephoneEmployee, int post, int salary, int experience, String operatingMode, int allowance) {
        this.id = id;
        this.firstNameEmployee = firstNameEmployee;
        this.secondNameEmployee = secondNameEmployee;
        this.thirdNameEmployee = thirdNameEmployee;
        this.dateBirthEmployee = dateBirthEmployee;
        this.addressEmployee = addressEmployee;
        this.telephoneEmployee = telephoneEmployee;
        this.post = post;
        this.salary = salary;
        this.experience = experience;
        this.operatingMode = operatingMode;
        this.allowance = allowance;
    }

    public Employee(String firstNameEmployee, String secondNameEmployee, String thirdNameEmployee, Date dateBirthEmployee, String addressEmployee, String telephoneEmployee, int post, int salary, int experience, String operatingMode, int allowance) {
        this.firstNameEmployee = firstNameEmployee;
        this.secondNameEmployee = secondNameEmployee;
        this.thirdNameEmployee = thirdNameEmployee;
        this.dateBirthEmployee = dateBirthEmployee;
        this.addressEmployee = addressEmployee;
        this.telephoneEmployee = telephoneEmployee;
        this.post = post;
        this.salary = salary;
        this.experience = experience;
        this.operatingMode = operatingMode;
        this.allowance = allowance;
    }
    public int getId() {
        return id;
    }

    @Override
    public List getAllParam() {
        return null;
    }

    public void setIdEmployee(int idEmployee) {
        this.id = idEmployee;
    }

    public String getFirstNameEmployee() {
        return firstNameEmployee;
    }

    public void setFirstNameEmployee(String firstNameEmployee) {
        this.firstNameEmployee = firstNameEmployee;
    }

    public String getSecondNameEmployee() {
        return secondNameEmployee;
    }

    public void setSecondNameEmployee(String secondNameEmployee) {
        this.secondNameEmployee = secondNameEmployee;
    }

    public String getThirdNameEmployee() {
        return thirdNameEmployee;
    }

    public void setThirdNameEmployee(String thirdNameEmployee) {
        this.thirdNameEmployee = thirdNameEmployee;
    }

    public Date getDateBirthEmployee() {
        return dateBirthEmployee;
    }

    public void setDateBirthEmployee(Date dateBirthEmployee) {
        this.dateBirthEmployee = dateBirthEmployee;
    }

    public String getAddressEmployee() {
        return addressEmployee;
    }

    public void setAddressEmployee(String addressEmployee) {
        this.addressEmployee = addressEmployee;
    }

    public String getTelephoneEmployee() {
        return telephoneEmployee;
    }

    public void setTelephoneEmployee(String telephoneEmployee) {
        this.telephoneEmployee = telephoneEmployee;
    }

    public int getPost() {
        return post;
    }

    public void setPost(int post) {
        this.post = post;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public String getOperatingMode() {
        return operatingMode;
    }

    public void setOperatingMode(String operatingMode) {
        this.operatingMode = operatingMode;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }
}
