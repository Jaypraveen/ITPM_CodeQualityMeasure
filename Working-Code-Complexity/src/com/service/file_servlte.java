package com.service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.RequestDispatcher;



/**
 * Servlet implementation class file_servlte
 */
@WebServlet("/file_servlte")
public class file_servlte extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public file_servlte() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("selectFactor");
		String code = request.getParameter("code");
		
		HttpSession session = request.getSession();
		session.setAttribute("test_code",code);
		
		
		if(type.equals("coupling")) {
			String recursive = request.getParameter("recursive");
			session.setAttribute("recursive",recursive);
			String regularRegular = request.getParameter("regularRegular");
			session.setAttribute("regularRegular",regularRegular);
			String regularRecursive = request.getParameter("regularRecursive");
			session.setAttribute("regularRecursive",regularRecursive);
			String recursiveRecursive = request.getParameter("recursiveRecursive");
			session.setAttribute("recursiveRecursive",recursiveRecursive);
			String recursiveRegular = request.getParameter("recursiveRegular");
			session.setAttribute("recursiveRegular",recursiveRegular);
			String regularGlobal = request.getParameter("regularGlobal");
			session.setAttribute("regularGlobal",regularGlobal);
			String recursiveGlobal = request.getParameter("recursiveGlobal");
			session.setAttribute("recursiveGlobal",recursiveGlobal);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/Coupling.jsp");
			dispatcher.forward(request, response);
		}else if(type.equals("")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("");
			dispatcher.forward(request, response);
		};
	}

}
