package com.erme.taxeTnb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erme.taxeTnb.bean.Redevable;
import com.erme.taxeTnb.dao.RedevableRepository;

@Service
public class RedevableService {

	@Autowired
	private RedevableRepository redevableRepository;

	public Redevable findByCin(String cin) {
		return redevableRepository.findByCin(cin);
	}

	public List<Redevable> findAll() {
		return redevableRepository.findAll();
	}
	
	public int save(Redevable redevable) {
		Redevable loadedRedevable = findByCin(redevable.getCin());
		if (loadedRedevable!=null) {
			return -1;
		}else {
			redevableRepository.save(redevable);
			return 1;
		}
	}
	
}
