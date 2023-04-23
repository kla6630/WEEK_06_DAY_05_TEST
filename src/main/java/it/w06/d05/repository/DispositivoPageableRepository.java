package it.w06.d05.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import it.w06.d05.model.Dispositivo;

public interface DispositivoPageableRepository extends PagingAndSortingRepository<Dispositivo, Long> {

}
