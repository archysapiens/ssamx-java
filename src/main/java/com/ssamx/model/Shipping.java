package com.ssamx.model;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Table(name = "shipping")
public class Shipping {
	
	@Id @GeneratedValue
	private int id;
	
	@Column(name="assign_date")
	@Temporal(TemporalType.DATE)
	private java.util.Date assign_date;
	
	@Column(name="update_date")
	@Temporal(TemporalType.DATE)
	private java.util.Date update_date;
	
	@Column(name="id_state",  length=2)
	private String id_state;
	
	@Column(name="stat",  length=1)
	private String stat;

	@Column(name="id_files")
	private int id_files;
	
	@Column(name="id_period")
	private int id_period;

	@Column(name="qna")
	private int qna;

	@Column(name="anio")
	private int anio;

	@Column(name="shipping_tag", length=32)
	private String shipping_tag;
	
	@Column(name="staging_d" , length=32)
	private String staging_d;

	@Column(name="staging_t" , length=32)
	private String staging_t;

	@Column(name="art74_fed" , length=1)
	private String art74_fed;
	
	
	public String getArt74_fed() {
		return art74_fed;
	}

	public void setArt74_fed(String art74_fed) {
		this.art74_fed = art74_fed;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public java.util.Date getAssign_date() {
		return assign_date;
	}

	public void setAssign_date(java.util.Date assign_date) {
		this.assign_date = assign_date;
	}

	public java.util.Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(java.util.Date update_date) {
		this.update_date = update_date;
	}

	public String getId_state() {
		return id_state;
	}

	public void setId_state(String id_state) {
		this.id_state = id_state;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public int getId_files() {
		return id_files;
	}

	public void setId_files(int id_files) {
		this.id_files = id_files;
	}

	public int getId_period() {
		return id_period;
	}

	public void setId_period(int id_period) {
		this.id_period = id_period;
	}

	public int getQna() {
		return qna;
	}

	public void setQna(int qna) {
		this.qna = qna;
	}

	public int getAnio() {
		return anio;
	}

	public void setAnio(int anio) {
		this.anio = anio;
	}

	public String getShipping_tag() {
		return shipping_tag;
	}

	public void setShipping_tag(String shipping_tag) {
		this.shipping_tag = shipping_tag;
	}

	public String getStaging_d() {
		return staging_d;
	}

	public void setStaging_d(String staging_d) {
		this.staging_d = staging_d;
	}

	public String getStaging_t() {
		return staging_t;
	}

	public void setStaging_t(String staging_t) {
		this.staging_t = staging_t;
	}
	
	
	
}
