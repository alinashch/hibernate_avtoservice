package Entities;



import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

public class Repair implements EntitiesInterface {
    private int id;
    private int idChange;
    private int idRequest;
    private Date repairDate;

    public Repair(){

    }

    @Override
    public String toString() {
        return "Repair{" +
                "idRepair=" + id +
                ", idChange=" + idChange +
                ", idRequest=" + idRequest +
                ", repairDate=" + repairDate +
                '}';
    }

    public Repair(int id, int idChange, int idRequest, Date repairDate) {
        this.id = id;
        this.idChange = idChange;
        this.idRequest = idRequest;
        this.repairDate = repairDate;
    }

    public int getId() {
        return id;
    }

    @Override
    public List getAllParam() {
        return null;
    }

    public void setIdRepair(int idRepair) {
        this.id = idRepair;
    }

    public int getIdChange() {
        return idChange;
    }

    public void setIdChange(int idChange) {
        this.idChange = idChange;
    }

    public int getIdRequest() {
        return idRequest;
    }

    public void setIdRequest(int idRequest) {
        this.idRequest = idRequest;
    }

    public Date getRepairDate() {
        return repairDate;
    }

    public void setRepairDate(Date repairDate) {
        this.repairDate = repairDate;
    }

    public Repair(int idChange, int idRequest, Date repairDate) {
        this.idChange = idChange;
        this.idRequest = idRequest;
        this.repairDate = repairDate;
    }
}
