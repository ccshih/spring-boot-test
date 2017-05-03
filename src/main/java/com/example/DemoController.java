package com.example;

import java.io.UnsupportedEncodingException;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@RequestMapping("/test")
public class DemoController {
	private static final Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@RequestMapping(value = "/check", 
			method = { RequestMethod.GET }, 
			produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody ResponseEntity<?> check(@RequestParam String id) 
    		throws UnsupportedEncodingException, JsonProcessingException, KeyManagementException, NoSuchAlgorithmException {		
		if (id.equalsTo("pass")) {			
			return ResponseEntity.accepted().build();
		}
		else {
			return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(null);
		}
    }
		
}
