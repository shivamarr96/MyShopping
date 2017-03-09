import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class LoginFilter implements Filter
{
FilterConfig config;
public void init(FilterConfig config)throws ServletException
{
	this.config=config;
}
public void doFilter(ServletRequest req,ServletResponse res, FilterChain chain)throws ServletException, IOException
{
	String name=req.getParameter("userid");
	String pass=req.getParameter("pass");
	
	PrintWriter out=res.getWriter();
	res.setContentType("text/html");
	ServletContext ctx=config.getServletContext();
	String url=(String)ctx.getInitParameter("url");
	String user=(String)ctx.getInitParameter("user");
	String password=(String)ctx.getInitParameter("pass");
	try
	{	
	Connection c=DriverManager.getConnection(url,user,password);
	Statement s=c.createStatement();
	String s1="select * from cust where name='"+name+"' and pass='"+pass+"'";
	ResultSet rs=s.executeQuery(s1);
	if(rs.next()){
		if(rs.getString("status").equalsIgnoreCase("f"))
		{
s1="update cust set status='t'where name='"+name+"' and pass='"+pass+"'";
s.executeUpdate(s1);
chain.doFilter(req,res);
RequestDispatcher rd=req.getRequestDispatcher("/welcome.html");
rd.forward(req,res);		}
	else
	{
		out.println("<html><body><h1>User Already Logged in</h1></body></html>");
HttpServletResponse hsr=(HttpServletResponse)res;
hsr.setHeader("Refresh","4;index.html");
		}	
	}
	else
	{
	out.println("<html><body><h1>Register and make a new account</h1></body></html>");
HttpServletResponse hsr=(HttpServletResponse)res;
hsr.setHeader("Refresh","4;register.html");	
	}
}catch(Exception e){out.println(e);}
}
	public void destroy(){}

}