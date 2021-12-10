package javasql;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Statement;
import com.sun.javafx.scene.control.SelectedCellsMap;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class tablo extends JFrame {

	private JPanel contentPane;
	private JTable table;

	DefaultTableModel model = new DefaultTableModel();

	Object[] kolonlar = {"Ad","Soyad","Yaþ","Numara"};
	Object[] satirlar = new Object[4];	
	private JTextField txt_Ad;
	private JTextField txt_Soyad;
	private JTextField txt_Yas;
	private JTextField txt_Numara;
	private JTextField txt_adsorgu;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tablo frame = new tablo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public tablo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 513);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setBackground(new Color(45,42,54));
		setContentPane(contentPane);
		contentPane.setLayout(null);		


		JScrollPane scrollPane = new JScrollPane();		
		scrollPane.setBounds(0, 0, 474, 427);
		contentPane.add(scrollPane);

		table = new JTable();
		model.setColumnIdentifiers(kolonlar);

		table.setBounds(158, 219, 256, 123);
		scrollPane.setViewportView(table);	

		JButton btnListele = new JButton("Listele");
		btnListele.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				model.setRowCount(0);

				ResultSet myRs = baglanti.yap();

				try {
					while(myRs.next()) {
						satirlar[0] = myRs.getString("Ad");
						satirlar[1] = myRs.getString("Soyad");
						satirlar[2] = myRs.getString("Yas");
						satirlar[3] = myRs.getString("Numara");
						model.addRow(satirlar);
					}
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}

				table.setModel(model);
			}
		});
		btnListele.setBounds(186, 438, 97, 25);
		contentPane.add(btnListele);

		txt_Ad = new JTextField();
		txt_Ad.setBounds(550, 17, 116, 22);
		contentPane.add(txt_Ad);
		txt_Ad.setColumns(10);

		txt_Soyad = new JTextField();
		txt_Soyad.setBounds(550, 53, 116, 22);
		contentPane.add(txt_Soyad);
		txt_Soyad.setColumns(10);

		txt_Yas = new JTextField();
		txt_Yas.setBounds(550, 88, 116, 22);
		contentPane.add(txt_Yas);
		txt_Yas.setColumns(10);

		txt_Numara = new JTextField();
		txt_Numara.setBounds(550, 123, 116, 22);
		contentPane.add(txt_Numara);
		txt_Numara.setColumns(10);

		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// INSERT INTO ogrenci ('Ad', 'Soyad', 'Yas', 'Numara') VALUES ('Taha', 'Tangulu', 25, 16260055)

				String Ad,Soyad,Yas,Numara,sql_sorgu;

				Ad = txt_Ad.getText();
				Soyad = txt_Soyad.getText();
				Yas = txt_Yas.getText();
				Numara = txt_Numara.getText();

				sql_sorgu = "INSERT INTO ogrenci (Ad,Soyad,Yas,Numara) VALUES ("+"'" +Ad+ "','" + Soyad + "'," + "" + Yas + "," + Numara + ")";
				System.out.println(sql_sorgu);

				baglanti.ekle(sql_sorgu);
				
			}
		});
		btnKaydet.setBounds(484, 166, 83, 25);
		contentPane.add(btnKaydet);

		JLabel lblAd = new JLabel("Ad");
		lblAd.setBounds(484, 14, 56, 16);
		contentPane.add(lblAd);

		JLabel lblSoyad = new JLabel("Soyad");
		lblSoyad.setBounds(484, 50, 56, 16);
		contentPane.add(lblSoyad);

		JLabel lblYas = new JLabel("Yas");
		lblYas.setBounds(484, 85, 56, 16);
		contentPane.add(lblYas);

		JLabel lblNumara = new JLabel("Numara");
		lblNumara.setBounds(484, 120, 56, 16);
		contentPane.add(lblNumara);

		JButton btnUpdate = new JButton("Güncelle");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				String Ad,Soyad,Yas,Numara,sql_sorgu;

				Ad = txt_Ad.getText();
				Soyad = txt_Soyad.getText();
				Yas = txt_Yas.getText();
				Numara = txt_Numara.getText();
				
				sql_sorgu = "UPDATE ogrenci SET Ad="+ "'" +Ad+ "',"+"Soyad='"+Soyad+"', Yas="+Yas+",Numara="+Numara+" WHERE Numara="+Numara;
							
				System.out.println(sql_sorgu);
				
				baglanti.update(sql_sorgu);

			}
		});
		btnUpdate.setBounds(584, 166, 83, 25);
		contentPane.add(btnUpdate);
		
		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Numara,sql_sorgu;

				Numara = txt_Numara.getText();
				
				//DELETE FROM ogrenci WHERE ogr_no=no
				
				sql_sorgu = "DELETE FROM ogrenci WHERE ogrenci="+Numara;
				
				baglanti.sil(sql_sorgu);
				
			}
		});
		btnSil.setBounds(687, 166, 83, 25);
		contentPane.add(btnSil);
		
		txt_adsorgu = new JTextField();
		txt_adsorgu.setBounds(550, 213, 116, 22);
		contentPane.add(txt_adsorgu);
		txt_adsorgu.setColumns(10);
		
		JLabel lblrenciAd = new JLabel("Filtrele");
		lblrenciAd.setBounds(484, 216, 83, 16);
		contentPane.add(lblrenciAd);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Ad", "Soyad", "Yaþ", "Numara"}));
		comboBox.setBounds(687, 213, 83, 22);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Sorgula");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);
				
				String sql_sorgu=null;
				
				String alan = txt_adsorgu.getText();
				
				ResultSet myRs = null;
				
				int secilen = comboBox.getSelectedIndex();
				
				if(secilen == 0 ) {
					sql_sorgu = "select * from ogrenci where Ad like '"+ alan +"%'";
				} else if(secilen == 1)
				{
					sql_sorgu = "select * from ogrenci where Soyad like '"+ alan +"%'";
				} else if(secilen == 2)
				{
					sql_sorgu = "select * from ogrenci where Yas like '"+ alan +"%'";
				} else if(secilen == 3)
				{
					sql_sorgu = "select * from ogrenci where Numara = "+ Integer.parseInt(alan);
				}
				
								
				System.out.println(sql_sorgu);
				
				myRs = baglanti.sorgula(sql_sorgu);
				
				try {
					while(myRs.next()) {
						satirlar[0] = myRs.getString("Ad");
						satirlar[1] = myRs.getString("Soyad");
						satirlar[2] = myRs.getString("Yas");
						satirlar[3] = myRs.getString("Numara");						
						model.addRow(satirlar);
					}
				} catch (SQLException e1) {					
					e1.printStackTrace();
				}

				table.setModel(model);
				
			}
		});
		btnNewButton.setBounds(550, 246, 116, 25);
		contentPane.add(btnNewButton);

		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txt_Ad.setText(model.getValueAt(table.getSelectedRow(), 0).toString());
				txt_Soyad.setText((String) model.getValueAt(table.getSelectedRow(), 1));
				txt_Yas.setText((String) model.getValueAt(table.getSelectedRow(), 2));
				txt_Numara.setText((String) model.getValueAt(table.getSelectedRow(), 3));
			}
		});

	}
}
