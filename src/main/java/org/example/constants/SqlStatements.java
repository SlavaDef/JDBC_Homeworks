package org.example.constants;

public class SqlStatements {


    public static final String CREATE_SQL = "CREATE TABLE Apartaments (apartament_number INT NOT NULL AUTO_INCREMENT PRIMARY KEY, " +
            "apartament_sity VARCHAR(50) NOT NULL, apartament_adress VARCHAR(50) NOT NULL, " +
            "apartament_area INT NOT NULL , " +
            "apartament_rooms INT NOT NULL, apartament_price BIGINT NOT NULL )";

    public static final String IN_IT_SQL = "INSERT INTO Apartaments " +
            "(apartament_sity, apartament_adress, apartament_area, apartament_rooms, apartament_price)" +
            " VALUES(?, ?, ?, ?, ?)";

    public static final String COUNT = "SELECT COUNT(*) FROM Apartaments";

    public static final String CREATE_SQL2 = "CREATE TABLE Apartaments (apartament_number INT AUTO_INCREMENT(5,10), " +
            "apartament_sity VARCHAR(50) NOT NULL, apartament_adress VARCHAR(50) NOT NULL, " +
            "apartament_area INT NOT NULL , " +
            "apartament_rooms INT NOT NULL, apartament_price BIGINT NOT NULL, "+
            "PRIMARY KEY (apartament_number) )";
    //IDENTITY(1,56)


}
