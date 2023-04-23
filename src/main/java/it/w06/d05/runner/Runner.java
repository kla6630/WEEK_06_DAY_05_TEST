package it.w06.d05.runner;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import it.w06.d05.model.Dispositivo;
import it.w06.d05.model.Utente;
import it.w06.d05.service.DispositivoService;
import it.w06.d05.service.UtenteService;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Runner implements ApplicationRunner {

	@Autowired
	UtenteService utenteService;

	@Autowired
	DispositivoService dispositivoService;

	@Autowired
	@Qualifier("UtenteAdminBean")
	ObjectProvider<Utente> utenteAdminBeanProvider;

	@Autowired
	@Qualifier("UtenteFakeBean")
	ObjectProvider<Utente> utenteFakeBeanProvider;

	@Autowired
	@Qualifier("DispositivoFakeBean")
	ObjectProvider<Dispositivo> dispositivoFakeBeanProvider;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Applicazione Avviata");

		utenteService.creaUtente(utenteAdminBeanProvider.getObject());
		dispositivoService.creaDispositivo(dispositivoFakeBeanProvider.getObject());

	}

}