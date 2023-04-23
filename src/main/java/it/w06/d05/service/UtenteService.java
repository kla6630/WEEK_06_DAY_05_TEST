package it.w06.d05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.w06.d05.model.Utente;
import it.w06.d05.repository.UtenteDaoRepository;
import it.w06.d05.repository.UtentePageableRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class UtenteService {

	@Autowired
	UtenteDaoRepository repo;
	@Autowired
	UtentePageableRepository repoPageable;

	public List<Utente> trovaTuttiGliUtente() {
		return (List<Utente>) repo.findAll();
	}

	public Utente getUtente(Long id) {
		if (!repo.existsById(id)) {
			throw new EntityNotFoundException("L'utente non esiste");
		}
		return repo.findById(id).get();
	}

	public Utente creaUtente(Utente utente) {
		if (repo.existsByEmail(utente.getEmail())) {
			throw new EntityExistsException("L'indirizzo email è già registrato nei nostri sistemi");
		} else {
			repo.save(utente);
		}
		return utente;
	}

	public String cancellaUtente(Long id) {
		if (!repo.existsById(id)) {
			throw new EntityExistsException("L'utente non esiste");
		}
		repo.deleteById(id);
		return "Utente Cancellato";
	}

	public Utente updateUtente(Utente utente) {
		if (!repo.existsById(utente.getId())) {
			throw new EntityExistsException("L'utente non esiste");
		}
		repo.save(utente);
		return utente;
	}

}
