package com.restapi.restaurant.services;

import java.util.List;
import java.util.Map;

import com.restapi.restaurant.models.Restaurant;

public interface RestaurantService {
	
	public List<Restaurant> findAll();

	public Restaurant findById(String id);

	public String create(Restaurant restaurant);

	public void update(String identifiant, Restaurant restaurant);

	public void partialUpdate(String identifiant, Map<String, Object> updates);

	public void deleteById(String identifiant);

}
