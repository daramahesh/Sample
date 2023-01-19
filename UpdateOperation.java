package com.JA.test;

public class UpdateOperation {
    public static void main(String[] args) {
        EmployeeDemo ed = new EmployeeDemo();
        ed.connect();
        Employee e = new Employee();
        ed.update(e);
    }
}
