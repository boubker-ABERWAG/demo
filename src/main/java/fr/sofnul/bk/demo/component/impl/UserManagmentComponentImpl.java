package fr.sofnul.bk.demo.component.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.sofnul.bk.demo.bo.Users;
import fr.sofnul.bk.demo.component.IUserManagmentComponent;
import fr.sofnul.bk.demo.operation.IGetUserOp;
import fr.sofnul.bk.fmk.component.impl.AbstractComponent;

public class UserManagmentComponentImpl extends AbstractComponent implements IUserManagmentComponent {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserManagmentComponentImpl.class);

	@SuppressWarnings("unchecked")
	@Override
	public List<Users> getUsers() {
		return (List<Users>) getComponentOperation(IGetUserOp.class).process();
	}

}
