package it.prova.gestioneassicurato.model;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "assicurato")
public class Assicurato {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotBlank(message = "{nome.notblank}")
	@Column(name = "nome")
	private String nome;

	@NotBlank(message = "{cognome.notblank}")
	@Column(name = "cognome")
	private String cognome;

	@NotNull(message = "{dataNascita.notnull}")
	@Column(name = "data_nascita")
	private Date dataNascita;

	@NotNull(message = "{nuoviSinistri.notnull}")
	@DecimalMin("0")
	@Column(name = "nuovi_sinistri")
	private BigInteger nuoviSinistri;

	@NotBlank(message = "{codiceFiscale.notblank}")
	@Column(name = "codice_fiscale")
	private String codiceFiscale;

	public Assicurato() {
	}

	public Assicurato(@NotBlank(message = "{nome.notblank}") String nome,
			@NotBlank(message = "{cognome.notblank}") String cognome,
			@NotNull(message = "{dataNascita.notnull}") Date dataNascita,
			@NotNull(message = "{nuoviSinistri.notnull}") @DecimalMin("0") BigInteger nuoviSinistri,
			@NotBlank(message = "{codiceFiscale.notblank}") String codiceFiscale) {
		super();
		this.nome = nome;
		this.cognome = cognome;
		this.dataNascita = dataNascita;
		this.nuoviSinistri = nuoviSinistri;
		this.codiceFiscale = codiceFiscale;
	}

	public Assicurato(Long id, @NotBlank(message = "{nome.notblank}") String nome,
			@NotBlank(message = "{cognome.notblank}") String cognome,
			@NotNull(message = "{dataNascita.notnull}") Date dataNascita,
			@NotNull(message = "{nuoviSinistri.notnull}") @DecimalMin("0") BigInteger nuoviSinistri,
			@NotBlank(message = "{codiceFiscale.notblank}") String codiceFiscale) {
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

	public void setNuoviSinistri(BigInteger bigInteger) {
		this.nuoviSinistri = bigInteger;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

}
