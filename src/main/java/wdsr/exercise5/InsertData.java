package wdsr.exercise5;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertData {
	Connect conn = new Connect();
	Connection con = conn.getConnection();
	
	
	public void insertStudents(){
		PreparedStatement statement;
		try {
			statement = con.prepareStatement("insert into Student(name,sex,age,level) values('John Smith','male',23,2);");			
			statement.execute();
			System.out.print("Row inserted" + "\n");
			statement = con.prepareStatement("insert into Student(name,sex,age,level) values('Rebecca Milson','female',27,3);");			
			statement.execute();
			System.out.print("Row inserted" + "\n");
			statement = con.prepareStatement("insert into Student(name,sex,age,level) values('George Heartbreaker','male',19,1);");			
			statement.execute();
			System.out.print("Row inserted" + "\n");
			statement = con.prepareStatement("insert into Student(name,sex,age,level) values('Deepika Chopra','female',25,3);");			
			statement.execute();
			System.out.print("Row inserted" + "\n");
			} catch (SQLException e) {
				e.printStackTrace();
				}
		}
	
	
	public void insertFaculty(){
		PreparedStatement statement;
		try {
			statement = con.prepareStatement("insert into Faculty(name) values('Engineering');");			
			statement.execute();
			System.out.print("Row inserted" + "\n");
			statement = con.prepareStatement("insert into Faculty(name) values('Philosophy');");			
			statement.execute();
			System.out.print("Row inserted" + "\n");
			statement = con.prepareStatement("insert into Faculty(name) values('Law and administration');");			
			statement.execute();
			System.out.print("Row inserted" + "\n");
			statement = con.prepareStatement("insert into Faculty(name) values('Languages');");			
			statement.execute();
			System.out.print("Row inserted" + "\n");
			} catch (SQLException e) {
				e.printStackTrace();
				}
		}
	
	public void insertClass(){
		PreparedStatement statement;
		try {
			statement = con.prepareStatement("insert into Class(name, fkey_faculty) values ('Introduction to labour law',(select pkey from Faculty where name='Law and administration'));");			
			statement.execute();
			System.out.print("Row inserted" + "\n");
			statement = con.prepareStatement("insert into Class(name, fkey_faculty) values ('Graph algorithms',(select pkey from Faculty where name='Engineering'));");			
			statement.execute();
			System.out.print("Row inserted" + "\n");
			statement = con.prepareStatement("insert into Class(name, fkey_faculty) values ('Existentialism in 20th century',(select pkey from Faculty where name='Philosophy'));");			
			statement.execute();
			System.out.print("Row inserted" + "\n");
			statement = con.prepareStatement("insert into Class(name, fkey_faculty) values ('English grammar',(select pkey from Faculty where name='Languages'));");			
			statement.execute();
			System.out.print("Row inserted" + "\n");
			statement = con.prepareStatement("insert into Class(name, fkey_faculty) values ('From Plato to Kant',(select pkey from Faculty where name='Philosophy'));");			
			statement.execute();
			System.out.print("Row inserted" + "\n");
			} catch (SQLException e) {
				e.printStackTrace();
				}
		}
	
	public void insertEnrollment(){
		PreparedStatement statement;
		try {
			statement = con.prepareStatement("insert into Enrollment values((select pkey from Student where name='John Smith'),(select pkey from Class where name='Introduction to labour law'));");			
			statement.execute();
			System.out.print("Row inserted" + "\n");
			statement = con.prepareStatement("insert into Enrollment values((select pkey from Student where name='John Smith'),(select pkey from Class where name='Existentialism in 20th century'));");			
			statement.execute();
			System.out.print("Row inserted" + "\n");
			statement = con.prepareStatement("insert into Enrollment values((select pkey from Student where name='John Smith'),(select pkey from Class where name='English grammar'));");			
			statement.execute();
			System.out.print("Row inserted" + "\n");
			statement = con.prepareStatement("insert into Enrollment values((select pkey from Student where name='John Smith'),(select pkey from Class where name='From Plato to Kant'));");			
			statement.execute();
			System.out.print("Row inserted" + "\n");
			statement = con.prepareStatement("insert into Enrollment values((select pkey from Student where name='Rebecca Milson'),(select pkey from Class where name='Existentialism in 20th century'));");			
			statement.execute();
			System.out.print("Row inserted" + "\n");
			statement = con.prepareStatement("insert into Enrollment values((select pkey from Student where name='Rebecca Milson'),(select pkey from Class where name='English grammar'));");			
			statement.execute();
			System.out.print("Row inserted" + "\n");
			statement = con.prepareStatement("insert into Enrollment values((select pkey from Student where name='Deepika Chopra'),(select pkey from Class where name='Introduction to labour law'));");			
			statement.execute();
			System.out.print("Row inserted" + "\n");
			statement = con.prepareStatement("insert into Enrollment values((select pkey from Student where name='Deepika Chopra'),(select pkey from Class where name='Existentialism in 20th century'));");			
			statement.execute();
			System.out.print("Row inserted" + "\n");
			statement = con.prepareStatement("insert into Enrollment values((select pkey from Student where name='Deepika Chopra'),(select pkey from Class where name='English grammar'));");			
			statement.execute();
			System.out.print("Row inserted" + "\n");
			} catch (SQLException e) {
				e.printStackTrace();
				}
		}
	
	
	
	
	
	
	
	
	
	
	
	
	/*public void insertStudents(){
		try {
			PreparedStatement stpre = con.prepareStatement("INSERT INTO Student VALUES (?,?,?,?)");
			stpre.setString(2,"John Smith");
			stpre.setString(3,"male");
			stpre.setInt(4,Integer.parseInt("23"));
			stpre.setInt(5,Integer.parseInt("2"));
			stpre.executeUpdate();
			stpre.setString(2,"Rebecca Milson");
			stpre.setString(3,"female");
			stpre.setInt(4,Integer.parseInt("27"));
			stpre.setInt(5,Integer.parseInt("3"));
			stpre.executeUpdate();
			stpre.setString(2,"George Heartbreaker");
			stpre.setString(3,"male");
			stpre.setInt(4,Integer.parseInt("19"));
			stpre.setInt(5,Integer.parseInt("1"));
			stpre.executeUpdate();
			stpre.setString(2,"Deepika Chopra");
			stpre.setString(3,"female");
			stpre.setInt(4,Integer.parseInt("25"));
			stpre.setInt(5,Integer.parseInt("3"));
			stpre.executeUpdate();
			System.out.print("Students inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void insertFaculty(){
		try {
			PreparedStatement stpre = con.prepareStatement("INSERT INTO Faculty VALUES (?)");
			stpre.setString(1,"Engineering");
			stpre.executeUpdate();
			stpre.setString(1,"Philosophy");
			stpre.executeUpdate();
			stpre.setString(1,"Law and administration");
			stpre.executeUpdate();
			stpre.setString(1,"Languages");
			stpre.executeUpdate();
			System.out.print("Faculty inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void insertClass(){
		try {
			PreparedStatement stpre = con.prepareStatement("INSERT INTO Class VALUES (?,?)");
			Statement st = con.createStatement();
			stpre.setString(1,"Introduction to labour law");
			stpre.setInt(2,st.executeQuery("select pkey from Faculty where name='Law and administration'").getInt(0));
			stpre.executeUpdate();
			stpre.setString(1,"Graph algorithms");
			stpre.setInt(2,st.executeQuery("select pkey from Faculty where name='Engineering'").getInt(0));
			stpre.executeUpdate();
			stpre.setString(1,"Existentialism in 20th century");
			stpre.setInt(2,st.executeQuery("select pkey from Faculty where name='Philosophy'").getInt(0));
			stpre.executeUpdate();
			stpre.setString(1,"English grammar");
			stpre.setInt(2,st.executeQuery("select pkey from Faculty where name='Languages'").getInt(0));
			stpre.executeUpdate();
			stpre.setString(1,"From Plato to Kant");
			stpre.setInt(2,st.executeQuery("select pkey from Faculty where name='Philosophy'").getInt(0));
			stpre.executeUpdate();
			System.out.print("Class inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void insertEnrollment(){
		try {
			PreparedStatement stpre = con.prepareStatement("INSERT INTO Enrollment VALUES (?,?)");
			Statement st = con.createStatement();
			stpre.setInt(1,st.executeQuery("select pkey from Student where name='John Smith'").getInt(0));
			stpre.setInt(2,st.executeQuery("select pkey from Class where name='Introduction to labour law'").getInt(0));
			stpre.executeUpdate();
			stpre.setInt(2,st.executeQuery("select pkey from Class where name='Existentialism in 20th century'").getInt(0));
			stpre.executeUpdate();
			stpre.setInt(2,st.executeQuery("select pkey from Class where name='English grammar'").getInt(0));
			stpre.executeUpdate();
			stpre.setInt(2,st.executeQuery("select pkey from Class where name='From Plato to Kant'").getInt(0));
			stpre.executeUpdate();
			stpre.setInt(1,st.executeQuery("select pkey from Student where name='Rebecca Milson'").getInt(0));
			stpre.setInt(2,st.executeQuery("select pkey from Class where name='Existentialism in 20th century'").getInt(0));
			stpre.executeUpdate();
			stpre.setInt(2,st.executeQuery("select pkey from Class where name='English grammar'").getInt(0));
			stpre.executeUpdate();
			stpre.setInt(1,st.executeQuery("select pkey from Student where name='Deepika Chopra'").getInt(0));
			stpre.setInt(2,st.executeQuery("select pkey from Class where name='Introduction to labour law'").getInt(0));
			stpre.executeUpdate();
			stpre.setInt(2,st.executeQuery("select pkey from Class where name='Existentialism in 20th century'").getInt(0));
			stpre.executeUpdate();
			stpre.setInt(2,st.executeQuery("select pkey from Class where name='English grammar'").getInt(0));
			stpre.executeUpdate();
			System.out.print("Enrollment inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
*/
}
