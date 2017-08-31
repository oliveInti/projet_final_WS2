package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// Classe voyage, décrit les différents voyages proposés sur notre appli
@Entity // pour faire persister la classe
@Table(name = "voyages")
@JsonIgnoreProperties("commande") // permet d'éviter les conflits entre commande
									// et voyage
public class Voyage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_v;

	private String libelle;
	private String destination;
	private String description;

	@OneToMany(mappedBy = "voyage", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<DateDepart> datesDepart;
	private int duree;
	private String urlPhoto;
	private int prix;
	private int categorie;
	@OneToOne(mappedBy = "voyage")
	private Commande commande;

	// Constructeurs : un vide puis complet, sans id et sans id sans classes
	public Voyage() {
		super();

	}

	public Voyage(int id_v, String libelle, String destination, String description, List<DateDepart> datesDepart,
			int duree, String urlPhoto, int prix, int categorie) {
		super();
		this.id_v = id_v;
		this.libelle = libelle;
		this.destination = destination;
		this.description = description;
		this.datesDepart = datesDepart;
		this.duree = duree;
		this.urlPhoto = urlPhoto;
		this.prix = prix;
		this.categorie = categorie;
	}

	public Voyage(String libelle, String destination, String description, List<DateDepart> datesDepart, int duree,
			String urlPhoto, int prix, int categorie) {
		super();
		this.libelle = libelle;
		this.destination = destination;
		this.description = description;
		this.datesDepart = datesDepart;
		this.duree = duree;
		this.urlPhoto = urlPhoto;
		this.prix = prix;
		this.categorie = categorie;

	}

	// méthode toString() pour l'affichage
	@Override
	public String toString() {
		return "Voyage [id_v=" + id_v + ", " + (libelle != null ? "libelle=" + libelle + ", " : "")
				+ (destination != null ? "destination=" + destination + ", " : "")
				+ (description != null ? "description=" + description + ", " : "")
				+ (datesDepart != null ? "datesDepart=" + datesDepart + ", " : "") + "duree=" + duree + ", "
				+ (urlPhoto != null ? "urlPhoto=" + urlPhoto + ", " : "") + "prix=" + prix + ", categorie=" + categorie
				+ "]";
	}

	// getters setters des attributs
	public int getId_v() {
		return id_v;
	}

	public void setId_v(int id_v) {
		this.id_v = id_v;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<DateDepart> getDatesDepart() {
		return datesDepart;
	}

	public void setDatesDepart(List<DateDepart> datesDepart) {
		this.datesDepart = datesDepart;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getUrlPhoto() {
		return urlPhoto;
	}

	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public int getCategorie() {
		return categorie;
	}

	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

}
