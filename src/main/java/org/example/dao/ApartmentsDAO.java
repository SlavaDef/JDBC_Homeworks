package org.example.dao;

import org.example.entity.Apartments;

import java.util.List;

public interface ApartmentsDAO {


    void createTable();
    void addApartament(String city, String adress, int area, int rooms, long price);
    List<Apartments> getAll();
    long count();

    void deleteApartmentById(int id);

    void updateApartment(int id, int apartment_rooms, long  apartment_price);

    Apartments getByNumber(int id);

    void printTablesIds();

    void createSomeApartaments();

    //  Apartaments get
}
