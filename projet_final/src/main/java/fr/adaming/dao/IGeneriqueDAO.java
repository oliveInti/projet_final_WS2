package fr.adaming.dao;

import java.util.List;

// Interface générique de la DAO, décrivant les méthodes qui seront implémentées dans les classes DAO
public interface IGeneriqueDAO<T> {

	public List<T> recupererTout();

	public T recupererParId(int i);

	public List<T> recupererParNom(String nom);

	public T creer(T t);

	public void supprimer(int i);

	public T modifier(T t);
}
