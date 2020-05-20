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

import com.erme.taxeTnb.bean.Redevable;
import com.erme.taxeTnb.service.RedevableService;
@CrossOrigin()
@RestController
@RequestMapping("/taxe-tnb/redevable")
public class RedevableRest {

	@Autowired
	private RedevableService redevableService;

	@GetMapping("/cin/{cin}")
	public Redevable findByCin(@PathVariable String cin) {
		return redevableService.findByCin(cin);
	}

	@GetMapping("/")
	public List<Redevable> findAll() {
		return redevableService.findAll();
	}

	@PostMapping("/")
	public int save(@RequestBody Redevable redevable) {
		return redevableService.save(redevable);
	}
}
