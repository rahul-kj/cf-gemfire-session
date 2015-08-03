package io.rahul.controller;

import java.io.Serializable;

import io.rahul.domain.User;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.WebApplicationContext;

@RestController
@RequestMapping(value = "/")
@Scope(value = WebApplicationContext.SCOPE_SESSION)
public class UserController implements Serializable {

	private User user = new User();

	@RequestMapping(method = RequestMethod.POST)
	public String saveUser(@RequestBody(required = true) User user) {
		this.user = user;
		return "SUCCESS";
	}

	@RequestMapping(produces = "application/json", method = RequestMethod.GET)
	public User getUser() {
		System.out.println(user);
		return user;
	}

}
