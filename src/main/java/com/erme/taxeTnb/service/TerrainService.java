package com.erme.taxeTnb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erme.taxeTnb.bean.Redevable;
import com.erme.taxeTnb.bean.Terrain;
import com.erme.taxeTnb.dao.TerrainRepository;

@Service
public class TerrainService {

	@Autowired
	private TerrainRepository terrainRepository;
	@Autowired
	private RedevableService redevableService;
	
	public Terrain findByReference(String reference) {
		return terrainRepository.findByReference(reference);
	}
	@Transactional
	public void updateTerrainLastYearPayed(Long id, int LastYearPayed) {
		terrainRepository.updateTerrainLastYearPayed(id, LastYearPayed);
	}



	public int save(Terrain terrain,String cin) {
		Terrain loadedTerrain = findByReference(terrain.getReference());
		Redevable loadedRedevable = redevableService.findByCin(cin);
		if (loadedTerrain!=null) {
			return -1;
		}else if(loadedRedevable == null) {
			return -2;
		}else if (terrain.getSurface()<=0) {
			return -3;
		} else {
			terrain.setRedevable(loadedRedevable);
			terrainRepository.save(terrain);
			return 1;
		}
	}
	
	public List<Terrain> findByRedevable(String cin) {
		return terrainRepository.findByRedevable(redevableService.findByCin(cin));
	}
	
	public List<Terrain> findAll() {
		return terrainRepository.findAll();
	}

	@Transactional
	public int deleteByReference(String reference) {
		return terrainRepository.deleteByReference(reference);
	}



	
	
}
