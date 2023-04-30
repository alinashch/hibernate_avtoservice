package Entities;


import java.util.List;

public interface EntitiesInterface<T> {
    String toString();
    int getId();

    List<T> getAllParam();
}
