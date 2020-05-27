package com.ssamx.dto;

import java.io.Serializable;


public class SesionDTO implements Serializable  {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;

	private String nombre_usuario;
	
	private String app_paterno;
	
	private String app_materno;
	
	private String id_roles;
	
	private String descripcion;
	
	private String id;
	
	private String organismo;
	
	private String foto;
	
	private String idusu;

	public String getNombre_usuario() {
		return nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		this.nombre_usuario = nombre_usuario;
	}

	public String getApp_paterno() {
		return app_paterno;
	}

	public void setApp_paterno(String app_paterno) {
		this.app_paterno = app_paterno;
	}

	public String getApp_materno() {
		return app_materno;
	}

	public void setApp_materno(String app_materno) {
		this.app_materno = app_materno;
	}

	public String getId_roles() {
		return id_roles;
	}

	public void setId_roles(String id_roles) {
		this.id_roles = id_roles;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getOrganismo() {
		return organismo;
	}

	public void setOrganismo(String organismo) {
		this.organismo = organismo;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getIdusu() {
		return idusu;
	}

	public void setIdusu(String idusu) {
		this.idusu = idusu;
	}
	
	
	

}
