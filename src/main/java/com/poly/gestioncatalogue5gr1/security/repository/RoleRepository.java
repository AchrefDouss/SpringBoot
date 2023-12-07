package com.poly.gestioncatalogue5gr1.security.repository;

import com.poly.gestioncatalogue5gr1.security.entities.AppRole;
import com.poly.gestioncatalogue5gr1.security.entities.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<AppRole,String> {

}
