package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDbUtil {
	
	private DataSource dataSource;
	//set up reference to the data source

	
	//constructor
	public StudentDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
		//theDataSource is passed in the args			
	}
	
	
	public List<Student> getStudents() throws Exception{
		
		List<Student> students = new ArrayList<>();
		
		Connection myConn =null;
		Statement myStmt = null;
		ResultSet myRs = null;
		
		
		try {
		
		// get a connection 
			
			myConn = dataSource.getConnection();
		
		// create a sql stmt
			String sql = "select * from student order by last_name";
		
			myStmt = myConn.createStatement();
		//execute the query
			
			myRs = myStmt.executeQuery(sql);
		
		//process the result set
			
			while(myRs.next()) {
				
				//retrieve data from the result set
				int id = myRs.getInt("id");
				String firstName = myRs.getString("first_name"); //column name from db
				String lastName = myRs.getString("last_name");
				String email = myRs.getString("email");
				
				// create a new student object
				
				//using the constructor method
				Student tempStudent =  new Student(id, firstName, lastName, email);
				
				//add it to the list of students array list of students
				students.add(tempStudent);
			}
					
		  return students;
		}
		
		finally {
			//close the jdbc objects
			close(myConn, myStmt, myRs);
			
		}
	
	}


	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
				if (myRs != null) {
					myRs.close();
				}
				
				
				if (myStmt != null) {
					myStmt.close();
				}
			
				if(myConn != null) {
					myConn.close(); //doesnt really close the db connection, just puts it back into the pool
				}
		}
		
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}
}
