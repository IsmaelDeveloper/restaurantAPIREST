package com.restapi.restaurant.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.restaurant.dao.RestaurantRepository;
import com.restapi.restaurant.models.Restaurant;
import com.restapi.restaurant.services.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	
	@Autowired
	private RestaurantRepository restoRepository;

	@Override
	public List<Restaurant> findAll() {
		List<Restaurant> liste = new ArrayList<Restaurant>();
		restoRepository.findAll().forEach(liste::add);
		return liste;
	}

	@Override
	public Restaurant findById(String id) {
		if(restoRepository.findById(id).isPresent()) {
			return restoRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public String create(Restaurant restaurant) {
		return restoRepository.save(restaurant).getId();
	}

	@Override
	public void update(String identifiant, Restaurant restaurant) {
		restaurant.setId(identifiant);
		restoRepository.save(restaurant);
	}

	@Override
	public void partialUpdate(String identifiant, Map<String, Object> updates) {
		Restaurant restoToUpdate = restoRepository.findById(identifiant).get();
		for (String key : updates.keySet()) {
			switch (key) {
			case "nom": {
				restoToUpdate.setNom((String) updates.get(key));
				break;
			}
			case "adresse": {
				restoToUpdate.setAdresse((String) updates.get(key));
				break;
			}
			}
		}
		restoRepository.save(restoToUpdate);
	}

	@Override
	public void deleteById(String identifiant) {
		restoRepository.deleteById(identifiant);
	}

}
