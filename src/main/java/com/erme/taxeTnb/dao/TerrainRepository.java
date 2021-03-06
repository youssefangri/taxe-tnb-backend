package com.erme.taxeTnb.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.erme.taxeTnb.bean.Redevable;
import com.erme.taxeTnb.bean.Terrain;

@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Long> {
	
	List<Terrain> findAll();
	Terrain findByReference(String reference);
	int deleteByReference(String reference);
	@Modifying 
	@Query(value = "update Terrain t set t.last_year_payed = ?2 where t.id = ?1",nativeQuery = true)
	void updateTerrainLastYearPayed(Long id, int LastYearPayed);
	List<Terrain> findByRedevable(Redevable redevable);
}
