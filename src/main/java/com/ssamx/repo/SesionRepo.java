package com.ssamx.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ssamx.dto.AnioQnaDTO;
import com.ssamx.dto.QnaDTO;
import com.ssamx.dto.SesionDTO;
import com.ssamx.dto.ShippingTagDTO;
import com.ssamx.model.Usuarios;

@Repository
public interface SesionRepo extends JpaRepository<Usuarios, String>{
	
	@Query(value="SELECT usu.nombre AS nombre_usuario,usu.app_paterno, usu.app_materno, " + 
			"pri.id_roles, rol.descripcion, org.id, org.name AS organismo, usu.foto, usu.id AS idusu " + 
			"FROM users usu, privilegios pri, states org, roles rol " + 
			"WHERE usu.id=pri.id_usuarios AND pri.id_organismos= org.id AND " + 
			"pri.id_roles= rol.id AND  " + 
			"usu.id=?1 AND usu.password=?2  AND pri.estatus='A' AND " + 
			"pri.id_roles='10'", nativeQuery = true)
	List<SesionDTO> findByUser(String user, String passwd);
	

	 public interface SesionDTO{
			public String getNombre_usuario();
			public String getApp_paterno(); 
			public String getApp_materno();
			public String getId_roles(); 
			public String getDescripcion(); 
			public String getId();
			public String getOrganismo(); 
			public String getFoto();
			public String getIdusu();
	 }

	 
		@Query(value="SELECT MIN(CAST(CONCAT(anio,LPAD(qna,2,'0')) AS SIGNED)) AS anio_qna, " + 
				"                        MIN(shipping_date) AS fecha_limite, " + 
				"                        MAX(qna) AS max_quincena, MAX(shipping_date) AS max_limite " + 
				"                        FROM periods " + 
				"                        WHERE qna >= ?1 AND anio=?2 AND art74_fed='A' " 
				, nativeQuery = true)
		List<QnaDTO> findByQnaLink(int qna, int anio);
	 
		@Query(value="SELECT MIN(CAST(CONCAT(anio,LPAD(qna,2,'0')) AS SIGNED)) AS anio_qna, " + 
				"                        MIN(shipping_date) AS fecha_limite, " + 
				"                        MAX(qna) AS max_quincena, MAX(shipping_date) AS max_limite " + 
				"                        FROM periods " + 
				"                        WHERE shipping_date >= CURDATE()  AND art74_fed='A' " 
				, nativeQuery = true)
		List<QnaDTO> findByQna();

		 public interface QnaDTO{
				
				public int getAnio_qna() ;
				public java.util.Date getFecha_limite();
				public int getMax_quincena() ;
				public java.util.Date getMax_limite();
		}

			@Query(value="SELECT rem.id,rem.assign_date,rem.update_date, " + 
					"rem.id_state,rem.stat,rem.id_files,rem.anio, " + 
					"rem.qna, arc.description, rem.art74_fed " + 
					"FROM shipping rem, files arc " + 
					"WHERE rem.id_files=arc.id AND  " + 
					"rem.anio=?1   " + 
					"AND rem.qna=?2 " + 
					"AND rem.id_state=?3 and rem.art74_fed ='A' "  
					, nativeQuery = true)
			List<AnioQnaDTO> findByAnioQnaDet(int anio, int qna, String idState);
		 
			 public interface AnioQnaDTO{
					public int getId() ;
					public java.util.Date getAssign_date() ;
					public java.util.Date getUpdate_date() ;
					public int getId_state() ;
					public String getStat() ;
					public int getId_files() ;
					public int getAnio() ;
					public int getQna() ;
					public String getDescription();
					public String getArt74_fed();
			}
			 

			 @Query(value="SELECT  logg.id_shipping, logg.shipping_tag " + 
			 		"              FROM shipping rem, logger logg       " + 
			 		"              WHERE rem.id=logg.id_shipping AND     " + 
			 		"              id_state=?3 AND                 " + 
			 		"              id_files=5 AND                    " + 
			 		"              anio=?1 AND logg.art74_fed='A' AND  " + 
			 		"              qna=?2 AND logg.stat NOT IN ('C','E') " + 
			 		"              ORDER BY logg.registration_date DESC"  
						, nativeQuery = true)
				List<ShippingTagDTO> findByShppingTag(int anio, int qna, String idState);		
			 
			 public interface ShippingTagDTO{
					public int getId();
					public String getShipping_tag();
			 
			 }
}
