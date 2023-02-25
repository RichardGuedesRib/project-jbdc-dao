package application;

import entities.Department;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        List<Department> departments = new ArrayList<>();

        System.out.print("Enter the quantity of departments: ");
        int quantity = sc.nextInt();

        System.out.println();
        System.out.println("==========================");
        sc.nextLine();
        for (int i =0; i < quantity; i++) {

            System.out.print("Enter the name of the department for ID " + (i + 1) + ": ");
            String name = sc.nextLine();
            departments.add(new Department((i + 1), name));
        }

        System.out.println();
        System.out.println("==========================");
        departments.forEach(System.out::println);


    }
}
