<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="org.hibernate.Session"%>
<%@ page import="org.hibernate.SessionFactory"%>
<%@ page import="org.hibernate.Query"%>
<%@ page import="java.util.ArrayList"%>

<%@ page import="java.util.List"%>
<%@ page import="com.nagarro.java.common.SessionCreation"%>

  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Upload Image</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="javascript/script.js"></script>

<link rel="stylesheet" href="CSS/Style2.css">
</head>
<body>
<%

response.setContentType("text/html");
response.setHeader("Pragma", "no-cache");
response.setHeader("Cache-Control", "no-store");
response.setHeader("Expires", "0");


String ss = (String) session.getAttribute("name");

	if (ss == null) {
		out.println("Session expired!");
	} else {
	%>

	<div class="container-fluid">
		
				<header>
					<h2>Image Management Utility</h2>
					<h4 align="right">Hi <%= ss %></h4>
				</header>

				<form onsubmit="return validate();" name="form1" method="post"
					enctype="multipart/form-data" action="UploadImageDetails">
					<p>Please select an Image file to upload (Max Size 1 MB)</p>
					<p>
						<input type="text" name="n1" required /> 
						<input type="file" name="ImageFile" id="ImageFile" required />
						<input type="submit" name="submit" value="submit" class="space" />
					    <input type="reset" name="reset" value="cancel" />
					</p>

				</form>
				<br>
				<h3>Uploaded Images</h3>
				<table>
					<tr>
						<th>S.No</th>
						<th>Name</th>
						<th>Size</th>
						<th>Preview</th>
						<th>Actions</th>
					</tr>
					<%
					 SessionCreation factory = new SessionCreation();
					SessionFactory sf = factory.getSessionFactory();
					Session sessionn=sf.openSession();
					sessionn.beginTransaction();
					Query q = sessionn.createQuery("select SNo, Image, Name, Size from ImageDetails where username='" + ss + "'");

					List<Object[]> data = (List<Object[]>) q.list();
					for (Object[] dataa : data) {
						
					%>
					<tr>
						<td><%=dataa[0]%></td>
						<td><%=dataa[2]%></td>
						<td><%=dataa[3]%></td>
						<td><img src="<%=dataa[1]%>" width="110" height="120" /></td>
						<td><a href="Edit.jsp?id=<%=dataa[0]%>"><i
								class="fa fa-edit" style="font-size: 48px; color: black;"></i> </a>
							&nbsp &nbsp &nbsp &nbsp <a onclick="return getConfirmation();"
							href="Delete.jsp?id=<%=dataa[0]%>"><i class="fa fa-close"
								style="font-size: 48px; color: red"></i> </a></td>
					</tr>
					<%
					}
					@SuppressWarnings("unused")
					String hql = "select SUM(Size) from ImageDetails where UserName='" + ss + "'";
					Query q1 = sessionn.createQuery("select SUM(Size) from ImageDetails where UserName='" + ss + "'");
					
				
					Object obj = q1.uniqueResult();
					String temp = (String) obj;
					%>
					<tr>
					<td colspan="2"></td>
					<td>
					<% 
					if(temp==null){
						out.println("No Image");
						out.println("Total Size = "+ 0 +" KB");
					}
					else{
						out.println("Total Size ="+ temp+"KB");
					}
					
					%>
					</td>
					<td colspan="2"></td>
					</tr>
</table>
</div>
<%} %>
</body>
</html>