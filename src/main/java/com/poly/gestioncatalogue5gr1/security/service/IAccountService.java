package com.poly.gestioncatalogue5gr1.security.service;

import com.poly.gestioncatalogue5gr1.security.entities.AppUser;

public interface IAccountService {
    public void addRole(String role);
    public void addUser(String userName,String passWord,String mail);
    public void addRoleToUser(String user,String role);
    public AppUser getUserByUserName(String userName);
}
