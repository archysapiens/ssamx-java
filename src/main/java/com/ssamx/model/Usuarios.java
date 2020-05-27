package com.ssamx.model;

import javax.persistence.Entity;
import javax.persistence.Column;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Usuarios {
	
	@Id
	@Column(name="Id", length=50)
	String id;
	@Column(name="nombre", length=100)
	String nombre;
	@Column(name="app_paterno", length=100)
	String app_paterno;
	@Column(name="app_materno", length=100)
	String app_materno;
	@Column(name="sexo", length=1)
	String sexo;
	@Column(name="edad", length=2 )
	int edad;
	@Column(name="fecha_nacimiento", length=10 )
	String fecha_nacimiento;
	@Column(name="foto", length=100 )
	String foto;
	@Column(name="tel_oficina", length=20 )
	String tel_oficina;
	@Column(name="extension", length=10 )
	String extension;
	@Column(name="tel_mobil", length=20 )
	String tel_mobil;
	@Column(name="organismos", length=2 )
	String organismos;
	@Column(name="unidad_responsable", length=3 )
	String unidad_responsable;
	@Column(name="credenciales", length=20 )
	String credenciales;
	@Column(name="pregunta", length=100 )
	String pregunta;
	@Column(name="respuesta", length=100 )
	String respuesta;
	@Column(name="password", length=100 )
	String password;
	@Column(name="cargo", length=100 )
	String cargo;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public int getEdad() {
		return edad;
	}
	public void setEdad(int edad) {
		this.edad = edad;
	}
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getFoto() {
		return foto;
	}
	public void setFoto(String foto) {
		this.foto = foto;
	}
	public String getTel_oficina() {
		return tel_oficina;
	}
	public void setTel_oficina(String tel_oficina) {
		this.tel_oficina = tel_oficina;
	}
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public String getTel_mobil() {
		return tel_mobil;
	}
	public void setTel_mobil(String tel_mobil) {
		this.tel_mobil = tel_mobil;
	}
	public String getOrganismos() {
		return organismos;
	}
	public void setOrganismos(String organismos) {
		this.organismos = organismos;
	}
	public String getUnidad_responsable() {
		return unidad_responsable;
	}
	public void setUnidad_responsable(String unidad_responsable) {
		this.unidad_responsable = unidad_responsable;
	}
	public String getCredenciales() {
		return credenciales;
	}
	public void setCredenciales(String credenciales) {
		this.credenciales = credenciales;
	}
	public String getPregunta() {
		return pregunta;
	}
	public void setPregunta(String pregunta) {
		this.pregunta = pregunta;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	

	
}
