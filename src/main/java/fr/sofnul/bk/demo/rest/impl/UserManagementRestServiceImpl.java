package fr.sofnul.bk.demo.rest.impl;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.sofnul.bk.demo.bo.Users;
import fr.sofnul.bk.demo.component.impl.UserManagmentComponentImpl;
import fr.sofnul.bk.demo.rest.IUserManagementRestService;
import fr.sofnul.bk.demo.service.IUserManagmentService;

@Service
@Path("users")
public class UserManagementRestServiceImpl implements IUserManagementRestService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserManagmentComponentImpl.class);

	@Autowired
	public IUserManagmentService userManagmentService;

	@Override
	@GET
	@Path("test")
	@Produces(MediaType.TEXT_PLAIN)
	public String test() {
		return "test";
	}

	@GET
	@Path("getUsers")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Users> getUsers() {
		return userManagmentService.getUsers();
	}
}
