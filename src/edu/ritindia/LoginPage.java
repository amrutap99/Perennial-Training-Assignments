package edu.ritindia;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This page validates login and password
 * This is servlet 1
 */
@WebServlet("/LoginPage")
public class LoginPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LoginPage() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter outPrintWriter= response.getWriter();
		
		String nm= request.getParameter("userName");
		String ps= request.getParameter("userPassword");
		
		if(ps.equals("amruta")) {
			outPrintWriter.print("Login Successful !");  
			
			

			RequestDispatcher  rd= request.getRequestDispatcher("servlet2");  
			rd.forward(request, response);
			
		}
		else {
			outPrintWriter.print("Sorry UserName or Password Error!");  

			RequestDispatcher  rd= request.getRequestDispatcher("/index.html");  
			rd.include(request, response);
		}
		
	}

}
