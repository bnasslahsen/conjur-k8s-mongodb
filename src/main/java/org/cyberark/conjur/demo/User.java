package org.cyberark.conjur.demo;

/**
 * @author bnasslahsen
 */

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * The type User.
 */
@Document
@Getter
@Setter
@AllArgsConstructor
public class User {
	/**
	 * The Id.
	 */
	@Id
	private int id;

	/**
	 * The First name.
	 */
	private String firstName;

	/**
	 * The Last name.
	 */
	private String lastName;

}