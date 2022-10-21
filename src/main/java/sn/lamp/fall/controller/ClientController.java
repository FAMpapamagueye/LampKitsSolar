package sn.lamp.fall.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import sn.lamp.fall.Model.User;
import sn.lamp.fall.Utils.Constant;
import sn.lamp.fall.service.userService;

@Controller
@RequestMapping("/client")
public class ClientController {
	@Autowired
	private userService userService;
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
		//httpSession.setAttribute(Constant.SESSION_ID_UTILISATEUR, user.getId());
		return "clients/index";
}
}
