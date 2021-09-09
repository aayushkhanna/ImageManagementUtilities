package com.nagarro.servlets;
/*
 * @Aayush Khanna
 * Trainee Technology
 * 
 * This servlet class is used to upload image details
 * */

//Imports
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.nagarro.java.common.SessionCreation;
import com.nagarro.java.exception.*;
import com.nagarro.java.pojo.ImageDetails;

/**
 * Servlet implementation class UploadImageDetails
 */
public class UploadImageDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadImageDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Expires", "0");
		
		//Session object creation
		HttpSession sessionn = request.getSession();
		String ss = (String) sessionn.getAttribute("name");
		if (ss == null)
			response.sendRedirect("index.jsp");
		else {

			PrintWriter out = response.getWriter();
			SessionCreation sc = new SessionCreation();
			SessionFactory sf = sc.getSessionFactory();
					Session session=sf.openSession();
			String NameFile = "";
			String itemName = "";
			String applicationPath = "";
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			try {
				if (!isMultipart) {
					throw new UserDefinedException("error");
				} else {
					FileItemFactory factory = new DiskFileItemFactory();
					ServletFileUpload upload = new ServletFileUpload(factory);
					@SuppressWarnings("rawtypes")
					List items = null;
					try {
						items = upload.parseRequest(request);
					} catch (FileUploadException e) {
						e.getMessage();
					}
					FileItem item = null;
					File savedFile = null;
					@SuppressWarnings("rawtypes")
					Iterator itr = items.iterator();
					while (itr.hasNext()) {
						item = (FileItem) itr.next();
						if (item.isFormField()) {
							String name1 = item.getFieldName();
							String value1 = item.getString();

							if (name1.equals("n1")) {
								NameFile = value1;
							}
						} else {
							try {
								applicationPath = getServletContext().getRealPath("");
								itemName = item.getName();
								savedFile = new File(applicationPath + itemName);
								System.out.println(applicationPath+","+itemName);
								
								item.write(savedFile);

							} catch (Exception e) {
								out.println("error" + e.getMessage());
							}
						}
					}
					try {
						 
						
						String hql = "select SUM(Size) from ImageDetails where UserName='" + ss + "'";
						Query q1 = session.createQuery("select SUM(Size) from ImageDetails where UserName='" + ss + "'");
						
					
						Object obj = q1.uniqueResult();
						String temp = (String) obj;
						Float si=0.0f;
						if(temp!=null) {
							 si=Float.parseFloat(temp);
						}
					
					ImageDetails imgdet = new ImageDetails();
					imgdet.setImage(itemName);
					imgdet.setName(NameFile);
					imgdet.setUserName(ss);
					File file = new File(applicationPath + itemName);
					long bytes = file.length();
					
					if((bytes/1024 )+ si<=10240) {
					imgdet.setSize(bytes / 1024 + "KB");
					Transaction tx = session.beginTransaction();
					session.save(imgdet);
					tx.commit();
					response.sendRedirect("imageUpload.jsp");}
					else {
					out.println("<script type=\"text/javascript\">");
					out.println("alert('totat size exceeding 10 MB');");
					out.println("location='imageUpload.jsp';");
					out.println("</script>");}
					}
					catch(Exception e) {
						System.out.println(e);
					}

	}}
 catch (Exception e) {
	System.out.println(e.getMessage());
}
		
			}
		}}