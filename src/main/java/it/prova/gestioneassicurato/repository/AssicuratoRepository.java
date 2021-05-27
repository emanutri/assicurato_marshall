package it.prova.gestioneassicurato.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.prova.gestioneassicurato.model.Assicurato;


public interface AssicuratoRepository extends CrudRepository<Assicurato, Long>{

	Optional<Assicurato> findByNomeAndCognomeAndCodiceFiscale(String nome, String cognome, String codiceFiscale);
}
