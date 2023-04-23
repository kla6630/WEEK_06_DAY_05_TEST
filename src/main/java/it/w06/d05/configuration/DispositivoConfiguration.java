package it.w06.d05.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import it.w06.d05.enums.StatoDispositivo;
import it.w06.d05.enums.TipologiaDispositivo;
import it.w06.d05.model.Dispositivo;

@Configuration
public class DispositivoConfiguration {

	@Bean("Dispositivo")
	@Scope("prototype")
	public Dispositivo nuovoDispositivo(TipologiaDispositivo tipologia, StatoDispositivo stato) {
		return Dispositivo.builder().tipologia(tipologia).stato(stato).build();
	}

}
