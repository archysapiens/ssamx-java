package com.ssamx.dto;

import java.io.Serializable;

public class AnioQnaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int id;
	private java.util.Date assign_date;
	private java.util.Date update_date;
	private int id_state;
	private String stat;
	private int id_files;
	private int anio;
	private int qna;
	private String description;
	private String art74_fed;
	
	public int getId() {
		return id;
	}
	public java.util.Date getAssign_date() {
		return assign_date;
	}
	public java.util.Date getUpdate_date() {
		return update_date;
	}
	public int getId_state() {
		return id_state;
	}
	public String getStat() {
		return stat;
	}
	public int getId_files() {
		return id_files;
	}
	public int getAnio() {
		return anio;
	}
	public int getQna() {
		return qna;
	}
	public String getDescription() {
		return description;
	}
	public String getArt74_fed() {
		return art74_fed;
	}
	
}
