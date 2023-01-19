package com.JA.test;

import java.sql.*;
import java.util.Scanner;

public class EmployeeDemo {
    Connection con;
    Scanner sc = new Scanner(System.in);
    public void connect() {
        try {
            con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","mahesh","mahesh");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void insert(Employee e) {
        System.out.println("Enter id:");
        e.setEid(sc.nextInt());
        System.out.println("Enter name:");
        e.setEname(sc.next());
        System.out.println("Enter salary:");
        e.setEsalary(sc.nextDouble());
        System.out.println("Enter designation:");
        e.setEdesignation(sc.next());
        try {
            PreparedStatement pst = con.prepareStatement("insert into employees values(?,?,?,?)");
            pst.setInt(1,e.getEid());
            pst.setString(2,e.getEname());
            pst.setDouble(3,e.getEsalary());
            pst.setString(4,e.getEdesignation());
            int n = pst.executeUpdate();
            pst.close();
            con.close();
            if(n != 0) {
                System.out.println("Record is inserted");
            }else {
                System.out.println("Record is not inserted");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void update(Employee e) {
        System.out.println("Enter id to update:");
        e.setEid(sc.nextInt());
        System.out.println("Enter name to be updated:");
        e.setEname(sc.next());
        System.out.println("Enter salary to be updated:");
        e.setEsalary(sc.nextDouble());
        System.out.println("Enter designation to be updated:");
        e.setEdesignation(sc.next());
        try {
            PreparedStatement pst = con.prepareStatement("update employees set name=?, salary=?, designation=? where id = ?");
            pst.setString(1,e.getEname());
            pst.setDouble(2,e.getEsalary());
            pst.setString(3,e.getEdesignation());
            pst.setInt(4,e.getEid());
            int n = pst.executeUpdate();
            pst.close();
            con.close();
            if(n != 0) {
                System.out.println("Record is updated");
            }else {
                System.out.println("Record is not updated");
            }
        } catch (SQLException exe) {
            exe.printStackTrace();
        }
    }
    public void delete(Employee e) {
        System.out.println("Enter id to delete a row: ");
        e.setEid(sc.nextInt());
        try {
            PreparedStatement pst = con.prepareStatement("delete from employees where id = ?");
            pst.setInt(1,e.getEid());
            int n = pst.executeUpdate();
            pst.close();
            con.close();
            if(n != 0) {
                System.out.println("Record is deleted");
            }else {
                System.out.println("Record is not deleted");
            }

        } catch (SQLException s) {
            s.printStackTrace();
        }
    }
    public void getAllEmployees() {
        try {
            PreparedStatement pst = con.prepareStatement("select * from employees");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDouble(3)+" "+rs.getString(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
