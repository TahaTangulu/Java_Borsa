package javasql;

import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.LocalTime;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class vericekme {

	static void vericek(String veriler) {

		
		try {
			ResultSet myRs = baglanti.yap();

			if (myRs.next()) {

				myRs.getString("Birim");
				myRs.getString("Alis");	
				myRs.getString("Satis");
				myRs.getString("Artis");

			}
				LocalDate Tarih = LocalDate.now(); // Tarih
		    	System.out.println(Tarih);

		    	
		        LocalTime Saat = LocalTime.now();
		        System.out.println(Saat); // Saat
		        
				Document doc = Jsoup.connect("https://dovizborsa.com/doviz/dolar").get();
				Element baslikElementi = doc.select("div.-x0 > a").first(); // div içindeki -x0'ın a kısmından veri çek.
																			
				String birim = baslikElementi.text();
				String alis = doc.select("div.-x1 > span").first().text(); // div içindeki -x1'ın span kısmından veri çek.
				String satis = doc.select("div.-x1 > span[class=-d3 _d3 _x19]").first().text(); // div içindeki -x1'in span kısmındaki "-d3 _d3 _x19" classından  veri çek 
				String artis = doc.select("div.-x0 > i[class=-s2 -d9 _d9 __cu]").first().text(); // div içindeki -x0'in i kısmındaki "-s2 -d9 _d9 __cu" classından  veri çek
				veriler = "INSERT INTO borsa (Birim,Alis,Satis,Artis,Tarih,Saat) VALUES (" + "'" + birim + "','" + alis + "','" + satis + "','" + artis + "','" + Tarih + "','"+ Saat + "')";

				// veriler = "INSERT INTO borsa (Birim,Alis,Satis,Artis,Tarih,Saat) VALUES (1154580,1154580,1154580,1154580,6546544,4154654)";

				System.out.println(veriler);
				baglanti.ekle(veriler);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
