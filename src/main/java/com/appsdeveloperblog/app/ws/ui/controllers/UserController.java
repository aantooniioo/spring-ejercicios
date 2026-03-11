package com.appsdeveloperblog.app.ws.ui.controllers;

import com.appsdeveloperblog.app.ws.ui.model.request.UserDetailsRequestModel;

import com.appsdeveloperblog.app.ws.ui.model.request.UpdateUserDetailsRequestModel;

import com.appsdeveloperblog.app.ws.ui.model.response.UserRest;

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

	// Logger para registrar eventos en la aplicación

	private static final Logger log = LoggerFactory.getLogger(UserController.class);

	/**

	 * Obtiene la lista de usuarios.

	 *

	 * @param page  número de página solicitada

	 * @param limit número de registros por página

	 * @param sort  tipo de ordenación

	 * @return mensaje indicando los parámetros recibidos

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

	 * Obtiene los datos de un usuario concreto a partir de su ID.

	 *

	 * @param userId identificador del usuario

	 * @return objeto UserRest con los datos del usuario

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

	 * Crea un nuevo usuario a partir de los datos enviados en el cuerpo de la petición.

	 *

	 * @param userDetails datos del usuario enviados en formato JSON

	 * @return usuario creado con un ID generado

	 */

	@PostMapping(

			path="/users",

			consumes = { MediaType.APPLICATION_JSON_VALUE },

			produces = { MediaType.APPLICATION_JSON_VALUE })

	public ResponseEntity<UserRest> createUser(@RequestBody UserDetailsRequestModel userDetails) {

		System.out.println("Create user called");

		System.out.println("First name: " + userDetails.getFirstName());

		System.out.println("Last name: " + userDetails.getLastName());

		System.out.println("Email: " + userDetails.getEmail());

		UserRest returnValue = new UserRest();

		returnValue.setFirstName(userDetails.getFirstName());

		returnValue.setLastName(userDetails.getLastName());

		returnValue.setEmail(userDetails.getEmail());

		returnValue.setUserId("generatedUserId");

		return ResponseEntity.status(HttpStatus.CREATED).body(returnValue);

	}

	/**

	 * Actualiza los datos de un usuario existente.

	 *

	 * @param userId identificador del usuario a modificar

	 * @param userDetails nuevos datos del usuario

	 * @return usuario actualizado

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

	 * Elimina un usuario a partir de su identificador.

	 *

	 * @param id identificador del usuario a eliminar

	 * @return respuesta HTTP 204 (No Content)

	 */

	@DeleteMapping(path = "/users/{id}")

	public ResponseEntity<Void> deleteUser(@PathVariable String id) {

		log.info("Request received to delete user with id: {}", id);

		return ResponseEntity.noContent().build();

	}

}
