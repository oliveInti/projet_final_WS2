package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

// Classe Client, décrit le client qui veut passer commande sur l'appli
@Entity // pour faire persister la classe
@Table(name = "clients")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_c;
	private String nom;
	private String prenom;
	private String mail;
	private String mdp;

	@Column(nullable = false, columnDefinition = "TINYINT", length = 1)
	private boolean admin;

	@OneToOne(mappedBy = "client")
	private Commande commande;

	// Constructeurs : un vide puis complet, sans id et sans id sans classes
	public Client(String nom, String prenom, String mail, String mdp, boolean admin) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
		this.admin = admin;
	}

	public Client(int id_c, String nom, String prenom, String mail, String mdp, boolean admin) {
		super();
		this.id_c = id_c;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.mdp = mdp;
		this.admin = admin;
	}

	public Client() {
		super();

	}

	// getters setters des attributs
	public int getId_c() {
		return id_c;
	}

	public void setId_c(int id_c) {
		this.id_c = id_c;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	// méthode toString() pour l'affichage
	@Override
	public String toString() {
		return "Client [id_c=" + id_c + ", " + (nom != null ? "nom=" + nom + ", " : "")
				+ (prenom != null ? "prenom=" + prenom + ", " : "") + (mail != null ? "mail=" + mail + ", " : "")
				+ (mdp != null ? "mdp=" + mdp + ", " : "") + "admin=" + admin + "]";
	}

}
