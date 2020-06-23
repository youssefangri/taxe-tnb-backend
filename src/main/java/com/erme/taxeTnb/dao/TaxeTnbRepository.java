package com.erme.taxeTnb.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erme.taxeTnb.bean.TaxeTnb;
import com.erme.taxeTnb.bean.Terrain;

@Repository
public interface TaxeTnbRepository extends JpaRepository<TaxeTnb, Long> {

	TaxeTnb findByTerrainReference(String terrainReference);
	List<TaxeTnb> findByAnnee(int annee);
	TaxeTnb findByTerrainReferenceAndAnnee(String terrainReference,int annee);
	//find by annee max et min
}
