package com.ssamx.dto;

import java.io.Serializable;

public class QnaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private int anio_qna;
	private java.util.Date fecha_limite;
	private int max_quincena;
	private java.util.Date max_limite;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getAnio_qna() {
		return anio_qna;
	}
	public java.util.Date getFecha_limite() {
		return fecha_limite;
	}
	public int getMax_quincena() {
		return max_quincena;
	}
	public java.util.Date getMax_limite() {
		return max_limite;
	}
	
	
}
