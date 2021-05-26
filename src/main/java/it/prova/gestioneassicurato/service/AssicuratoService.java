package it.prova.gestioneassicurato.service;

import java.util.List;

import it.prova.gestioneassicurato.model.Assicurato;

public interface AssicuratoService {

	List<Assicurato> listAllElements();
	
	Assicurato caricaSingoloElemento(Long id);
	
	Assicurato aggiorna(Assicurato assicuratoInstance);
	
	Assicurato inserisciNuovo(Assicurato assicuratoInstance);
	
	void rimuovi(Assicurato assicuratoInstance);
}
