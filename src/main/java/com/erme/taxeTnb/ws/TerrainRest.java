package com.erme.taxeTnb.ws;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.erme.taxeTnb.bean.Terrain;
import com.erme.taxeTnb.service.TerrainService;
@CrossOrigin()
@RestController
@RequestMapping("/taxe-tnb/terrain")
public class TerrainRest {

	@Autowired
	private TerrainService terrainService;

	@GetMapping("/reference/{reference}")
	public Terrain findByReference(@PathVariable String reference) {
		return terrainService.findByReference(reference);
	}

	@PostMapping("/redevable/cin/{cin}")
	public int save(@RequestBody Terrain terrain,@PathVariable String cin) {
		return terrainService.save(terrain, cin);
	}

	@GetMapping("/redevable/cin/{cin}")
	public List<Terrain> findByRedevable(@PathVariable String cin) {
		return terrainService.findByRedevable(cin);
	}

	@GetMapping("/")
	public List<Terrain> findAll() {
		return terrainService.findAll();
	}

	@DeleteMapping("/reference/{reference}")
	public int deleteByReference(@PathVariable String reference) {
		return terrainService.deleteByReference(reference);
	}
	
	
	
}
