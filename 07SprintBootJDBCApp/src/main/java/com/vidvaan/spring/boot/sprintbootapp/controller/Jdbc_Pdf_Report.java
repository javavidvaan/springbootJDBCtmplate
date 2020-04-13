package com.vidvaan.spring.boot.sprintbootapp.controller;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.itextpdf.text.Document;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class Jdbc_Pdf_Report {
	public static void main(String[] args) throws Exception{
        
        /* Create Connection objects */
        Class.forName ("oracle.jdbc.OracleDriver"); 
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe", "chandu", "root");
        Statement stmt = conn.createStatement();
        /* Define the SQL query */
        ResultSet query_set = stmt.executeQuery("SELECT * FROM EMPL");
        /* Step-2: Initialize PDF documents - logical objects */
        Document my_pdf_report = new Document();
        
        
        
        PdfWriter.getInstance(my_pdf_report, new FileOutputStream("pdf_report_from_sql_using_java.pdf"));
        my_pdf_report.open();            
        //we have four columns in our table
        PdfPTable my_report_table = new PdfPTable(3);
        //create a cell object
        PdfPCell table_cell;
       
        while (query_set.next()) {                
                        String eno = query_set.getString("ENO");
                        table_cell=new PdfPCell(new Phrase(eno));
                        my_report_table.addCell(table_cell);
                        String ename=query_set.getString("ENAME");
                        table_cell=new PdfPCell(new Phrase(ename));
                        my_report_table.addCell(table_cell);
                        String salary=query_set.getString("SALARY");
                        table_cell=new PdfPCell(new Phrase(salary));
                        my_report_table.addCell(table_cell);
                        
                        }
        /* Attach report table to PDF */
        my_pdf_report.add(my_report_table);                       
        my_pdf_report.close();
        
        /* Close all DB related objects */
        query_set.close();
        stmt.close(); 
        conn.close();               
        
}

}
