package com.erme.taxeTnb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erme.taxeTnb.bean.Terrain;

@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Long> {
	
	List<Terrain> findAll();
	Terrain findByReference(String reference);
	int deleteByReference(String reference);
}
