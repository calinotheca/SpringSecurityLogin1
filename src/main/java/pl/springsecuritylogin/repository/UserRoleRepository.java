package pl.springsecuritylogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.springsecuritylogin.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
	UserRole findByRole(String role);
}
