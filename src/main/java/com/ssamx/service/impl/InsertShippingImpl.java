package com.ssamx.service.impl;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssamx.model.Shipping;
import com.ssamx.repo.ShippingRepo;
import com.ssamx.service.InsertShipping;

@Service
public class InsertShippingImpl implements InsertShipping{

	@Autowired
	private ShippingRepo repo;
	
	private static Logger log = LoggerFactory.getLogger(InserPeriodsImpl.class);
	
	@Override
	public void insertShipping() {
		
		List<Shipping> shippings = repo.findShipping();
		
		for (Shipping shipping : shippings) {
			
			Shipping ship = new  Shipping();
			ship = shipping ;
			
/**
			ship.setAssign_date(shipping.getAssign_date());
			ship.setAnio(shipping.getAnio());
			ship.setId_files(shipping.getId_files());
			ship.setId_period(shipping.getId_period());
			ship.setId_state(shipping.getId_state());
			ship.setQna(shipping.getQna());
			ship.setShipping_tag(shipping.getShipping_tag());
			ship.setStaging_d(shipping.getStaging_d());
			ship.setStaging_t(shipping.getStaging_t());
			ship.setStat(shipping.getStat());
**/			
			repo.save(ship);
			log.info("After save -- Shipping {}-{}" , String.valueOf(shipping.getId()),shipping.getAssign_date());
		}
		
		//shipping.forEach(x->{
		//	Shipping shipping = Shipping();
		//	log.info("Shipping {}-{}" , String.valueOf(x.getId()),x.getAssign_date());
		//});
		
		
		
	}
	
	

}
