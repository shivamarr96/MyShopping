import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class NetbankServlet extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
	String name=req.getParameter("name");
	String cardno=req.getParameter("cardno");
	String bankname=req.getParameter("bankname");
	
	PrintWriter out=res.getWriter();
	res.setContentType("text/html");
	ServletContext ctx=getServletContext();
	String url=(String)ctx.getInitParameter("url");
	String user=(String)ctx.getInitParameter("user");
	String password=(String)ctx.getInitParameter("pass");
	try
	{	
	Connection c=DriverManager.getConnection(url,user,password);
	Statement s=c.createStatement();
	String s1="select * from bank where name='"+name+"' and cardno='"+cardno+"'";
	ResultSet rs=s.executeQuery(s1);
	if(rs.next()){
	out.println("<html><body><h1>Thank you!!</h1><br><h2>Payment Successful</h2></body></html>");
	res.setHeader("Refresh","4;welcome.html");
}
else
{
out.println("<html><body><h1>Invalid Details..Try Again..</h1></body></html>");
	res.setHeader("Refresh","4;netbank.html");	
}
}catch(Exception e)
{
	out.println(e);
}
}
}