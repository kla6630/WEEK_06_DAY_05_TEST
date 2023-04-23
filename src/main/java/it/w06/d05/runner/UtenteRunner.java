//package it.w06.d05.runner;
//
//import org.springframework.beans.factory.ObjectProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//import it.w06.d05.model.Utente;
//import it.w06.d05.service.UtenteService;
//
//@Component
//public class UtenteRunner implements ApplicationRunner {
//
//	@Autowired
//	UtenteService utenteService;
//
//	@Autowired
//	@Qualifier("UtenteAdminBean")
//	ObjectProvider<Utente> utenteAdminBeanProvider;
//
//	@Autowired
//	@Qualifier("UtenteFakeBean")
//	ObjectProvider<Utente> utenteFakeBeanProvider;
//
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		System.out.println("Applicazione Avviata");
//		// System.out.println(utenteAdminBeanProvider.getObject());
//		// System.out.println(utenteFakeBeanProvider.getObject());
//
//		// creazione utente admin in DB:
//		// utenteService.creaUtente(utenteAdminBeanProvider.getObject());
//
//		// creazione utente fake in DB:
//	utenteService.creaUtente(utenteFakeBeanProvider.getObject());
//		
//
//	}
//
//}
