package web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.User;
import service.UserService;

@WebServlet(name="users" , urlPatterns ="/users")
public class UserServlet extends HttpServlet {

	@EJB
	private UserService userService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users = userService.getUsers();
		
		req.setAttribute("users", users);
	
		req.getRequestDispatcher("/WEB-INF/users.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<User> users  = new ArrayList<User>();
		
		if(req.getParameter("cne").equals("")) {
			users = userService.getUsers();
		} else {
			Long cne = Long.parseLong(req.getParameter("cne"));
		
			try {
				User user = userService.getUser(cne);
				
				if(user == null) {
					req.setAttribute("error", "USER NOT WITH CNE " + cne + " NOT FOUND");
					
					req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, resp);
				}
				
				users.add(user);
				
			} catch(Exception exception) {
				req.setAttribute("error", exception.getMessage());
			}
		
		}
		
		req.setAttribute("users",users );
		
		req.getRequestDispatcher("/WEB-INF/users.jsp").forward(req, resp);
		
	}
}
