package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Commande;

//interface CommandeService, décrivant les méthodes qui seront implémentées dans les classes Service
public interface ICommandeService {

	public List<Commande> recupererTout();

	public Commande recupererParId(int i);

	public Commande creer(Commande c);

	public void supprimer(int id);

	public Commande modifier(Commande c);
}
