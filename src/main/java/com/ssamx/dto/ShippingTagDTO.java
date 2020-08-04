package com.ssamx.dto;

import java.io.Serializable;

public class ShippingTagDTO  implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int id;
	
	private String shipping_tag;

	public void setId(int id) {
		this.id = id;
	}

	public void setShipping_tag(String shipping_tag) {
		this.shipping_tag = shipping_tag;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public String getShipping_tag() {
		return shipping_tag;
	}
	
	
}
