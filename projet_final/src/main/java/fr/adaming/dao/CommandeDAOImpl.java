package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Commande;
import fr.adaming.model.Voyage;

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
		Session s = sf.getCurrentSession();
		Commande varCommande = (Commande) s.get(Commande.class, i);
		return varCommande;
	}

	@Override
	public Commande creer(Commande co) {
		Session s = sf.getCurrentSession();

		System.out.println("AVANT : " + co);		
		co.setPrixTotal(calculerPrix(co));
		
		s.save(co);

		return co;
	}

	@Override
	public void supprimer(int id) {
		Session s = sf.getCurrentSession();
		Commande commande = (Commande) s.get(Commande.class, id);
		s.delete(commande);

	}

	@Override
	public Commande modifier(Commande t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int calculerPrix(Commande commande) {

		System.out.println("prix voyage 1 : " + commande.getVoyage().getPrix());
		
		int voyageurs = commande.getNbAdulte() + commande.getNbEnfant();

		float prixTotal = (commande.getVoyage().getPrix() * (commande.getNbAdulte() + (commande.getNbEnfant() * 0.7f)));

		System.out.println("nb adultes : " + commande.getNbAdulte());
		System.out.println("nb enfants : " + commande.getNbEnfant());
		
		System.out.println("prix total 1 : " + prixTotal);
		
		if (voyageurs > 10) {
			if (voyageurs > 30) {
				prixTotal = prixTotal * 0.8f;
			} else {
				prixTotal = prixTotal * 0.9f;
			}
		}

		System.out.println("prix total 2 : " + prixTotal);
		
		return (int)prixTotal;
	}

}
