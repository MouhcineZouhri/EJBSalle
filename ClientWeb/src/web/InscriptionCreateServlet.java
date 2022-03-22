package web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Entity.Formation;
import Entity.Salle;
import Entity.User;
import Model.InscriptionInfo;
import service.FormationService;
import service.InscriptionService;
import service.SalleService;
import service.UserService;

@WebServlet(urlPatterns="/inscriptions/create")
public class InscriptionCreateServlet extends HttpServlet {
	
	@EJB
	private UserService userService;
	
	@EJB
	private FormationService formationService;
	
	@EJB
	private InscriptionService inscriptionService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		List<Formation> formations = formationService.getAllForamtions();
	
		List<User> users = userService.getUsers();
		
		req.setAttribute("formations", formations);		
		
		req.setAttribute("users", users);
		
		req.getRequestDispatcher("/WEB-INF/createInscription.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long cne = Long.parseLong(req.getParameter("cne"));
		
		String type = req.getParameter("type");
		
		inscriptionService.createInscription(cne, type);
		
		List<InscriptionInfo> inscriptionInfos =   inscriptionService.getInscriptionsInfo();
		
		req.setAttribute("inscriptions",inscriptionInfos);
		
		req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
		
	}
}
