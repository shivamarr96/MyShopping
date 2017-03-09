import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class UserExistServlet extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter out=res.getWriter();
	res.setContentType("text/html");
	out.println("<html><body><h1>User already exists..Login to shop..</h1></body></html>");
	res.setHeader("Refresh","4;index.html");
}
}