package org.tinygroup.dalpractice.dataobject;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="org.tinygroup.dalpractice.dataobject.CustomDo")
@Table(name="custom")
public class CustomDo implements Serializable {

	private static final long serialVersionUID = 8869486729757172617L;
	@Id  
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	private int id;
	private String name;
	private int age;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
