package com.erme.taxeTnb.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Terrain {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String reference;
    private Double surface;
    private int lastYearPayed;
    @ManyToOne
    private Redevable redevable;
    
    
	public int getLastYearPayed() {
		return lastYearPayed;
	}
	public void setLastYearPayed(int lastYearPayed) {
		this.lastYearPayed = lastYearPayed;
	}
	public Terrain() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Terrain(Long id, String reference, Double surface, int lastYearPayed) {
		super();
		this.id = id;
		this.reference = reference;
		this.surface = surface;
		this.lastYearPayed = lastYearPayed;
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
	
	public Redevable getRedevable() {
		return redevable;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setRedevable(Redevable redevable) {
		this.redevable = redevable;
	}
	@Override
	public String toString() {
		return "Terrain [id=" + id + ", reference=" + reference + ", surface=" + surface + ", lastYearPayed="
				+ lastYearPayed + "]";
	}
    
}
