package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;

//Classe impl�mentant les m�thodes DAO de Client
@Repository // permet d'identifier un bean de type DAO
public class ClientDAOImpl implements IClientDAO {

	@Autowired // injection de d�pendance, permet de sp�cifier une variable
	// d'instance � renseigner par Spring
	private SessionFactory sf;

	@Override
	public List<Client> recupererTout() {
		// ouvrir une session
		Session s = sf.getCurrentSession();
		// la requ�te HQL
		String req = "FROM Client";

		Query query = s.createQuery(req);

		// envoie de la requ�te et r�cup�ration du r�sultat
		@SuppressWarnings("unchecked")
		List<Client> listeClients = query.list();
		return listeClients;
	}

	@Override
	public Client recupererParId(int i) {
		Session s = sf.getCurrentSession();
		Client varClient = (Client) s.get(Client.class, i);
		return varClient;
	}

	@Override
	public Client creer(Client t) {
		Session s = sf.getCurrentSession();
		s.save(t);
		return t;
	}

	@Override
	public void supprimer(int id) {
		Session s = sf.getCurrentSession();
		Client client = (Client) s.get(Client.class, id);
		s.delete(client);
	}

	@Override
	public Client modifier(Client t) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(t);
		return t;
	}

	@Override
	public boolean isAdmin(Client client) {
		Session s = sf.getCurrentSession();
		String req = "FROM Client as c WHERE mail=? AND admin='true'";
		Query query = s.createQuery(req);
		query.setParameter(1, client.getMail());

		@SuppressWarnings("unchecked")
		List<Client> clients = query.list();

		int verif = clients.size();
		return (verif == 1);
	}

	@Override
	public List<Client> recupererParNom(String nom) {
		Session s = sf.getCurrentSession();
		String req = "FROM Client as c WHERE c.nom like :name";
		Query query = s.createQuery(req);
		query.setParameter("name", nom);
		@SuppressWarnings("unchecked")
		List<Client> listeClients = query.list();
		return listeClients;
	}

	@Override
	public Client login(String mail, String mdp) {
		Session s = sf.getCurrentSession();

		String req = "FROM Client as c WHERE mail=? AND mdp=?";
		Query query = s.createQuery(req);

		query.setParameter(0, mail);
		query.setParameter(1, mdp);

		Client client = (Client) query.uniqueResult();

		if (client != null ) {
			return client;
		} else {

			return null;
		}
	}

}
