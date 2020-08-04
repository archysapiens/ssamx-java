package com.ssamx.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.ssamx.model.Shipping;
import com.ssamx.repo.SesionRepo;
import com.ssamx.repo.ShippingRepo;
import com.ssamx.repo.SesionRepo.ShippingTagDTO;
import com.ssamx.service.InsertShipping;

@Service
public class InsertShippingImpl implements InsertShipping{

	@Autowired
	private ShippingRepo repo;
	
	@Autowired
	private SesionRepo sessionRepo;
	
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
	
	@Override
	public String buildTagShipping(String configurationData, Model model) {
		log.info("buildTagShipping/configurationData {}", configurationData);
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		DateFormat timeFormat = new SimpleDateFormat("HHmmss");
		Date date = new Date();
		
		
		String[] datosConfiguration = configurationData.split("\\|");
		String Art74Fed = datosConfiguration[datosConfiguration.length-1];
		log.info("buildTagShipping/Art74Fed {}", Art74Fed);
		
		String datosOper =  datosConfiguration[0];
		String[] datosQna = datosOper.split("@",5);
		log.info("buildTagShipping/datosQna.length {}", String.valueOf(datosQna.length));
		
		String AnioProc =datosQna[0];
		String QnaProc =datosQna[1];
		
		log.info("buildTagShipping/AnioProc {} QnaProc{}", AnioProc,QnaProc);
		String idState = model.getAttribute("id_state").toString();
		
		String idTS = String.format("%s-%s-%s-%s%s-5-%s", idState, QnaProc, AnioProc,
				dateFormat.format(date),timeFormat.format(date), Art74Fed );
		
		String shippingTag = String.format("var TagEnvio ='%s';", idTS);

		log.info("buildTagShipping/shippingTag {}", shippingTag);
		
		List<SesionRepo.ShippingTagDTO> databaseTag = sessionRepo.findByShppingTag(Integer.parseInt(AnioProc), Integer.parseInt(QnaProc), 
						idState);
		if (!databaseTag.isEmpty()) {
			for (SesionRepo.ShippingTagDTO shippingTagDTO : databaseTag) {
				
				String tag = shippingTagDTO.getShipping_tag();
				shippingTag = String.format("var TagEnvio ='%s';", tag);
				break;
			}
			
		}
		
		
		return shippingTag;
	}

	
	@Override
	public List<String> buildQnaList(String configurationData, Model model) {
		
		String[] datosConfiguration = configurationData.split("\\|");
		String Art74Fed = datosConfiguration[datosConfiguration.length-1];
		log.info("buildQnaList/Art74Fed {}", Art74Fed);
		
		String datosOper =  datosConfiguration[0];
		String[] datosQna = datosOper.split("@",5);
		log.info("buildQnaList/datosQna.length {}", String.valueOf(datosQna.length));
		
		String AnioProc =datosQna[0];
		String QnaProc =datosQna[1];
		String QnaMax =datosQna[3];
		log.info("buildQnaList/AnioProc {} QnaProc {} QnaMax {} ", AnioProc,QnaProc, QnaMax);
		int contador=Integer.parseInt(QnaProc);
		int limitLocal = Integer.parseInt(QnaProc)+1;
		List<String> arrayQnas = new ArrayList<String>();
		
		while ((contador <= limitLocal) && (limitLocal <= Integer.parseInt(AnioProc)) ){
			String item = String.format("%d|%s", contador,AnioProc );
			arrayQnas.add(item);
			contador++;
		}

		return arrayQnas;
		
	}
	
}
