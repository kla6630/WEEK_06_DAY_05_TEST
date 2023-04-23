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

import it.w06.d05.model.Dispositivo;
import it.w06.d05.service.DispositivoService;

@RestController
@RequestMapping("/dispositivi")
public class DispositivoController {

	@Autowired
	DispositivoService dispositivoService;

	@GetMapping
	public ResponseEntity<?> trovaTuttiDispositivo() {
		return new ResponseEntity<List<Dispositivo>>(dispositivoService.trovaTuttiDispositivo(), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> trovaDispositivo(@PathVariable Long id) {
		return new ResponseEntity<Dispositivo>(dispositivoService.getDispositivo(id), HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> creaDispositivo(@RequestBody Dispositivo dispositivo) {
		return new ResponseEntity<Dispositivo>(dispositivoService.creaDispositivo(dispositivo), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> cancellaDispositivo(@PathVariable Long id) {
		return new ResponseEntity<String>(dispositivoService.cancellaDispositivo(id), HttpStatus.OK);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> aggiornaDispositivo(@RequestBody Dispositivo dispositivo) {
		return new ResponseEntity<Dispositivo>(dispositivoService.updateDispositivo(dispositivo), HttpStatus.CREATED);
	}

}
