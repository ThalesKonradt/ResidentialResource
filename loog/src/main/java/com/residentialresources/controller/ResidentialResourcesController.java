package com.residentialresources.controller;

import javax.validation.ConstraintViolationException;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.residentialresources.model.ResponseData;
import com.residentialresources.service.ResidentialResourcesService;

@RestController
@Validated
@RequestMapping("/api/v1/property")//http://localhost:8080/api/v1/property/filter
public class ResidentialResourcesController {

	@Autowired
	private ResidentialResourcesService service;

	@GetMapping(value = "/filter", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ResponseData> getPropertys(
			@RequestParam(defaultValue = "") @Pattern(regexp = "^[0-9]+$|^$|^\\s$") String dormitoriesNumber,
			@RequestParam(defaultValue = "") @Pattern(regexp = "^$|(?i)true|false(?-i)") String hasPool)
			throws JsonProcessingException {
		return ResponseEntity.ok().body(service.filterPropertyList(dormitoriesNumber, hasPool));
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
		//em cenario de producao nao retornaria dados da exception por questoes de seguranca.
		return new ResponseEntity<>("not valid due to validation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	}
}





