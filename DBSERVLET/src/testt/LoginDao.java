package testt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class LoginDao {
	static Connection con=Util.getDBConnection();	
	
public static boolean validate(String name, String pass)
{
	boolean status =false;
	try {
		PreparedStatement ps=con.prepareStatement("select * from JAVAWEB.logininfo where name=? and pass=?");
	ps.setString(1, name);
	ps.setString(2, pass);
	ResultSet rs=ps.executeQuery();
	status=rs.next();
	}catch(Exception e)
	{
		System.out.println(e);
	}
	return status;
}
public static ArrayList<UserData> data(String name)
{
	ArrayList<UserData> a1=new ArrayList<UserData>();
	UserData u=new UserData();
	try {
		PreparedStatement ps=con.prepareStatement("select * from JAVAWEB.userinfor where name=?");
	ps.setString(1, name);
	
	ResultSet rs=ps.executeQuery();
	while(rs.next())	
	{
		u.setName(rs.getString(1));
		u.setGender(rs.getString(2));
		u.setAge(rs.getInt(3));
		u.setOccupation(rs.getString(4));
		u.setSalary(rs.getInt(5));
		a1.add(u);
		
	}
	}catch(Exception e)
	{
		System.out.println(e);
	}
	return a1;
}
}


