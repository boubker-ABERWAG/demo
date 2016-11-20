package fr.sofnul.bk.demo.component;

import java.util.List;

import fr.sofnul.bk.demo.bo.Users;
import fr.sofnul.bk.fmk.component.IComponent;

public interface IUserManagmentComponent extends IComponent {
	public List<Users> getUsers();
}
