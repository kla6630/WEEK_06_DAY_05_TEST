package it.w06.d05.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.w06.d05.model.Dispositivo;
import it.w06.d05.repository.DispositivoDaoRepository;
import it.w06.d05.repository.DispositivoPageableRepository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class DispositivoService {

	@Autowired
	DispositivoDaoRepository repo;
	@Autowired
	DispositivoPageableRepository repoPageable;

	public List<Dispositivo> trovaTuttiDispositivo() {
		return (List<Dispositivo>) repo.findAll();
	}

	public Dispositivo getDispositivo(Long id) {
		if (!repo.existsById(id)) {
			throw new EntityNotFoundException("Il dispositivo non esiste");
		}
		return repo.findById(id).get();
	}

	public Dispositivo creaDispositivo(Dispositivo dispositivo) {
		if (repo.existsById(dispositivo.getId())) {
			throw new EntityExistsException("Questo dispositivo è già inserito nel nostro DB");
		} else {
			repo.save(dispositivo);
		}
		return dispositivo;
	}

	public String cancellaDispositivo(Long id) {
		if (!repo.existsById(id)) {
			throw new EntityExistsException("Il dispositivo non è presente nel nostro DB");
		}
		repo.deleteById(id);
		return "Dispositivo Cancellato";
	}

	public Dispositivo updateDispositivo(Dispositivo dispositivo) {
		if (!repo.existsById(dispositivo.getId())) {
			throw new EntityExistsException("Il dispositivo non è presente nel nostro DB");
		}
		repo.save(dispositivo);
		return dispositivo;
	}

}
