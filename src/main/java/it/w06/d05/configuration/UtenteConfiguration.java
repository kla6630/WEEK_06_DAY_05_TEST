package it.w06.d05.configuration;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;

import it.w06.d05.model.Utente;

@Configuration
public class UtenteConfiguration {

	@Value("${utente.admin.nomeutente}")
	private String adminNomeUtente;
	@Value("${utente.admin.nome}")
	private String adminNome;
	@Value("${utente.admin.cognome}")
	private String adminCognome;
	@Value("${utente.admin.email}")
	private String adminEmail;
	@Value("${utente.admin.password}")
	private String adminPassword;

	@Bean("UtenteAdminBean")
	@Scope("singleton")
	public Utente nuovoUtenteAdmin() {
		return Utente.builder().nomeutente(adminNomeUtente).nome(adminNome).cognome(adminCognome).email(adminEmail)
				.password(adminPassword).build();

	}

	@Bean("UtenteFakeBean")
	@Scope("prototype")
	public Utente nuovoUtenteFake() {
		Faker fake = Faker.instance(new Locale("it-IT"));
		Utente u = new Utente();

		u.setNome(fake.name().firstName());
		u.setCognome(fake.name().lastName());
		u.setEmail((u.getNome() + "." + u.getCognome() + (fake.number().numberBetween(0, 99)) + "@fakemail.com").toLowerCase());
		u.setNomeutente(u.getCognome() + u.getNome() + "_" + (fake.number().numberBetween(0, 100)));
		u.setPassword((fake.internet().password(6, 10, true, true)));
		return u;
	}

	@Bean("UtenteCustomBean")
	@Scope("prototype")
	public Utente nuovoUtenteCustom() {
		return new Utente();
	}

}
