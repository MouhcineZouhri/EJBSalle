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

@WebServlet(urlPatterns="/users/update")
public class UserUpdateServlet  extends HttpServlet{

	@EJB
	private UserService userService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long cne = Long.parseLong(req.getParameter("cne"));
		
		User user = userService.getUser(cne);
		
		req.setAttribute("user", user);
		
		req.getRequestDispatcher("/WEB-INF/updateUserJsp.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long cne = Long.parseLong(req.getParameter("cne"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		int age = Integer.parseInt(req.getParameter("age"));
		
		User user = new User();
		
		user.setCne(cne);
		user.setEmail(email);
		user.setName(name);
		user.setAge(age);
		
		userService.updateUser(user);
		
		List<User> users = userService.getUsers();
		
		req.setAttribute("users", users);
		
		req.getRequestDispatcher("/WEB-INF/users.jsp").forward(req, resp);
		
		
	}
}
