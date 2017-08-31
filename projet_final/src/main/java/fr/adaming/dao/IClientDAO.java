package fr.adaming.dao;

import fr.adaming.model.Client;

// interface ClientDao, extension de l'interface générique
public interface IClientDAO extends IGeneriqueDAO<Client> {

	// méthode permettant de déterminer si un client est Administrateur du site
	// ou non : un admin peut créer et supprimer des voyages
	public boolean isAdmin(Client client);
}
