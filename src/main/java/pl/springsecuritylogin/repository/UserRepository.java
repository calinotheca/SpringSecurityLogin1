package pl.springsecuritylogin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.springsecuritylogin.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
}
