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
public class UserDirectory {
    
    private ArrayBag<User> userList;

    public UserDirectory() {
        this.userList = new ArrayBag<User>();     
    }
   
    public User addUser(){
        User user = new User();
        userList.add(user);
        return user;
    }
    
    public void deleteUser(User user){
        userList.remove(user);
    }
    
    
}