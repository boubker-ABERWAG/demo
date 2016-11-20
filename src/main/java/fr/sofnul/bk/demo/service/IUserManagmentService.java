package fr.sofnul.bk.demo.service;

import java.util.List;

import fr.sofnul.bk.demo.bo.Users;
import fr.sofnul.bk.fmk.service.IService;

public interface IUserManagmentService extends IService {

	public List<Users> getUsers();

}
