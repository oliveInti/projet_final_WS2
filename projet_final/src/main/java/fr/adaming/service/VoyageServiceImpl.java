package fr.adaming.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVoyageDAO;
import fr.adaming.model.Voyage;

//Classe impl�mentant les m�thodes Service de Voyage
@Service// permet d'identifier le bean comme un service
@Transactional// sert � pr�ciser � Spring quelles m�thodes doivent s�ex�cuter
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
