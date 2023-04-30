package Entities;



import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Request implements EntitiesInterface {
    private int id;
    private String firstName;
    private String secondName;
    private String thirdName;
    private String telephone;
    private Date requestDate;

    public Request() {

    }

    public int getId() {
        return id;
    }

    @Override
    public List getAllParam() {
        return null;
    }

    public void setIdRequest(int idRequest) {
        this.id = idRequest;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getThirdName() {
        return thirdName;
    }

    public void setThirdName(String thirdName) {
        this.thirdName = thirdName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;
    }

    public Request(int id, String firstName, String secondName, String thirdName, String telephone, Date requestDate) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.telephone = telephone;
        this.requestDate = requestDate;
    }

    @Override
    public String toString() {
        return "Request{" +
                "idRequest=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", thirdName='" + thirdName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", requestDate=" + requestDate +
                '}';
    }

    public Request(String firstName, String secondName, String thirdName, String telephone, Date requestDate) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.telephone = telephone;
        this.requestDate = requestDate;
    }
}