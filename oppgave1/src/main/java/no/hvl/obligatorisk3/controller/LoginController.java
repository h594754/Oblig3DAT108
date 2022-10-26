package no.hvl.obligatorisk3.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import no.hvl.obligatorisk3.util.LoginUtil;

@Controller
@RequestMapping(value = "/login")
public class LoginController {
	
	//Bruker Value for å hente strengene fra application.properties, ikke bruke æøå. 
 	@Value("${app.message.invalidPassword}")
	private String INVALID_PASSWORD;
 	
 	@Value("${app.login.correctPassword}")
 	private String CORRECT_PASSWORD;
 	
 	@Value("${app.url.handleliste}")
 	private String HANDLELISTE_URL;
 	
 	@Value("${app.url.login}")
 	private String LOGIN_URL;

	//Returner med en get en login side når jeg skriver inn localhost:8080/login
	@GetMapping
	public String loginPage() {
		return "login";
	}

	//Det som skjer når man skriver inn i tekstboksen å trykker logg inn.
	@PostMapping
	public String loggeInn(@RequestParam String password, HttpServletRequest request, RedirectAttributes ra, LoginUtil lu) {
	//Sjekker om passordet samsvarer med passordet som er satt i Value strengen. Kaster feilmelding om passordet ikke er lik strengen
		if (!password.equals(CORRECT_PASSWORD)) {
			ra.addFlashAttribute("errorMsg", INVALID_PASSWORD);
			return "redirect:" + LOGIN_URL;
		}
		
	//Hvis passordet samsvarer så logger den inn brukerer i requesten og redirecter brukeren inn i handlelisten.
		LoginUtil.loggInnBruker(request, password);
		return "redirect:" + HANDLELISTE_URL;
	}
}
