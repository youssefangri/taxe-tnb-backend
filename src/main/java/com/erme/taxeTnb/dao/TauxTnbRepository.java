package com.erme.taxeTnb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.erme.taxeTnb.bean.TauxTnb;

@Repository
public interface TauxTnbRepository extends JpaRepository<TauxTnb, Long> {

	//@Query("select taux from TauxTnb taux where :surface between taux.surfaceMin and taux.surfaceMax")
	@Query("select taux from TauxTnb taux where :surface>taux.surfaceMin and :surface<= taux.surfaceMax")
	TauxTnb findBySurface(@Param("surface") Double surface); 
	
}
