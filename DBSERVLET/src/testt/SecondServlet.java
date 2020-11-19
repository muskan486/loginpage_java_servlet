package testt;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 ArrayList<UserData> a=new ArrayList<UserData>();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter pt=response.getWriter();
	String n=request.getParameter("uname");  
	a=LoginDao.data(n);
	pt.print("Welcome "+n+"<br>");
	pt.print("Here are your details: <br><br>");
	Iterator<UserData> itr=a.iterator();
	while(itr.hasNext())
	{
		UserData ud=(UserData) itr.next();
		pt.print("Username: "+ud.getName()+"<br>"+"Gender: "+ud.getGender()+"<br>"+"Age: "+ud.getAge()+"<br>"+"Occupation: "+ud.getOccupation()+"<br>"+"Salary: "+ud.getSalary());
	}
	
	pt.close();
	}	

}
