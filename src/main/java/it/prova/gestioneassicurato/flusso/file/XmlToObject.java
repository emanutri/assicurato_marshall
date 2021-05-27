package it.prova.gestioneassicurato.flusso.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.stereotype.Component;

import it.prova.gestioneassicurato.flusso.marshall.Assicurati;
import it.prova.gestioneassicurato.flusso.marshall.Assicurato;

@Component
public class XmlToObject {

//	public Assicurati unmarshall() throws JAXBException, FileNotFoundException {
//		JAXBContext context = JAXBContext.newInstance(Assicurati.class);
//		return (Assicurati) context.createUnmarshaller().unmarshal(new FileReader("assicuratoXml.xml"));
//	}

//	public static void main(String[] args) {
	public List<it.prova.gestioneassicurato.model.Assicurato> doUnmarshall() throws Exception{

		List<it.prova.gestioneassicurato.model.Assicurato> assicuratoList = new ArrayList<>();

		try {

			File file = new File("assicuratoXml.xml");
			JAXBContext jaxbContext = JAXBContext.newInstance(Assicurati.class);

			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Assicurati assicurati = (Assicurati) jaxbUnmarshaller.unmarshal(file);

//			assicuratoList = assicurati.getAssicurato();
			for (Assicurato assicurato : assicurati.getAssicurato()) {
				it.prova.gestioneassicurato.model.Assicurato assicuratoModel = new it.prova.gestioneassicurato.model.Assicurato();
				assicuratoModel.setNome(assicurato.getNome());
				assicuratoModel.setCognome(assicurato.getCognome());
				assicuratoModel.setDataNascita(assicurato.getDatanascita().toGregorianCalendar().getTime());
				assicuratoModel.setNuoviSinistri(assicurato.getNuovisinistri());
				assicuratoModel.setCodiceFiscale(assicurato.getCodicefiscale());
				assicuratoList.add(assicuratoModel);
//				assicurati.getAssicurato().add(assicurato);
//				System.out.println(assicurato.getCognome() + assicurato.getNuovisinistri());
			}
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return assicuratoList;

	}
}