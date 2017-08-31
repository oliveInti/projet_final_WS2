package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;

public interface IClientService {

	public List<Client> recupererTout();

	public Client recupererParId(int i);

	public Client creer(Client c);

	public void supprimer(int id);

	public Client modifier(Client c);
	
	public boolean isAdmin(Client client);
}
