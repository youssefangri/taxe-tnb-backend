package com.erme.taxeTnb.ws;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erme.taxeTnb.bean.TaxeTnb;
import com.erme.taxeTnb.bean.Terrain;
import com.erme.taxeTnb.service.TaxeTnbService;
@CrossOrigin()
@RestController
@RequestMapping("/taxe-tnb/taxe")
public class TaxeTnbRest {

	@Autowired
	private TaxeTnbService taxeTnbService;

	@GetMapping("/terrain/")
	public TaxeTnb findByTerrain(@RequestBody Terrain terrain) {
		return taxeTnbService.findByTerrain(terrain);
	}

	@GetMapping("/annee/{annee}")
	public List<TaxeTnb> findByAnnee(int annee) {
		return taxeTnbService.findByAnnee(annee);
	}

	@GetMapping("/")
	public List<TaxeTnb> findAll() {
		return taxeTnbService.findAll();
	}

	@GetMapping("/terrain/annee/cin/{cin}")
	public TaxeTnb findByTerrainAndAnnee(@RequestBody Terrain terrain,@PathVariable int annee) {
		return taxeTnbService.findByTerrainAndAnnee(terrain, annee);
	}

	@PostMapping("/save/terrain/reference/{reference}/annee/{annee}/cin/{cin}")
	public Object[] save(@PathVariable String terrainReference,@PathVariable int annee,@RequestBody Date datePresentation,@PathVariable String cin) {
		return taxeTnbService.save(terrainReference, annee, datePresentation, cin);
	}

	@PostMapping("/simuler/terrain/reference/{reference}/annee/{annee}/cin/{cin}")
	public Object[] simuler(@PathVariable String terrainReference,@PathVariable int annee,@RequestBody Date datePresentation,@PathVariable String cin) {
		return taxeTnbService.simuler(terrainReference, annee, datePresentation, cin);
	}
	
	
}
