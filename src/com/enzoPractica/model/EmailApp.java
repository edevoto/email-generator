package com.enzoPractica.model;


import com.enzoPractica.Email;

import java.util.ArrayList;
import java.util.List;

public class EmailApp {



    public static void main(String[] args) {
        try {
            Email email = new Email("Edev" , "Java");
            List<String> listOfEmails = new ArrayList<>();
            listOfEmails.add(email.getAlternateEmail());
            email.setSavedEmails(listOfEmails);
            System.out.println(email.showInfo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
