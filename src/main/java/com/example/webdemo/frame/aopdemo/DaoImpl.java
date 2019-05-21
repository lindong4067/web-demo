package com.example.webdemo.frame.aopdemo;

public class DaoImpl implements Dao {
    @Override
    public void select() {
        System.out.println("Query execution...");
    }

    @Override
    public void insert() {
        System.out.println("Insert execution...");
    }
}
