/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chefconnect.model;

import chefconnect.utility.CustomHashing;
import lombok.Data;

/**
 *
 * @author rakadadevarushikamidi
 */
@Data
public class User {
    
    private String Firstname;
    private String Lastname;
    private String Email;
    private String Username;
    private String Password;

    public static String hashPassword(String plainPassword) {
        return CustomHashing.customHash(plainPassword);
    }
    
    public static boolean checkPassword(String plainPassword, String hashedPassword) {
        return CustomHashing.verifyPassword(plainPassword, hashedPassword);       
    }

}

