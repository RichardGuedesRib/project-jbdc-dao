package application;

import dao.DaoFactory;
import dao.SellerDao;
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

        SellerDao sellerdao = DaoFactory.createSellerDao();

        Seller seller = sellerdao.findById(2);
        System.out.println(seller);
    }
}
