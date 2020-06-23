package com.erme.taxeTnb.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@Entity
public class TaxeTnb {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private int annee;
    private Double montantBase;
    private long nombreMoisRetard;
    private Double montantRetard;
    private Double montant;
    @JsonFormat(shape = Shape.STRING,pattern = "dd-MM-yyyy")
    private Date datePresentation;
    @ManyToOne
    private Terrain terrain;
    @ManyToOne
    private TauxTnb tauxTnb;
    @ManyToOne
    private Redevable redevable;
    
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
	
	public TaxeTnb(Long id, int annee, Double montantBase, long nombreMoisRetard, Double montantRetard, Double montant,
			Date datePresentation, Terrain terrain, TauxTnb tauxTnb, Redevable redevable) {
		super();
		this.id = id;
		this.annee = annee;
		this.montantBase = montantBase;
		this.nombreMoisRetard = nombreMoisRetard;
		this.montantRetard = montantRetard;
		this.montant = montant;
		this.datePresentation = datePresentation;
		this.terrain = terrain;
		this.tauxTnb = tauxTnb;
		this.redevable = redevable;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDatePresentation() {
		return datePresentation;
	}
	public void setDatePresentation(Date datePresentation) {
		this.datePresentation = datePresentation;
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
	public long getNombreMoisRetard() {
		return nombreMoisRetard;
	}
	public void setNombreMoisRetard(long nombreMoisRetard) {
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
	
	public Redevable getRedevable() {
		return redevable;
	}
	public void setRedevable(Redevable redevable) {
		this.redevable = redevable;
	}
	@Override
	public String toString() {
		return "TaxeTnb [id=" + id + ", annee=" + annee + ", montantBase=" + montantBase + ", nombreMoisRetard="
				+ nombreMoisRetard + ", montantRetard=" + montantRetard + ", montant=" + montant + ", datePresentation="
				+ datePresentation + ", terrain=" + terrain + ", tauxTnb=" + tauxTnb + ", redevable=" + redevable + "]";
	}
	
    
    
}
