package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Client;

//interface ClientService, d�crivant les m�thodes qui seront impl�ment�es dans les classes Service
public interface IClientService {

	public List<Client> recupererTout();

	public Client recupererParId(int i);

	public Client creer(Client c);

	public void supprimer(int id);

	public Client modifier(Client c);

	public boolean isAdmin(Client client);

	public List<Client> recupererParNom(String nom);
	
	public Client login(String mail, String mdp);
}
