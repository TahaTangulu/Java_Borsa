package javasql;

		
import  java.sql.Connection;		
import  java.sql.Statement;		
import  java.sql.ResultSet;		
import  java.sql.DriverManager;		
import  java.sql.SQLException;



public class  javasql {				
    	public static void  main(String[] args) throws  ClassNotFoundException, SQLException {	
    		
				// Baglantı için yazış şekili: "jdbc:mysql://ipadresi:port/database_adı"		
                String dbUrl = "jdbc:mysql://localhost:3306/javasql";					

				// Database Kullanıcı adı		
				String username = "root";	
                 
				// Database Parola		
				String password = "";				

				// Çalıştırılacak sorgu		
				String query = "select *  from ogrenci;";	
                
         	    // mysql jdbc driver		
           	    Class.forName("com.mysql.jdbc.Driver");			
           
           		// Veritabanına bağlantı		
            	Connection con = DriverManager.getConnection(dbUrl,username,password);
          
          		// Nesne oluşturma		
        	   Statement stmt = con.createStatement();					
       
       			// SQL Sorgusunu yürütme ve sonuçları ResultSet'e aktarma	
         		ResultSet rs= stmt.executeQuery(query);							
         
         		// Tüm verileri yinelemek ve sonuçları yazdırmak için Döngü		
                System.out.println("Ad	"+"Soyad	"+"Yaş	"+"Numara	");
                System.out.println("-------------------------------");
				while (rs.next()){
			        		String Ad = rs.getString(1);
			        		String Soyad = rs.getString(2);
                            String Yas = rs.getString(3);
                            String Num = rs.getString(4);
                            System.out.println(Ad+"	"+Soyad+"	"+Yas+"	"+Num);
                            
                    }		
      			 // Veritabanı bağlantısını sonlandır.		
      			con.close();			
		}
}

