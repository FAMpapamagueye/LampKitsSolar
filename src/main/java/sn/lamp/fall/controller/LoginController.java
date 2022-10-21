package sn.lamp.fall.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import sn.lamp.fall.DAO.userRepository;
import sn.lamp.fall.Model.User;
import sn.lamp.fall.Utils.Constant;
import sn.lamp.fall.service.userService;

@Controller
public class LoginController {
	@Autowired
	private userService userService;
	@Autowired
	private userRepository repository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("/login")
	public String login(Model M) {
		User U = new User();
		M.addAttribute("user", U);
		return "login";
	}

	@SuppressWarnings("unused")
	@PostMapping("/login")
	public String login(@ModelAttribute("user") User user,BindingResult result,Model M,HttpSession httpSession) throws Exception {

		if(result.hasErrors()) {
			User U = new User();
			M.addAttribute("user", U);
			M.addAttribute("error","error");
			return "login";
		}
//		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		System.out.print("*******************************"+user.getPassword());
		User users = repository.findByEmail(user.getEmail()).orElse(new User());
		System.out.print("*******************************"+users.getEmail());
		if (users == null) {
			M.addAttribute("user", users);
			M.addAttribute("error","error");
			return "login";
		}
		System.out.print("*******************************"+user.getPassword()+"_________"+users.getPassword()+"**************");
		if (isPassword(user.getPassword(), users.getPassword())) {
			httpSession.setAttribute(Constant.SESSION_ID_UTILISATEUR, users.getId());
			return "redirect:/admin/";
		}
		M.addAttribute("error","error");
		return "login";
	}

	@GetMapping("/register")
	public String showRegistrationForm(Model M) {
		User U = new User();
		M.addAttribute("user", U);
		return "register";
	}

	@PostMapping("/register")
	public String registerUserAccount(@ModelAttribute("user") User user,Model M) {
		if (user == null) {
			User U = new User();
			M.addAttribute("user", U);
			M.addAttribute("error","error");
			return "register";
		}
		userService.save(user);
			return "redirect:/login";
			

		
	}

	public boolean isPassword(String password, String motdepasse) throws Exception {
		return bCryptPasswordEncoder.matches(password, motdepasse);
	}
}
