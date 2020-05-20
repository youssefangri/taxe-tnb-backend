package com.erme.taxeTnb.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erme.taxeTnb.bean.TauxTnb;
import com.erme.taxeTnb.service.TauxTnbService;
@CrossOrigin()
@RestController
@RequestMapping("/taxe-tnb/taux")
public class TauxTnbRest {

	@Autowired
	private TauxTnbService tauxTnbService;

	@GetMapping("/")
	public List<TauxTnb> findAll() {
		return tauxTnbService.findAll();
	}
	@GetMapping("/surface/{surface}")
	public TauxTnb findBySurface(@PathVariable Double surface) {
		return tauxTnbService.findBySurface(surface);
	}

	@PostMapping("/")
	public int save(@RequestBody TauxTnb tauxTnb) {
		return tauxTnbService.save(tauxTnb);
	}
}
