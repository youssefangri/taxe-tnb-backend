package com.erme.taxeTnb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erme.taxeTnb.bean.TaxeTnb;
import com.erme.taxeTnb.bean.Terrain;

@Repository
public interface TaxeTnbRepository extends JpaRepository<TaxeTnb, Long> {

	TaxeTnb findByTerrain(Terrain terrain);
	List<TaxeTnb> findByAnnee(int annee);
	TaxeTnb findByTerrainAndAnnee(Terrain terrain,int annee);
}
