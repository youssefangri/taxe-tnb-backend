package com.erme.taxeTnb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erme.taxeTnb.bean.TauxTnb;
import com.erme.taxeTnb.dao.TauxTnbRepository;

@Service
public class TauxTnbService {

	@Autowired
	private TauxTnbRepository tauxTnbRepository;

	public TauxTnb findBySurface(Double surface) {
		return tauxTnbRepository.findBySurface(surface);
	}
	
	public int save(TauxTnb tauxTnb) {
		TauxTnb loadedTaux1 = findBySurface(tauxTnb.getSurfaceMax());
		//TauxTnb loadedTaux2 = findBySurface(tauxTnb.getSurfaceMin());
		if (tauxTnb.getSurfaceMax()<tauxTnb.getSurfaceMin()) {
			return -1;
		}else if (loadedTaux1 !=null /*|| loadedTaux2 !=null*/ ) {
			return -2;
		}else {
			tauxTnbRepository.save(tauxTnb);
			return 1;
		}
		
	}
}
