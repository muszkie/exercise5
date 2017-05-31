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
	

}
