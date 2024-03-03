package org.example.entity;

import org.example.constants.Id;

public class Apartaments {

    @Id
    private int apartament_number;

    private String apartament_sity;

    private String apartament_adress;

    private int apartament_area;

    private int apartament_rooms;

    private long apartament_price;

    public int getApartament_number() {
        return apartament_number;
    }

    public void setApartament_number(int apartament_number) {
        this.apartament_number = apartament_number;
    }

    public String getApartament_sity() {
        return apartament_sity;
    }

    public void setApartament_sity(String apartament_sity) {
        this.apartament_sity = apartament_sity;
    }

    public String getApartament_adress() {
        return apartament_adress;
    }

    public void setApartament_adress(String apartament_adress) {
        this.apartament_adress = apartament_adress;
    }

    public int getApartament_area() {
        return apartament_area;
    }

    public void setApartament_area(int apartament_area) {
        this.apartament_area = apartament_area;
    }

    public int getApartament_rooms() {
        return apartament_rooms;
    }

    public void setApartament_rooms(int apartament_rooms) {
        this.apartament_rooms = apartament_rooms;
    }

    public long getApartament_price() {
        return apartament_price;
    }

    public void setApartament_price(long apartament_price) {
        this.apartament_price = apartament_price;
    }

    @Override
    public String toString() {
        return "Apartaments{" +
                " apartament_number=" + apartament_number +
                ", apartament_sity='" + apartament_sity + '\'' +
                ", apartament_adress='" + apartament_adress + '\'' +
                ", apartament_area=" + apartament_area +"/m_2"+
                ", apartament_rooms=" + apartament_rooms +
                ", apartament_price=" + apartament_price + "$ "+
                '}';
    }
}
