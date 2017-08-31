package fr.adaming.service;

import java.util.List;

import fr.adaming.model.Voyage;

//interface VoyageService, d�crivant les m�thodes qui seront impl�ment�es dans les classes Service
public interface IVoyageService {

	public List<Voyage> recupererTout();

	public Voyage recupererParId(int i);

	public Voyage creer(Voyage v);

	public void supprimer(int id);

	public Voyage modifier(Voyage v);

	public List<Voyage> recupererParNom(String nom);
}
