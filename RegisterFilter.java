import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class RegisterFilter implements Filter
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
	String repass=req.getParameter("repass");
	
	PrintWriter out=res.getWriter();
	res.setContentType("text/html");
	if(pass.equals(repass))
	{
ServletContext ctx=config.getServletContext();
	try{		
	String url=(String)ctx.getInitParameter("url");
	String user=(String)ctx.getInitParameter("user");
	String password=(String)ctx.getInitParameter("pass");
		
	Connection c=DriverManager.getConnection("jdbc:mysql://localhost/shop?autoReconnect=true","root","hello123");
	Statement s=c.createStatement();
	String s1="select * from cust where name='"+name+"' and pass='"+pass+"'";
	ResultSet rs=s.executeQuery(s1);
	if(rs.next()){
	chain.doFilter(req, res);}
	else
	{
		s1="insert into cust values('"+name+"','"+pass+"','F')";
		int a=s.executeUpdate(s1);
		out.println("<html><body><br><h1>Registered Successfully</h1><br>");
	out.println("<h2>Please login now!!</h2></body></html>");
	HttpServletResponse rss=(HttpServletResponse)res;
	rss.setHeader("Refresh","4;index.html");
	}
	}
	catch(Exception e){out.println(e);}
}
else
{
out.println("<html><body><h2>Password and Re-entered password do not match</h2><br><h3>Register page reloading</h3></body></html>");
HttpServletResponse rss=(HttpServletResponse)res;
	rss.setHeader("Refresh","4;register.html");

}
	}	
	public void destroy(){}
}