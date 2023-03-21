package com.restapi.restaurant.util;

import com.restapi.restaurant.exceptions.ResourceNotFoundException;

public final class CtrlPreconditions {

	public static <T> T checkFound(T object) {
		if(object == null) {
			throw new ResourceNotFoundException();
		}
		return object;
	}
	
}
