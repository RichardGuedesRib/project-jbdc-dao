package application;

import entities.Department;
import entities.Seller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Department> departments = new ArrayList<>();
        List<Seller> sellers = new ArrayList<>();

        System.out.print("Enter the quantity of Sellers: ");
        int quantity = sc.nextInt();

        System.out.println();
        System.out.println("==========================");
        sc.nextLine();
        for (int i =0; i < quantity; i++) {

            System.out.print("Enter the name of Seller for ID " + (i + 1) + ": ");
            String name = sc.nextLine();
            System.out.print("Enter the email for " + name + ": ");
            String email = sc.nextLine();
            System.out.print("Enter BirthDate for " + name + ": ");
            Date birthDate = sdf.parse(sc.nextLine());
            System.out.print("Enter the BaseSalary for " + name + ": ");
            double baseSalary = sc.nextDouble();
            System.out.println("Enter the ID Department for " + name + ": ");
            int IdepartmentId = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter the name department for " + name + ": ");
            String departmentName = sc.nextLine();

            sellers.add(new Seller((i + 1), name, email, birthDate, baseSalary, (new Department(IdepartmentId, departmentName))));

        }

        System.out.println();
        System.out.println("==========================");
        sellers.forEach(System.out::println);


    }
}
