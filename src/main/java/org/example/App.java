package org.example;

import org.example.dao.ApartamentsDAO;
import org.example.dao.ApartamentsDAOImp;
import org.example.entity.Apartments;
import org.example.storage.ConnectionFactory;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class App {

    public static void main(String[] args) throws SQLException {
        try (Connection conn = ConnectionFactory.getConnection();
             Scanner sc = new Scanner(System.in)) {
            ApartamentsDAO dao = new ApartamentsDAOImp(conn);
            dao.createTable();
            dao.createSomeApartaments();

            while (true) {
                System.out.println("1: add Apartaments");
                System.out.println("2: view Apartaments");
                System.out.println("3: view count");
                System.out.println("4: view numbers");
                System.out.println("5: view Apartment by number");
                System.out.print("-> ");

                String s = sc.nextLine();
                switch (s) {
                    case "1":
                        System.out.print("Enter apartament city: ");
                        String city = sc.nextLine();
                        System.out.print("Enter apartament adress: ");
                        String adress = sc.nextLine();
                        System.out.print("Enter apartament area: ");
                        String area = sc.nextLine();
                        int are = Integer.parseInt(area);
                        System.out.print("Enter apartament rooms: ");
                        String room = sc.nextLine();
                        int rooms = Integer.parseInt(room);
                        System.out.print("Enter apartament price: ");
                        String prise = sc.nextLine();
                        long prises = Long.parseLong(prise);

                        dao.addApartament(city, adress, are, rooms, prises);
                        break;
                    case "2":
                        List<Apartments> list = dao.getAll();
                        for (Apartments ap : list) {
                            System.out.println(ap);
                        }
                        break;
                    case "3":
                        System.out.println("Count: " + dao.count());
                        break;
                    case "4":
                        dao.printTablesIds();
                        break;
                    case "5":
                        System.out.println("What number do you need?");
                        String numb = sc.nextLine();
                        int num = Integer.parseInt(numb);
                        dao.getByNumber(num);
                        break;
                    default:
                        return;
                }
            }
        }
    }
}
