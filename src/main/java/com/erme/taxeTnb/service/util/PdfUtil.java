package com.erme.taxeTnb.service.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.ResourceUtils;

import com.erme.taxeTnb.bean.TaxeTnb;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

public class PdfUtil {

	public static byte[] generatePdf(List list,String pathJrxml) throws JRException {
		byte[] bytes = null;
		try {
			File file = ResourceUtils.getFile("classpath:"+pathJrxml);
			InputStream input = new FileInputStream(file);
			JasperReport jasperReport = JasperCompileManager.compileReport(input);
			JRBeanCollectionDataSource source = new JRBeanCollectionDataSource(list);
			
			Map<String, Object> parameters = new HashMap<>();
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, source);
			//JRSaver.saveObject(jasperReport, storageService.loadJasperFile("taxe.pdf"));
			bytes = JasperExportManager.exportReportToPdf(jasperPrint);
			
			System.out.println("PDF File Generated !!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bytes;
	}
	public static byte[] generatePdf(Object object,String pathJrxml) throws JRException {
		List list = new ArrayList<>();
		if (object != null) {
			list.add(object);
		}else {
			list.add(new Object());
		}
		return generatePdf(list, pathJrxml);
	}
}
