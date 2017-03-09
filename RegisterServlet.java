import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class RegisterServlet extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
	
	PrintWriter out=res.getWriter();
	res.setContentType("text/html");
	out.println("<html><body><h1>User Already exists</h1><br><h2>Login page reloading</h2></body></html>");
	res.setHeader("Refresh","4;login.html");
}
}