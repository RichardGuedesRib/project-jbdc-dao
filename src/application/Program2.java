package application;

import dao.DaoFactory;
import dao.DepartmentDao;
import entities.Department;
import entities.Seller;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Program2 {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        List<Department> department = new ArrayList<>();
        List<Seller> sellers = new ArrayList<>();


        System.out.println("=================================");
        System.out.println("=== TEST N 1 -- Find By Id ===");
        Department department1 = departmentDao.findById(2);
        System.out.println(department1);
        System.out.println("=================================");

        System.out.println("\n\n=================================");
        System.out.println("=== TEST N 2 -- Find All Departments ===");
        List<Department> list = departmentDao.findAll();
        list.forEach(System.out::println);
        System.out.println("=================================");

        System.out.println("\n\n==============================================");
        System.out.println("=== TEST N 3 -- Insert Departments ===");
        Department dep = new Department(null, "TESTE123");
        departmentDao.insert(dep);
        department1 = departmentDao.findById(dep.getId());
        System.out.print("Registered : " + department1);
        System.out.println("\n==============================================");

        System.out.println("\n\n==============================================");
        System.out.println("=== TEST N 4 -- Delete By Id Departments ===");
        departmentDao.deleteById(10);
        System.out.println("==============================================");

        System.out.println("\n\n==============================================");
        System.out.println("=== TEST N 5 -- Update By Id Departments ===");
        department1 = departmentDao.findById(9);
        department1.setName("Informatica");
        departmentDao.update(department1);
        System.out.println("==============================================");


    }
}
