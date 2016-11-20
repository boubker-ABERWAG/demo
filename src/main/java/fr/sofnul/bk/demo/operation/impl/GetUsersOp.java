package fr.sofnul.bk.demo.operation.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.sofnul.bk.demo.bo.Users;
import fr.sofnul.bk.demo.dao.IUserDao;
import fr.sofnul.bk.demo.operation.IGetUserOp;
import fr.sofnul.bk.fmk.operation.impl.AbstractOperation;

public class GetUsersOp extends AbstractOperation implements IGetUserOp {

	private static final Logger LOGGER = LoggerFactory.getLogger(GetUsersOp.class);

	@Override
	public void checkParameters() {
	}

	@Override
	public List<Users> process() {
		return getDao(IUserDao.class).findAll();
	}
}
