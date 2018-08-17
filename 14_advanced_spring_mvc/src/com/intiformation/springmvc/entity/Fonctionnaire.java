package com.intiformation.springmvc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="fonctionnaire")
@Table(name="fonctionnaires")
public class Fonctionnaire implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_fonctionnaire")
	private int id;
	@Column(name="nom")
	private String nom;
	@Column(name="prenom")
	private String prenom;
	@Column(name="fonction")
	private String fonction;
	@Column(name="departement")
	private String departement;
	@Column(name="salaire")
	private double salaire;
	
	
	// Ctor
	public Fonctionnaire() {
	}
	public Fonctionnaire(String nom, String prenom, String fonction, String departement, double salaire) {
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
		this.departement = departement;
		this.salaire = salaire;
	}
	public Fonctionnaire(int id, String nom, String prenom, String fonction, String departement, double salaire) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.fonction = fonction;
		this.departement = departement;
		this.salaire = salaire;
	}
	
	
	// Getters Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getFonction() {
		return fonction;
	}
	public void setFonction(String fonction) {
		this.fonction = fonction;
	}
	public String getDepartement() {
		return departement;
	}
	public void setDepartement(String departement) {
		this.departement = departement;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	
	
}
