package com.petclinic.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.petclinic.service.PerClinicService;

@Controller
public class PetClinicController {

	@Autowired
	private PerClinicService petClinicService;
	
	@RequestMapping("/owners")
	public ModelAndView getOwners() {
		ModelAndView md = new ModelAndView();
		md.addObject("owners",petClinicService.findOwners());
		md.setViewName("owners");
		return md;	
	}
	
	@RequestMapping("/pcs")
	@ResponseBody
	public String Welcome() {
		return "İlk Spring Sayfasına Hoş Geldiniz..";		
	}
	
}
