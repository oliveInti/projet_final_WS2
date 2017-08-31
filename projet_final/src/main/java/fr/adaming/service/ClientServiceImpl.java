package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IClientDAO;
import fr.adaming.model.Client;

@Service
@Transactional
public class ClientServiceImpl implements IClientService {

	@Autowired
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
//		clientDAO.supprimer(id);

	}

	@Override
	public Client modifier(Client c) {
		// TODO Auto-generated method stub
		return null;
	}

}
