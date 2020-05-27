package com.ssamx.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssamx.model.Usuarios;
import com.ssamx.repo.UsersRepo;

@Service
public class ValidaUserImpl implements ValidaUser{

	private static Logger log = LoggerFactory.getLogger(ValidaUserImpl.class);
	
	@Autowired
	private UsersRepo repo;
	
	@Override
	public String validateUserAccess(String userId, String passwd) {
		List<Usuarios> users = repo.findAll();
		users.forEach(x->{
			log.info(x.getId());
			});
		
		Optional<Usuarios> usrBy = repo.findByIdAndPass(userId, passwd);
		if (usrBy.isPresent()) {
			log.info("Query {}-	{} ",usrBy.get().getId(), usrBy.get().getNombre());
		}
		
		Optional<Usuarios> usr = repo.findById(userId);
		if (usr.isPresent()) {
			log.info("Resultado {}-	{} ",usr.get().getId(), usr.get().getNombre());
			if(passwd.equals(usr.get().getPassword())) {
				log.info("Acceso permitido {}",usr.get().getId());
				return "product";
			}
			else {
				log.warn("Acceso Np permitido {}",usr.get().getId());
				return "no-access";
			}
		}
		else {
			log.warn("No se encontro el registro {}",userId );
			return "no-access";
		}	
		
	}
}
