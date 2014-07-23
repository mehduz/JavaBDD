package print;

import java.io.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

public class JTableToPDF {
	JTable table;
	JButton button;

	public static void JTableToPDF(String[] args) {
		new JTableToPDF();
	}

	public JTableToPDF() {
		JFrame frame = new JFrame("Getting Cell Values in JTable");
		JPanel panel = new JPanel();
		String data[][] = { { "Angelina", "Mumbai" }, { "Martina", "Delhi" } };

		String col[] = { "Name", "Address" };
		DefaultTableModel model = new DefaultTableModel(data, col);
		table = new JTable(model);
		JScrollPane pane = new JScrollPane(table);
		button = new JButton("Save to pdf");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				try {
					int count = table.getRowCount();
					Document document = new Document();
					PdfWriter.getInstance(document, new FileOutputStream(
							"C:/data.pdf"));
					document.open();
					PdfPTable tab = new PdfPTable(2);
					tab.addCell("Name");
					tab.addCell("Address");
					for (int i = 0; i < count; i++) {
						Object obj1 = GetData(table, i, 0);
						Object obj2 = GetData(table, i, 1);
						String value1 = obj1.toString();
						String value2 = obj2.toString();

						tab.addCell(value1);
						tab.addCell(value2);
					}
					document.add(tab);
					document.close();
				} catch (Exception e) {
				}
			}
		});
		panel.add(pane);
		panel.add(button);
		frame.add(panel);
		frame.setSize(500, 500);
		frame.setUndecorated(true);
		frame.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public Object GetData(JTable table, int row_index, int col_index) {
		return table.getModel().getValueAt(row_index, col_index);
	}
}