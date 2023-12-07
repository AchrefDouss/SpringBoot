package com.poly.gestioncatalogue5gr1.security.service;

import com.poly.gestioncatalogue5gr1.security.entities.AppRole;
import com.poly.gestioncatalogue5gr1.security.entities.AppUser;
import com.poly.gestioncatalogue5gr1.security.repository.RoleRepository;
import com.poly.gestioncatalogue5gr1.security.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@AllArgsConstructor
@Service
@Transactional
public class GestionIAccountService implements IAccountService{
    private RoleRepository roleRepository;
    private UserRepository userRepository;
    PasswordEncoder passwordEncoder;
    @Override
    public void addRole(String role) {
        //roleRepository.save(new AppRole(role));
        roleRepository.save(AppRole.builder().role(role).build());

    }

    @Override
    public void addUser(String userName, String passWord, String mail) {
        AppUser user = getUserByUserName(userName);
        if(user != null)
            throw new RuntimeException("User Exist");
    userRepository.save(AppUser.builder()
            .id(UUID.randomUUID().toString())
            .email(mail)
            .userName(userName)
            .password(passwordEncoder.encode(passWord))
            .build());
    }

    @Override
    public void addRoleToUser(String userName, String role) {
        AppUser user=getUserByUserName(userName);
        AppRole rol = roleRepository.findById(role).orElse(null);
        user.getRoles().add(rol);

    }

    @Override
    public AppUser getUserByUserName(String userName) {
        return userRepository.findAppUserByUserName(userName);
    }
}
