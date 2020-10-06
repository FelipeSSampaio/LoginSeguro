package br.com.loginSeguro.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.loginSeguro.enums.PerfilEnum;

@Controller
public class RotaController {

	private static String loginPage = "/views/public/login.xhtml";
	private String inicialPage = "/views/private/inicialPage.xhtml";
	
	@RequestMapping(value="/inicialPage", method=RequestMethod.GET)
	public String inicialPage(Principal principal, Model model) {	
		
		model.addAttribute("usuarioLogadoNome", principal.getName().toUpperCase());
		
		if(principal.toString().contains(PerfilEnum.ADMIN.name()) || principal.toString().contains(PerfilEnum.GESTOR.name()))
			return inicialPage;
		
		return loginPage();
	}
	
	protected static String loginPage() {
		return loginPage;
	}
}
