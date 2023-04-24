package it.w06.d05.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import it.w06.d05.auth.entity.ERole;
import it.w06.d05.auth.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}
