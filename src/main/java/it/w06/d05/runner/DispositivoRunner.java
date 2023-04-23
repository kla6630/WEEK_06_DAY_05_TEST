//package it.w06.d05.runner;
//
//import org.springframework.beans.factory.ObjectProvider;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;
//import org.springframework.stereotype.Component;
//
//import it.w06.d05.model.Dispositivo;
//import it.w06.d05.service.DispositivoService;
//
//
//@Component
//public class DispositivoRunner implements ApplicationRunner {
//
//	@Autowired
//	DispositivoService dispositivoService;
//
//	@Autowired
//	@Qualifier("DispositivoFakeBean")
//	ObjectProvider<Dispositivo> dispositivoFakeBeanProvider;
//
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		
//		// System.out.println(dispositivoFakeBeanProvider.getObject());
//
//		dispositivoService.creaDispositivo(dispositivoFakeBeanProvider.getObject());
//		
//
//	}
//
//}
