/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chefconnect.model;

import chefconnect.utility.CustomHashing;

/**
 *
 * @author rakadadevarushikamidi
 */
public class User {
    private String Firstname;
    private String Lastname;
    private String Email;
    private String Username;
    private String Password;

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
    
    public static String hashPassword(String plainPassword) {
        return CustomHashing.customHash(plainPassword);
    }
    
    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return CustomHashing.verifyPassword(plainPassword, hashedPassword);       
    }

}

