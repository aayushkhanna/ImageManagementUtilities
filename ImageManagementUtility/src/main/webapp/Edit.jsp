<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="org.hibernate.Session"%>
<%@ page import="org.hibernate.SessionFactory"%>
<%@ page import="org.hibernate.Query"%>
<%@ page import="java.util.List"%>
<%@ page import="com.nagarro.java.common.SessionCreation"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit image</title>
<link rel="stylesheet" href="CSS/Style2.css">
<script src="javascript/script.js"></script>
</head>
<body>
	<%
	String id = request.getParameter("id");
	SessionCreation sc=new SessionCreation();
	SessionFactory factory = sc.getSessionFactory();
	Session sessionn = factory.openSession();
	Query q = sessionn.createQuery("select SNo, Image, Name, Size from ImageDetails where SNo= '" + id + "' ");
	List<Object[]> data = (List<Object[]>) q.list();
	for (Object[] dataa : data) {
	%>
	<div class="container-fluid">
		
				<header>
					<h2>Edit Image data</h2>
				</header>
				<form onsubmit = "return validate()" name="form1" method="post" enctype="multipart/form-data" action="Update" >
					<p>Please select an Image file to upload (Max Size 1 MB)</p>
					<p>
						<input type="hidden" name="serialno" value="<%=id%>" /> 
						<input type="text" name="n1" value="<%=dataa[2]%>" required /> 
						<input type="file" name="ImageFile" id= "ImageFile" value="<%=dataa[1]%>" required />
						 <input type="submit" name="submit" value="submit" class="space" />
						 <a href="imageUpload.jsp"><button type="button">Cancel</button> </a>
						</p>
				</form>
			</div>
		
	<%
	}
	%>
</body>
</html>
    

