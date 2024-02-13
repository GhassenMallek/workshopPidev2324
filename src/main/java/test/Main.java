package test;

import models.BankAccount;
import models.User;
import services.BookServices;
import services.UserService;

import java.sql.SQLException;

public class Main {


    public static void main(String[] args) {
        UserService ps = new UserService();
        BookServices bs = new BookServices();

        User p1 = new User(10,24, "Ghassen");



        try {
            ps.add(p1);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
      
       try {
           ps.update(new User(1, 24, "GhassenMallek"));
       } catch (SQLException e) {
           e.printStackTrace();
       }

        try {
            System.out.println(ps.getAll());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        try {
            System.out.println(ps.getById(p1.getId()));
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }

        try {
            bs.add(new BankAccount(1000,p1));
        }catch (SQLException e){
            System.err.println("add book error : " + e.getMessage());
        }

    }
}
