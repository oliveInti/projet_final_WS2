package fr.adaming.dao;

import fr.adaming.model.Client;

// interface ClientDao, extension de l'interface g�n�rique
public interface IClientDAO extends IGeneriqueDAO<Client> {

	// m�thode permettant de d�terminer si un client est Administrateur du site
	// ou non : un admin peut cr�er et supprimer des voyages
	public boolean isAdmin(Client client);
}
