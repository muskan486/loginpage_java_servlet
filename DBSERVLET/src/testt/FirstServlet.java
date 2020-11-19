package testt;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pt=res.getWriter();
		String n=req.getParameter("uname");
		String p=req.getParameter("password");
		if(LoginDao.validate(n,p))
		{
			RequestDispatcher rd= req.getRequestDispatcher("second");
			rd.forward(req, res);
			
		}
		else
		{
			pt.print("SORRY USERNAME OR PASSWORD IS INCORRECT");
			RequestDispatcher rd= req.getRequestDispatcher("login.html");
			rd.include(req, res);
			
		}
		pt.close();
	}

}
