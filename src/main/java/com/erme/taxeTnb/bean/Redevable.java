package com.erme.taxeTnb.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Redevable {

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private String cin;
    private String nom;
    
	public Redevable(Long id, String cin, String nom) {
		super();
		this.id = id;
		this.cin = cin;
		this.nom = nom;
	}
	public Redevable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	@Override
	public String toString() {
		return "Redevable [id=" + id + ", cin=" + cin + ", nom=" + nom + "]";
	}
    
    
}
