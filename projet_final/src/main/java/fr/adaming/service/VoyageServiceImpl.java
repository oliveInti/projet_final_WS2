package fr.adaming.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVoyageDAO;
import fr.adaming.model.Voyage;

//Classe implémentant les méthodes Service de Voyage
@Service// permet d'identifier le bean comme un service
@Transactional// sert à préciser à Spring quelles méthodes doivent s’exécuter
// dans une transaction
public class VoyageServiceImpl implements IVoyageService {

	@Autowired
	private IVoyageDAO voyageDAO;
	
	@Override
	public List<Voyage> recupererTout() {
		return voyageDAO.recupererTout();
	}

	@Override
	public Voyage recupererParId(int i) {
		return voyageDAO.recupererParId(i);
	}

	@Override
	public Voyage creer(Voyage v) {
		return voyageDAO.creer(v);
	}

	@Override
	public void supprimer(int id) {
		voyageDAO.supprimer(id);

	}

	@Override
	public Voyage modifier(Voyage v) {
		
		return voyageDAO.modifier(v);
	}

	@Override
	public List<Voyage> recupererParNom(String nom) {

		return voyageDAO.recupererParNom(nom);
	}

}
