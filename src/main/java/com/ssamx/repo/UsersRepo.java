package com.ssamx.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ssamx.model.Usuarios;

public interface UsersRepo extends JpaRepository<Usuarios, String>{
	
	
	//@Query("select u from users u where u.id = ?1")
	//Usuarios findByEmailAddress(String emailAddress);
	
	@Query(value="SELECT * FROM users  WHERE id = ?1 and password = ?2", nativeQuery = true)
	Optional<Usuarios> findByIdAndPass(String Id, String passwd);

	
}
