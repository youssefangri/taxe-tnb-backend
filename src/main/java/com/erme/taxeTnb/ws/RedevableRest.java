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

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@CrossOrigin()
@Api("Redevable is the person who pay the taxe. Use Redevable API calls to manage tax payed")
@RestController
@RequestMapping("/taxe-tnb/redevable")
public class RedevableRest {

	@Autowired
	private RedevableService redevableService;

	@ApiOperation("This methode use to get Redevable usign CIN")
	@GetMapping("/cin/{cin}")
	public Redevable findByCin(@PathVariable String cin) {
		return redevableService.findByCin(cin);
	}

	@ApiOperation("Use this methode to get a list of all Redevable in Databases")
	@GetMapping("/")
	public List<Redevable> findAll() {
		return redevableService.findAll();
	}

	@ApiOperation("Use this methode to create a new Redevable")
	@PostMapping("/")
	public int save(@RequestBody Redevable redevable) {
		return redevableService.save(redevable);
	}
}
