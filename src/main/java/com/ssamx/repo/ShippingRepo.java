package com.ssamx.repo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.ssamx.model.Shipping;


public interface ShippingRepo  extends JpaRepository<Shipping, Integer>{
	
	//			"  DATE_FORMAT(CURDATE(), '%d/%m/%Y') AS assign_date, " +
	@Query(value="SELECT  1 AS id, " + 
			" CURDATE() AS assign_date, " + 
			"   NULL AS update_date, " + 
			"  a.id id_state, " + 
			"  'A' AS stat," + 
			"  c.id id_files," + 
			"   b.id id_period," + 
			"    b.qna," + 
			"  b.anio, " + 
			"  NULL AS shipping_tag," + 
			"  NULL AS staging_d," + 
			"  NULL AS staging_t " + 
			"FROM  spring.states a , spring.periods b,  spring.files c  " + 
			"WHERE c.id=5 LIMIT 0, 2000 ", nativeQuery = true)
	List<Shipping> findShipping();


}
