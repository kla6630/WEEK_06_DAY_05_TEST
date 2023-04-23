package it.w06.d05.repository;

import org.springframework.data.repository.CrudRepository;

import it.w06.d05.model.Utente;

public interface UtenteDaoRepository extends CrudRepository<Utente, Long> {
//Crud repository permette di aggiungere anche delle funzioalità custom!

	// funzionalità che va a verificare se esiste un indirizzo email
	public boolean existsByEmail(String email);

	// funzionalità che ricerca l'utente attraverso l'email
	public Utente findByEmail(String email);
}
