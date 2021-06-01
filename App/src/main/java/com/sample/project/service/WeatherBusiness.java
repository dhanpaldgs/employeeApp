package com.sample.project.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sample.project.exception.WeatherException;
import com.sample.project.model.CityInfo;
import com.sample.project.model.WeatherInfo;

@Service
public class WeatherBusiness {

	@Autowired
	RestTemplate restTemplate;

	public ResponseEntity<List<String>> getCityList(String name) throws WeatherException {

		try {
			ResponseEntity<WeatherInfo> weatherInfo = restTemplate.getForEntity(
					"https://samples.openweathermap.org/data/2.5/box/city?bbox=12,32,15,37,10&appid=b6907d289e10d714a6e88b30761fae22",
					WeatherInfo.class);

			if (weatherInfo.getStatusCode().is2xxSuccessful()) {

				List<CityInfo> list = weatherInfo.getBody().getList();
				List<String> list1 = list.stream().map(p -> p.getName()).filter(p -> p.startsWith(name))
						.collect(Collectors.toList());
				return new ResponseEntity<List<String>>(list1, HttpStatus.OK);
			} else {
				throw new WeatherException("Error while geting data from api", HttpStatus.INTERNAL_SERVER_ERROR);
			}
		} catch (Exception e) {
			System.out.println(e);
			throw new WeatherException("Some expetion occured", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}