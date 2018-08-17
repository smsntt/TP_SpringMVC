package com.intiformation.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intiformation.springmvc.dao.IFonctionnaireDAO;
import com.intiformation.springmvc.entity.Fonctionnaire;

/**
 * Implémentation concrète de la couche Service
 * @author Simon Ulrich
 *
 */
@Transactional
@Service // Déclare un bean de service dans le conteneur
public class FonctionnaireService implements IFonctionnaireService{

	// Déclaration de la couche DAO
	@Autowired // Injection par type du DAO
	private IFonctionnaireDAO fonctionnaireDAO;
	
	
	@Override
	public void ajouterFonctionnaire(Fonctionnaire pFonctionnaire) {
		fonctionnaireDAO.addFonctionnaire(pFonctionnaire);
	}

	@Override
	public void modifierFonctionnaire(Fonctionnaire pFonctionnaire) {
		fonctionnaireDAO.updateFonctionnaire(pFonctionnaire);
	}

	@Override
	public void supprimerFonctionnaire(int pIdFonctionnaire) {
		fonctionnaireDAO.deleteFonctionnaire(pIdFonctionnaire);
	}

	@Override
	public Fonctionnaire findFonctionnaireById(int pIdFonctionnaire) {
		return fonctionnaireDAO.getFonctionnaireById(pIdFonctionnaire);
	}

	@Override
	public List<Fonctionnaire> findAllFonctionnaires() {
		return fonctionnaireDAO.getAllFonctionnaires();
	}


	/**
	 * Setter pour injection du DAO avec Spring
	 * @param fonctionnaireDAO
	 */
	public void setFonctionnaireDAO(IFonctionnaireDAO fonctionnaireDAO) {
		this.fonctionnaireDAO = fonctionnaireDAO;
	}

	
}
