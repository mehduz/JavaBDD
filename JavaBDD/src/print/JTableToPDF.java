package print;

import java.io.*;

import javax.swing.*;

import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class JTableToPDF {

	public static void print(JTable table) {

		int count = table.getRowCount();
		Document document = new Document();
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream("C:\\Users\\n3ocat\\Bulettin.pdf"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (DocumentException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		PdfPTable tab = new PdfPTable(3);
		
//		PdfPCell cell1 = new PdfPCell(new Paragraph("Matières"));
//		PdfPCell cell2 = new PdfPCell(new Paragraph("Notes CC"));
//		PdfPCell cell3 = new PdfPCell(new Paragraph("Notes Examen"));
//		
//		cell1.setFixedHeight(30f);
//	    cell2.setFixedHeight(40f);  
//	    cell3.setFixedHeight(50f);
//		
//		tab.addCell(cell1);
//		tab.addCell(cell2);
//		tab.addCell(cell3);
		
		
		for (int i = 0; i < count; i++) {
			
//			Object obj1 = GetData(table, i, 0);
//			Object obj2 = GetData(table, i, 1);
//			Object obj3 = GetData(table, i, 2);
//			
//			PdfPCell cell11 = new PdfPCell(new Paragraph(obj1.toString()));
//			PdfPCell cell22 = new PdfPCell(new Paragraph(obj2.toString()));
//			PdfPCell cell33 = new PdfPCell(new Paragraph("Notes Examen"));
//			
//			cell11.setFixedHeight(30f);
//		    cell22.setFixedHeight(40f);  
//		    cell33.setFixedHeight(50f);
//			
//			tab.addCell(cell11);
//			tab.addCell(cell22);
//			tab.addCell(cell33);
			
//			String value1 = obj1.toString();
//			String value2 = obj2.toString();
//			String value3 = obj3.toString();
//			
//			tab.addCell(value1);
//			tab.addCell(value2);
//			tab.addCell(value3);
			
		}
		
		try {
			document.add(tab);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		document.close();

	}

	public static Object GetData(JTable table, int row_index, int col_index) {
		return table.getModel().getValueAt(row_index, col_index);
	}
	
}