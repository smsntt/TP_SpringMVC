package com.intiformation.springmvc.service;

import java.util.List;

import com.intiformation.springmvc.entity.Fonctionnaire;

/**
 * Interface de la couche service
 * @author Simon Ulrich
 *
 */
public interface IFonctionnaireService {

	public void ajouterFonctionnaire(Fonctionnaire pFonctionnaire);
	public void modifierFonctionnaire(Fonctionnaire pFonctionnaire);
	public void supprimerFonctionnaire(int pIdFonctionnaire);
	public Fonctionnaire findFonctionnaireById(int pIdFonctionnaire);
	public List<Fonctionnaire> findAllFonctionnaires();
	
}
