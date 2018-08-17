package com.intiformation.springmvc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.intiformation.springmvc.entity.Fonctionnaire;

/**
 * Implémentation concrète de la couche DAO
 * @author Simon Ulrich
 *
 */
@Repository // Déclare un bean du DAO dans le conteneur spring
public class FonctionnaireDAO implements IFonctionnaireDAO{

	// Déclaration de la sessionFactory d'hibernate
	@Autowired // Injection par type de la sessionFactory
	private SessionFactory sessionFactory;
	
	/**
	 * Ajout dans la BDD
	 */
	@Transactional // Déclare la méthode transactionnelle
	@Override
	public void addFonctionnaire(Fonctionnaire pFonctionnaire) {
		
		sessionFactory.getCurrentSession().save(pFonctionnaire);
		
	}

	/**
	 * Modification dans la BDD
	 */
	@Transactional // Déclare la méthode transactionnelle
	@Override
	public void updateFonctionnaire(Fonctionnaire pFonctionnaire) {
		
		sessionFactory.getCurrentSession().update(pFonctionnaire);
		
	}

	/**
	 * Suppression dans la BDD
	 */
	@Transactional // Déclare la méthode transactionnelle
	@Override
	public void deleteFonctionnaire(int pIdFonctionnaire) {
		
		Fonctionnaire fonctionnaire = sessionFactory.getCurrentSession().get(Fonctionnaire.class, pIdFonctionnaire);
		
		sessionFactory.getCurrentSession().delete(fonctionnaire);
		
	}

	/**
	 * Récupère un Fonctionnaire par son ID
	 */
	@Transactional(readOnly=true) // Déclare la méthode transactionnelle en lecture seule
	@Override
	public Fonctionnaire getFonctionnaireById(int pIdFonctionnaire) {
		return sessionFactory.getCurrentSession().get(Fonctionnaire.class, pIdFonctionnaire);
	}

	/**
	 * Récupère la liste de tous les Fonctionnaires de la BDD
	 */
	@Override
	@Transactional(readOnly=true) // Déclare la méthode transactionnelle en lecture seule
	public List<Fonctionnaire> getAllFonctionnaires() {
		return sessionFactory.getCurrentSession().createQuery("FROM fonctionnaire").list();
	}


	/**
	 * Setter de la sessionFactory pour l'injection de Spring
	 * @param sessionFactory
	 */
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	
	
}
