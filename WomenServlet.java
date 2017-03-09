import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class WomenServlet extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
	
	PrintWriter out=res.getWriter();
	res.setContentType("text/html");
	try
	{
	HttpSession session=req.getSession(false);
	if(session!=null)
	{
	String[] women=req.getParameterValues("women");
	session.setAttribute("women",women);
	RequestDispatcher rd=req.getRequestDispatcher("/welcome.html");
	rd.forward(req,res);
}
else
{
//HttpServletResponse rss=(HttpServletResponse)res;
out.println("<html><body><h1>Please login first</h1></body></html>");
res.setHeader("Refresh","4;index.html");
}
}catch(Exception e)
{
	out.println(e);
}
	
	
}
}