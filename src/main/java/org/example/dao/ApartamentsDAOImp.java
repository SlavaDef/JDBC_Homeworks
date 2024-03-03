package org.example.dao;

import org.example.entity.Apartaments;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.example.constants.SqlStatements.*;

public class ApartamentsDAOImp implements ApartamentsDAO {

    private final Connection conn;

    public ApartamentsDAOImp(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void createTable() {

        try {
            try (Statement st = conn.createStatement()) {
                st.execute("DROP TABLE IF EXISTS Apartaments");
                st.execute(createSql);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void addApattament(String city, String adress, int area, int rooms, long price) {

        try {
                try (PreparedStatement st = conn.prepareStatement(inItSQL) ){
                st.setString(1, city);
                st.setString(2, adress);
                st.setInt(3, area);
                st.setInt(4, rooms);
                st.setLong(5,price);
                st.executeUpdate();
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public List<Apartaments> getAll() {

        List<Apartaments> res = new ArrayList<>();

        try {
            try (Statement st = conn.createStatement()) {
                try (ResultSet rs = st.executeQuery("SELECT * FROM Apartaments")) {
                    while (rs.next()) {
                        Apartaments apartaments = new Apartaments();

                        apartaments.setApartament_number(rs.getInt(1));
                        apartaments.setApartament_sity(rs.getString(2));
                        apartaments.setApartament_adress(rs.getString(3));
                        apartaments.setApartament_area(rs.getInt(4));
                        apartaments.setApartament_rooms(rs.getInt(5));
                        apartaments.setApartament_price(rs.getLong(6));

                        res.add(apartaments);
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
                        throw new RuntimeException("No Apartamens in base!");
                }
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }

    }
}
