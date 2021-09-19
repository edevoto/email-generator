package com.enzoPractica.model;


import com.enzoPractica.Email;

public class EmailApp {



    public static void main(String[] args) {
        try {
            Email email = new Email("Edev" , "Java");
            System.out.println(email.showInfo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
