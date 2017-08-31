package fr.adaming.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.model.DateDepart;

@Repository
public class DateDepartDaoImpl implements IDateDepartDao {
	
	@Autowired
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void supprimer(int i) {
		// TODO Auto-generated method stub

	}

	@Override
	public DateDepart modifier(DateDepart date) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(date);
		return null;
	}

}
