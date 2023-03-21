package com.restapi.restaurant.services;

import java.util.Map;
import java.util.Set;

import com.restapi.restaurant.models.Menu;

public interface MenuService {
	
	public Set<Menu> findAllOfRestaurant(String idRestaurant);

	public Menu findById(String id);

	public String create(String idRestaurant, Menu menu);

	public void update(String id, Menu menu);

	public void partialUpdate(String id, Map<String, Object> updates);

	public void deleteById(String idRestaurant, String idMenu);

}
