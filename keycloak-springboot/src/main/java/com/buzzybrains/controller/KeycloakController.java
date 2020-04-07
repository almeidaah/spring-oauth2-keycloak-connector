package com.buzzybrains.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.buzzybrains.model.UserCredentials;
import com.buzzybrains.model.UserDTO;
import com.buzzybrains.services.KeyCloakService;

@RestController
@RequestMapping(value = "/keycloak")
public class KeycloakController {

	@Autowired
	KeyCloakService keyClockService;

	/*
	 * Creating user in keycloak passing UserDTO contains username, emailid,
	 * password, firtname, lastname
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
		try {

			keyClockService.createUserInKeyCloak(userDTO);
			return new ResponseEntity<>(HttpStatus.OK);
		}

		catch (Exception ex) {

			ex.printStackTrace();
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

		}

	}
}
