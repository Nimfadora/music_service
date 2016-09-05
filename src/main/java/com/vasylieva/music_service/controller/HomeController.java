package com.vasylieva.music_service.controller;

import java.security.Principal;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<String> index(Principal principal) {
		return new ResponseEntity<String>("Hello World!", HttpStatus.OK);
	}
}
