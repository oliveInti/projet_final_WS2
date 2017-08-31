package fr.adaming.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "commandes")
//@JsonIgnoreProperties("client")
public class Commande implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne
	@JoinColumn(name = "fk_c", referencedColumnName = "id_c")
	private Client client;
	@OneToOne
	@JoinColumn(name = "fk_v", referencedColumnName = "id_v")
	private Voyage voyage;
	private String agence;
	private int nbAdulte;
	private int nbEnfant;
	private int prixTotal;

	public Commande() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Commande(int id, Client client, Voyage voyage, String agence, int nbAdulte, int nbEnfant, int prixTotal) {
		super();
		this.id = id;
		this.client = client;
		this.voyage = voyage;
		this.agence = agence;
		this.nbAdulte = nbAdulte;
		this.nbEnfant = nbEnfant;
		this.prixTotal = prixTotal;
	}

	public Commande(Client client, Voyage voyage, String agence, int nbAdulte, int nbEnfant, int prixTotal) {
		super();
		this.client = client;
		this.voyage = voyage;
		this.agence = agence;
		this.nbAdulte = nbAdulte;
		this.nbEnfant = nbEnfant;
		this.prixTotal = prixTotal;
	}

	public Commande(Client client, Voyage voyage, String agence, int nbAdulte, int nbEnfant) {
		super();
		this.client = client;
		this.voyage = voyage;
		this.agence = agence;
		this.nbAdulte = nbAdulte;
		this.nbEnfant = nbEnfant;
	}

	@Override
	public String toString() {
		return "Commande [id=" + id + ", " + (client != null ? "client=" + client + ", " : "")
				+ (voyage != null ? "voyage=" + voyage + ", " : "") + (agence != null ? "agence=" + agence + ", " : "")
				+ "nbAdulte=" + nbAdulte + ", nbEnfant=" + nbEnfant + ", prixTotal=" + prixTotal + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Voyage getVoyage() {
		return voyage;
	}

	public void setVoyage(Voyage voyage) {
		this.voyage = voyage;
	}

	public String getAgence() {
		return agence;
	}

	public void setAgence(String agence) {
		this.agence = agence;
	}

	public int getNbAdulte() {
		return nbAdulte;
	}

	public void setNbAdulte(int nbAdulte) {
		this.nbAdulte = nbAdulte;
	}

	public int getNbEnfant() {
		return nbEnfant;
	}

	public void setNbEnfant(int nbEnfant) {
		this.nbEnfant = nbEnfant;
	}

	public int getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(int prixTotal) {
		this.prixTotal = prixTotal;
	}

}
