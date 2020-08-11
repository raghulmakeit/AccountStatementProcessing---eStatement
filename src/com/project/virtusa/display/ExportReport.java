package com.project.virtusa.display;
import java.io.File;
import java.sql.SQLException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRCsvExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.JRXlsExporterParameter;

public class ExportReport {
	 public void addReport(String AccountNumber){
		 if("PDF".equals(ReportType))
			{
				//System.out.println("getReportShow()-PDF ");
				String pdfpath="pdf";
				filePath=report_path+pdfpath+File.separator+reportId+".pdf";
				
				JasperExportManager.exportReportToPdfFile(jasperPrint,filePath);
			
				
				          
			}
			if("CSV".equals(ReportType))
			{
				String xlPath="csv";
				filePath=report_path+xlPath+File.separator+reportId+".csv";
			
				JRCsvExporter exporter = new JRCsvExporter();


				exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME, filePath );
				exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING,"UTF-8");






	            exporter.exportReport();
			}
			if("EXCEL".equals(ReportType))
			{
				//System.out.println("getReportShow()-EXCEL ");
			  
				String xlPath="excel";
				filePath=report_path+xlPath+File.separator+reportId+".xls";
				
				JRXlsExporter exporter = new JRXlsExporter(); 
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,C:\Users\Raghul Make It\workspace\AccountStatement\Blank_A4_Landscape.jrxml );
				exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING,"UTF-8");
				exporter.setParameter(JRExporterParameter.IGNORE_PAGE_MARGINS,Boolean.TRUE);
				exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_COLUMNS,Boolean.TRUE);
				exporter.setParameter(JRXlsExporterParameter.IS_REMOVE_EMPTY_SPACE_BETWEEN_ROWS,Boolean.TRUE);
				exporter.setParameter(JRXlsExporterParameter.IS_IGNORE_CELL_BORDER,Boolean.TRUE);
				exporter.setParameter(JRXlsExporterParameter.IS_DETECT_CELL_TYPE,Boolean.TRUE);
				exporter.setParameter(JRXlsExporterParameter.IS_IMAGE_BORDER_FIX_ENABLED,Boolean.TRUE);
				exporter.exportReport();
		
			}
			
		    
			}
			
	 
}
