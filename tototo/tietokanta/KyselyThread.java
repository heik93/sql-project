package tietokanta;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;

public class KyselyThread extends Thread{
	
	public void run(Connection con){
		boolean a = true;
		Scanner sc = new Scanner(System.in);
		while(a){
		System.out.println("Give your SQL SELECT statement");
		String statement = sc.nextLine();
		System.out.println("Give the name of the column you want to see from the selected row");
		String colu = sc.nextLine();
		Statement st = null;
		ResultSet rs = null;
		String tulos = "";
		try{
			st = con.createStatement();
			rs = st.executeQuery(statement);
			if(st.execute(statement)){
				rs = st.getResultSet();
				System.out.println(rs.toString());
				 if(rs.next()){

			            tulos = rs.getString(colu);

			       }
				 System.out.println(tulos);
			}
			
		}
		catch(SQLException e){
			System.err.println(e);
		}
		finally{
		boolean c = true;
		while(c){
		System.out.println("Do you want to continue?(yes = 1)(no = 0)");
		String d = sc.nextLine();
		int b = Integer.parseInt(d);
			if(b == 0){
				a = false;
				c = false;
			}
			if(b == 1){
				c = false;
			}
			if(b != 1 && b != 0){
				System.out.println("Are you an idiot?");
			}
		}
		if (rs != null) {
	        try {
	            rs.close();
	        } 
	        catch (SQLException sqlEx) 
	        { } // ignore

	        rs = null;
	    }

	    if (st != null) {
	        try {
	            st.close();
	        } 
	        catch (SQLException sqlEx) 
	        { } // ignore

	        st = null;
	    }
		
		}
		}
		sc.close();
		
	}
}
