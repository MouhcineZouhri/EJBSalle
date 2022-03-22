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


@WebServlet(name = "inscriptions" , urlPatterns = "/inscriptions")
public class InscriptionServlet extends HttpServlet {

	@EJB
	private InscriptionService inscriptionService;
	
	
	@Override
	protected void doGet(HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws ServletException, IOException {
			List<InscriptionInfo> inscriptionInfos =   inscriptionService.getInscriptionsInfo();
	
			req.setAttribute("inscriptions",inscriptionInfos);
			
			req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}


	
	// Search Inscriptions Par cne .
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<InscriptionInfo> inscriptionInfos ;
		
		if(req.getParameter("cne").equals("")) {
			
			inscriptionInfos = inscriptionService.getInscriptionsInfo();
			
		}
		else{
			Long cne = Long.parseLong(req.getParameter("cne"));
			inscriptionInfos = inscriptionService.getFilterInscriptionsInfo(cne);
		}
		
	
		
		req.setAttribute("inscriptions",inscriptionInfos);
		
		req.getRequestDispatcher("/WEB-INF/index.jsp").forward(req, resp);
	}
	
	
}
