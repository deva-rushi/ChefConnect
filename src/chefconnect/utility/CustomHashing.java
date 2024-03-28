/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chefconnect.utility;

/**
 *
 * @author rakadadevarushikamidi
 */
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CustomHashing {
    public static void main(String[] args) {
        String password = "user_password";
        String hashedPassword = customHash(password);
        System.out.println("Hashed Password: " + hashedPassword);
    }

    public static String customHash(String password) {
        try {
            // Create MessageDigest instance for SHA-256
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            // Add password bytes to digest
            md.update(password.getBytes());

            // Get the hash's bytes
            byte[] bytes = md.digest();

            // Convert bytes to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }

            // Get complete hashed password in hexadecimal format
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public static boolean verifyPassword(String enteredPassword, String hashedPassword) {
        // Hash the entered password using the same method
        String hashedEnteredPassword = customHash(enteredPassword);
        
        // Compare the hashed entered password with the stored hashed password
        return hashedEnteredPassword.equals(hashedPassword);
    }
}
