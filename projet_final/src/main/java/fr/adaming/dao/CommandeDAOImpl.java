package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Commande;

@Repository
public class CommandeDAOImpl implements ICommandeDAO {

	@Autowired
	private SessionFactory sf;

	@Override
	public List<Commande> recupererTout() {
		// ouvrir une session (bus de données -> bud)
		Session s = sf.getCurrentSession();
		// la requête HQL
		String req = "FROM Commande";

		Query query = s.createQuery(req);

		// envoie de la requête et récupération du résultat
		@SuppressWarnings("unchecked")
		List<Commande> listeCommandes = query.list();

		return listeCommandes;
	}

	@Override
	public Commande recupererParId(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Commande creer(Commande t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimer(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Commande modifier(Commande t) {
		// TODO Auto-generated method stub
		return null;
	}

}
