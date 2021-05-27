package it.prova.gestioneassicurato.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.prova.gestioneassicurato.model.Assicurato;
import it.prova.gestioneassicurato.repository.AssicuratoRepository;

@Service
public class AssicuratoServiceImpl implements AssicuratoService {

	@Autowired
	private AssicuratoRepository repository;

	@Override
	public List<Assicurato> listAllElements() {
		return (List<Assicurato>) repository.findAll();
	}

	@Override
	public Assicurato caricaSingoloElemento(Long id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	public Assicurato aggiorna(Assicurato assicuratoInstance) {
		return repository.save(assicuratoInstance);
	}

	@Override
	public Assicurato inserisciNuovo(Assicurato assicuratoInstance) {
		return repository.save(assicuratoInstance);
	}

	@Override
	public void rimuovi(Assicurato assicuratoInstance) {
		repository.delete(assicuratoInstance);
	}

	@Override
	public Assicurato trovaAssicurato(Assicurato assicuratoInstance) {
		String nome = assicuratoInstance.getNome();
		String cognome = assicuratoInstance.getCognome();
		String codFis = assicuratoInstance.getCodiceFiscale();
		return repository.findByNomeAndCognomeAndCodiceFiscale(nome, cognome, codFis).orElse(null);

	}

	@Override
	public Assicurato aggiornaSinistri(Assicurato assicuratoInstance) {
		String nome = assicuratoInstance.getNome();
		String cognome = assicuratoInstance.getCognome();
		String codFis = assicuratoInstance.getCodiceFiscale();
		Assicurato assicuratoTemp = repository.findByNomeAndCognomeAndCodiceFiscale(nome, cognome, codFis).get();
		assicuratoTemp.setNuoviSinistri(assicuratoTemp.getNuoviSinistri().add(assicuratoInstance.getNuoviSinistri()));

		return repository.save(assicuratoTemp);
	}
}
