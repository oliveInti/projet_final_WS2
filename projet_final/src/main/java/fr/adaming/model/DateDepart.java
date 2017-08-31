package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//Classe dates de départ, décrit les différentes dates départ pour un voyage
@Entity // pour faire persister la classe
@Table(name = "datesDepart")
@JsonIgnoreProperties("voyage") // permet d'éviter les conflits entre datedepart
// et voyage
public class DateDepart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_d;

	private String dateDepart;

	@ManyToOne
	@JoinColumn(name = "fk_v", referencedColumnName = "id_v")
	private Voyage voyage;

	// Constructeurs : un vide puis complet et sans id
	public DateDepart() {
		super();

	}

	public DateDepart(int id_d, String dateDepart) {
		super();
		this.id_d = id_d;
		this.dateDepart = dateDepart;
	}

	public DateDepart(String dateDepart) {
		super();
		this.dateDepart = dateDepart;
	}

	// méthode toString() pour l'affichage
	@Override
	public String toString() {
		return "DateDepart [id_d=" + id_d + ", " + (dateDepart != null ? "dateDepart=" + dateDepart : "") + "]";
	}

	// getters setters des attributs
	public int getId_d() {
		return id_d;
	}

	public void setId_d(int id_d) {
		this.id_d = id_d;
	}

	public String getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Voyage getVoyage() {
		return voyage;
	}

	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}

}
