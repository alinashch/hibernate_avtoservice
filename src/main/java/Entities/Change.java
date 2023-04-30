package Entities;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Change  implements EntitiesInterface  {
    private int id;
    private Date dateProduction;
    private String nameDetail;
    private int numberDetail;

    public Change( Date dateProduction, String nameDetail, int numberDetail) {
        this.dateProduction = dateProduction;
        this.nameDetail = nameDetail;
        this.numberDetail = numberDetail;
    }

    public Change(int idChange, Date dateProduction, String nameDetail, int numberDetail) {
        this.id = idChange;
        this.dateProduction = dateProduction;
        this.nameDetail = nameDetail;
        this.numberDetail = numberDetail;
    }

    @Override
    public String toString() {
        return "Change{" +
                "idChange=" + id +
                ", dateProduction=" + dateProduction +
                ", nameDetail='" + nameDetail + '\'' +
                ", numberDetail=" + numberDetail +
                '}';
    }


    public int getId() {
        return id;
    }

    @Override
    public List getAllParam() {
        List< Object> list=new ArrayList<>();
        list.add(dateProduction);
        list.add(nameDetail);
        list.add(numberDetail);
        return list;
    }

    public void setIdChange(int idChange) {
        this.id = idChange;
    }

    public Date getDateProduction() {
        return dateProduction;
    }

    public void setDateProduction(Date dateProduction) {
        this.dateProduction = dateProduction;
    }

    public String getNameDetail() {
        return nameDetail;
    }

    public void setNameDetail(String nameDetail) {
        this.nameDetail = nameDetail;
    }

    public int getNumberDetail() {
        return numberDetail;
    }

    public void setNumberDetail(int numberDetail) {
        this.numberDetail = numberDetail;
    }

    public Change(){

    }


}
