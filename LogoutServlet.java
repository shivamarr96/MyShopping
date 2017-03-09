import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
public class LogoutServlet extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
	
	PrintWriter out=res.getWriter();
	ServletContext ctx=getServletContext();
	res.setContentType("text/html");
	String url=(String)ctx.getInitParameter("url");
	String user=(String)ctx.getInitParameter("user");
	String password=(String)ctx.getInitParameter("pass");
	HttpSession session=req.getSession(false);
	try
	{	
	
if(session!=null)
{String name=(String)session.getAttribute("userid");
	String pass=(String)session.getAttribute("pass");
		
	Connection c=DriverManager.getConnection(url,user,password);
	Statement s=c.createStatement();
	String s1="update cust set status='f'where name='"+name+"' and pass='"+pass+"'";
s.executeUpdate(s1);
	
	session.invalidate();
out.println("<html><body><h1>Logged out successfully</h1><br>");
out.println("<a href='index.html'>Login</a>");
out.println("</body></html>");

}
else
{
out.println("<html><body><h1>Please login first..</h1></body></html>");
res.setHeader("Refresh","2;index.html");
}
}catch(Exception e){out.println(e);}
}
}