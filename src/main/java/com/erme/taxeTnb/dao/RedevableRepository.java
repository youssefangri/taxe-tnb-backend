package com.erme.taxeTnb.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.erme.taxeTnb.bean.Redevable;
@Repository
public interface RedevableRepository extends JpaRepository<Redevable, Long>{

	Redevable findByCin(String cin);
}
