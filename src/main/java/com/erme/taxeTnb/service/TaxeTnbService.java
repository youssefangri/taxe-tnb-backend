package com.erme.taxeTnb.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erme.taxeTnb.bean.TauxTnb;
import com.erme.taxeTnb.bean.TaxeTnb;
import com.erme.taxeTnb.bean.Terrain;
import com.erme.taxeTnb.dao.TaxeTnbRepository;
import com.erme.taxeTnb.service.util.DateUtil;

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

	private Object[] save(String terrainReference, int annee, Date datePresentation, boolean simuler) {
		int res = 0;
		TaxeTnb newTaxeTnb=null;
		Terrain loadedTerrain = terrainService.findByReference(terrainReference);
		if(loadedTerrain == null) {
			res =-1;
		}
		if (findByTerrainAndAnnee(loadedTerrain, annee) !=null) {
			res = -2;
		}
		TauxTnb loadedTaux = tauxTnbService.findBySurface(loadedTerrain.getSurface());
		if (loadedTaux==null) {
			res =  -3;
		}else {
			long nombreMoisRetard = DateUtil.diff(datePresentation,annee);
			newTaxeTnb = new TaxeTnb();
			newTaxeTnb.setAnnee(annee);
			newTaxeTnb.setMontantBase(loadedTerrain.getSurface()*loadedTaux.getPrixMetreCarre());
			newTaxeTnb.setNombreMoisRetard(nombreMoisRetard);
			newTaxeTnb.setMontantRetard(newTaxeTnb.getMontantBase()*nombreMoisRetard*0.5);
			newTaxeTnb.setMontant(newTaxeTnb.getMontantBase()+newTaxeTnb.getMontantRetard());
			newTaxeTnb.setTauxTnb(loadedTaux);
			newTaxeTnb.setTerrain(loadedTerrain);
			if (simuler==false) {
				taxeTnbRepository.save(newTaxeTnb);
			}
			res =  1;
		}
		return new Object[] {res,newTaxeTnb};
	}
	public Object[] save(String terrainReference, int annee, Date datePresentation) {
		return save(terrainReference, annee, datePresentation, false);
	}
	public Object[] simuler(String terrainReference, int annee, Date datePresentation) {
		return save(terrainReference, annee, datePresentation, true);
	}
	
}
