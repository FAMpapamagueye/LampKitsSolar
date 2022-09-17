package sn.lamp.fall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


import sn.lamp.fall.Model.Equipement;
import sn.lamp.fall.service.EquipementService;

@Controller
public class EquipementController {
	private EquipementService equipementService;

	@GetMapping("/")
	public String index() {
		
		return "index";
	}

	@GetMapping("/form")
	public String formView(Model M) {
		Equipement E = new Equipement();
		M.addAttribute("Equipement", E);
		return "formview";
	}

	@PostMapping("/form")
	public String add(@Validated @ModelAttribute("Equipement") Equipement E, Model M, BindingResult bindingResult) {
		if (bindingResult.hasErrors() || E == null) {
			M.addAttribute("error", "save are fails");
			return "redirect:/form";
		}
		equipementService.saveEquipement(E);
		M.addAttribute("add", "Equipement add Succefuly");
		return "redirect:/form";
	}

}
