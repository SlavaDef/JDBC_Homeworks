package org.example.dao;

import org.example.entity.Apartaments;

import java.util.List;

public interface ApartamentsDAO {


    void createTable();
    void addApattament(String city, String adress, int area, int rooms, long price);
    List<Apartaments> getAll();
    long count();
}
