package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.DateDepart;

//Classe impl�mentant les m�thodes DAO de DateDepart
@Repository // permet d'identifier un bean de type DAO
public class DateDepartDaoImpl implements IDateDepartDao {

	@Autowired // injection de d�pendance, permet de sp�cifier une variable
	// d'instance � renseigner par Spring
	private SessionFactory sf;

	@Override
	public List<DateDepart> recupererTout() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DateDepart recupererParId(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DateDepart creer(DateDepart t) {
		Session s = sf.getCurrentSession();
		s.save(t);
		return t;
	}

	@Override
	public void supprimer(int id) {
		Session s = sf.getCurrentSession();
		DateDepart dateDepart = (DateDepart) s.get(DateDepart.class, id);
		s.delete(dateDepart);
	}

	@Override
	public DateDepart modifier(DateDepart date) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(date);
		return null;
	}

	@Override
	public List<DateDepart> recupererParNom(String nom) {
		// TODO Auto-generated method stub
		return null;
	}

}
