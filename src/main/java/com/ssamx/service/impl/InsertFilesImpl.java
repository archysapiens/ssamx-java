package com.ssamx.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssamx.dao.ReadUsers;
import com.ssamx.model.Files;
import com.ssamx.repo.FilesRepo;
import com.ssamx.service.InsertFiles;

@Service
public class InsertFilesImpl implements InsertFiles{
	
	@Autowired
	private FilesRepo repo;

	
	@Autowired
	private ReadUsers readUsers;
	
	private static Logger log = LoggerFactory.getLogger(InserPeriodsImpl.class);

	
	
	@Override
	public void insertFiles(String operation, String fileName)
			throws FileNotFoundException, IOException, ParseException {
		
		if(operation.equals("reset")) {
			File file = readUsers.getFileFromResources("archivos.csv");
	        try (FileReader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader)) {
	           		String line;
	           		int countLines =1;
	           		while ((line = br.readLine()) != null) {
	           			line = line.replace("\\N", "0");
	           			if (countLines > 1) {
		           			Files files = new Files();
		           			log.info(line);
		           			String[] output = line.split(",");
		           			log.info("String tokens {} - {}", output[0],output[1] );
		           			files.setId(Integer.parseInt(output[0]));
		           			files.setDescription(output[1]);
		           			repo.save(files);
	           			}
	           			countLines++;
			        }
				//readUsers.insertUsers(file);
				log.info("The file was loaded");
	        }	
		}


		
	}
	
	

}
