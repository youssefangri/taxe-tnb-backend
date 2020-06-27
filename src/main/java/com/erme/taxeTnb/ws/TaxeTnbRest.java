package com.erme.taxeTnb.ws;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
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

import net.sf.jasperreports.engine.JRException;
@CrossOrigin()
@RestController
@RequestMapping("/taxe-tnb/taxe")
public class TaxeTnbRest {

	@Autowired
	private TaxeTnbService taxeTnbService;

	@GetMapping("/terrain/reference/{terrainReference}")
	public TaxeTnb findByTerrain(@PathVariable String terrainReference) {
		return taxeTnbService.findByTerrainReference(terrainReference);
	}

	@GetMapping("/annee/{annee}")
	public List<TaxeTnb> findByAnnee(@PathVariable int annee) {
		return taxeTnbService.findByAnnee(annee);
	}

	@GetMapping("/")
	public List<TaxeTnb> findAll() {
		return taxeTnbService.findAll();
	}

	@GetMapping("/terrain/reference/{terrainReference}/annee/{annee}")
	public TaxeTnb findByTerrainAndAnnee(@PathVariable String terrainReference,@PathVariable int annee) {
		return taxeTnbService.findByTerrainReferenceAndAnnee(terrainReference, annee);
	}

	@PostMapping("/save/terrain/reference/{terrainReference}/annee/{annee}/cin/{cin}/date/{datePresentation}")
	public Object[] save(@PathVariable String terrainReference,@PathVariable int annee,@PathVariable String datePresentation,@PathVariable String cin) throws ParseException {
		return taxeTnbService.save(terrainReference, annee, datePresentation, cin);
	}

	@PostMapping("/simuler/terrain/reference/{terrainReference}/annee/{annee}/cin/{cin}/date/{datePresentation}")
	public Object[] simuler(@PathVariable String terrainReference,@PathVariable int annee,@PathVariable String datePresentation,@PathVariable String cin) throws ParseException {
		return taxeTnbService.simuler(terrainReference, annee, datePresentation, cin);
	}

	@GetMapping("/pdf/terrain/reference/{terrainReference}/annee/{annee}")
	public ResponseEntity<byte[]> generatePdf(@PathVariable String terrainReference,@PathVariable int annee) throws JRException {
		byte[] bytes = taxeTnbService.generatePdf(terrainReference, annee);
		HttpHeaders headers = new HttpHeaders();
		ContentDisposition contentDisposition = ContentDisposition.builder("inline")
				.filename("taxe.pdf").build();
		headers.setContentDisposition(contentDisposition);
		return ResponseEntity
				.ok()
				.header("Content-Type", "application/pdf; charset=UTF-8")
				.headers(headers)
				.body(bytes);
	}

	@GetMapping("/statistic/annee/{annee}")
	public Object[] calculeTotatMontantInYear(@PathVariable int annee) {
		return taxeTnbService.calculeTotatMontantInYear(annee);
	}

	
	
	
	
}
