package com.ssamx.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssamx.dao.ReadUsers;
import com.ssamx.model.Periods;
import com.ssamx.repo.PeriodsRepo;
import com.ssamx.service.InserPeriods;

import java.util.Date;  

@Service
public class InserPeriodsImpl implements InserPeriods{
	
	
	@Autowired
	private PeriodsRepo repo;

	
	@Autowired
	private ReadUsers readUsers;
	
	private static Logger log = LoggerFactory.getLogger(InserPeriodsImpl.class);

	

	@Override
	public void insertPeriods(String operation, String fileName) throws FileNotFoundException, IOException, ParseException {
	
		if(operation.equals("reset")) {
			File file = readUsers.getFileFromResources("periodos.csv");
	        try (FileReader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader)) {
	           		String line;
	           		int countLines =1;
	           		while ((line = br.readLine()) != null) {
	           			line = line.replace("\\N", "0");
	           			if (countLines > 1) {
	           				
	           				
		           			Periods period = new Periods();
		           			log.info(line);
		           			String[] output = line.split(",");
		           			String Id = String.format("%s%s",output[0],output[1] );
		           			
		           			//log.info("String tokens {} - {}", output[0],output[1] );
		           			period.setId(Integer.parseInt(Id));
		           			period.setAnio(Integer.parseInt(output[0]));
		           			period.setQna(Integer.parseInt(output[1]));
		           			Date fecha = new SimpleDateFormat("yyyy-MM-dd").parse(output[2]);
		           			
		           			period.setSqlDate(fecha);
		           			period.setDescription(output[3]);
		           			period.setType(output[4]);
		           			period.setArt74_fed(output[5]);
		           			repo.save(period);
	           			}
	           			countLines++;
			        }
				//readUsers.insertUsers(file);
				log.info("The file was loaded");
	        }	
		}
	}

}
