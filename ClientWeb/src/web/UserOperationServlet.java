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

@WebServlet(name ="userOperation" ,urlPatterns ="/users/operation" )
public class UserOperationServlet  extends HttpServlet {
	@EJB
	private UserService userService;
	
	
	// Remove a User
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long cne= Long.parseLong(req.getParameter("cne"));
		
		userService.removeUser(cne);
		
		List<User> users = userService.getUsers();
		
		req.setAttribute("users", users);
	
		req.getRequestDispatcher("/WEB-INF/users.jsp").forward(req, resp);
		

	}
	
	
}
