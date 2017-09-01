package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDAO;
import fr.adaming.model.Client;

//Classe implémentant les méthodes Service de Client
@Service // permet d'identifier le bean comme un service
@Transactional // sert à préciser à Spring quelles méthodes doivent s’exécuter
				// dans une transaction
public class ClientServiceImpl implements IClientService {

	@Autowired // injection de dépendance, permet de spécifier une variable
	// d'instance à renseigner par Spring
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
