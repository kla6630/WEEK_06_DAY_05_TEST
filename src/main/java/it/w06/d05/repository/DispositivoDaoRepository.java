package it.w06.d05.repository;

import org.springframework.data.repository.CrudRepository;

import it.w06.d05.enums.StatoDispositivo;
import it.w06.d05.enums.TipologiaDispositivo;
import it.w06.d05.model.Dispositivo;

public interface DispositivoDaoRepository extends CrudRepository<Dispositivo, Long> {

	public boolean existsById(Long idLong);

	public Dispositivo findByTipologia(TipologiaDispositivo tipologiadispositivo);
	
	public Dispositivo findByStato(StatoDispositivo statodispositivo);
	
	
}
