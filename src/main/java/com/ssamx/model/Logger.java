package com.ssamx.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "logger")
public class Logger {
	@Id
	private int id;
	
	@Column(name="id_shipping")
	private int id_shipping;
	
	
	@Column(name="registration_date")
	@Temporal(TemporalType.DATE)
	private java.util.Date registration_date;
	
	@Column(name="validation_date")
	@Temporal(TemporalType.DATE)
	private java.util.Date validation_date;

	@Column(name="load_date")
	@Temporal(TemporalType.DATE)
	private java.util.Date load_date;

	@Column(name="type_file")
	private int type_file;
	
	@Column(name="file_name",  length=250)
	private String file_name;
	
	@Column(name="num_rows")
	private int num_rows;

	@Column(name="comments",  length=250)
	private String comments;
	
	@Column(name="shipping_tag",  length=30)
	private String shipping_tag;
	
	@Column(name="error_file",  length=250)
	private String error_file;

	@Column(name="fail_error")
	private int fail_error;
	
	@Column(name="stat",  length=1)
	private String stat;

	@Column(name="id_type_nom",  length=2)
	private String id_type_nom;
	
	@Column(name="add_date")
	@Temporal(TemporalType.DATE)
	private java.util.Date add_date;

	@Column(name="staging_table",  length=35)
	private String staging_table;

	@Column(name="ods_table",  length=35)
	private String ods_table;

	@Column(name="ur_list",  length=100)
	private String ur_list;
	
	@Column(name="art74_fed",  length=1)
	private String art74_fed;

	public void setId_shipping(int id_shipping) {
		this.id_shipping = id_shipping;
	}

	public void setRegistration_date(java.util.Date registration_date) {
		this.registration_date = registration_date;
	}

	public void setValidation_date(java.util.Date validation_date) {
		this.validation_date = validation_date;
	}

	public void setLoad_date(java.util.Date load_date) {
		this.load_date = load_date;
	}

	public void setType_file(int type_file) {
		this.type_file = type_file;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public void setNum_rows(int num_rows) {
		this.num_rows = num_rows;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public void setShipping_tag(String shipping_tag) {
		this.shipping_tag = shipping_tag;
	}

	public void setError_file(String error_file) {
		this.error_file = error_file;
	}

	public void setFail_error(int fail_error) {
		this.fail_error = fail_error;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public void setId_type_nom(String id_type_nom) {
		this.id_type_nom = id_type_nom;
	}

	public void setAdd_date(java.util.Date add_date) {
		this.add_date = add_date;
	}

	public void setStaging_table(String staging_table) {
		this.staging_table = staging_table;
	}

	public void setOds_table(String ods_table) {
		this.ods_table = ods_table;
	}

	public void setUr_list(String ur_list) {
		this.ur_list = ur_list;
	}

	public void setArt74_fed(String art74_fed) {
		this.art74_fed = art74_fed;
	}

	
	
	
}
