package com.operations;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.AllDetails.TeacherDetail;
import com.util.Util;

@WebServlet("/listteachers")
public class ShowTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		try {
			SessionFactory factory = Util.buildConnection();
			
			Session session = factory.openSession();
			
			List<TeacherDetail> list = session.createQuery("from TeacherDetail").list();
			
			out.println("<h2>LIST OF TEACHERSS");
			
			out.println("<style> table,td,th{"
					+ "border:2px solid red; "
					+ "padding:2px;); "
					+ "</style>");
			out.println("<table>");
			out.println("<tr>");
			out.println("<th>S.No</th>");
			out.println("<th>Teacher Name</th>");
			out.println("<th>Teacher Subject</th>");
			out.println("<th>Teacher Class</th>");
			out.println("<tr>");
			
			for(TeacherDetail teachdet : list) {
				out.println("<tr>");
				out.println("<td>"+ teachdet.getId() +"</td>");
				out.println("<td>"+ teachdet.getName() +"</td>");
				out.println("<td>"+ teachdet.getSubject() +"</td>");
				out.println("<td>"+ teachdet.getTeacherClass() +"</td>");
				out.println("</tr>");
			}
			out.println("</table>");
			out.println("<a href='adminpage.html'>RETURN To MainMenu!</a>");
			session.close();
		} catch (Exception e) {
			out.println("<h2 style='color:red'>TRY AGAIN! OPERATION FAILED...<h2>");
			out.println("<a href='adminpage.html'>RETURN To MainMenu!</a>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
