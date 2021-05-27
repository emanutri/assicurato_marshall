package it.prova.gestioneassicurato.flusso.file;

import java.io.FileOutputStream;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeFactory;

import org.springframework.stereotype.Component;

import it.prova.gestioneassicurato.flusso.marshall.Assicurati;
import it.prova.gestioneassicurato.flusso.marshall.Assicurato;

@Component
public class ObjectToXml {

//	public Assicurati marshall() throws JAXBException, FileNotFoundException {
//		JAXBContext context = JAXBContext.newInstance(Assicurati.class);
//		return (Assicurati) context.createMarshaller().marshal(new FileWriter("assicuratoXml.xml"));
//	}

	// public static void main(String[] args) throws Exception {
	public void doMarshall(it.prova.gestioneassicurato.model.Assicurato assicuratoInstance,
			String fileInCuiVa) throws Exception {

		JAXBContext contextObj = JAXBContext.newInstance(Assicurati.class);

		Marshaller marshallerObj = contextObj.createMarshaller();
		marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

		GregorianCalendar gregory = new GregorianCalendar();
		Assicurati assicurati = new Assicurati();
		Assicurato assicuratoPojo = new Assicurato();
//		for (it.prova.gestioneassicurato.model.Assicurato assicurato : assicuratiInstance) {
			assicuratoPojo.setNome(assicuratoInstance.getNome());
			assicuratoPojo.setCognome(assicuratoInstance.getCognome());
			gregory.setTime(assicuratoInstance.getDataNascita());
			assicuratoPojo.setDatanascita(DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory));
			assicuratoPojo.setNuovisinistri(assicuratoInstance.getNuoviSinistri());
			assicuratoPojo.setCodicefiscale(assicuratoInstance.getCodiceFiscale());

			assicurati.getAssicurato().add(assicuratoPojo);
//		}

//		Assicurato assicurato1 = new Assicurato();
//		Assicurato assicurato2 = new Assicurato();
//
//		DateFormat dateSimple = new SimpleDateFormat("dd/MM/yyyy");
//		Date date = dateSimple.parse("13/06/1983");
//		GregorianCalendar cal = new GregorianCalendar();
//		cal.setTime(date);
//		XMLGregorianCalendar xmlDate = DatatypeFactory.newInstance().newXMLGregorianCalendarDate(cal.get(Calendar.YEAR),
//				cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH), DatatypeConstants.FIELD_UNDEFINED);
//
//		BigInteger bigInt = BigInteger.valueOf(1);
//		BigInteger bigInt2 = BigInteger.valueOf(2);
//
//		assicurato1.setNome("simona");
//		assicurato1.setCognome("ross");
//		assicurato1.setDatanascita(xmlDate);
//		assicurato1.setNuovisinistri(bigInt);
//		assicurato1.setCodicefiscale("ertm4j5k67iowmiy");
//
//		assicurato2.setNome("francesco");
//		assicurato2.setCognome("agnelli");
//		assicurato2.setDatanascita(xmlDate);
//		assicurato2.setNuovisinistri(bigInt2);
//		assicurato2.setCodicefiscale("djhibni234rt67uh");
//
//		Assicurati assicurati = new Assicurati();
//		assicurati.getAssicurato().add(assicurato1);
//		assicurati.getAssicurato().add(assicurato2);

		marshallerObj.marshal(assicurati, new FileOutputStream(fileInCuiVa));

	}
}
