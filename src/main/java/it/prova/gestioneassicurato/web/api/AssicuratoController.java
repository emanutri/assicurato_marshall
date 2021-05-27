package it.prova.gestioneassicurato.web.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.prova.gestioneassicurato.flusso.file.ObjectToXml;
import it.prova.gestioneassicurato.flusso.file.XmlToObject;
import it.prova.gestioneassicurato.model.Assicurato;
import it.prova.gestioneassicurato.service.AssicuratoService;

@RestController
@RequestMapping("assicurato")
public class AssicuratoController {

	@Autowired
	private XmlToObject unmarshall;
	
	@Autowired
	private ObjectToXml marshall;
	
	@Autowired
	private AssicuratoService assicuratoService;
	
	@GetMapping("prova")
	public void controllaAssicurato() throws Exception {
		
		List<Assicurato> assicuratoList = unmarshall.doUnmarshall();
		
		for(Assicurato assicuratiItem : assicuratoList) {
			
			if(assicuratiItem.getNuoviSinistri().intValue() < 10) {
			
				if(assicuratoService.trovaAssicurato(assicuratiItem) != null) {
				
					assicuratoService.aggiornaSinistri(assicuratiItem);
					marshall.doMarshall(assicuratiItem, "processed.xml");
				
				}else {
					assicuratoService.inserisciNuovo(assicuratiItem);
					marshall.doMarshall(assicuratiItem, "processed.xml");
				}
					
				
			}else {
				marshall.doMarshall(assicuratiItem, "scarti.xml");
				
			}
		}
		
	}
	
}
