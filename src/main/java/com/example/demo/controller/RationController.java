package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import antlr.collections.List;

import javax.servlet.http.HttpServletRequest;

	
@Controller
public class RationController {
	@Autowired
	RationService rationService;
	
	
	@PostMapping("/")
	public String registrationdetails(String statecd,
			 Model model,HttpServletRequest request
			){
		String gen_male = rationService.getcount("General","m");
		model.addAttribute("gen_male",gen_male);
		String gen_female = rationService.getcount("General","f");
		model.addAttribute("gen_female",gen_female);
		String sc_male = rationService.getcount("SC","m");
		model.addAttribute("sc_male",sc_male);
		String sc_female = rationService.getcount("SC","f");
		model.addAttribute("sc_female",sc_female);
		String st_male = rationService.getcount("ST","m");
		model.addAttribute("st_male",st_male);
		String st_female = rationService.getcount("ST","f");
		model.addAttribute("st_female",st_female);
		String total = rationService.getTotal();
		model.addAttribute("total",total);
		String state = rationService.getstate();
		model.addAttribute("state",state);
		String dis = rationService.getDist(statecd);
		model.addAttribute("dis",dis);
		return "index";
		
	}
	
	@PostMapping("/registrationdetails/getulb")
	public @ResponseBody String ulblist(
			@RequestParam(required = false) String district_code
			) {
		java.util.List<Object[]> ulb = null ;
		try {
		   ulb=	rationService.getulb(district_code);
		   
		} catch (Exception e) {
			
		}
		
		return ulb.toString();
		
	}
	
	
	@PostMapping("/registrationdetails/regtntable")
	public @ResponseBody String regtntable(
			@RequestParam(required= false) String office, String office_id,
			Model model,HttpServletRequest request
			) {
		System.out.println(office_id);
		
		
		Object range = null;
		try {
//			JSONObject str =reportService.registration("Others","m",office_id);
//			System.out.println(str);
			List  gen_male = (List) rationService.registndetails("General","m",office,office_id);
			model.addAttribute("gen_male",gen_male);
			java.util.List<Object[]> gen_female = rationService.registndetails("General","f",office,office_id);
			model.addAttribute("gen_female",gen_female);
			range = rationService.registndetails("SC","m",office,office_id);
			model.addAttribute("sc_male",range);
			range = rationService.registndetails("SC","f",office,office_id);
			model.addAttribute("sc_female",range);
			range = rationService.registndetails("ST","m",office,office_id);
			model.addAttribute("st_male",range);
			range = rationService.registndetails("ST","f",office,office_id);
			model.addAttribute("st_female",range);
			range = rationService.registndetails("","",office,office_id);
			model.addAttribute("total",range);
			
		} catch (Exception e) {
			
		}
		System.out.println(range);
		return range.toString();
	}
    
}
