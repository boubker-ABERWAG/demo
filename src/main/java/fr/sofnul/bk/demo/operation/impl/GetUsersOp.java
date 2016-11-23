package fr.sofnul.bk.demo.operation.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fr.sofnul.bk.demo.dao.IUserDao;
import fr.sofnul.bk.demo.operation.IGetUserOp;
import fr.sofnul.bk.fmk.operation.impl.AbstractOperation;

public class GetUsersOp extends AbstractOperation implements IGetUserOp {

	private static final Logger LOGGER = LoggerFactory.getLogger(GetUsersOp.class);

	@Override
	public void checkParameters(Object... params) {
	}

	@Override
	public Object process(Object... params) {
		return getDao(IUserDao.class).findAll();
	}
}
