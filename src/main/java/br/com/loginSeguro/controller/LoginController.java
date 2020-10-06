package br.com.loginSeguro.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController { 
	
	private String mensagemErro = "Falha na autenticação!";
	private String mensagemLogout = "Usuário deslogado!";
	
	@RequestMapping(value= {"/","/login"}, method=RequestMethod.GET)
	public String loginForm(Model model) {	
		
		model.addAttribute("mensagemErro", mensagemErro);
		model.addAttribute("mensagemLogout", mensagemLogout);
		
		return RotaController.loginPage();
	}
}
