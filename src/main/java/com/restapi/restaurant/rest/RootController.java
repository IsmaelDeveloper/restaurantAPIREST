package com.restapi.restaurant.rest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController {

	@GetMapping("/")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void rootUri(final HttpServletRequest request, final HttpServletResponse response) {
		String rootUri = request.getRequestURL().toString();
		
		response.addHeader("Link", "<" + rootUri + "restaurants>; rel=\"restaurants\"");
	}
}
