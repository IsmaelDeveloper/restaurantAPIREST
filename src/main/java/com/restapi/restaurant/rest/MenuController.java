package com.restapi.restaurant.rest;

import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restapi.restaurant.models.Menu;
import com.restapi.restaurant.services.MenuService;
import com.restapi.restaurant.services.RestaurantService;
import com.restapi.restaurant.util.CtrlPreconditions;

@RestController
public class MenuController {
	
	@Autowired
	public MenuService menuService;
	
	@Autowired
	public RestaurantService restoService;
	
	@GetMapping("/restaurants/{idResto}/menus")
	public Set<Menu> findAllOfRestaurant(@PathVariable("idResto") String idRestaurant) {
		CtrlPreconditions.checkFound(restoService.findById(idRestaurant));
		return menuService.findAllOfRestaurant(idRestaurant);
	}
	
	@GetMapping("/menus/{id}")
	public Menu findById(@PathVariable("id") String id) {
		Menu reponse = menuService.findById(id);
		CtrlPreconditions.checkFound(reponse);
		return reponse;
	}
	
	@PostMapping("/restaurants/{idResto}/menus")
	@ResponseStatus(code = HttpStatus.CREATED)
	public String create(@PathVariable("idResto") String idRestaurant, @RequestBody Menu menu) {
		CtrlPreconditions.checkFound(restoService.findById(idRestaurant));
		return menuService.create(idRestaurant, menu);
	}
	
	@PutMapping("/menus/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void update(@PathVariable("id") String id, @RequestBody Menu menu) {
		CtrlPreconditions.checkFound(menuService.findById(id));
		menuService.update(id, menu);
	}

	@PatchMapping("/menus/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public void partialUpdate(@PathVariable("id") String id, @RequestBody Map<String, Object> updates) {
		CtrlPreconditions.checkFound(menuService.findById(id));
		menuService.partialUpdate(id, updates);
	}

	@DeleteMapping("/restaurants/{idResto}/menus/{idMenu}")
	public void delete(@PathVariable("idResto") String idRestaurant, @PathVariable("idMenu") String idMenu) {
		CtrlPreconditions.checkFound(restoService.findById(idRestaurant));
		CtrlPreconditions.checkFound(menuService.findById(idMenu));
		menuService.deleteById(idRestaurant, idMenu);
	}
}
