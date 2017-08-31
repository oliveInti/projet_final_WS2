package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Client;
import fr.adaming.model.DateDepart;
import fr.adaming.model.Voyage;

@Repository
public class VoyageDAOImpl implements IVoyageDAO {

	@Autowired
	private SessionFactory sf;

	@Override
	public List<Voyage> recupererTout() {
		// ouvrir une session (bus de données -> bud)

		Session s = sf.getCurrentSession();
		// la requête HQL
		String req = "FROM Voyage";

		Query query = s.createQuery(req);

		// envoie de la requête et récupération du résultat
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
	public Voyage creer(Voyage v) {
		// ouvrir une session (bus de données -> bdd)
		Session s = sf.getCurrentSession();
		// ajouter l'employé dans le context Hibernate
		s.save(v);
		for (DateDepart date : v.getDatesDepart()) {
			date.setVoyage(v);
			s.save(date);
		}

		// t.getId_v();
		return null;
	}

	@Override
	public void supprimer(int id) {
		Session s = sf.getCurrentSession();
		Voyage voyage = (Voyage) s.get(Voyage.class, id);
		s.delete(voyage);
	}

	@Override
	public Voyage modifier(Voyage t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Voyage> recupererParNom(String nom) {
		Session s = sf.getCurrentSession();
		String req = "FROM Voyage as v WHERE v.destination like :name";
		Query query = s.createQuery(req);
		query.setParameter("name", nom);
		List<Voyage> listeVoyages = query.list();
		return listeVoyages;
	}

}
