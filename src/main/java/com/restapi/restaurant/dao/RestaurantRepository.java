package com.restapi.restaurant.dao;

import org.springframework.data.repository.CrudRepository;

import com.restapi.restaurant.models.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, String> {
}
