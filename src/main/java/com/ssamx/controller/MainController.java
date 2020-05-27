package com.ssamx.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssamx.dao.HtmlDAO;
import com.ssamx.dto.QnaDTO;
import com.ssamx.dto.SesionDTO;
import com.ssamx.repo.SesionRepo;
import com.ssamx.service.InserPeriods;
import com.ssamx.service.InsertFiles;
import com.ssamx.service.InsertShipping;
import com.ssamx.service.InsertStates;
import com.ssamx.service.InsertUsers;
import com.ssamx.service.ValidaUser;
import com.ssamx.service.impl.InserPeriodsImpl;

@Controller
public class MainController {
	
	private static Logger log = LoggerFactory.getLogger(InserPeriodsImpl.class);
	
	@Autowired
	private ValidaUser validaUser;
	
	@Autowired
	private HtmlDAO htmlDAO;

	@Autowired
	private SesionRepo session;
	
	@Autowired
	private InsertShipping insertShipping;

	@Autowired
	private InsertStates insertStates;

	@Autowired
	private InsertFiles insertFiles;
	
	@Autowired
	private InserPeriods inserPeriods;

	@Autowired
	private InsertUsers insertUsers;
	
	@GetMapping("/greeting")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@GetMapping("/")
	public String index(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "index";
	}

	@GetMapping("/route")
	public String routeAcceso(@RequestParam(name="usuario", required=true, defaultValue="guess") String userId, @RequestParam(name="password", required=true, defaultValue="guess") String passwd,
				@RequestParam(name="QuincenaUrl", required=true, defaultValue="00") String QuincenaUrl, 
				@RequestParam(name="AnioQuincenaUrl", required=true, defaultValue="00") String AnioQuincenaUrl,
				Model model) {
		 String idState="debug";
		model.addAttribute("name", userId);
		model.addAttribute("passwd", passwd);
		
		List<SesionRepo.SesionDTO> sessionData = session.findByUser(userId, passwd);
		
		if (!sessionData.isEmpty()){
			for (SesionRepo.SesionDTO sesionDTO : sessionData) {
				log.info("route =>{}- {}-{}-{} ",sesionDTO.getId(), sesionDTO.getNombre_usuario(), sesionDTO.getApp_paterno(),sesionDTO.getApp_materno());
				model.addAttribute("nombre_usuario", sesionDTO.getNombre_usuario());
				model.addAttribute("app_paterno", sesionDTO.getApp_paterno());
				model.addAttribute("app_materno", sesionDTO.getApp_materno());
				model.addAttribute("id_roles", sesionDTO.getId_roles());
				model.addAttribute("id_roles", sesionDTO.getId_roles());
				model.addAttribute("id_state", sesionDTO.getId());
				model.addAttribute("state", sesionDTO.getOrganismo());
				model.addAttribute("photo", sesionDTO.getFoto());
				model.addAttribute("id", sesionDTO.getIdusu());
				idState = sesionDTO.getId();
				 
			}	
		}
		List<SesionRepo.QnaDTO> qnaData;
		
		if (QuincenaUrl.equals("00")) {
			qnaData = session.findByQna();
		}
		else {
			qnaData = session.findByQnaLink(Integer.valueOf(QuincenaUrl), Integer.valueOf(AnioQuincenaUrl));
		}
		
		if (!qnaData.isEmpty()) {
			
			for (SesionRepo.QnaDTO qnaDTO : qnaData ) {
				  
					String anioQna = String.valueOf(qnaDTO.getAnio_qna());
					log.info("qnaData =>{}<-> {}<->{}<->{} ", anioQna, 
							qnaDTO.getFecha_limite().toString(),String.valueOf(qnaDTO.getMax_quincena()) ,
							qnaDTO.getMax_limite().toString());
					String anio = anioQna.substring(0,4) ;
					String qna  = anioQna.substring(4,anioQna.length()) ;
					String idStateLoc= idState; //model.getAttribute("id_state").toString();
					log.info("anio =>{} qna {} id_state {}", anio,qna, idStateLoc);
					
					String header = String.format("%s@%s@%s@%s@%s@", anio, qna,
							qnaDTO.getFecha_limite().toString(),
							String.valueOf(qnaDTO.getMax_quincena()) ,
							qnaDTO.getMax_limite().toString() );
					log.info("header =>{} ", header);
					
					List<SesionRepo.AnioQnaDTO> qnaDetal = session.findByAnioQnaDet(Integer.parseInt(anio), 
							Integer.parseInt(qna),idStateLoc);
					
							//model.getAttribute("id_state").toString());
					log.info("Despues del List<SesionRepo.AnioQnaDTO>");
					
					if(!qnaDetal.isEmpty()) {
						qnaDetal.forEach(y->{
							log.info("qnaDataDetalle =>{}", 
									String.valueOf(y.getId())); 
							/**
							log.info("qnaDataDetalle =>{}-{}- {}-{}-{} {}-{}- {}-{}-{}", 
									String.valueOf(y.getId()),y.getAssign_date().toString(),
									y.getUpdate_date().toString(), y.getId_state(), 
									y.getStat(), String.valueOf(y.getId_files()),
									String.valueOf(y.getAnio()), String.valueOf(y.getQna()),
									y.getDescription(), y.getArt74_fed());
						**/			 
						
						});
				
					}
		 }
		}		
		idState="";
		String response = validaUser.validateUserAccess(userId, passwd);
		return response;
	}

	
	@GetMapping("/carga-usuarios")
	public String loadUsuarios(@RequestParam(name="operacion", required=false, defaultValue="reset") String name,@RequestParam(required=false, defaultValue="file.csv") String file, Model model) throws FileNotFoundException, IOException {
		insertUsers.insertaUsers(name, file);
		return "index";
	}

	
	@GetMapping("/carga-periodos")
	public String loadPeriods(@RequestParam(name="operacion", required=false, defaultValue="reset") String name,@RequestParam(required=false, defaultValue="file.csv") String file, Model model) throws FileNotFoundException, IOException, ParseException {
		
		inserPeriods.insertPeriods(name, file);
		return "index";
	}

	@GetMapping("/carga-archivos")
	public String loadFiles(@RequestParam(name="operacion", required=false, defaultValue="reset") String name,@RequestParam(required=false, defaultValue="file.csv") String file, Model model) throws FileNotFoundException, IOException, ParseException {
		insertFiles.insertFiles(name, file);
		return "index";
	}
	
	@GetMapping("/carga-estados")
	public String loadStates(@RequestParam(name="operacion", required=false, defaultValue="reset") String name,@RequestParam(required=false, defaultValue="file.csv") String file, Model model) throws FileNotFoundException, IOException, ParseException {
		insertStates.insertStates(name, file);
		return "index";
	}

	@GetMapping("/carga-envios")
	public String loadShipping(@RequestParam(name="operacion", required=false, defaultValue="reset") String name,@RequestParam(required=false, defaultValue="file.csv") String file, Model model) throws FileNotFoundException, IOException, ParseException {

		insertShipping.insertShipping();
		return "index";
	}
	
	
}
