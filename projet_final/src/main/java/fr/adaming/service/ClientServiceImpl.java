package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDAO;
import fr.adaming.model.Client;

//Classe impl�mentant les m�thodes Service de Client
@Service // permet d'identifier le bean comme un service
@Transactional // sert � pr�ciser � Spring quelles m�thodes doivent s�ex�cuter
				// dans une transaction
public class ClientServiceImpl implements IClientService {

	@Autowired // injection de d�pendance, permet de sp�cifier une variable
	// d'instance � renseigner par Spring
	private IClientDAO clientDAO;

	@Override
	public List<Client> recupererTout() {
		return clientDAO.recupererTout();
	}

	@Override
	public Client recupererParId(int i) {
		return clientDAO.recupererParId(i);
	}

	@Override
	public Client creer(Client c) {
		return clientDAO.creer(c);

	}

	@Override
	public void supprimer(int id) {
		clientDAO.supprimer(id);

	}

	@Override
	public Client modifier(Client c) {

		return clientDAO.modifier(c);
	}

	@Override
	public boolean isAdmin(Client client) {
		return clientDAO.isAdmin(client);

	}

	@Override
	public List<Client> recupererParNom(String nom) {
		return clientDAO.recupererParNom(nom);
	}

	@Override
	public Client login(String mail, String mdp) {
		
		return clientDAO.login(mail, mdp);
	}

}
