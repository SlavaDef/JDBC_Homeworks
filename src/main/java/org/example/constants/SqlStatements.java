package org.example.constants;

public class SqlStatements {


    public static final String CREATE_SQL = "CREATE TABLE Apartments (apartment_number INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
            "apartment_sity VARCHAR(50) NOT NULL, apartment_adress VARCHAR(50) NOT NULL, " +
            "apartment_area INT NOT NULL , " +
            "apartment_rooms INT NOT NULL, apartment_price BIGINT NOT NULL )";

    public static final String IN_IT_SQL = "INSERT INTO Apartments " +
            "(apartment_sity, apartment_adress, apartment_area, apartment_rooms, apartment_price)" +
            " VALUES(?, ?, ?, ?, ?)";

    public static final String COUNT = "SELECT COUNT(*) FROM Apartments";

    public static final String CREATE_SQL2 = "CREATE TABLE Apartments (apartment_number INT AUTO_INCREMENT(5,10), " +
            "apartment_sity VARCHAR(50) NOT NULL, apartment_adress VARCHAR(50) NOT NULL, " +
            "apartment_area INT NOT NULL , " +
            "apartment_rooms INT NOT NULL, apartment_price BIGINT NOT NULL, "+
            "PRIMARY KEY (apartment_number) )";
    //IDENTITY(1,56)


}
