package org.example.entity;

import org.example.constants.Id;

public class Apartments {

    @Id
    private int apartment_number;

    private String apartment_sity;

    private String apartment_adress;

    private int apartment_area;

    private int apartment_rooms;

    private long apartment_price;

    public Apartments() {
    }

    public Apartments(int apartment_number, String apartment_sity, String apartment_adress,
                      int apartment_area, int apartment_rooms, long apartment_price) {
        this.apartment_number = apartment_number;
        this.apartment_sity = apartment_sity;
        this.apartment_adress = apartment_adress;
        this.apartment_area = apartment_area;
        this.apartment_rooms = apartment_rooms;
        this.apartment_price = apartment_price;
    }

    public int getApartment_number() {
        return apartment_number;
    }

    public void setApartment_number(int apartment_number) {
        this.apartment_number = apartment_number;
    }

    public String getApartment_sity() {
        return apartment_sity;
    }

    public void setApartment_sity(String apartment_sity) {
        this.apartment_sity = apartment_sity;
    }

    public String getApartment_adress() {
        return apartment_adress;
    }

    public void setApartment_adress(String apartment_adress) {
        this.apartment_adress = apartment_adress;
    }

    public int getApartment_area() {
        return apartment_area;
    }

    public void setApartment_area(int apartment_area) {
        this.apartment_area = apartment_area;
    }

    public int getApartment_rooms() {
        return apartment_rooms;
    }

    public void setApartment_rooms(int apartment_rooms) {
        this.apartment_rooms = apartment_rooms;
    }

    public long getApartment_price() {
        return apartment_price;
    }

    public void setApartment_price(long apartment_price) {
        this.apartment_price = apartment_price;
    }

    @Override
    public String toString() {
        return "Apartments = " +
                " apartment_number=" + apartment_number +
                ", apartment_sity='" + apartment_sity + '\'' +
                ", apartment_adress='" + apartment_adress + '\'' +
                ", apartment_area=" + apartment_area +"/m_2"+
                ", apartment_rooms=" + apartment_rooms +
                ", apartment_price=" + apartment_price + "$ ";

    }
}
