package com.erme.taxeTnb.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;




import com.erme.taxeTnb.bean.Redevable;
import com.erme.taxeTnb.bean.TauxTnb;
import com.erme.taxeTnb.bean.TaxeTnb;
import com.erme.taxeTnb.bean.Terrain;
import com.erme.taxeTnb.dao.TaxeTnbRepository;
import com.erme.taxeTnb.jasper.StorageService;
import com.erme.taxeTnb.service.util.DateUtil;
import com.erme.taxeTnb.service.util.PdfUtil;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRSaver;

@Service
public class TaxeTnbService {

	@Autowired
	private TaxeTnbRepository taxeTnbRepository;
	@Autowired
	private TerrainService terrainService;
	@Autowired
	private TauxTnbService tauxTnbService;
	@Autowired
	private RedevableService redevableService;
	@Autowired(required=false)
	private StorageService storageService;
	public TaxeTnb findByTerrainReference(String terrainReference) {
		return taxeTnbRepository.findByTerrainReference(terrainReference);
	}

	public List<TaxeTnb> findByAnnee(int annee) {
		return taxeTnbRepository.findByAnnee(annee);
	}

	public List<TaxeTnb> findAll() {
		return taxeTnbRepository.findAll();
	}
	
	
	
	
	
	public TaxeTnb findByTerrainReferenceAndAnnee(String terrainReference, int annee) {
		return taxeTnbRepository.findByTerrainReferenceAndAnnee(terrainReference, annee);
	}
	
	public byte[] generatePdf(String terrainReference, int annee) throws JRException {
		TaxeTnb taxe= findByTerrainReferenceAndAnnee(terrainReference, annee);
		return PdfUtil.generatePdf(taxe, "jasper\\report.jrxml");
	}
	
	

	private Object[] save(String terrainReference, int annee, String datePresentationAsString,String cin, boolean simuler) throws ParseException {
		System.out.println(datePresentationAsString);
		Date datePresentation=new SimpleDateFormat("dd-MM-yyyy").parse(datePresentationAsString);
		int res = 0;
		TaxeTnb newTaxeTnb=null;
		Redevable loadedRedevable = redevableService.findByCin(cin);
		if (loadedRedevable == null) {
			res = -1;
		}
		Terrain loadedTerrain = terrainService.findByReference(terrainReference);
		if(loadedTerrain == null) {
			res = -2;
		}
		if (findByTerrainReferenceAndAnnee(terrainReference, annee) !=null) {
			res = -3;
		}
		TauxTnb loadedTaux = tauxTnbService.findBySurface(loadedTerrain.getSurface());
		if (loadedTaux==null) {
			res = -4;
		}else {
			long nombreMoisRetard = DateUtil.diff(datePresentation,annee);
			newTaxeTnb = new TaxeTnb();
			newTaxeTnb.setAnnee(annee);
			newTaxeTnb.setMontantBase(loadedTerrain.getSurface()*loadedTaux.getPrixMetreCarre());
			newTaxeTnb.setNombreMoisRetard(nombreMoisRetard);
			newTaxeTnb.setMontantRetard(newTaxeTnb.getMontantBase()*nombreMoisRetard*0.5);
			newTaxeTnb.setMontant(newTaxeTnb.getMontantBase()+newTaxeTnb.getMontantRetard());
			newTaxeTnb.setTauxTnb(loadedTaux);
			if(loadedTerrain.getLastYearPayed()<annee) {
			loadedTerrain.setLastYearPayed(annee);
			}
			newTaxeTnb.setDatePresentation(datePresentation);
			newTaxeTnb.setTerrain(loadedTerrain);
			newTaxeTnb.setRedevable(loadedRedevable);
			if (simuler==false) {
				terrainService.updateTerrainLastYearPayed(loadedTerrain.getId(), annee);
				taxeTnbRepository.save(newTaxeTnb);
			}
			res =  1;
		}
		return new Object[] {res,newTaxeTnb};
	}
	public Object[] save(String terrainReference, int annee, String datePresentation, String cin) throws ParseException {
		return save(terrainReference, annee, datePresentation,cin, false);
	}
	public Object[] simuler(String terrainReference, int annee, String datePresentation,String cin) throws ParseException {
		return save(terrainReference, annee, datePresentation,cin, true);
	}
	
}
