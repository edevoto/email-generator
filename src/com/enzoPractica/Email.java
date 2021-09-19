package com.enzoPractica;

import com.enzoPractica.EmailUtils.EmailConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int defaultPasswordLength = 10;
    private String alternateEmail;
    private int mailboxCapacity;
    private List<String> savedEmails;

    public Email(String firstName, String lastName) {
        try {
            this.firstName = firstName;
            this.lastName = lastName;
            this.department = setDepartment();
            this.password = randomPassword(defaultPasswordLength);
            this.email = firstName.toLowerCase(Locale.ROOT) + "." + lastName.toLowerCase(Locale.ROOT) + "@" + department + "." + EmailConstants.COMPANY_SUFFIX;
            this.alternateEmail = setAlternatedEmail(alternateEmail) + "." + lastName.toLowerCase(Locale.ROOT) + "@" + department + "." + EmailConstants.COMPANY_SUFFIX;
            this.savedEmails = saveEmail(alternateEmail);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String showInfo() {
        return "Display name: " + firstName + " " + lastName + "\n" +
                "Company email: " + email + "\n" +
                "Password: " + password + "\n" +
                "Mailbox capaity: " + mailboxCapacity + " mb\n" +
                "Saved Emails: " + savedEmails;
    }

    private String setDepartment() throws Exception {
        try {
            System.out.println("Entrer\n1 for sales\n2 for develompent\n3 for Accounting\n0 for none\nEnter department code: ");
            Scanner in = new Scanner(System.in);
            int departmentChoice = in.nextInt();
            if (departmentChoice == 1) {
                return "sales";
            } else if (departmentChoice == 2) {
                return "dev";
            } else if (departmentChoice == 3) {
                return "account";
            } else {
                return EmailConstants.EXCEPTION_SCANNER;
            }
        } catch (Exception e) {
            throw new Exception(EmailConstants.EXCEPTION_SCANNER);
        }
    }

    private String randomPassword(int length) {
        String passwordSet = "abcdefghijklmnopqrstuvwxyz1234567890!@#$%";
        char[] password = new char[length];
        for (int iterator = 0; iterator < length; iterator++) {
            int passGenerator = (int) (Math.random() * passwordSet.length());
            password[iterator] = passwordSet.charAt(passGenerator);
        }
        return new String(password);
    }

    private String setAlternatedEmail(String email) {
        System.out.println("Set a new alternate email");
        Scanner emails = new Scanner(System.in);
        String newEmail = emails.next();
        return alternateEmail = newEmail;
    }

    private List<String> saveEmail(String savedEmail) throws Exception {
        List<String> emails = new ArrayList<>();
        try {
            emails.add(email);
            setAlternateEmail(savedEmail);
            emails.add(alternateEmail);

        } catch (Exception e) {
            throw new Exception(EmailConstants.EXCEPTION_SCANNER, e);
        }
        return emails;
    }

}
