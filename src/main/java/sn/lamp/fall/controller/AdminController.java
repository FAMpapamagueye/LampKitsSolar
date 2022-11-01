package sn.lamp.fall.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sn.lamp.fall.Model.Client;
import sn.lamp.fall.Model.Devis;
import sn.lamp.fall.Model.Equipement;
import sn.lamp.fall.Model.User;
import sn.lamp.fall.Utils.Constant;
import sn.lamp.fall.service.ClientService;
import sn.lamp.fall.service.DevisService;
import sn.lamp.fall.service.EquipementService;
import sn.lamp.fall.service.userService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private userService userService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private EquipementService equipementService;
	@Autowired
	private DevisService devisService;
	@GetMapping("/")
	public String dashboard(HttpSession httpSession,Model M) {
		Long user_id=(Long) httpSession.getAttribute(Constant.SESSION_ID_UTILISATEUR);
		if(user_id==null) {
			M.addAttribute(Constant.SESSION_TIME_OUT, "Time Out Session");
			return "redirect:/";}
		User user=userService.findById(user_id);
			
		httpSession.setAttribute("logged-in", "true");
		M.addAttribute("user_id", user);
		M.addAttribute(Constant.SESSION_ID_UTILISATEUR ,user);
		httpSession.setAttribute(Constant.SESSION_ID_UTILISATEUR, user.getId());
		return "admin/dashboard";
	}
	
	@GetMapping("/client")
	public String client_index(HttpSession httpSession,Model M) {
		Long user_id=(Long) httpSession.getAttribute(Constant.SESSION_ID_UTILISATEUR);
		if(user_id==null) {
			M.addAttribute(Constant.SESSION_TIME_OUT, "Time Out Session");
			return "redirect:/login";}
		User user=userService.findById(user_id);
		Client client=new  Client();
		List<Client> clients=clientService.getAll();
		httpSession.setAttribute("logged-in", "true");
		M.addAttribute("user_id", user);
		M.addAttribute(Constant.SESSION_ID_UTILISATEUR ,user);
		M.addAttribute(Constant.CLIENT,client);
		M.addAttribute(Constant.CLIENTS,clients);
		return "clients/index";
	}
	@GetMapping("/client/{id}")
	public String client_index(HttpSession httpSession,Model M,@PathVariable("id") Long id) {
		Long user_id=(Long) httpSession.getAttribute(Constant.SESSION_ID_UTILISATEUR);
		if(user_id==null) {
			M.addAttribute(Constant.SESSION_TIME_OUT, "Time Out Session");
			return "redirect:/login";}
		if(id==null)return null;
		User user=userService.findById(user_id);
		
		httpSession.setAttribute("client_id", id);
		M.addAttribute("user_id", user);
		Client C1=clientService.findById(id);
		System.out.print(C1.getId());
		Equipement Equipement=new  Equipement();
		List<Equipement> Equipements=equipementService.findByListId(id);
		httpSession.setAttribute("logged-in", "true");
		M.addAttribute("client", C1);
		M.addAttribute(Constant.SESSION_ID_UTILISATEUR ,user);
		M.addAttribute(Constant.EQUIPEMENT,Equipement);
		M.addAttribute(Constant.EQUIPEMENTS,Equipements);
		return "dimensionnent/index";
	}
	@PostMapping("/client")
	public String client_add(Model M,@ModelAttribute("client") Client C) {
		if(C==null) {
			M.addAttribute("Client", "ne peut pas etre vide");
			
		}
		clientService.save(C);
		M.addAttribute("success", "enregistrement reussit");
			
		return "redirect:/admin/client";
	}
	@PostMapping("/add")
	public String Equipement_add(Model M,@ModelAttribute("Equipement") Equipement E,HttpSession httpSession) {
		if(E==null) {
			M.addAttribute("Equipement", "ne peut pas etre vide");
			
		}
		Long id=(Long) httpSession.getAttribute("client_id");
		 Client C1=clientService.findById(id); 
//System.out.println("*******************"+C1.getClient_id());
		equipementService.saveEquipement(E);
		M.addAttribute("success", "enregistrement reussit");
			
		return "redirect:/admin/client/"+C1.getId();
	}
//	devis 
	@GetMapping("/devis/{id}")
	public String devis_index(HttpSession httpSession,Model M,@PathVariable("id") Long id) {
		Long user_id=(Long) httpSession.getAttribute(Constant.SESSION_ID_UTILISATEUR);
		if(user_id==null) {
			M.addAttribute(Constant.SESSION_TIME_OUT, "Time Out Session");
			return "redirect:/login";}
		if(id==null)return null;
		User user=userService.findById(user_id);
		
		httpSession.setAttribute("client", id);
		M.addAttribute("user_id", user);
		Client C1=clientService.findById(id);
		System.out.print(C1.getId());
		Devis devi=new  Devis();
		List<Devis> devis=devisService.findByListId(id);
		M.addAttribute("client", C1);
		M.addAttribute(Constant.SESSION_ID_UTILISATEUR ,user);
		M.addAttribute(Constant.DEVI,devi);	
		M.addAttribute(Constant.DEVIS,devis);
		return "devis/index";
	}
	@PostMapping("/devis")
	public String Devis_add(Model M,@ModelAttribute("devi") Devis D,HttpSession httpSession) {
		if(D==null) {
			M.addAttribute("devis", "ne peut pas etre vide");
			
		}
		Long id=(Long) httpSession.getAttribute("client");
		 Client C1=clientService.findById(id); 
//System.out.println("*******************"+C1.getClient_id());
		devisService.save(D);
		M.addAttribute("success", "enregistrement reussit");
			
		return "redirect:/admin/devis/"+C1.getId();
	}
	//RAPPORT
	@GetMapping("/rapport/{id}")
	public String rapport_index(HttpSession httpSession,Model M,@PathVariable("id") Long id) {
		Long user_id=(Long) httpSession.getAttribute(Constant.SESSION_ID_UTILISATEUR);
		if(user_id==null) {
			M.addAttribute(Constant.SESSION_TIME_OUT, "Time Out Session");
			return "redirect:/login";}
		if(id==null)return null;
		User user=userService.findById(user_id);
		
		httpSession.setAttribute("client", id);
		M.addAttribute("user_id", user);
		Client C1=clientService.findById(id);
		System.out.print(C1.getId());
		Devis devi=new  Devis();
		List<Devis> devis=devisService.findByListId(id);
		List<Equipement> Equipements=equipementService.findByListId(id);
//	double totalL=devis.stream().collect(Collectors.summingInt((e.getPrixUnitaire()*e.getQuantite())));
//		Constant.TOTAL=0;
		for (Devis dev : devis) {
			Constant.TOTAL+=dev.getPrixUnitaire()*dev.getQuantite();
		}
		
		M.addAttribute("client", C1);
		M.addAttribute(Constant.SESSION_ID_UTILISATEUR ,user);
		M.addAttribute(Constant.EQUIPEMENTS,Equipements);
		M.addAttribute(Constant.DEVI,devi);	
		M.addAttribute(Constant.DEVIS,devis);
		M.addAttribute("TOTAL",Constant.TOTAL);
		Constant.TOTAL=0;
		return "rapport/index";
	}
}
