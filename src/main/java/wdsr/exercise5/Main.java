package wdsr.exercise5;

public class Main {
	public static void main(String[] args) {
		CreateDatabase cd =  new CreateDatabase();
		cd.createTables();
		InsertData id = new InsertData();
		id.insertStudents();
		id.insertFaculty();
		id.insertClass();
		id.insertEnrollment();
		SelectData sd = new SelectData();
		sd.query1();
		sd.query2();
		sd.query3();
		sd.query4();
		sd.query5();
		sd.query6();
		sd.query7();
		cd.dropTables();
	}

}
