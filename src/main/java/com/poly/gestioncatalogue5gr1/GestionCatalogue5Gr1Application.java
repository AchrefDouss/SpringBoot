package com.poly.gestioncatalogue5gr1;


import com.poly.gestioncatalogue5gr1.dao.CategorieRepository;
import com.poly.gestioncatalogue5gr1.dao.ProduitRepository;
import com.poly.gestioncatalogue5gr1.entities.Categorie;

import com.poly.gestioncatalogue5gr1.security.service.GestionIAccountService;
import com.poly.gestioncatalogue5gr1.security.service.IAccountService;
import lombok.AllArgsConstructor;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@SpringBootApplication
@AllArgsConstructor
public class GestionCatalogue5Gr1Application implements CommandLineRunner{
   // @Autowired
    private ProduitRepository produitRepository;
   // @Autowired
    private CategorieRepository categorieRepository;
    public static void main(String[] args) {
        SpringApplication.run(GestionCatalogue5Gr1Application.class, args);    }
    @Override
    public void run(String... args) throws Exception {

    }
    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    //@Bean
    CommandLineRunner commandLineRunner(IAccountService accountService){
        return args ->{
            accountService.addRole("ADMIN");
            accountService.addRole("USER");
            accountService.addUser("user","123","user@gmail.com");
            accountService.addUser("admin","123","admin@gmail.com");

            accountService.addRoleToUser("user","USER");
            accountService.addRoleToUser("admin","ADMIN");
            accountService.addRoleToUser("admin","USER");
        };
    }
}
