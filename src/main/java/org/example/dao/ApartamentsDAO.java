package org.example.dao;

import org.example.entity.Apartments;

import java.util.List;

public interface ApartamentsDAO {


    void createTable();
    void addApartament(String city, String adress, int area, int rooms, long price);
    List<Apartments> getAll();
    long count();

    void deleteApartament();

    void updateApartament();

    Apartments getByNumber(int id);

    void printTablesIds();

    void createSomeApartaments();

    //  Apartaments get
}
