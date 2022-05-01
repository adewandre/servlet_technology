package be.pxl.paj.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "/ButtonClicked", value="/ButtonClicked")
public class ButtonClickedServlet extends HttpServlet {

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

		int clickCount;

		//get the session, which contains user-specific data
		HttpSession session = request.getSession();

		if(session.getAttribute("clickCount") != null){
			//we've already stored the clickCount in a previous request, so get it
			clickCount = (int) session.getAttribute("clickCount");
		}
		else{
			//we haven't stored the clickCount for this user yet, start it at zero
			clickCount = 0;
		}

		clickCount++;

		//store the new clickCount in the session
		session.setAttribute("clickCount", clickCount);

		//output the clickCount for this user
		response.getOutputStream().println("<h1>You clicked the button " + clickCount + " times.</h1>");
		response.getOutputStream().println("<p>Click <a href=\"/index.html\">here</a> to go back to the button.</p>");
	}
}
