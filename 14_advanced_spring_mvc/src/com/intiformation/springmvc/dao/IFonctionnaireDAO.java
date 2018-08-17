package com.intiformation.springmvc.dao;

import java.util.List;

import com.intiformation.springmvc.entity.Fonctionnaire;

/**
 * Interface de la couche DAO
 * @author Simon Ulrich
 *
 */
public interface IFonctionnaireDAO {

	public void addFonctionnaire(Fonctionnaire pFonctionnaire);
	public void updateFonctionnaire(Fonctionnaire pFonctionnaire);
	public void deleteFonctionnaire(int pIdFonctionnaire);
	public Fonctionnaire getFonctionnaireById(int pIdFonctionnaire);
	public List<Fonctionnaire> getAllFonctionnaires();
	
}
