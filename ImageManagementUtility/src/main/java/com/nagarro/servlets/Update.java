package com.nagarro.servlets;
/*
 * @Aayush Khanna
 * Trainee Technology
 * 
 * This file is for updation
 * */

//Imports
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
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

import com.nagarro.java.common.SessionCreation;
import com.nagarro.java.exception.UserDefinedException;

/**
 * Servlet implementation class Update
 */
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Update() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/html");
		response.setHeader("Pragma", "no-cache");
		response.setHeader("Cache-Control", "no-store");
		response.setHeader("Expires", "0");

		HttpSession sessionn = request.getSession();
		String ss = (String) sessionn.getAttribute("name");
		if (ss == null)
			response.sendRedirect("index.jsp");
		else {

			PrintWriter out = response.getWriter();

			String sno = "";
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
							String name2 = item.getFieldName();
							String value2 = item.getString();

							if (name1.equals("n1")) {
								NameFile = value1;
							}
							if (name2.equals("serialno")) {
								sno = value2;
							}
						} else {
							try {
								applicationPath = getServletContext().getRealPath("");
								itemName = item.getName();
								savedFile = new File(applicationPath + itemName);
								item.write(savedFile);

							} catch (Exception e) {
								out.println("error" + e.getMessage());
							}
						}
					}
					File file = new File(applicationPath + itemName);
					long bytes = file.length();
					String size = bytes / 1024 + "KB";
					SessionCreation sc = new SessionCreation();
					SessionFactory factry = sc.getSessionFactory();
					Session session = factry.openSession();

					session.beginTransaction();

					Query q = session.createQuery("update ImageDetails set Name='" + NameFile + "' , Image= '"
							+ itemName + "', Size = '" + size + "' where SNo = '" + sno + "'");
					q.executeUpdate();
					session.getTransaction().commit();
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		response.sendRedirect("imageUpload.jsp");
	}

}
