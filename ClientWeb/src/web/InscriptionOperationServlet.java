package web;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.InscriptionInfo;
import service.InscriptionService;

@WebServlet(name="inscriptionOperation" , urlPatterns = "/inscriptions/oprations")
public class InscriptionOperationServlet extends HttpServlet{

	@EJB
	private InscriptionService inscriptionService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		
		inscriptionService.changeEtatInscription(id);
		
		List<InscriptionInfo> inscriptionInfos =   inscriptionService.getInscriptionsInfo();
		
		req.setAttribute("inscriptions",inscriptionInfos);
		
		req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
		
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id = Long.parseLong(req.getParameter("id"));
		
		inscriptionService.removeInscription(id);
		
		List<InscriptionInfo> inscriptionInfos =   inscriptionService.getInscriptionsInfo();
		
		req.setAttribute("inscriptions",inscriptionInfos);
		
		req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}
}
