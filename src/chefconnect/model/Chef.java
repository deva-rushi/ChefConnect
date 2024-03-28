/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chefconnect.model;

import chefconnect.collections.ArrayBag;

/**
 *
 * @author rakadadevarushikamidi
 */
public class Chef {
    private String name;
    private String userName;
    private String password;
    private ArrayBag<String> itemsList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayBag<String> getItemsList() {
        return itemsList;
    }

    public void setItemsList(ArrayBag<String> itemsList) {
        this.itemsList = itemsList;
    }
    
}

