package com.vidvaan.spring.boot.sprintbootapp.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
@RestController
@RequestMapping("/pdf")
public class PDFcontroller {
	
	@GetMapping(value = "/changetopdf")
	public  String Convertpdf() {
	 Document document = new Document();
     try	
     {
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("HelloWorld.pdf"));
        document.open();
        document.add(new Paragraph("A Hello World PDF document."));
        
        PdfPTable table = new PdfPTable(3); 
        table.setWidthPercentage(100);
        table.setSpacingBefore(10f);
        table.setSpacingAfter(10f); 
      //Set Column widths
        float[] columnWidths = {1f, 1f, 1f};
        table.setWidths(columnWidths);
        PdfPCell cell1 = new PdfPCell(new Paragraph("Cell 1"));
        cell1.setBorderColor(BaseColor.BLUE);
        PdfPCell cell2 = new PdfPCell(new Paragraph("Cell 2"));
        cell1.setBorderColor(BaseColor.RED);
        PdfPCell cell3 = new PdfPCell(new Paragraph("Cell 3"));
        cell1.setBorderColor(BaseColor.YELLOW);
        table.addCell(cell1);
        table.addCell(cell2);
        table.addCell(cell3);
        document.add(table);
        
        document.close();
        writer.close();
     } catch (DocumentException e)
     {
        e.printStackTrace();
     } catch (FileNotFoundException e1)
     {
        e1.printStackTrace();
     }
	return "sucsess";
  }
}
