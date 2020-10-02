package pl.springsecuritylogin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import pl.springsecuritylogin.model.User;
import pl.springsecuritylogin.model.UserRole;
import pl.springsecuritylogin.repository.UserRepository;
import pl.springsecuritylogin.repository.UserRoleRepository;

@Controller
public class mainController {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRoleRepository userRoleRepository;

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/")
	public String sercuredPage() {
		return "/securedPage";

	}

	@GetMapping("/login")
	public String login() {
		if (userRoleRepository.count() == 0) {
			UserRole userRole = new UserRole("ADMIN", "Administrator");
			userRoleRepository.save(userRole);
		}

		if (userRepository.count() == 0) {
			String password = "1234abcd";
			String hashPassword = passwordEncoder.encode(password);
			UserRole userRole = userRoleRepository.findByRole("ADMIN");
			User user = new User("John", "Smith", "example@example.com", hashPassword, userRole);
			userRepository.save(user);
		}
		return "/login";
	}

}
