package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IVoyageDAO;
import fr.adaming.model.Voyage;

@Service
@Transactional
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
		// TODO Auto-generated method stub

	}

	@Override
	public Voyage modifier(Voyage v) {
		// TODO Auto-generated method stub
		return null;
	}

}
