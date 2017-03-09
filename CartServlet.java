import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class CartServlet extends HttpServlet
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
	String[] watches=(String[])session.getAttribute("watches");
	String[] men=(String[])session.getAttribute("men");
	String[] cars=(String[])session.getAttribute("cars");
	String[] women=(String[])session.getAttribute("women");
	String[] laptops=(String[])session.getAttribute("laptops");
	String[] mobiles=(String[])session.getAttribute("mobiles");
	out.println("<html><body><table bgcolor='green' border=2 width=600>");
	out.println(" <tr><th>Item</th><th>Category</th> </tr>");
	if(mobiles!=null)
	{
		for(int m=0;m<mobiles.length;m++)
		{
			out.println("<tr>");
			out.println("<td>"+mobiles[m]+"</td>");
			out.println("<td>Mobile</td>");
			out.println("</tr>");
		}
	}
		if(cars!=null)
	{
		
		for(int m=0;m<cars.length;m++)
		{
			out.println("<tr>");
			out.println("<td>"+cars[m]+"</td>");
			out.println("<td>Car</td>");
			out.println("</tr>");
		}
	}	if(laptops!=null)
	{
		
		for(int m=0;m<laptops.length;m++)
		{
			out.println("<tr>");
			out.println("<td>"+laptops[m]+"</td>");
			out.println("<td>Laptop</td>");
			out.println("</tr>");
		}
	}	if(watches!=null)
	{
		
		for(int m=0;m<watches.length;m++)
		{
			out.println("<tr>");
			out.println("<td>"+watches[m]+"</td>");
			out.println("<td>Watch</td>");
			out.println("</tr>");
		}
	}	if(men!=null)
	{
		
		for(int m=0;m<men.length;m++)
		{
			out.println("<tr>");
			out.println("<td>"+men[m]+"</td>");
			out.println("<td>Men Clothing</td>");
			out.println("</tr>");
		}
	}	if(women!=null)
	{
		
		for(int m=0;m<women.length;m++)
		{
			out.println("<tr>");
			out.println("<td>"+women[m]+"</td>");
			out.println("<td>Women Clothing</td>");
			out.println("</tr>");
		}
	}
	out.println("</table>");
	out.println("<br><br><a href='netbank.html'><input type='submit' value='Buy Now'/></a>");
	out.println("<br><br><a href='welcome.html'><input type='submit' value='Back'/></a>");
		
	
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