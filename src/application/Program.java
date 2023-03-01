package application;

import dao.DaoFactory;
import dao.SellerDao;
import entities.Department;
import entities.Seller;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) throws ParseException {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        List<Department> departments = new ArrayList<>();
        List<Seller> sellers = new ArrayList<>();

        SellerDao sellerdao = DaoFactory.createSellerDao();

        Seller seller = sellerdao.findById(2);

        System.out.println("Test N. 1 -- Find By Id: ");
        System.out.println(seller);

        System.out.println("\n\nTest N. 2 -- Find By Department:");
        Department department = new Department(1, null);
        List<Seller> list = sellerdao.findByDepartment(department);
        list.forEach(System.out::println);

        System.out.println("\n\nTest N. 3 -- Find By All:");
        List<Seller> list2 = sellerdao.findAll();
        list2.forEach(System.out::println);

        System.out.println("\n\nTest N. 4 -- Insert:");
        Seller newSeller = new Seller(null, "Richard1301", "Richard@gamil.com", new Date(13/03/1991), 4000.50, department);
        sellerdao.insert(newSeller);
        System.out.println("Inserted! New id =  + newSeller.getId());");
        System.out.println(newSeller);

        System.out.println("\n\nTest N. 5 -- Update:");
        seller = sellerdao.findById(10);
        seller.setName("Richard9876");
        sellerdao.update(seller);
        System.out.println("Update Complete!\n\n");


        System.out.println("==============================");
        System.out.println("Test N. 6 -- Delete:");
        List<Seller> list3 = sellerdao.findAll();
        list3.forEach(System.out::println);
        System.out.println("==============================");
        System.out.print("Enter Id for Delete: ");
        int delId = sc.nextInt();
        System.out.println("==============================");
        sellerdao.deleteById(delId);
        System.out.println("Delete Complete!\n\n");




    }
}
