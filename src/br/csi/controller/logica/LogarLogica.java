package br.csi.controller.logica;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogarLogica implements Logica{

	@Override
	public String executa(HttpServletRequest rq, HttpServletResponse rp) {
		
		
		System.out.println("dentro do executa no logar logica");
		
		return "/WEB-INF/jsp/principal.jsp";
	}

}
