package com.sample.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sample.project.exception.WeatherException;
import com.sample.project.service.WeatherBusiness;

@RestController("/")
@CrossOrigin("http://localhost:3000")
public class Weather {

	@Autowired
	WeatherBusiness weatherBusiness;

	@GetMapping(value = "search/{name}")
	public ResponseEntity<List<String>> searchCity(@PathVariable("name") String name) throws WeatherException {

		return weatherBusiness.getCityList(name);
	}

	@GetMapping(value = "hello")
	public String getHello() {
		return "hello";
	}

}
