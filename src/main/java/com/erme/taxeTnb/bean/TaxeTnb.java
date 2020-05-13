package com.erme.taxeTnb.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class TaxeTnb {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private int annee;
    private Double montantBase;
    private int nombreMoisRetard;
    private Double montantRetard;
    private Double montant;
    @OneToOne
    private Terrain terrain;
    @OneToOne
    private TauxTnb tauxTnb;
	public TaxeTnb() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TaxeTnb(int annee, Double montantBase, int nombreMoisRetard, Double montantRetard, Double montant,
			Terrain terrain, TauxTnb tauxTnb) {
		super();
		this.annee = annee;
		this.montantBase = montantBase;
		this.nombreMoisRetard = nombreMoisRetard;
		this.montantRetard = montantRetard;
		this.montant = montant;
		this.terrain = terrain;
		this.tauxTnb = tauxTnb;
	}
	public int getAnnee() {
		return annee;
	}
	public void setAnnee(int annee) {
		this.annee = annee;
	}
	public Double getMontantBase() {
		return montantBase;
	}
	public void setMontantBase(Double montantBase) {
		this.montantBase = montantBase;
	}
	public int getNombreMoisRetard() {
		return nombreMoisRetard;
	}
	public void setNombreMoisRetard(int nombreMoisRetard) {
		this.nombreMoisRetard = nombreMoisRetard;
	}
	public Double getMontantRetard() {
		return montantRetard;
	}
	public void setMontantRetard(Double montantRetard) {
		this.montantRetard = montantRetard;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public Terrain getTerrain() {
		return terrain;
	}
	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}
	public TauxTnb getTauxTnb() {
		return tauxTnb;
	}
	public void setTauxTnb(TauxTnb tauxTnb) {
		this.tauxTnb = tauxTnb;
	}
	@Override
	public String toString() {
		return "TaxeTnb [annee=" + annee + ", montantBase=" + montantBase + ", nombreMoisRetard=" + nombreMoisRetard
				+ ", montantRetard=" + montantRetard + ", montant=" + montant + "]";
	}
    
    
}
