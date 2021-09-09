package com.nagarro.servlets;
/*
 * @Aayush Khanna
 * Trainee Technology
 * 
 * This is Login servlet class
 * */

//Imports
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.nagarro.java.common.SessionCreation;
import com.nagarro.java.servlet.HttpSession;
import com.nagarro.java.servlet.RequestDispatcher;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	//Initialization of final methods
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Login() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setHeader("Pragma","no cache");
		response.setHeader("cache-control","no-store");
		response.setHeader("Expires","0");
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	String name=request.getParameter("name");
	String password=request.getParameter("password");
	
	try {
		
		
		PrintWriter out=response.getWriter();
		
		HttpSession s=request.getSession();
		s.setAttribute("name", name);
		
		
		SessionCreation sc=new SessionCreation();
		SessionFactory sf=sc.getSessionFactory();
		Session sessionh=sf.openSession();
		Query q=sessionh.createQuery("from LoginDetails where username='"+name+"' and password='"+password+"'");
		if(q.list().isEmpty()) {
			
			RequestDispatcher rd=request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
			out.println("<h3>wrong username or password<h3>");
		}
		else {
			response.sendRedirect("imageUpload.jsp");
		}
		
	}catch(Exception e) {
		System.out.println(e);
	}
}

}
