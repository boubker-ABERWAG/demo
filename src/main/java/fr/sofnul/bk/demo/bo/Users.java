package fr.sofnul.bk.demo.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.sofnul.bk.fmk.bo.IObjectBaseBO;

@Entity
@Table(name = "users")
public class Users extends IObjectBaseBO<Long> {

	private static final long serialVersionUID = 8351589422392310534L;

	@Id
	@GeneratedValue
	private Integer id;
	@Column
	private String name;
	@Column
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
