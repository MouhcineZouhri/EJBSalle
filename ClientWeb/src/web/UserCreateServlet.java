package web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.User;
import service.UserService;

@WebServlet(urlPatterns="/users/create")
public class UserCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private UserService userService;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/createUserJsp.jsp").forward(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		int age = Integer.parseInt(req.getParameter("age"));
		
		User user = new User();
		
		
		user.setName(name);
		user.setEmail(email);
		user.setAge(age);
		
		userService.createUser(user);
		
		List<User> users = userService.getUsers();
		
		req.setAttribute("users", users);
		
		req.getRequestDispatcher("/WEB-INF/users.jsp").forward(req, resp);
		
		
	}



}
