package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Voyage;

@Repository
public class VoyageDAOImpl implements IVoyageDAO {

	@Autowired
	private SessionFactory sf;

	@Override
	public List<Voyage> recupererTout() {
		// ouvrir une session (bus de donn�es -> bud)

		Session s = sf.getCurrentSession();
		// la requ�te HQL
		String req = "FROM Voyage";

		Query query = s.createQuery(req);

		// envoie de la requ�te et r�cup�ration du r�sultat
		@SuppressWarnings("unchecked")
		List<Voyage> liste = query.list();

		return liste;
	}

	@Override
	public Voyage recupererParId(int i) {
		Session s = sf.getCurrentSession();
		Voyage varVoyage = (Voyage) s.get(Voyage.class, i);
		return varVoyage;
	}

	@Override
	public Voyage creer(Voyage t) {
		// ouvrir une session (bus de donn�es -> bdd)
		Session s = sf.getCurrentSession();
		// ajouter l'employ� dans le context Hibernate
		s.save(t);
		return null;
	}

	@Override
	public void supprimer(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Voyage modifier(Voyage t) {
		// TODO Auto-generated method stub
		return null;
	}

}
