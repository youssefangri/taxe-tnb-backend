package com.erme.taxeTnb;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.erme.taxeTnb.bean.Terrain;
import com.erme.taxeTnb.service.TerrainService;

@SpringBootApplication
public class TaxeTnbApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(TaxeTnbApplication.class, args);
		
		/****
		 *  
		 * TerrainService terrainService = ctx.getBean(TerrainService.class);
			terrainService.save(new Terrain("ref1", 10D));
			terrainService.save(new Terrain("ref2", 20D));
			terrainService.save(new Terrain("ref3", 30D));
			
			Terrain terrain3 = terrainService.findByReference("ref3");
			System.out.println(terrain3);
			System.out.println();
			System.out.println("---all terrains-----");
			List<Terrain> terrains = terrainService.findAll();
			for (Terrain t : terrains) {
				System.out.println(t);
			}
			System.out.println();
			System.out.println("--- Deleting ref2 -----");
			terrainService.deleteByReference("ref2");
			*/
	}

}
