package com.ssamx.service;

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
import com.ssamx.model.Usuarios;
import com.ssamx.repo.UsersRepo;


@Service
public class InsertUsersImpl implements InsertUsers{
	
	@Autowired
	private UsersRepo repo;

	
	@Autowired
	private ReadUsers readUsers;
	
	private static Logger log = LoggerFactory.getLogger(InsertUsersImpl.class);

	@Override
	public void insertaUsers(String operation, String fileName) throws FileNotFoundException, IOException {
	
		if(operation.equals("reset")) {
			File file = readUsers.getFileFromResources("usuarios.csv");
	        try (FileReader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader)) {
	           		String line;
	           		int countLines =1;
	           		while ((line = br.readLine()) != null) {
	           			line = line.replace("\\N", "0");
	           			if (countLines > 1) {
		           			Usuarios usuario = new Usuarios();
		           			log.info(line);
		           			String[] output = line.split("\t");
		           			log.info("String tokens {} - {}", output[0],output[1] );
		           			usuario.setId(output[0]);
		           			usuario.setNombre(output[1]);
		           			usuario.setApp_paterno(output[2]);
		           			usuario.setApp_materno(output[3]);
		           			String Sexo;
		           			if (output[4].equals("Masculino"))
		           				Sexo = "M";
		           			else
		           				Sexo = "F";
		           			usuario.setSexo(Sexo);
		           			usuario.setEdad(Integer.parseInt(output[5]));
		           			usuario.setFecha_nacimiento(output[6]);
		           			usuario.setFoto(output[7]);
		           			usuario.setTel_oficina(output[8]);
		           			usuario.setExtension(output[9]);
		           			usuario.setTel_mobil(output[10]);
		           			usuario.setOrganismos(output[11]);
		           			usuario.setUnidad_responsable(output[12]);
		           			usuario.setCredenciales(output[13]);
		           			usuario.setPregunta(output[14]);
		           			usuario.setRespuesta(output[15]);
		           			usuario.setPassword(output[15]);
		           			usuario.setCargo(output[16]);
		           			repo.save(usuario);
	           			}
	           			countLines++;
			        }
				//readUsers.insertUsers(file);
				log.info("The file was loaded");
	        }	
		}
	}
	
	

}
