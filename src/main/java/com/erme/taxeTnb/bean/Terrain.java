package com.erme.taxeTnb.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Terrain {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
    private Double surface;
    private String reference;
	public Terrain() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Terrain(Double surface, String reference) {
		super();
		this.surface = surface;
		this.reference = reference;
	}
	public Double getSurface() {
		return surface;
	}
	public void setSurface(Double surface) {
		this.surface = surface;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(String reference) {
		this.reference = reference;
	}
	@Override
	public String toString() {
		return "Terrain [surface=" + surface + ", reference=" + reference + "]";
	}
    
}
