package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.Commande;

// Classe impl�mentant les m�thodes DAO de Commande
@Repository // permet d'identifier un bean de type DAO
public class CommandeDAOImpl implements ICommandeDAO {

	@Autowired // injection de d�pendance, permet de sp�cifier une variable
	// d'instance � renseigner par Spring
	private SessionFactory sf;

	@Override
	public List<Commande> recupererTout() {
		// ouvrir une session (bus de donn�es -> bud)
		Session s = sf.getCurrentSession();
		// la requ�te HQL
		String req = "FROM Commande";

		Query query = s.createQuery(req);

		// envoie de la requ�te et r�cup�ration du r�sultat
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
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(t);
		return t;
	}

	@Override // calcul du prix total : prix enfant = (prix adulte)*0.7
	// r�ductions = pour un groupe de 10 � 30 personnes : 10% de r�duction
	// pour un groupe de plus de 30 personnes : 20% de r�duction
	public int calculerPrix(Commande commande) {

		int voyageurs = commande.getNbAdulte() + commande.getNbEnfant();

		float prixTotal = (commande.getVoyage().getPrix() * (commande.getNbAdulte() + (commande.getNbEnfant() * 0.7f)));

		if (voyageurs > 10) {
			if (voyageurs > 30) {
				prixTotal = prixTotal * 0.8f;
			} else {
				prixTotal = prixTotal * 0.9f;
			}
		}

		return (int) prixTotal;
	}

	@Override
	public List<Commande> recupererParNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

}
