import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class MenServlet extends HttpServlet
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
	String[] men=req.getParameterValues("men");
	session.setAttribute("men",men);
	RequestDispatcher rd=req.getRequestDispatcher("/welcome.html");
	rd.forward(req,res);
}
else
{
out.println("<html><body><h1>Please login first</h1></body></html>");
res.setHeader("Refresh","4;index.html");
}
}catch(Exception e)
{
	out.println(e);
}
	
	
}
}