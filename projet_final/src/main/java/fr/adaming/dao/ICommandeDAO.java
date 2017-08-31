package fr.adaming.dao;

import fr.adaming.model.Commande;

//interface CommandeDao, extension de l'interface g�n�rique
public interface ICommandeDAO extends IGeneriqueDAO<Commande> {

	// m�thode permettant de calculer le prix d'une commande en fonction du
	// nombre de participants et du nombre d'enfants de moins de 12 ans pr�sents
	public int calculerPrix(Commande commande);

}
