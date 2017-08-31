package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ICommandeDAO;
import fr.adaming.dao.IVoyageDAO;
import fr.adaming.model.Commande;

@Service
@Transactional
public class CommandeServiceImpl implements ICommandeService {

	@Autowired
	private ICommandeDAO commandeDAO;
	
	@Autowired
	private IVoyageDAO voyageDAO;

	@Override
	public List<Commande> recupererTout() {
		return commandeDAO.recupererTout();
	}

	@Override
	public Commande recupererParId(int i) {

		return commandeDAO.recupererParId(i);
	}

	@Override
	public Commande creer(Commande c) {
		
		c.setVoyage(voyageDAO.recupererParId(c.getVoyage().getId_v()));
		
		return commandeDAO.creer(c);

	}

	@Override
	public void supprimer(int id) {
		commandeDAO.supprimer(id);

	}

	@Override
	public Commande modifier(Commande c) {
		// TODO Auto-generated method stub
		return null;
	}

}
