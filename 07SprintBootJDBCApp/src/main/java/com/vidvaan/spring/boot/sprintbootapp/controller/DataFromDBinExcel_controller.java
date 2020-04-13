package com.vidvaan.spring.boot.sprintbootapp.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itextpdf.text.Document;
@RequestMapping("/excel")
@RestController
public class DataFromDBinExcel_controller {
	@GetMapping(value = "/getexcel")
	public  void Convertpdf() {
	 Document document = new Document();
     try	
     {
    	 Class.forName ("oracle.jdbc.OracleDriver"); 
    	    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "chandu", "root");
    	    Statement st = con.createStatement();
    	    ResultSet rs = st.executeQuery("Select * from empl");
    	    HSSFWorkbook workbook = new HSSFWorkbook();
    	    HSSFSheet sheet = workbook.createSheet("lawix10");
    	    HSSFRow rowhead = sheet.createRow((short) 0);
    	    rowhead.createCell((short) 0).setCellValue("ENO");
    	    rowhead.createCell((short) 1).setCellValue("ENAME");
    	    rowhead.createCell((short) 2).setCellValue("SALARY");
    	    int i = 1;
    	    while (rs.next()){
    	        HSSFRow row = sheet.createRow((short) i);
    	        row.createCell((short) 0).setCellValue(Integer.toString(rs.getInt("ENO")));
    	        row.createCell((short) 1).setCellValue(rs.getString("ENAME"));
    	        row.createCell((short) 2).setCellValue(Double.toString(rs.getDouble("SALARY")));
    	        i++;
    	    }
    	    String yemi = "D:\\chanduuuuu1.xls";
    	    FileOutputStream fileOut = new FileOutputStream(yemi);
    	    workbook.write(fileOut);
    	    fileOut.close();
    	    } catch (ClassNotFoundException e1) {
    	       e1.printStackTrace();
    	    } catch (SQLException e1) {
    	        e1.printStackTrace();
    	    } catch (FileNotFoundException e1) {
    	        e1.printStackTrace();
    	    } catch (IOException e1) {
    	        e1.printStackTrace();
     }

}}
