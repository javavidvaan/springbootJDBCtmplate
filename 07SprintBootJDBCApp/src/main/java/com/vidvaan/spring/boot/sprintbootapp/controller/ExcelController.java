package com.vidvaan.spring.boot.sprintbootapp.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/excel")
public class ExcelController {
	@GetMapping(value = "/createexcel")
	public String Createexcel() throws IOException {

		Workbook wb = new HSSFWorkbook();

		// An output stream accepts output bytes and sends them to sink.
		OutputStream fileOut = new FileOutputStream("Chandu.xlsx");

		// Creating Sheets using sheet object
		Sheet sheet1 = wb.createSheet("Array");
		Sheet sheet2 = wb.createSheet("String");
		Sheet sheet3 = wb.createSheet("LinkedList");
		Sheet sheet4 = wb.createSheet("Tree");
		Sheet sheet5 = wb.createSheet("Dynamic Programing");
		Sheet sheet6 = wb.createSheet("Puzzles");

		wb.write(fileOut);
		int noOfRows=sheet2.getLastRowNum();
		System.out.println(noOfRows);
		return "Sheets Has been Created successfully";
	}

}
