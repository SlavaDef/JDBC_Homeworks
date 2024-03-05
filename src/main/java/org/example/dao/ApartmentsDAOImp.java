package org.example.dao;

import org.example.entity.Apartments;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.constants.SqlStatements.*;

public class ApartmentsDAOImp implements ApartmentsDAO {

    private final Connection conn;

    private final String table;

    public ApartmentsDAOImp(Connection conn) {

        this.conn = conn;
        this.table = "Apartments";
    }


    @Override
    public void createTable() {

        try {
            try (Statement st = conn.createStatement()) {
                st.execute("DROP TABLE IF EXISTS " + table);
                st.execute(CREATE_SQL);
                // st.execute("ALTER TABLE Apartments AUTO_INCREMENT=20");
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void addApartament(String city, String adress, int area, int rooms, long price) {

        try {
            try (PreparedStatement st = conn.prepareStatement(IN_IT_SQL)) {
                st.setString(1, city);
                st.setString(2, adress);
                st.setInt(3, area);
                st.setInt(4, rooms);
                st.setLong(5, price);
                st.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Apartments> getAll() {

        List<Apartments> res = new ArrayList<>();

        try {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery("SELECT * FROM " + table)) {
                    while (rs.next()) {
                        Apartments apartments = new Apartments();

                        apartments.setApartment_number(rs.getInt(1));
                        apartments.setApartment_sity(rs.getString(2));
                        apartments.setApartment_adress(rs.getString(3));
                        apartments.setApartment_area(rs.getInt(4));
                        apartments.setApartment_rooms(rs.getInt(5));
                        apartments.setApartment_price(rs.getLong(6));

                        res.add(apartments);
                    }
                }
            }

            return res;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public long count() {
        try {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery(COUNT)) {
                    if (rs.next())
                        return rs.getLong(1);
                    else
                        throw new RuntimeException("No Apartmens in base!");
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void deleteApartmentById(int id) {
        Apartments res = getByNumber(id);

        try {
         //   try (Statement st = conn.createStatement()) {
            //    st.execute("DELETE FROM " + table + " WHERE apartment_number=" + id);
         //   }
            try (PreparedStatement st = conn.prepareStatement("DELETE FROM " + table + " WHERE apartment_number=" + id)) {
                st.executeUpdate();
            }
            System.out.println(res + " was deleted");

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void updateApartment(int id, int apartment_rooms, long apartment_price) {

        try {
            try (PreparedStatement st = conn.prepareStatement("UPDATE " + table +
                    " set apartment_rooms = ?, apartment_price = ?" +
                    " where apartment_number =" + id)) {
                st.setInt(1, apartment_rooms);
                st.setLong(2, apartment_price);
                st.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


    @Override
    public Apartments getByNumber(int id) {
        Apartments res = new Apartments();

        try {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery("SELECT * FROM " + table + " WHERE apartment_number=" + id)) {
                    while (rs.next()) {
                        Apartments apartments = new Apartments();

                        apartments.setApartment_number(rs.getInt(1));
                        apartments.setApartment_sity(rs.getString(2));
                        apartments.setApartment_adress(rs.getString(3));
                        apartments.setApartment_area(rs.getInt(4));
                        apartments.setApartment_rooms(rs.getInt(5));
                        apartments.setApartment_price(rs.getLong(6));
                        res = apartments;
                    }
                }
            }
            System.out.println(res);
            return res;
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void createSomeApartaments() {
        addApartament("Lviv", "Lola street,8", 58, 2, 423944);
        addApartament("Kyiv", "Porica street, 12", 90, 3, 78569);
        addApartament("Odessa", "Nevadska street, 34", 35, 1, 24890);
        addApartament("Marik", "Peremogu street, 22", 129, 4, 250999);
        addApartament("New Jerci", "Bonjur street,15", 100, 2, 1423944);
        addApartament("Keip Toun", "Dell street, 68", 115, 4, 178569);
        addApartament("Kair", "Bombo street, 98", 135, 3, 124890);
        addApartament("Dallas", "St.Jeniffer street, 1", 129, 4, 1250999);
    }

    @Override
    public void printTablesIds() { // метод виводе всі numbers

        try (Statement st = conn.createStatement()) {

            try (ResultSet res = st.executeQuery("SELECT apartment_number FROM " + table)) {
                while (res.next()) {
                    long id = res.getInt("apartment_number");
                    System.out.println("Number = " + id);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}


