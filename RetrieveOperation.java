package com.JA.test;

public class RetrieveOperation {
    public static void main(String[] args) {
        EmployeeDemo ed = new EmployeeDemo();
        ed.connect();
        ed.getAllEmployees();
    }
}
