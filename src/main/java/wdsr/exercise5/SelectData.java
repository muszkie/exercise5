package wdsr.exercise5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectData {
	
	Connect conn = new Connect();
	Connection con = conn.getConnection();
	int selectCounter = 0;

	public void query1(){		
	
	try {
		PreparedStatement stpre = con.prepareStatement("select pkey,name from Student;");
		
		ResultSet result =  stpre.executeQuery();
		int columnCount = result.getMetaData().getColumnCount();
		
		System.out.print("Wynik zapytania: " + ++selectCounter + ":  \n");
		while (result.next()) {
			StringBuilder row = new StringBuilder();

			for (int i = 1; i <= columnCount; i++) {
				row.append(result.getMetaData().getColumnName(i) + " = ");
				row.append(result.getString(i) + ", ");
			}
			System.out.print(row.toString()+"  \n");
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
	}
	
	public void query2(){		
		
	try {
		PreparedStatement stpre = con.prepareStatement("select pkey,name from Student "
				+ "where pkey not in(select distinct fkey_student  "
				+ "from ENROLLMENT);");
		
		ResultSet result =  stpre.executeQuery();
		int columnCount = result.getMetaData().getColumnCount();
		
		System.out.print("Wynik zapytania: " + ++selectCounter + ":  \n");
		while (result.next()) {
			StringBuilder row = new StringBuilder();

			for (int i = 1; i <= columnCount; i++) {
				row.append(result.getMetaData().getColumnName(i) + " = ");
				row.append(result.getString(i) + ", ");
			}
			System.out.print(row.toString()+"  \n");
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
	}

	
	public void query3(){		
		
	try {
		PreparedStatement stpre = con.prepareStatement("select pkey,name from Student"
				+ " where sex='female' and pkey in(select distinct e.FKEY_STUDENT "
				+ "from ENROLLMENT e join Class c on e.FKEY_CLASS=c.PKEY "
				+ "and name='Existentialism in 20th century');");
		
		ResultSet result =  stpre.executeQuery();
		int columnCount = result.getMetaData().getColumnCount();
		
		System.out.print("Wynik zapytania: " + ++selectCounter + ":  \n");
		while (result.next()) {
			StringBuilder row = new StringBuilder();

			for (int i = 1; i <= columnCount; i++) {
				row.append(result.getMetaData().getColumnName(i) + " = ");
				row.append(result.getString(i) + ", ");
			}
			System.out.print(row.toString()+"  \n");
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
	}

	
	public void query4(){		
		
	try {
		PreparedStatement stpre = con.prepareStatement("select name from FACULTY"
				+ " where pkey in(select fkey_faculty "
				+ "from CLASS "
				+ "where pkey not in (select distinct fkey_class from ENROLLMENT));");
		
		ResultSet result =  stpre.executeQuery();
		int columnCount = result.getMetaData().getColumnCount();
		
		System.out.print("Wynik zapytania: " + ++selectCounter + ":  \n");
		while (result.next()) {
			StringBuilder row = new StringBuilder();

			for (int i = 1; i <= columnCount; i++) {
				row.append(result.getMetaData().getColumnName(i) + " = ");
				row.append(result.getString(i) + ", ");
			}
			System.out.print(row.toString()+"  \n");
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
	}

	
	public void query5(){		
		
	try {
		PreparedStatement stpre = con.prepareStatement("select max(age) as age from STUDENT "
				+ "where pkey in (select FKEY_STUDENT from ENROLLMENT"
				+ " where FKEY_CLASS =(select PKEY from CLASS"
				+ " where NAME='Introduction to labour law'));");
		
		ResultSet result =  stpre.executeQuery();
		int columnCount = result.getMetaData().getColumnCount();
		
		System.out.print("Wynik zapytania: " + ++selectCounter + ":  \n");
		while (result.next()) {
			StringBuilder row = new StringBuilder();

			for (int i = 1; i <= columnCount; i++) {
				row.append(result.getMetaData().getColumnName(i) + " = ");
				row.append(result.getString(i) + ", ");
			}
			System.out.print(row.toString()+"  \n");
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
	}

	
	public void query6(){		
		
	try {
		PreparedStatement stpre = con.prepareStatement("SELECT NAME FROM CLASS "
				+ "WHERE PKEY in (SELECT FKEY_CLASS FROM ENROLLMENT"
				+ " GROUP BY FKEY_CLASS "
				+ "HAVING count(FKEY_CLASS) > 1);");
		
		ResultSet result =  stpre.executeQuery();
		int columnCount = result.getMetaData().getColumnCount();
		
		System.out.print("Wynik zapytania: " + ++selectCounter + ":  \n");
		while (result.next()) {
			StringBuilder row = new StringBuilder();

			for (int i = 1; i <= columnCount; i++) {
				row.append(result.getMetaData().getColumnName(i) + " = ");
				row.append(result.getString(i) + ", ");
			}
			System.out.print(row.toString()+"  \n");
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
	}
	
	public void query7(){		
		
	try {
		PreparedStatement stpre = con.prepareStatement("SELECT LEVEL, avg(AGE) as average  FROM STUDENT"
				+ " where LEVEL in (SELECT DISTINCT LEVEL FROM STUDENT)"
				+ " GROUP BY LEVEL;");
		
		ResultSet result =  stpre.executeQuery();
		int columnCount = result.getMetaData().getColumnCount();
		
		System.out.print("\nWynik zapytania: " + ++selectCounter + ":  \n");
		while (result.next()) {
			StringBuilder row = new StringBuilder();

			for (int i = 1; i <= columnCount; i++) {
				row.append(result.getMetaData().getColumnName(i) + " = ");
				row.append(result.getString(i) + ", ");
			}
			System.out.print(row.toString()+"  ");
		}
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	
	}



	
	
}
