package org.cyberark.conjur.demo;

/**
 * @author bnasslahsen
 */

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type User controller.
 */
@RestController
public class UserController {
	/**
	 * The User repository.
	 */
	private UserRepository userRepository;

	/**
	 * Instantiates a new User controller.
	 *
	 * @param userRepository the user repository
	 */
	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 * List list.
	 *
	 * @return the list
	 */
	@GetMapping("/users")
	public List<User> list() {
		return userRepository.findAll();
	}

	/**
	 * Create.
	 *
	 * @param user the user
	 */
	@PostMapping("/user")
	public void create(User user) {
		userRepository.save(user);
	}

}