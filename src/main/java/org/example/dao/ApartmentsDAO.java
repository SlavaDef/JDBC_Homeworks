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

    Apartments getByCity(String city);

    Apartments getByAddress(String address);

     List<Apartments> getByPrice(int price);

    List<Apartments> getByArea(int area);

    List<Apartments> getByRooms(int rooms);

}
