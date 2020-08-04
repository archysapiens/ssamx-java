package com.ssamx.service;

import java.util.List;

import org.springframework.ui.Model;

public interface InsertShipping {
	
	
	void insertShipping();
	String buildTagShipping(String configurationData, Model model);
	List<String>  buildQnaList(String configurationData, Model model);

}
