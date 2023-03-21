package com.restapi.restaurant.dao;

import org.springframework.data.repository.CrudRepository;

import com.restapi.restaurant.models.Menu;

public interface MenuRepository extends CrudRepository<Menu, String> {
}
