package it.w06.d05.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.w06.d05.model.Utente;
import it.w06.d05.service.UtenteService;

@RestController // per creare delle API
@RequestMapping("/utenti")
public class UtenteController {

	@Autowired
	UtenteService utenteService;

	@GetMapping
	public ResponseEntity<?> trovaTuttiGliUtente() {
		return new ResponseEntity<List<Utente>>(utenteService.trovaTuttiGliUtente(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> trovaUtente(@PathVariable Long id) {
		return new ResponseEntity<Utente>(utenteService.getUtente(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> creaUtente(@RequestBody Utente utente) {
		return new ResponseEntity<Utente>(utenteService.creaUtente(utente), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> cancellaUtente(@PathVariable Long id) {
		return new ResponseEntity<String>(utenteService.cancellaUtente(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> aggiornaUtente(@RequestBody Utente utente) {
		return new ResponseEntity<Utente>(utenteService.updateUtente(utente), HttpStatus.CREATED);
	}

}
