package com.appsdeveloperblog.app.ws.ui.controllers;

import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.request.UpdateUserDetailsRequestModel;
import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;
import com.appsdeveloperblog.app.ws.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * REST Controller encargado de gestionar las operaciones relacionadas con los usuarios.
 * Permite obtener, crear, modificar y eliminar usuarios mediante servicios REST.
 */
@RestController
public class UserController {

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	/**
	 * Obtiene la lista de usuarios.
	 */
	@GetMapping("/users")
	public ResponseEntity<String> getUsers(
			@RequestParam(value = "page", defaultValue = "1") int page,
			@RequestParam(value = "limit", defaultValue = "50") int limit,
			@RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {

		log.info("Request received to get users - page: {}, limit: {}, sort: {}", page, limit, sort);

		String mensaje = "getUsers was called with page = " + page + " and limit = " + limit;

		return ResponseEntity.ok(mensaje);
	}

	/**
	 * Obtiene un usuario por ID.
	 */
	@GetMapping(
			path = "/users/{userId}",
			produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<UserRest> getUser(@PathVariable String userId) {

		log.info("Request received to get user with id: {}", userId);

		UserRest returnValue = new UserRest();

		returnValue.setUserId(userId);
		returnValue.setFirstName("Antonio");
		returnValue.setLastName("Angeles");
		returnValue.setEmail("antonio@email.com");

		return ResponseEntity.ok(returnValue);
	}

	/**
	 * Crea un nuevo usuario.
	 */
	@PostMapping(
			path = "/users",
			consumes = { MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailsRequestModel userDetails) {

		log.info("Create user called");
		log.info("First name: {}", userDetails.getFirstName());
		log.info("Last name: {}", userDetails.getLastName());
		log.info("Email: {}", userDetails.getEmail());

		// 🔥 AQUÍ ESTÁ EL CAMBIO IMPORTANTE
		UserRest returnValue = userService.createUser(userDetails);

		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);
	}

	/**
	 * Actualiza un usuario.
	 */
	@PutMapping(
			path = "/users/{userId}",
			consumes = { MediaType.APPLICATION_JSON_VALUE },
			produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<UserRest> updateUser(
			@PathVariable String userId,
			@RequestBody UpdateUserDetailsRequestModel userDetails) {

		log.info("Request received to update user with id: {}", userId);

		UserRest returnValue = new UserRest();

		returnValue.setUserId(userId);
		returnValue.setFirstName(userDetails.getFirstName());
		returnValue.setLastName(userDetails.getLastName());

		return ResponseEntity.ok(returnValue);
	}

	/**
	 * Elimina un usuario.
	 */
	@DeleteMapping(path = "/users/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable String id) {

		log.info("Request received to delete user with id: {}", id);

		return ResponseEntity.noContent().build();
	}
}