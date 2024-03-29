/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chefconnect.model;

import chefconnect.collections.ArrayBag;
import lombok.Data;

/**
 *
 * @author rakadadevarushikamidi
 */
@Data
public class Chef {
    
    private String name;
    private String userName;
    private String password;
    private ArrayBag<String> itemsList;
    
}

