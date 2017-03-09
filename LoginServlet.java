import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class LoginServlet extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
	
	PrintWriter out=res.getWriter();
	res.setContentType("text/html");
	String name=req.getParameter("userid");
	String pass=req.getParameter("pass");
	try{
	ServletContext ctx=getServletContext();
	HttpSession http=req.getSession();
	http.setAttribute("userid",name);
	http.setAttribute("pass",pass);

}catch(Exception e)
{
	out.println(e);
}
	
	
}
}