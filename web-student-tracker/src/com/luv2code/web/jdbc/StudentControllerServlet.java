package com.luv2code.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private StudentDbUtil studentDbUtil;
	
	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
	//connection pool
	//tomcat server will inject a connection pool/datasource object and assign to the variable dataSource
	
	@Override
	public void init() throws ServletException {
		super.init();
		// called by the tomcat server, when this servlet is first initialized
		//can put custom initialization work here
		//work that you would normally do inside a constructor can go here
		
		//create an instance of our student db util..and pass in the conn pool / datasource
		
		try {
			
			studentDbUtil = new StudentDbUtil(dataSource);
			
		}
		
		catch(Exception exc){
			throw new ServletException(exc);
			}		
	}
	
	

	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//list the students...in MVC fashion
		try {
			listStudents(request, response);
		} catch (Exception exc) {
			// TODO Auto-generated catch block
			throw new ServletException(exc);
		}
		
		
		
	}




	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get the students from db util
		
		List<Student> students = studentDbUtil.getStudents();
		
		
		// add the students to the request, set the attribute
		request.setAttribute("STUDENT_LIST",students);
		
		
		
		//send data to the JSP page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);
	}




}
