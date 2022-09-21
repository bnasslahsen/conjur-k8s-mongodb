package org.cyberark.conjur.demo;

/**
 * @author bnasslahsen
 */

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	private UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping("/users")
	public List<User> list() {
		return userRepository.findAll();
	}

	@PostMapping("/user")
	public void create(User user) {
		userRepository.save(user);
	}

}