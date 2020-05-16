package com.erme.taxeTnb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erme.taxeTnb.bean.TauxTnb;
import com.erme.taxeTnb.bean.TaxeTnb;
import com.erme.taxeTnb.bean.Terrain;
import com.erme.taxeTnb.dao.TaxeTnbRepository;

@Service
public class TaxeTnbService {

	@Autowired
	private TaxeTnbRepository taxeTnbRepository;
	@Autowired
	private TerrainService terrainService;
	@Autowired
	private TauxTnbService tauxTnbService;

	public TaxeTnb findByTerrain(Terrain terrain) {
		return taxeTnbRepository.findByTerrain(terrain);
	}

	public List<TaxeTnb> findByAnnee(int annee) {
		return taxeTnbRepository.findByAnnee(annee);
	}

	public List<TaxeTnb> findAll() {
		return taxeTnbRepository.findAll();
	}
	
	
	public TaxeTnb findByTerrainAndAnnee(Terrain terrain, int annee) {
		return taxeTnbRepository.findByTerrainAndAnnee(terrain, annee);
	}

	public int save(String terrainReference, int annee, int nombreMoisRetard) {
		Terrain loadedTerrain = terrainService.findByReference(terrainReference);
		if(loadedTerrain == null) {
			return -1;
		}
		if (findByTerrainAndAnnee(loadedTerrain, annee) !=null) {
			return -2;
		}
		TauxTnb loadedTaux = tauxTnbService.findBySurface(loadedTerrain.getSurface());
		if (loadedTaux==null) {
			return -3;
		}else {
			TaxeTnb newTaxeTnb = new TaxeTnb();
			newTaxeTnb.setAnnee(annee);
			newTaxeTnb.setMontantBase(loadedTerrain.getSurface()*loadedTaux.getPrixMetreCarre());
			newTaxeTnb.setNombreMoisRetard(nombreMoisRetard);
			newTaxeTnb.setMontantRetard(newTaxeTnb.getMontantBase()*nombreMoisRetard*0.05);
			newTaxeTnb.setMontant(newTaxeTnb.getMontantBase()+newTaxeTnb.getMontantRetard());
			newTaxeTnb.setTauxTnb(loadedTaux);
			newTaxeTnb.setTerrain(loadedTerrain);
			taxeTnbRepository.save(newTaxeTnb);
			return 1;
		}
	}
	
}
