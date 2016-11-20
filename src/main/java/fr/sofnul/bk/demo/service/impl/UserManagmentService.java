package fr.sofnul.bk.demo.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.sofnul.bk.demo.bo.Users;
import fr.sofnul.bk.demo.component.IUserManagmentComponent;
import fr.sofnul.bk.demo.service.IUserManagmentService;
import fr.sofnul.bk.fmk.service.impl.AbstractService;

// @Path("users")
public class UserManagmentService extends AbstractService implements IUserManagmentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserManagmentService.class);

	// @GET
	// @Path("getUsers")
	// @Produces(MediaType.APPLICATION_JSON)
	@Override
	public List<Users> getUsers() {
		return getComponent(IUserManagmentComponent.class).getUsers();
	}
}