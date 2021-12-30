package javasql;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;


import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;

public class arayuz extends JFrame {

	private JPanel contentPane;
	private JTable table;

	DefaultTableModel model = new DefaultTableModel();

	Object[] kolonlar = { "Birim", "Alış", "Satış", "Durum", "Tarih" ,"Saat"};
	Object[] satirlar = new Object[6];
	private JTextField txt_Birim;
	private JTextField txt_Alis;
	private JTextField txt_Satis;
	private JTextField txt_Artis;
	private JTextField txt_Tarih;
	private JTextField txt_Saat;
	private JTextField txt_birimsorgu;
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					arayuz frame = new arayuz();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public arayuz() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 808, 513);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		// contentPane.setBackground(new Color(45,42,54));
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
					while (myRs.next()) {
						satirlar[0] = myRs.getString("Birim");
						satirlar[1] = myRs.getString("Alis");
						satirlar[2] = myRs.getString("Satis");
						satirlar[3] = myRs.getString("Artis");
						satirlar[4] = myRs.getString("Tarih");
						satirlar[5] = myRs.getString("Saat");
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

		txt_Birim = new JTextField();
		txt_Birim.setBounds(550, 18, 116, 20);
		contentPane.add(txt_Birim);
		txt_Birim.setColumns(10);

		txt_Alis = new JTextField();
		txt_Alis.setBounds(550, 54, 116, 20);
		contentPane.add(txt_Alis);
		txt_Alis.setColumns(10);

		txt_Satis = new JTextField();
		txt_Satis.setBounds(550, 89, 116, 20);
		contentPane.add(txt_Satis);
		txt_Satis.setColumns(10);

		txt_Artis = new JTextField();
		txt_Artis.setBounds(550, 124, 116, 20);
		contentPane.add(txt_Artis);
		txt_Artis.setColumns(10);
		
		txt_Tarih = new JTextField();
		txt_Tarih.setBounds(550, 123, 116, 22);
		contentPane.add(txt_Artis);
		txt_Tarih.setColumns(10);
		
		txt_Saat = new JTextField();
		txt_Saat.setBounds(550, 123, 116, 22);
		contentPane.add(txt_Artis);
		txt_Saat.setColumns(10);
		
		txt_Tarih = new JTextField();
		txt_Tarih.setBounds(550, 158, 116, 20);
		contentPane.add(txt_Tarih);
		txt_Tarih.setColumns(10);
		

		txt_Saat = new JTextField();
		txt_Saat.setBounds(550, 189, 116, 20);
		contentPane.add(txt_Saat);
		txt_Saat.setColumns(10);


		JButton btnKaydet = new JButton("Kaydet");
		btnKaydet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				// INSERT INTO borsa ('Birim', 'Alis', 'Satis', 'Artis') VALUES ('Taha',
				// 'Tangulu', 25, 16260055)

				String Birim, Alis, Satis, Artis, Tarih, Saat, sql_sorgu;

				Birim = txt_Birim.getText();
				Alis = txt_Alis.getText();
				Satis = txt_Satis.getText();
				Artis = txt_Artis.getText();
				Tarih = txt_Tarih.getText();
				Saat = txt_Saat.getText();

				sql_sorgu = "INSERT INTO borsa (Birim,Alis,Satis,Artis,Tarih,Saat) VALUES (" + "'" + Birim + "','" + Alis + "','" + Satis + "','" + Artis + "','" + Tarih + "','"+ Saat + "')";

				System.out.println(sql_sorgu);
				baglanti.ekle(sql_sorgu);

			}
		});
		btnKaydet.setBounds(485, 232, 83, 25);
		contentPane.add(btnKaydet);

		JLabel lblBirim = new JLabel("Birim");
		lblBirim.setBounds(484, 20, 56, 16);
		contentPane.add(lblBirim);

		JLabel lblSoyad = new JLabel("Alış");
		lblSoyad.setBounds(484, 56, 56, 16);
		contentPane.add(lblSoyad);

		JLabel lblYas = new JLabel("Satış");
		lblYas.setBounds(484, 91, 56, 16);
		contentPane.add(lblYas);

		JLabel lblNumara = new JLabel("Artış");
		lblNumara.setBounds(484, 126, 56, 16);
		contentPane.add(lblNumara);
		
		JLabel lblTarih = new JLabel("Tarih");
		lblTarih.setBounds(484, 161, 46, 14);
		contentPane.add(lblTarih);
		
		JLabel lblSaat = new JLabel("Saat");
		lblSaat.setBounds(484, 192, 46, 14);
		contentPane.add(lblSaat);

		JButton btnUpdate = new JButton("Güncelle");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String Birim, Alis, Satis, Artis, Tarih, Saat, sql_sorgu;

				Birim = txt_Birim.getText();
				Alis = txt_Alis.getText();
				Satis = txt_Satis.getText();
				Artis = txt_Artis.getText();
				Tarih = txt_Tarih.getText();
				Saat = txt_Saat.getText();
				
				

				sql_sorgu = "UPDATE borsa SET Birim=" + "'" + Birim + "'," + "Alis='" + Alis + "'," + "Satis='" + Satis + "'," + "Artis='" + Artis + "'," + "Tarih='" + Tarih + "'," + "Saat='" + Saat +  "' WHERE Saat='" + Saat + "'";

				System.out.println(sql_sorgu);

				baglanti.update(sql_sorgu);

			}
		});
		btnUpdate.setBounds(584, 232, 83, 25);
		contentPane.add(btnUpdate);

		JButton btnSil = new JButton("Sil");
		btnSil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Saat, sql_sorgu;

				Saat = txt_Saat.getText();

				// DELETE FROM borsa WHERE ogr_no=no

				sql_sorgu = "DELETE FROM borsa WHERE Saat='" + Saat +"'";
				System.out.println(sql_sorgu);
				baglanti.sil(sql_sorgu);

			}
		});
		btnSil.setBounds(687, 232, 83, 25);
		contentPane.add(btnSil);

		txt_birimsorgu = new JTextField();
		txt_birimsorgu.setBounds(550, 279, 116, 22);
		contentPane.add(txt_birimsorgu);
		txt_birimsorgu.setColumns(10);

		JLabel lblrenciAd = new JLabel("Filtrele");
		lblrenciAd.setBounds(484, 282, 83, 16);
		contentPane.add(lblrenciAd);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Birim", "Alış", "Satış", "Artış" ,"Tarih","Saat" }));
		comboBox.setBounds(687, 279, 83, 22);
		contentPane.add(comboBox);

		JButton btnNewButton = new JButton("Sorgula");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.setRowCount(0);

				String sql_sorgu = null;

				String alan = txt_birimsorgu.getText();

				ResultSet myRs = null;

				int secilen = comboBox.getSelectedIndex();

				if (secilen == 0) {
					sql_sorgu = "select * from borsa where Birim like '" + alan + "%'";
				} else if (secilen == 1) {
					sql_sorgu = "select * from borsa where Alis like '" + alan + "%'";
				} else if (secilen == 2) {
					sql_sorgu = "select * from borsa where Satis like '" + alan + "%'";
				} else if (secilen == 3) {
					sql_sorgu = "select * from borsa where Artis = " + Integer.parseInt(alan);
				} else if (secilen == 4) {
					sql_sorgu = "select * from borsa where Tarih like '" + alan + "%'";
				} else if (secilen == 5) {
				sql_sorgu = "select * from borsa where Saat like '" + alan + "%'";
				}

				System.out.println(sql_sorgu);

				myRs = baglanti.sorgula(sql_sorgu);

				try {
					while (myRs.next()) {
						satirlar[0] = myRs.getString("Birim");
						satirlar[1] = myRs.getString("Alis");
						satirlar[2] = myRs.getString("Satis");
						satirlar[3] = myRs.getString("Artis");
						satirlar[4] = myRs.getString("Tarih");
						satirlar[5] = myRs.getString("Saat");
						model.addRow(satirlar);
					}
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

				table.setModel(model);

			}
		});
		btnNewButton.setBounds(550, 312, 116, 25);
		contentPane.add(btnNewButton);
		
		
		//VERİ ÇEK

		JButton btncek = new JButton("Veri Çek");
		btncek.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String veriler = null;

				vericekme.vericek(veriler);
				System.out.println(veriler);

				table.setModel(model);
			}
		});
		btncek.setBounds(550, 348, 116, 32);
		contentPane.add(btncek);
		
		
		//DIŞARI AKTARMA
		JButton btnCikti = new JButton("Dışarı Aktar");
		
		btnCikti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
			
		
			File dosya =new File("C:\\Cikti.txt");	
			 if(!dosya.exists()){
                 dosya.createNewFile();
             }
             
             FileWriter fw = new FileWriter(dosya.getAbsoluteFile());
             BufferedWriter bw = new BufferedWriter(fw);
             
             //Satırların döngüsü
             for(int i = 0; i < table.getRowCount(); i++){
                 //Sütunların döngüsü
                 for(int j = 0; j < table.getColumnCount(); j++){
                     bw.write(table.getModel().getValueAt(i, j)+" ");
                 }
                 //Başlangıç ve sonları için çizgi
                 
                 bw.write("\n_________\n");
             }
             //BufferedWriter'ı kapatma
             bw.close();
             //FileWriter'ı kapatma
             fw.close();
             JOptionPane.showMessageDialog(null, "Çıktı Alındı");
             
             }catch(Exception ex){
                 ex.printStackTrace();
             }
         }
      });
			
				
		
		btnCikti.setBounds(550, 391, 116, 23);
		contentPane.add(btnCikti);
		
		
		
		JLabel lblNewLabel = new JLabel("Veri Tabanı Sistemleri Proje");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNewLabel.setBounds(669, 460, 153, 14);
		contentPane.add(lblNewLabel);
		
		//Hakkında
		
		JButton btnHakkinda = new JButton("Hakkında");
		
		btnHakkinda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

             JOptionPane.showMessageDialog(null, "Taha Tangülü 16260055\nŞerife Yeşildallar 16260105");
             

             
         }
      });
		
		
		btnHakkinda.setBounds(550, 425, 116, 23);
		contentPane.add(btnHakkinda);
		
		
		


		


		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				txt_Birim.setText(model.getValueAt(table.getSelectedRow(), 0).toString());
				txt_Alis.setText((String) model.getValueAt(table.getSelectedRow(), 1));
				txt_Satis.setText((String) model.getValueAt(table.getSelectedRow(), 2));
				txt_Artis.setText((String) model.getValueAt(table.getSelectedRow(), 3));
				txt_Tarih.setText((String) model.getValueAt(table.getSelectedRow(), 4));
				txt_Saat.setText((String) model.getValueAt(table.getSelectedRow(), 5));
			}
		});

	}
}
