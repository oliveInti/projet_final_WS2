package fr.adaming.dao;

import fr.adaming.model.Commande;

//interface CommandeDao, extension de l'interface générique
public interface ICommandeDAO extends IGeneriqueDAO<Commande> {

	// méthode permettant de calculer le prix d'une commande en fonction du
	// nombre de participants et du nombre d'enfants de moins de 12 ans présents
	public int calculerPrix(Commande commande);

}
