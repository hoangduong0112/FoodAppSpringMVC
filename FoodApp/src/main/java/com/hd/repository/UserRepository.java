/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.hd.repository;

import com.hd.pojo.User;
import java.util.List;

/**
 *
 * @author Duong Hoang
 */
public interface UserRepository {

    User getUserByUsername(String username);
    List<User> getUsers();
    boolean saveUser(User u);
}
