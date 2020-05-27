package com.ssamx.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssamx.dao.ReadUsers;
import com.ssamx.model.States;
import com.ssamx.repo.StatesRepo;
import com.ssamx.service.InsertStates;


@Service
public class InsertStatesImpl implements InsertStates{

	@Autowired
	private StatesRepo repo;

	
	@Autowired
	private ReadUsers readUsers;
	
	private static Logger log = LoggerFactory.getLogger(InserPeriodsImpl.class);


	@Override
	public void insertStates(String operation, String fileName) throws FileNotFoundException, IOException {
		if(operation.equals("reset")) {
			File file = readUsers.getFileFromResources("organismos.csv");
	        try (FileReader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader)) {
	           		String line;
	           		int countLines =1;
	           		while ((line = br.readLine()) != null) {
	           			line = line.replace("\\N", "0");
	           			if (countLines > 1) {
		           			States states = new States();
		           			log.info(line);
		           			String[] output = line.split(",");
		           			log.info("String tokens {} - {}", output[0],output[1] );
		           			states.setId(output[0]);
		           			states.setName(output[1]);
		           			repo.save(states);
	           			}
	           			countLines++;
			        }
				//readUsers.insertUsers(file);
				log.info("The file was loaded");
	        }	
	    }
	}
}
