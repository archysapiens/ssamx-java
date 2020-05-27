package com.ssamx.model;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "periods")
@IdClass(Periods.class)
public class Periods implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int id;

	private int anio;

	private int qna;
 
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Basic
    @Column(name="shipping_date")
    @Temporal(TemporalType.DATE)
    private java.util.Date shipping_date;
	
	@Column(name="description", length=100)
    private String Description;
	@Column(name="type", length=1)
    private String type;
	@Column(name="art74_fed	", length=1)
    private String art74_fed;
	public int getAnio() {
		return anio;
	}
	public void setAnio(int anio) {
		this.anio = anio;
	}
	public int getQna() {
		return qna;
	}
	public void setQna(int qna) {
		this.qna = qna;
	}
	public java.util.Date getSqlDate() {
		return shipping_date;
	}
	public void setSqlDate(java.util.Date shipping_date) {
		this.shipping_date = shipping_date;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getArt74_fed() {
		return art74_fed;
	}
	public void setArt74_fed(String art74_fed) {
		this.art74_fed = art74_fed;
	}
    
	
	

}
