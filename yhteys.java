package tietokanta;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class yhteys {

	public static void main(String[] args) {
		String host = "jdbc:mysql://localhost:3306/world"; //tietokannan osoite muodossa jdbc:mysql://ip-osoite:portti:tietokannan nimi
		try{
			Connection con = DriverManager.getConnection(host, "root", "ascent");
			//yhteyden luonti SQL tietokantaan
			if (con != null){
				System.out.println("yhteys on luotu");
				KyselyThread k = new KyselyThread(); //ohjelma threadin luonti
				k.run(con);
			}
			else{
				System.out.println("jotain on silti viassa");
			}
		}
		catch(SQLException e){
			System.err.println(e);
		}
		
	}
	
}


