import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class RegisteredServlet extends HttpServlet
{
public void service(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter out=res.getWriter();
	res.setContentType("text/html");
	out.println("<html><body><h1>Thank you!!</h1><br><h2>Account Registered Successfully</h2></body></html>");
	res.setHeader("Refresh","4;index.html");
}
}