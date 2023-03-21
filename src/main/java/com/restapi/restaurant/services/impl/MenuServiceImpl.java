package com.restapi.restaurant.services.impl;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restapi.restaurant.dao.MenuRepository;
import com.restapi.restaurant.dao.RestaurantRepository;
import com.restapi.restaurant.models.Menu;
import com.restapi.restaurant.models.Restaurant;
import com.restapi.restaurant.services.MenuService;

@Service
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private RestaurantRepository restoRepository;

	@Autowired
	private MenuRepository menuRepository;

	@Override
	public Set<Menu> findAllOfRestaurant(String idRestaurant) {
		return restoRepository.findById(idRestaurant).get().getMenus();
	}

	@Override
	public Menu findById(String id) {
		if(menuRepository.findById(id).isPresent()) {
			return menuRepository.findById(id).get();
		}
		return null;
	}

	@Override
	public String create(String idRestaurant, Menu menu) {
		Restaurant restoEntity = restoRepository.findById(idRestaurant).get();
		restoEntity.getMenus().add(menu);
		restoRepository.save(restoEntity);
		Menu menuEntity = restoEntity.getMenus().stream().filter(m -> m.equals(menu)).findFirst().get();
		return menuEntity.getIdentifiant();
	}

	@Override
	public void update(String id, Menu menu) {
		menu.setIdentifiant(id);
		menuRepository.save(menu);
	}

	@Override
	public void partialUpdate(String id, Map<String, Object> updates) {
		Menu menuToUpdate = menuRepository.findById(id).get();
		for (String key : updates.keySet()) {
			switch (key) {
			case "entrees": {
				menuToUpdate.setEntrees((String) updates.get(key));
				break;
			}
			case "plats": {
				menuToUpdate.setPlats((String) updates.get(key));
				break;
			}
			case "desserts": {
				menuToUpdate.setDesserts((String) updates.get(key));
				break;
			}
			}
			
		}
		menuRepository.save(menuToUpdate);
	}

	@Override
	public void deleteById(String idRestaurant, String idMenu) {
		Restaurant restoToUpdate = restoRepository.findById(idRestaurant).get();
		Set<Menu> menus = restoToUpdate.getMenus();
		Menu menu = menus.stream().filter(m -> m.getIdentifiant().equals(idMenu)).findFirst().get();
		menus.remove(menu);
		restoToUpdate.setMenus(menus);
		restoRepository.save(restoToUpdate);
		menuRepository.delete(menu);
	}

}
