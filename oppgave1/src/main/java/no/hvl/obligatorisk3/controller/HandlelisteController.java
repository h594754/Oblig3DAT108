package no.hvl.obligatorisk3.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import no.hvl.obligatorisk3.handleliste.Handleliste;
import no.hvl.obligatorisk3.handleliste.Vare;
import no.hvl.obligatorisk3.util.InputValidator;
import no.hvl.obligatorisk3.util.LoginUtil;

@Controller
public class HandlelisteController {
	@Value("${app.url.handleliste}")
	private String HANDLELISTE_URL;
	@Value("${app.url.login}")
	private String LOGIN_URL;
	@Value("${app.message.needLogin}")
	private String TRENGER_LOGIN;

	// Oppretter en ny tom handleliste
	Handleliste vare = new Handleliste();

	// Henter handlelisten så lenge brukeren er blitt logget inn
	@GetMapping(value = "handleliste")
	public String visHandleliste(HttpSession session, RedirectAttributes ra, Model model) {
		// Om brukeren ikke er logget inn i sesjonen så vil hen bli bedt om å skrive inn
		// passordet
		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("errorMsg", TRENGER_LOGIN);
			return "redirect:" + LOGIN_URL;
		}
		// Sjekker om handlelisten er tom, hvis den ikke er det så legger den et element
		// inn.
		// Vare kommer fra parameteren som er hentet fra input formen i jsp'en. Vare er
		// også handlelisten.
		if (vare.size() != 0) {
			model.addAttribute("vare", vare);
		}

		return HANDLELISTE_URL;
	}

	@PostMapping("handleliste")
	public String leggTilVarerIHandleliste(@RequestParam(value="vare") String varer, HttpSession session, Model model,
			HttpServletRequest request, RedirectAttributes ra) {
		// kaster en feilmelding om brukeren ikke er logget inn.
		if (!LoginUtil.erBrukerInnlogget(session)) {
			ra.addFlashAttribute("errorMsg", TRENGER_LOGIN);
			return "redirect:" + LOGIN_URL;
		}
		// Sjekker om vare inputen er gyldig.
		if (!InputValidator.gyldigVare(varer)) {
			return "redirect:" + HANDLELISTE_URL;
		}
		// Lager et nytt vareobjekt som er elementet som hentes fra parameteren til
		// String varer.
		Vare v = new Vare(varer);
		// Legger til den nye varen med en add i Listen.
		vare.leggTilVare(v);
		// Redirecter opp til visHandliste hvor den legger til i Listen.
		return "redirect:" + HANDLELISTE_URL;

	}

	@PostMapping(value = "slettpost")
	public String slettVare(@RequestParam(value = "vare") String varer, HttpSession session, Model model,
			HttpServletRequest request, RedirectAttributes ra) {
		//kaller på slett vare og sletter vare som kommer fra parameteren. 
		vare.slettVare(varer);
		return "redirect:" + HANDLELISTE_URL;
	}
}
