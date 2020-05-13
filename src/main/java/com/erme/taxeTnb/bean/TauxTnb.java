package com.erme.taxeTnb.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class TauxTnb {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private Double surfaceMin;
    private Double surfaceMax;
    private Double prixMetreCarre;
	public TauxTnb() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TauxTnb(Double surfaceMin, Double surfaceMax, Double prixMetreCarre) {
		super();
		this.surfaceMin = surfaceMin;
		this.surfaceMax = surfaceMax;
		this.prixMetreCarre = prixMetreCarre;
	}
	public Double getSurfaceMin() {
		return surfaceMin;
	}
	public void setSurfaceMin(Double surfaceMin) {
		this.surfaceMin = surfaceMin;
	}
	public Double getSurfaceMax() {
		return surfaceMax;
	}
	public void setSurfaceMax(Double surfaceMax) {
		this.surfaceMax = surfaceMax;
	}
	public Double getPrixMetreCarre() {
		return prixMetreCarre;
	}
	public void setPrixMetreCarre(Double prixMetreCarre) {
		this.prixMetreCarre = prixMetreCarre;
	}
	@Override
	public String toString() {
		return "TauxTnb [id=" + id + ", surfaceMin=" + surfaceMin + ", surfaceMax=" + surfaceMax + ", prixMetreCarre="
				+ prixMetreCarre + "]";
	}
    
}
