package com.erme.taxeTnb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.erme.taxeTnb.bean.Terrain;
import com.erme.taxeTnb.dao.TerrainRepository;

@Service
public class TerrainService {

	@Autowired
	private TerrainRepository terrainRepository;
	
	public Terrain findByReference(String reference) {
		return terrainRepository.findByReference(reference);
	}
	
	public int save(Terrain terrain) {
		Terrain loadedTerrain = findByReference(terrain.getReference());
		if (loadedTerrain!=null) {
			return -1;
		}else if(terrain.getSurface()<=0) {
			return -2;
		}else {
			terrainRepository.save(terrain);
			return 1;
		}
	}
	
	public List<Terrain> findAll() {
		return terrainRepository.findAll();
	}

	@Transactional
	public int deleteByReference(String reference) {
		return terrainRepository.deleteByReference(reference);
	}
	
	
}
