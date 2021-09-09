<%@page import="com.nagarro.java.common.SessionCreation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="org.hibernate.SessionFactory"%>
<%@ page import="org.hibernate.Query"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	response.setContentType("text/html");
	response.setHeader("Pragma", "no-cache");
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("Expires", "0");
	
	HttpSession session1 = request.getSession();
	String ss = (String) session1.getAttribute("name");
	if (ss == null)
		response.sendRedirect("index.jsp");
	else {
		String id = request.getParameter("id");
		SessionCreation sc=new SessionCreation();
		SessionFactory factory = sc.getSessionFactory();
		Session sessionn = factory.openSession();
		sessionn.beginTransaction();
		Query q = sessionn.createQuery("delete from ImageDetails where SNo='" + id + "'");
		int row = q.executeUpdate();
		if (row == 0)
			System.out.println("no rows deleted");

		sessionn.getTransaction().commit();
		response.sendRedirect("imageUpload.jsp");
	}
	%>
</body>
</html>