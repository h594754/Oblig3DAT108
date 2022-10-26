package no.hvl.obligatorisk3.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Value;

public class LoginUtil {
	
 	@Value("${app.login.correctPassword}")
 	private String CORRECT_PASSWORD;
 	
	public static void loggUtBruker(HttpSession session) {
		session.invalidate();
	}
	
	public static void loggInnBruker(HttpServletRequest request, String password) {
		//Logger ut bruker før den logger inn igjen slik at vi ikke får problemer med autentisering
		loggUtBruker(request.getSession());
		
		HttpSession http = request.getSession();
		
		//Setter tiden man maks kan være inaktiv i sekunder. 
		http.setMaxInactiveInterval(60);
		http.setAttribute("password", password);
		
	}
	
	public static boolean erBrukerInnlogget(HttpSession session) {
		return session != null && session.getAttribute("password") != null; 
	}
}
