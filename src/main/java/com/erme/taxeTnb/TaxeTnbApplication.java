package com.erme.taxeTnb;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.erme.taxeTnb.bean.TauxTnb;
import com.erme.taxeTnb.bean.Terrain;
import com.erme.taxeTnb.service.TauxTnbService;
import com.erme.taxeTnb.service.TaxeTnbService;
import com.erme.taxeTnb.service.TerrainService;

@SpringBootApplication
public class TaxeTnbApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(TaxeTnbApplication.class, args);
		
		/****
		  	TerrainService terrainService = ctx.getBean(TerrainService.class);
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
		
			/*
			// Insert Taux Into DATABASE
			TauxTnbService tauxTnbService = ctx.getBean(TauxTnbService.class); 
			tauxTnbService.save(new TauxTnb(0D, 100D, 2D));
			tauxTnbService.save(new TauxTnb(100D, 200D, 4D));
			tauxTnbService.save(new TauxTnb(200D, 300D, 6D));
			tauxTnbService.save(new TauxTnb(300D, 600D, 8D));
			tauxTnbService.save(new TauxTnb(600D, 1000D, 10D));
			//TauxTnb t1 = tauxTnbService.findBySurface(50D);
			//TauxTnb t2 = tauxTnbService.findBySurface(101D);
			//System.out.println(t1);
			//System.out.println(t2); 
			 */
		
			TaxeTnbService taxeTnbService = ctx.getBean(TaxeTnbService.class);
			TerrainService terrainService = ctx.getBean(TerrainService.class);
			taxeTnbService.save("ref1", 2020, 1);
			taxeTnbService.save("ref1", 2021, 2);
			taxeTnbService.save("ref1", 2022, 0);
			taxeTnbService.save("ref3", 2020, 0);
			taxeTnbService.save("ref3", 2020, 2);
			System.out.println("---Test Find All--- ");
			System.out.println(taxeTnbService.findAll());
			System.out.println("---Test Find By Annee: 2020--- ");
			System.out.println(taxeTnbService.findByAnnee(2020));
			System.out.println("---Test Find By Terrain and Annee: ref1-2021--- ");
			System.out.println(taxeTnbService.findByTerrainAndAnnee(terrainService.findByReference("ref1"), 2021));
	}

}
