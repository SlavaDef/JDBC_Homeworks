package org.example;

import org.example.dao.ApartmentsDAO;
import org.example.dao.ApartmentsDAOImp;
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
            ApartmentsDAO dao = new ApartmentsDAOImp(conn);
            dao.createTable();
            dao.createSomeApartaments();

            while (true) {
                System.out.println("1: add Apartments");
                System.out.println("2: view Apartments");
                System.out.println("3: view count");
                System.out.println("4: view numbers");
                System.out.println("5: view Apartment by number");
                System.out.println("6: delete Apartment by number");
                System.out.println("7: update Apartment by number");
                System.out.print("-> ");

                String s = sc.nextLine();
                switch (s) {
                    case "1":
                        System.out.print("Enter apartment city: ");
                        String city = sc.nextLine();
                        System.out.print("Enter apartment address: ");
                        String address = sc.nextLine();
                        System.out.print("Enter apartment area: ");
                        String area = sc.nextLine();
                        int are = Integer.parseInt(area);
                        System.out.print("Enter apartment rooms: ");
                        String room = sc.nextLine();
                        int rooms = Integer.parseInt(room);
                        System.out.print("Enter apartment price: ");
                        String prise = sc.nextLine();
                        long prises = Long.parseLong(prise);

                        dao.addApartament(city, address, are, rooms, prises);
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
                        System.out.println("What number of apartment do you need?");
                        String numb = sc.nextLine();
                        int num = Integer.parseInt(numb);
                        dao.getByNumber(num);
                        break;
                    case "6":
                        System.out.println("What number of apartment do you want to delete?");
                        String number = sc.nextLine();
                        int id = Integer.parseInt(number);
                        dao.deleteApartmentById(id);
                        break;
                    case "7":
                        System.out.println("What number of apartment do you want to update?");
                        String numbe = sc.nextLine();
                        int idS = Integer.parseInt(numbe);
                        System.out.println("How many rooms yet?");
                        String rooM = sc.nextLine();
                        int rM = Integer.parseInt(rooM);
                        System.out.println("What is a new price?");
                        String price = sc.nextLine();
                        long priSe = Long.parseLong(price);
                        dao.updateApartment(idS, rM, priSe);
                        break;
                    default:
                        return;
                }
            }
        }
    }
}
