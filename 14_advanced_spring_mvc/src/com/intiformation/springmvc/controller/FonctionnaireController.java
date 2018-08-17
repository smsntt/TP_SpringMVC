package com.intiformation.springmvc.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.intiformation.springmvc.entity.Fonctionnaire;
import com.intiformation.springmvc.service.IFonctionnaireService;

@Controller
public class FonctionnaireController {

	// Déclaration du service
	@Autowired
	private IFonctionnaireService fonctionnaireManager;

	// Setter pour pemettre à Spring d'injecter
	public void setFonctionnaireManager(IFonctionnaireService fonctionnaireManager) {
		this.fonctionnaireManager = fonctionnaireManager;
	}
	
	/**
	 * 
	 * @param modele : modele de données à retourner vers la vue
	 * @return le nom logique de la vue
	 */
	@RequestMapping(value="/fonctionnaire/liste", method=RequestMethod.GET)
	public String listerFonctionnaires(ModelMap modele) {
		
		// Appel au service pour récupérer la liste des Fonctionnaires
		List<Fonctionnaire> listeFonctionnaire = fonctionnaireManager.findAllFonctionnaires();
		
		// Données à retourner vers la vue
		modele.addAttribute("attributeListeFonctionnaire", listeFonctionnaire);
		
		// Renvoi du nom logique de la vue
		return "fonctionnaires";
	}
	
	
	// On peut mapper une méthode sur plusieurs URL
	@RequestMapping(value= {"/fonctionnaire/delete/{fonctionnaireId}", "/fonctionnaire/remove/{fonctionnaireId}"}, method=RequestMethod.GET)
	public String deleteFonctionnaire(@PathVariable("fonctionnaireId") int pIdFonctionnaire, ModelMap modele) {
		
		// Supression du Fonctionnaire
		fonctionnaireManager.supprimerFonctionnaire(pIdFonctionnaire);
		
		// Récupération de la liste des fonctionnaires
		List<Fonctionnaire> listeFonctionnaire = fonctionnaireManager.findAllFonctionnaires();
		
		// Données à retourner vers la vue
		modele.addAttribute("attributeListeFonctionnaire", listeFonctionnaire);
				
		// Renvoi du nom logique de la vue
		//return "fonctionnaires";
		return "redirect:/fonctionnaire/liste";
	}
	
	
	/**
	 * Affiche le formulaire d'ajout de Fonctionnaire en requete GET
	 * @return
	 */
	@RequestMapping(value= "/addfonctionnaireform", method=RequestMethod.GET)
	public ModelAndView setUpFormulaire() {
		
		// Données à retourner vers la vue 
		Map<String, Object> data = new HashMap<>();
		
		// 1. Définition de l'objet de commande
		Fonctionnaire fonctionnaire = new Fonctionnaire();
		
		// 2. Définition du nom de l'objet de commande
		String objetDeCommandeFonctionnaire = "fonctionnaireCommand";
		
		// 3. Association du nom à l'objet
		data.put(objetDeCommandeFonctionnaire, fonctionnaire);
		
		// ########### Nom logique de la vue #############
		String viewName = "ajouterfonctionnaire";
		
		return new ModelAndView(viewName, data);
	}
	
	/**
	 * Ajoute un nouveau Fonctionnaire dans la BDD via le formulaire d'ajout
	 * @return
	 */
	@RequestMapping(value= "/fonctionnaire/add", method=RequestMethod.POST)
	public String addFonctionnaire(@ModelAttribute("fonctionnaireCommand") Fonctionnaire pFonctionnaire, ModelMap modele) {
		
		// Appel du Service pour l'ajout du fonctionnaire dans la BDD
		fonctionnaireManager.ajouterFonctionnaire(pFonctionnaire);
		
		// Récupération de la liste des fonctionnaires
		List<Fonctionnaire> listeFonctionnaire = fonctionnaireManager.findAllFonctionnaires();
		
		// Données à retourner vers la vue
		modele.addAttribute("attributeListeFonctionnaire", listeFonctionnaire);
				
		// Renvoi du nom logique de la vue
		//return "fonctionnaires";
		return "redirect:/fonctionnaire/liste";
	}
	
	
	/**
	 * Affiche le formulaire en réponse à une requete en GET pour la modification
	 * @return
	 */
	@RequestMapping(value= "/fonctionnaire/updatefonctionnaireform", method=RequestMethod.GET)
	public ModelAndView setUpFormulaireUpdate(@RequestParam("fonctid") int pFonctionnaireId) {
		
		// 1. Récupération d'un Fonctionnaire de la BDD (objet de commande)
		Fonctionnaire fonctionnaire = fonctionnaireManager.findFonctionnaireById(pFonctionnaireId);
		
		// nom de la vue : updatefonctionnaire -> WEB-INF/views/updatefonctionnaire.jsp
		// nom de l'objet de commande : fonctionnaireUpCommand
		// l'objet de commande : fonctionnaire
		return new ModelAndView("updatefonctionnaire", "fonctionnaireUpCommand", fonctionnaire);
	}
	
	
	@RequestMapping(value= "/fonctionnaire/update", method=RequestMethod.POST)
	public String updateFonctionnaire(@ModelAttribute("fonctionnaireCommand") Fonctionnaire pFonctionnaire, ModelMap modele) {
		
		fonctionnaireManager.modifierFonctionnaire(pFonctionnaire);
		
		// Récupération de la liste des fonctionnaires
		List<Fonctionnaire> listeFonctionnaire = fonctionnaireManager.findAllFonctionnaires();
		
		// Données à retourner vers la vue
		modele.addAttribute("attributeListeFonctionnaire", listeFonctionnaire);
				
		// Renvoi du nom logique de la vue
		//return "fonctionnaires";
		return "redirect:/fonctionnaire/liste";
	}
	
}
