package it.prova.gestioneassicurato.dto;

import java.math.BigInteger;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import it.prova.gestioneassicurato.model.Assicurato;

public class AssicuratoDto {

	private Long id;

	@NotBlank(message = "{nome.notblank}")
	private String nome;

	@NotBlank(message = "{cognome.notblank}")
	private String cognome;

	@NotNull(message = "{dataNascita.notnull}")
	private Date dataNascita;

	@NotNull(message = "{nuoviSinistri.notull}")
	private BigInteger nuoviSinistri;

	@NotBlank(message = "{codiceFiscale.notblank}")
	@Size(max = 16, min = 16, message = "{codiceFiscale.sizeproblem}")
	private String codiceFiscale;

	public AssicuratoDto() {
	}

	public AssicuratoDto(@NotBlank(message = "{nome.notblank}") String nome,
			@NotBlank(message = "{cognome.notblank}") String cognome,
			@NotNull(message = "{dataNascita.notnull}") Date dataNascita,
			@NotNull(message = "{nuoviSinistri.notull}") BigInteger nuoviSinistri,
			@NotBlank(message = "{codiceFiscale.notblank}") @Size(max = 16, min = 16, message = "{codiceFiscale.sizeproblem}") String codiceFiscale) {
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.nuoviSinistri = nuoviSinistri;
		this.codiceFiscale = codiceFiscale;
	}

	public AssicuratoDto(Long id, @NotBlank(message = "{nome.notblank}") String nome,
			@NotBlank(message = "{cognome.notblank}") String cognome,
			@NotNull(message = "{dataNascita.notnull}") Date dataNascita,
			@NotNull(message = "{nuoviSinistri.notull}") BigInteger nuoviSinistri,
			@NotBlank(message = "{codiceFiscale.notblank}") @Size(max = 16, min = 16, message = "{codiceFiscale.sizeproblem}") String codiceFiscale) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.nuoviSinistri = nuoviSinistri;
		this.codiceFiscale = codiceFiscale;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public BigInteger getNuoviSinistri() {
		return nuoviSinistri;
	}

	public void setNuoviSinistri(BigInteger nuoviSinistri) {
		this.nuoviSinistri = nuoviSinistri;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public Assicurato buildAssicuratoModel() {
		return new Assicurato(this.nome, this.cognome, this.dataNascita, this.nuoviSinistri, this.codiceFiscale);
	}

	public static AssicuratoDto createAssicuratoDtoInstanceFromParams(String nomeInput, String cognomeInput,
			Date dataNascitaInput, BigInteger nuoviSinistri, String codiceFiscale) {

		AssicuratoDto result = new AssicuratoDto(nomeInput, cognomeInput, dataNascitaInput, nuoviSinistri,
				codiceFiscale);

		return result;
	}

	public static Assicurato createModelFromDTO(AssicuratoDto assicuratoInstance) {
		return new Assicurato(assicuratoInstance.getNome(), assicuratoInstance.getCognome(),
				assicuratoInstance.getDataNascita(), assicuratoInstance.getNuoviSinistri(),
				assicuratoInstance.getCodiceFiscale());
	}

	public static AssicuratoDto createDTOFromModel(Assicurato assicuratoInstance) {
		return new AssicuratoDto(assicuratoInstance.getId(), assicuratoInstance.getNome(),
				assicuratoInstance.getCognome(), assicuratoInstance.getDataNascita(),
				assicuratoInstance.getNuoviSinistri(), assicuratoInstance.getCodiceFiscale());
	}
}
