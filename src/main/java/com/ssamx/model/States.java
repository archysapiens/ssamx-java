package com.ssamx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name = "states")
public class States {
	
	@Id
	@Column(name="id", length=2)
	private String Id;
	
	@Column(name="name", length=100)
	private String Name;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}
	
}
